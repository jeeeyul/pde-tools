package net.jeeeyul.pdetools.clipboard.internal;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.clipboard.IClipboardService;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.JavaInfo;
import net.jeeeyul.pdetools.clipboard.model.clipboard.TextRange;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ClipboardServiceImpl implements IClipboardService {
	private static IClipboardService INSTANCE;
	private static ILock lock = Job.getJobManager().newLock();

	public static void initailze() {
		lock.acquire();
		try {
			if (INSTANCE == null) {
				INSTANCE = new ClipboardServiceImpl();
			}
		} finally {
			lock.release();
		}
	}

	public static IClipboardService getInstance() {
		lock.acquire();
		try {
			if (INSTANCE == null) {
				initailze();
			}
		} finally {
			lock.release();
		}
		return INSTANCE;
	}

	private ClipHistory history;
	private CopyActionDetector detector;
	private Clipboard nativeClipboard;
	private IWindowListener windowHook = new WindowAdaptor() {
		public void windowActivated(IWorkbenchWindow window) {
			handleCopy(null);
		};
	};

	@Override
	public Clipboard getNativeClipboard() {
		if (nativeClipboard == null) {
			nativeClipboard = new Clipboard(Display.getDefault());
		}
		return nativeClipboard;
	}

	@Override
	public ClipHistory getHistory() {
		if (history == null) {
			try {
				URI uri = getPersistanceURI();
				if (new File(uri.toFileString()).exists()) {
					BinaryResourceImpl resourceImpl = new BinaryResourceImpl(uri);
					resourceImpl.load(new HashMap<Object, Object>());
					history = (ClipHistory) resourceImpl.getContents().get(0);
				} else {
					history = ClipboardFactory.eINSTANCE.createClipHistory();
				}
			}

			catch (Exception e) {
				e.printStackTrace();
				history = ClipboardFactory.eINSTANCE.createClipHistory();
			}
		}
		return history;
	}

	private URI getPersistanceURI() {
		IPath stateLocation = PDEToolsCore.getDefault().getStateLocation();
		IPath clipboardURI = stateLocation.append("clipboard.data");
		URI uri = URI.createFileURI(clipboardURI.toPortableString());
		return uri;
	}

	public ClipboardServiceImpl() {
		detector = new CopyActionDetector();
		detector.setCopyHandler(new Procedure1<ExecutionEvent>() {
			@Override
			public void apply(ExecutionEvent event) {
				handleCopy(event);
			}
		});

		PlatformUI.getWorkbench().addWindowListener(windowHook);
	}

	protected void handleCopy(ExecutionEvent event) {
		boolean hasTextContents = hasDataFor(getTextTransfer());
		if (!hasTextContents) {
			return;
		}

		String textContents = (String) getNativeClipboard().getContents(getTextTransfer());

		if (!getHistory().getEntries().isEmpty()) {
			if (getHistory().getEntries().get(0).getTextContent().equals(textContents)) {
				return;
			}
		}
		ClipboardEntry entry = createClipEntry();

		// clip entry from outside of elcipse.
		if (event != null) {
			IWorkbenchPart part = HandlerUtil.getActivePart(event);
			IFile file = null;
			ITextSelection textSelection = null;

			if (part != null && part.getAdapter(IResource.class) instanceof IFile) {
				file = (IFile) part.getAdapter(IResource.class);
			}

			if (part != null) {
				entry.setPartId(part.getSite().getId());
			}

			if (file != null) {
				entry.setReleatedFile(file);
			}

			if (part != null) {
				ISelectionProvider selectionProvider = part.getSite().getSelectionProvider();
				ISelection selection = selectionProvider.getSelection();

				if (selection instanceof ITextSelection) {
					textSelection = (ITextSelection) selection;
					TextRange range = ClipboardFactory.eINSTANCE.createTextRange();
					range.setStartLine(textSelection.getStartLine());
					range.setOffset(textSelection.getOffset());
					range.setEndLine(textSelection.getEndLine());
					range.setLength(textSelection.getLength());
					entry.setTextRange(range);
				}
			}

			if (part instanceof IEditorPart) {
				IEditorInput editorInput = ((IEditorPart) part).getEditorInput();
				if (editorInput instanceof IFileEditorInput) {
					entry.setReleatedFile(((IFileEditorInput) editorInput).getFile());
				}

				IJavaElement element = JavaUI.getEditorInputJavaElement(editorInput);
				if (element instanceof ITypeRoot && textSelection != null) {
					ITypeRoot root = (ITypeRoot) element;
					try {
						IType primaryType = root.findPrimaryType();
						IJavaElement cursorElement = root.getElementAt(textSelection.getOffset());

						JavaInfo javaInfo = ClipboardFactory.eINSTANCE.createJavaInfo();
						javaInfo.setQualifiedTypeName(getQualifiedName(primaryType));

						if (cursorElement instanceof IMember) {
							if (!cursorElement.equals(primaryType) && !cursorElement.equals(root))
								javaInfo.setEnclosingElementName(getQualifiedName(cursorElement));
						}
						entry.setJavaInfo(javaInfo);
					} catch (JavaModelException e) {
						e.printStackTrace();
					}
				}
			}

		}

		entry.setTakenTime(new Date());
		getHistory().getEntries().add(0, entry);

		int maxSize = PDEToolsCore.getDefault().getPreferenceStore()
				.getInt(ClipboardPreferenceConstants.CLIPBOARD_MAXIMUM_HISTORY_SIZE);

		if (maxSize > 0) {
			while (getHistory().getEntries().size() > maxSize) {
				getHistory().getEntries().remove(getHistory().getEntries().size() - 1);
			}
		}
	}

	protected TextTransfer getTextTransfer() {
		return TextTransfer.getInstance();
	}

	protected RTFTransfer getRTFTransfer() {
		return RTFTransfer.getInstance();
	}

	public void dispose() {
		PlatformUI.getWorkbench().removeWindowListener(windowHook);
		nativeClipboard.dispose();
		detector.dispose();
	}

	public ClipboardEntry createClipEntry() {
		ClipboardEntry entry = ClipboardFactory.eINSTANCE.createClipboardEntry();
		entry.setTextContent((String) getNativeClipboard().getContents(getTextTransfer()));

		if (hasDataFor(getRTFTransfer())) {
			entry.setRtfContent((String) getNativeClipboard().getContents(getRTFTransfer()));
		}

		return entry;
	}

	private boolean hasDataFor(Transfer transfer) {
		TransferData[] availableTypes = getNativeClipboard().getAvailableTypes();
		for (TransferData eachData : availableTypes) {
			if (transfer.isSupportedType(eachData)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void doSave() {
		BinaryResourceImpl resource = new BinaryResourceImpl(getPersistanceURI());
		resource.getContents().add(EcoreUtil.copy(getHistory()));
		try {
			resource.save(new HashMap<Object, Object>());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getQualifiedName(IJavaElement element) {
		long LABEL_FLAGS = new Long(JavaElementLabels.F_FULLY_QUALIFIED | JavaElementLabels.M_FULLY_QUALIFIED
				| JavaElementLabels.I_FULLY_QUALIFIED | JavaElementLabels.T_FULLY_QUALIFIED
				| JavaElementLabels.M_PARAMETER_TYPES | JavaElementLabels.USE_RESOLVED
				| JavaElementLabels.T_TYPE_PARAMETERS | JavaElementLabels.CU_QUALIFIED | JavaElementLabels.CF_QUALIFIED)
				.longValue();
		return TextProcessor.deprocess(JavaElementLabels.getTextLabel(element, LABEL_FLAGS));
	}
}

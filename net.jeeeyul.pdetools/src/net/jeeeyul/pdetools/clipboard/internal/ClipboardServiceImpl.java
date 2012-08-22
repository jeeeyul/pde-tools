package net.jeeeyul.pdetools.clipboard.internal;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.clipboard.IClipboardService;
import net.jeeeyul.pdetools.model.pdetools.ClipHistory;
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;
import net.jeeeyul.pdetools.model.pdetools.JavaInfo;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;
import net.jeeeyul.pdetools.model.pdetools.TextRange;
import net.jeeeyul.pdetools.model.pdetools.provider.PdetoolsItemProviderAdapterFactory;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
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

	private ClipHistory history;
	private CopyActionDetector detector;
	private Clipboard nativeClipboard;
	private IWindowListener windowHook = new WindowAdaptor() {
		public void windowActivated(IWorkbenchWindow window) {
			handleCopy(null);
		};
	};

	private AdapterFactoryEditingDomain editingDomain;

	private ClipboardServiceImpl() {
		detector = new CopyActionDetector();
		detector.setCopyHandler(new Procedure1<ExecutionEvent>() {
			@Override
			public void apply(ExecutionEvent event) {
				handleCopy(event);
			}
		});

		PlatformUI.getWorkbench().addWindowListener(windowHook);
	}

	public ClipboardEntry createClipEntry() {
		ClipboardEntry entry = PdetoolsFactory.eINSTANCE.createClipboardEntry();
		entry.setTextContent((String) getNativeClipboard().getContents(getTextTransfer()));

		if (hasDataFor(getRTFTransfer())) {
			entry.setRtfContent((String) getNativeClipboard().getContents(getRTFTransfer()));
		}

		return entry;
	}

	public void dispose() {
		PlatformUI.getWorkbench().removeWindowListener(windowHook);
		nativeClipboard.dispose();
		detector.dispose();
	}

	@Override
	public void doSave() {
		try {
			getResource().save(new HashMap<Object, Object>());
			System.out.println("Clipboard was saved.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private AdapterFactoryEditingDomain getEditingDomain() {
		if (editingDomain == null) {
			editingDomain = new AdapterFactoryEditingDomain(new PdetoolsItemProviderAdapterFactory(),
					new BasicCommandStack());
			editingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put("data", new BinaryResourceFactory());
		}
		return editingDomain;
	}

	@Override
	public ClipHistory getHistory() {
		if (history == null) {
			Resource resource = getResource();
			try {
				resource.load(new HashMap<Object, Object>());
				history = (ClipHistory) resource.getContents().get(0);
				System.out.println("Clipboard was loaded.");
			}

			catch (Exception e) {
				e.printStackTrace();
				history = PdetoolsFactory.eINSTANCE.createClipHistory();
				resource.getContents().clear();
				resource.getContents().add(history);
				System.out.println("Clipboard was created.");
			}
		}
		return history;
	}

	@Override
	public Clipboard getNativeClipboard() {
		if (nativeClipboard == null) {
			nativeClipboard = new Clipboard(Display.getDefault());
		}
		return nativeClipboard;
	}

	private URI getPersistanceURI() {
		IPath stateLocation = PDEToolsCore.getDefault().getStateLocation();
		IPath clipboardURI = stateLocation.append("clipboard.data");
		URI uri = URI.createFileURI(clipboardURI.toPortableString());
		return uri;
	}

	private String getQualifiedName(IJavaElement element) {
		long LABEL_FLAGS = new Long(JavaElementLabels.F_FULLY_QUALIFIED | JavaElementLabels.M_FULLY_QUALIFIED
				| JavaElementLabels.I_FULLY_QUALIFIED | JavaElementLabels.T_FULLY_QUALIFIED
				| JavaElementLabels.M_PARAMETER_TYPES | JavaElementLabels.USE_RESOLVED
				| JavaElementLabels.T_TYPE_PARAMETERS | JavaElementLabels.CU_QUALIFIED | JavaElementLabels.CF_QUALIFIED)
				.longValue();
		return TextProcessor.deprocess(JavaElementLabels.getTextLabel(element, LABEL_FLAGS));
	}

	private ResourceSet getResourceSet() {
		return getEditingDomain().getResourceSet();
	}

	private Resource getResource() {
		Resource resource = null;
		try {
			resource = getResourceSet().getResource(getPersistanceURI(), true);
		} catch (Exception e) {
			resource = getResourceSet().createResource(getPersistanceURI());
			System.out.println("New resource for Clipboard History was created.");
		}
		return resource;
	}

	private RTFTransfer getRTFTransfer() {
		return RTFTransfer.getInstance();
	}

	private TextTransfer getTextTransfer() {
		return TextTransfer.getInstance();
	}

	private void handleCopy(ExecutionEvent event) {
		boolean hasTextContents = hasDataFor(getTextTransfer());
		if (!hasTextContents) {
			return;
		}

		String textContents = (String) getNativeClipboard().getContents(getTextTransfer());

		for (ClipboardEntry each : getHistory().getEntries()) {
			if (textContents.equals(each.getTextContent())) {
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
					TextRange range = PdetoolsFactory.eINSTANCE.createTextRange();
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

						JavaInfo javaInfo = PdetoolsFactory.eINSTANCE.createJavaInfo();
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

		EReference entriesFeature = PdetoolsPackage.eINSTANCE.getClipHistory_Entries();
		EReference activeEntryFeature = PdetoolsPackage.eINSTANCE.getClipHistory_ActiveEntry();

		CompoundCommand command = new CompoundCommand();
		AddCommand addEntry = new AddCommand(getEditingDomain(), getHistory(), entriesFeature, entry, 0);
		command.append(addEntry);
		command.append(new SetCommand(getEditingDomain(), getHistory(), activeEntryFeature, entry));

		int maxSize = PDEToolsCore.getDefault().getPreferenceStore()
				.getInt(ClipboardPreferenceConstants.CLIPBOARD_MAXIMUM_HISTORY_SIZE);

		int currentSize = getHistory().getEntries().size();
		if (maxSize > 0 && currentSize + 1 > maxSize) {
			List<ClipboardEntry> remove = getHistory().getEntries().subList(maxSize - 1, currentSize);
			command.append(new RemoveCommand(getEditingDomain(), getHistory(), entriesFeature, remove));
		}

		command.setLabel("Capture new content");
		editingDomain.getCommandStack().execute(command);
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
}

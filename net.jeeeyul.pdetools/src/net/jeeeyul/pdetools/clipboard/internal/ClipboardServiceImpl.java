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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Display;
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
					XMLResourceImpl resourceImpl = new XMLResourceImpl(uri);
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
		IPath clipboardURI = stateLocation.append("clipboard.xml");
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
			if (part != null) {
				entry.setImageData(part.getTitleImage().getImageData());
				entry.setPartId(part.getSite().getId());
			}
		}

		entry.setTakenTime(new Date());
		getHistory().getEntries().add(0, entry);
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
		XMLResourceImpl resource = new XMLResourceImpl(getPersistanceURI());
		resource.getContents().add(EcoreUtil.copy(getHistory()));
		try {
			resource.save(new HashMap<Object, Object>());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

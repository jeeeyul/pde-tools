package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

public abstract class AbstractClipboardService {
	private ClipHistory history;
	private CopyActionDetector detector;
	private Clipboard nativeClipboard;

	public Clipboard getNativeClipboard() {
		if (nativeClipboard == null) {
			nativeClipboard = new Clipboard(Display.getDefault());
		}
		return nativeClipboard;
	}

	public ClipHistory getHistory() {
		if (history == null) {
			history = ClipboardFactory.eINSTANCE.createClipHistory();
		}
		return history;
	}

	public AbstractClipboardService() {
		detector = new CopyActionDetector();
		detector.setCopyHandler(new Procedure0() {
			@Override
			public void apply() {
				handleCopy();
			}
		});
	}

	protected abstract void handleCopy();

	protected TextTransfer getTextTransfer() {
		return TextTransfer.getInstance();
	}

	protected RTFTransfer getRTFTransfer() {
		return RTFTransfer.getInstance();
	}

	public void dispose() {
		nativeClipboard.dispose();
		detector.dispose();
	}
}

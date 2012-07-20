package net.jeeeyul.pdetools.clipboard.internal;

import net.jeeeyul.pdetools.clipboard.IClipboardService;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public abstract class AbstractClipboardService implements IClipboardService {
	private ClipHistory history;
	private CopyActionDetector detector;
	private Clipboard nativeClipboard;

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
			history = ClipboardFactory.eINSTANCE.createClipHistory();
		}
		return history;
	}

	public AbstractClipboardService() {
		detector = new CopyActionDetector();
		detector.setCopyHandler(new Procedure1<ExecutionEvent>() {
			@Override
			public void apply(ExecutionEvent event) {
				handleCopy(event);
			}
		});
	}

	protected abstract void handleCopy(ExecutionEvent event);

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

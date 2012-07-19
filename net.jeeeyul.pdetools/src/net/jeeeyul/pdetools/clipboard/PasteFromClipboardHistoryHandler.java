package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class PasteFromClipboardHistoryHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell activeShell = HandlerUtil.getActiveShell(event);
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		Control focusControl = Display.getDefault().getFocusControl();

		CaretHint referencePoint = null;

		if (focusControl instanceof StyledText) {
			StyledText styledText = (StyledText) focusControl;
			referencePoint = CaretHint.capture(styledText);
		} else if (focusControl instanceof Text) {
			Text text = (Text) focusControl;
			referencePoint = CaretHint.capture(text);
		}

		PasteDialog dialog = new PasteDialog(activeShell);
		dialog.setReferencePoint(referencePoint);

		if (dialog.open() == IDialogConstants.OK_ID) {
			Clipboard clipboard = ClipboardService.getInstance().getNativeClipboard();

			ClipboardEntry backup = ClipboardService.getInstance().createClipEntry();

			ClipboardEntry result = dialog.getResult();
			result.transferTo(clipboard);
			result.increaseUsing();

			ITextOperationTarget target = (ITextOperationTarget) activePart.getAdapter(ITextOperationTarget.class);
			if (target != null) {
				target.doOperation(ITextOperationTarget.PASTE);
			} else if (focusControl instanceof Text) {
				((Text) focusControl).paste();
			} else if (focusControl instanceof StyledText) {
				((StyledText) focusControl).paste();
			}

			backup.transferTo(clipboard);
		}

		return null;
	}
}

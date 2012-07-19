package net.jeeeyul.pdetools.clipboard;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.custom.StyledText;
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

		if (referencePoint == null) {
			return null;
		}

		ClipEntrySelectionDialog dialog = new ClipEntrySelectionDialog(activeShell);
		dialog.open();

		return null;
	}
}

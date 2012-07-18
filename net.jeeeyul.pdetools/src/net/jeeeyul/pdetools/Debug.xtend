package net.jeeeyul.pdetools

import net.jeeeyul.pdetools.clipboard.ClipboardView
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import static extension org.eclipse.ui.handlers.HandlerUtil.*
import org.eclipse.swt.dnd.Clipboard
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.dnd.RTFTransfer

class Debug extends AbstractHandler {
	override execute(ExecutionEvent event) throws ExecutionException {
		var view = event.activeWorkbenchWindow.activePage.showView(ClipboardView::ID) as ClipboardView
		var Clipboard clip = new Clipboard(Display::getDefault());
		var rtfString = clip.getContents(RTFTransfer::instance) as String
		view.showRTF(rtfString)
		null
	}
}
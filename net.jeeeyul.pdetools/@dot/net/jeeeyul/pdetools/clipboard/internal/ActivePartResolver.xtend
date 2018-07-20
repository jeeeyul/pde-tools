package net.jeeeyul.pdetools.clipboard.internal

import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.ui.PlatformUI

/**
 * 27: Capture Information is unavailable @ eclipse 4.3 ~ 4.4
 * http://github.com/jeeeyul/pde-tools/issues/issue/27
 */
class ActivePartResolver {
	def IWorkbenchPart resolve(ExecutionEvent e) {
		var result = HandlerUtil::getActivePart(e)

		if (result == null) {
			result = PlatformUI::workbench?.activeWorkbenchWindow?.activePage?.activePart
		}

		return result
	}
}

package net.jeeeyul.pdetools.shell

import java.net.URI
import java.util.Map
import net.jeeeyul.pdetools.clipboard.IClipboardService
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Platform
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.swt.dnd.TextTransfer
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.commands.IElementUpdater
import org.eclipse.ui.menus.UIElement

import static extension org.eclipse.ui.handlers.HandlerUtil.*

class CopyReversedRelativeResourcePath extends AbstractHandler implements IElementUpdater {
	public static val COMMAND_ID = "net.jeeeyul.pdetools.shell.CopyReversedRelativeResourcePath"

	override execute(ExecutionEvent event) throws ExecutionException {
		var selection = (event.currentSelection as IStructuredSelection).toArray
		if (selection.size != 2) {
			return null
		}

		var first = selection.get(0).asPath
		var second = selection.get(1).asPath
		val relPath = second.makeRelativeTo(first)
		try {
			IClipboardService.INSTANCE => [
				nativeClipboard.setContents(#[relPath.toOSString], #[TextTransfer.instance])
				createSnapshotIfNeeded()
			]
		} catch (Exception e) {
			e.printStackTrace()
		}
		return null
	}


	private def Path asPath(Object obj) {
		var resource = Platform::adapterManager.getAdapter(obj, typeof(IResource)) as IResource
		if(resource === null){
			return null
		}
		var URI uri = null
		if (resource.linked) {
			uri = resource.rawLocationURI
		} else {
			uri = resource.locationURI
		}

		new Path(uri.toString)
	}

	override updateElement(UIElement element, Map parameters) {
		var selection = (PlatformUI.workbench.activeWorkbenchWindow?.activePage?.selection as IStructuredSelection)?.
			toArray
		if (selection !== null && selection.size == 2 && selection.forall[it.asPath !== null]) {
			var first = selection.get(0).asPath
			var second = selection.get(1).asPath
			element.text = '''Copy Relative Path of ‘«second.lastSegment»’ to ‘«first.lastSegment»’'''
		} else {
			element.text = "Copy Relative Path"
		}
	}

}
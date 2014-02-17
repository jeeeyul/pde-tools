package net.jeeeyul.pdetools.shell

import java.io.File
import java.net.URI
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.filesystem.EFS
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Platform
import org.eclipse.jface.viewers.IStructuredSelection

import static extension org.eclipse.ui.handlers.HandlerUtil.*
import net.jeeeyul.pdetools.clipboard.IClipboardService
import org.eclipse.swt.dnd.TextTransfer

class CopyResourcePathHandler extends AbstractHandler {

	public static final val COMMAND_ID = "net.jeeeyul.pdetools.command.copy.resource.path"

	override execute(ExecutionEvent event) throws ExecutionException {
		var selection = event.currentSelection as IStructuredSelection
		var resource = Platform::adapterManager.getAdapter(selection.firstElement, typeof(IResource)) as IResource
		var URI uri = null
		if (resource.linked) {
			uri = resource.rawLocationURI
		} else {
			uri = resource.locationURI
		}

		try {
			var File file = EFS::getStore(uri).toLocalFile(0, new NullProgressMonitor)
			IClipboardService::INSTANCE.nativeClipboard.setContents(#[file.absolutePath], #[TextTransfer.instance])
		} catch (Exception e) {
			e.printStackTrace()
		}

		return null
	}

}

package net.jeeeyul.pdetools.snapshot.handlers

import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository
import net.jeeeyul.pdetools.shared.SharedImages
import net.jeeeyul.pdetools.snapshot.SnapshotAction
import org.eclipse.swt.dnd.Clipboard
import org.eclipse.swt.dnd.FileTransfer
import org.eclipse.swt.widgets.Display
import org.eclipse.ui.actions.ActionFactory

/**
 * https://github.com/jeeeyul/pde-tools/issues/29
 */
class CopyAction extends SnapshotAction {

	new(SnapshotRepository repository) {
		super(repository)
		actionDefinitionId = ActionFactory.COPY.commandId
		text = "Copy"
		imageDescriptor = SharedImages.getImageDescriptor(SharedImages.COPY)
	}

	override update() {
		setEnabled(selection !== null && selection.size > 0)
	}

	override run() {
		var clipboard = new Clipboard(Display.^default)
		var String[] filenames = selection.map[it.absoulteVisibleFilePath]
		clipboard.setContents(#[filenames], #[FileTransfer.instance])
	}

}

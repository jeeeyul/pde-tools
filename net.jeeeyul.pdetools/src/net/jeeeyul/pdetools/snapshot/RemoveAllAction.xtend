package net.jeeeyul.pdetools.snapshot

import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository
import net.jeeeyul.pdetools.shared.ConfirmDialog
import net.jeeeyul.pdetools.shared.SharedImages
import org.eclipse.core.runtime.Path
import org.eclipse.jface.dialogs.IDialogConstants

class RemoveAllAction extends SnapshotAction {
	new(SnapshotRepository repository) {
		super(repository)
		setText("Remove All Items")
		setImageDescriptor(SharedImages::getImageDescriptor(SharedImages::DELETE_ALL))
	}

	override run() {
		var dialog = new ConfirmDialog(SnapshotPreferenceConstants::DONT_ASK_WHEN_REMOVE_ALL_SNAPSHOT)
		dialog.message = "Do you really want to remove all snapshots?"
		if(dialog.open() != IDialogConstants::YES_ID) {
			return;
		}
		var basePath = new Path(repository.eResource.URI.toFileString).removeLastSegments(1).setDevice(null);
		var entries = repository.eAllContents.filter(typeof(SnapshotEntry)).toIterable
		for(each : entries.toList){
			var eachFile = basePath.append(each.getOriginalFile).toFile
			if(eachFile.exists) {
				try{
					eachFile.delete();
				}catch(Exception e){
					eachFile.deleteOnExit();
				}
			}
			each.parent = null
		}
		repository.groups.clear();
		SnapshotCore::doSaveAndClearUnusedFile();
	}

	override update() {
		enabled = !repository.groups.empty
	}
}
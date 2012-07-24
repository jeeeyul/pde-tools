package net.jeeeyul.pdetools.snapshot

import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository
import org.eclipse.core.runtime.Path
import net.jeeeyul.pdetools.shared.SharedImages
import net.jeeeyul.pdetools.shared.ConfirmDialog
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
		if(dialog.open() == IDialogConstants::NO_ID) {
			return;
		}
		var basePath = new Path(repository.repositoryLocation).removeLastSegments(1).setDevice(null);
		var entries = repository.eAllContents.filter(typeof(SnapshotEntry)).toIterable
		for(each : entries){
			var eachFile = basePath.append(each.fileName).toFile
			if(eachFile.exists) {
				try{
					eachFile.delete();
				}catch(Exception e){
					eachFile.deleteOnExit();
				}
			}
		}
		repository.groups.clear();
		SnapshotCore::doSave();
	}

	override update() {
		enabled = !repository.groups.empty
	}
}
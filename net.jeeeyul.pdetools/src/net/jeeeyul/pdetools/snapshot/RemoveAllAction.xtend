package net.jeeeyul.pdetools.snapshot

import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository
import org.eclipse.core.runtime.Path
import net.jeeeyul.pdetools.shared.SharedImages

class RemoveAllAction extends SnapshotAction {
	new(SnapshotRepository repository) {
		super(repository)
		setText("Remove All Items")
		setImageDescriptor(SharedImages::getImageDescriptor(SharedImages::DELETE_ALL))
	}

	override run() {
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
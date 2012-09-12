package net.jeeeyul.pdetools.snapshot.handlers

import org.eclipse.emf.common.command.AbstractCommand
import net.jeeeyul.pdetools.model.pdetools.SnapshotGroup
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository

class RemoveGroupIfEmptyCommand extends AbstractCommand {
	SnapshotGroup group
	SnapshotRepository repository
	
	new(SnapshotGroup group){
		this.group = group 
	}
	
	override protected prepare() {
		true
	}
	
	override execute() {
		if(group.entries.size() == 0){
			repository = group.parent
			group.parent = null
		}

	}
	
	override redo() {
		execute()
	}
	
	override undo() {
		if(repository != null){
			group.parent = repository
		}
	}
}
package net.jeeeyul.pdetools.snapshot.handlers

import org.eclipse.emf.common.command.AbstractCommand
import net.jeeeyul.pdetools.model.pdetools.SnapshotGroup

class RemoveGroupIfEmptyCommand extends AbstractCommand {
	SnapshotGroup group
	
	new(SnapshotGroup group){
		this.group = group 
	}	

	override execute() {
	}
	
	override redo() {
	}
	
}
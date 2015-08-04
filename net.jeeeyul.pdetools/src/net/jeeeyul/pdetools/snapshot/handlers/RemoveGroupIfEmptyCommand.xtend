package net.jeeeyul.pdetools.snapshot.handlers

import net.jeeeyul.pdetools.model.pdetools.SnapshotGroup
import net.jeeeyul.pdetools.snapshot.SnapshotCore
import org.eclipse.emf.common.command.AbstractCommand
import org.eclipse.emf.common.command.Command
import org.eclipse.emf.edit.command.DeleteCommand

class RemoveGroupIfEmptyCommand extends AbstractCommand {
	SnapshotGroup group
	Command deleteCommand
	
	new(SnapshotGroup group){
		this.group = group 
	}
	
	override protected prepare() {
		true
	}
	
	override execute() {
		if(group.entries.size() == 0){
			deleteCommand = DeleteCommand::create(SnapshotCore::editingDomain, group)
			deleteCommand.execute()
		}
	}
	
	override redo() {
		execute()
	}
	
	override undo() {
		if(deleteCommand != null){
			deleteCommand.undo
		}
	}
}
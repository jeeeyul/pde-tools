package net.jeeeyul.pdetools.snapshot.handlers

import net.jeeeyul.pdetools.snapshot.SnapshotAction
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository
import org.eclipse.ui.actions.ActionFactory
import org.eclipse.emf.common.command.CompoundCommand
import org.eclipse.emf.edit.command.DeleteCommand
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain

class RemoveSnapshotAction extends SnapshotAction{
	new(SnapshotRepository repository) {
		super(repository)
		actionDefinitionId = ActionFactory.DELETE.commandId
		text = "Delete"
	}
	
	override update() {
		enabled = selection != null && selection.size > 0
	}
	
	override run() {
		var editDomain = AdapterFactoryEditingDomain.getEditingDomainFor(repository)
		var command = new CompoundCommand("Remove Snapshot")
		for(each : selection){
			command.append(DeleteCommand.create(editDomain, each))
		}
		
		for(eachGroup : selection.map[it.parent].toSet){
			command.append(new RemoveGroupIfEmptyCommand(eachGroup))
		}
		
		editDomain.commandStack.execute(command)
	}
	
}
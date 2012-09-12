package net.jeeeyul.pdetools.snapshot.handlers

import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.emf.common.command.CompoundCommand
import org.eclipse.emf.edit.command.DeleteCommand
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
import org.eclipse.jface.viewers.IStructuredSelection

import static extension org.eclipse.ui.handlers.HandlerUtil.*

class RemoveSnapShotHandler extends AbstractHandler {

	override execute(ExecutionEvent event) throws ExecutionException {
		var selection = event.currentSelection as IStructuredSelection

		if(selection.size == 0){
			return null;
		}
		
		var repo = (selection.firstElement as SnapshotEntry).parent.parent
		var editDomain = AdapterFactoryEditingDomain::getEditingDomainFor(repo)
		
		var command = new CompoundCommand("Remove Snapshot")
		for(each : selection.toArray){
			var eachSnapshot = each as SnapshotEntry
			command.append(DeleteCommand::create(editDomain, eachSnapshot))
		}
		
		var groupSet = selection.toArray.map[(it as SnapshotEntry).parent].toSet
		for(g : groupSet){
			command.append(new RemoveGroupIfEmptyCommand(g))
		}
		
		editDomain.commandStack.execute(command)
		return null
	}


	
}
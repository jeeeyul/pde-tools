package net.jeeeyul.pdetools.snapshot.handlers

import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository
import net.jeeeyul.pdetools.shared.ConfirmDialog
import net.jeeeyul.pdetools.shared.SharedImages
import net.jeeeyul.pdetools.snapshot.SnapshotAction
import net.jeeeyul.pdetools.snapshot.SnapshotPreferenceConstants
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.emf.common.command.CompoundCommand
import org.eclipse.emf.edit.command.DeleteCommand

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

		var editDomain = AdapterFactoryEditingDomain::getEditingDomainFor(repository)
		var command = new CompoundCommand("Remove all snapshots")
		 
		for(group : repository.groups){
			command.append(DeleteCommand::create(editDomain, group))	
		}
		
		editDomain.commandStack.execute(command)
	}

	override update() {
		enabled = !repository.groups.empty
	}
}
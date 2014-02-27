package net.jeeeyul.pdetools.snapshot.handlers

import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository
import net.jeeeyul.pdetools.snapshot.SnapshotAction
import net.jeeeyul.pdetools.snapshot.SnapshotCoreimport org.eclipse.ui.actions.ActionFactory

class UndoAction extends SnapshotAction{
	
	new(SnapshotRepository repository) {
		super(repository)
		actionDefinitionId = ActionFactory.UNDO.commandId
	}
	
	override run() {
		editDomain.commandStack.undo()
	}
	
	override update() {
		setEnabled(editDomain.commandStack.canUndo)
		text = if(enabled){
			'''Undo «editDomain.commandStack.undoCommand.label»'''			
		}else{
			"Undo"
		}
	}
	
	def getEditDomain(){
		SnapshotCore::editingDomain
	}

}
package net.jeeeyul.pdetools.clipboard.internal;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import net.jeeeyul.pdetools.model.pdetools.ClipHistory;

public class UndoAction extends ClipboardHistoryAction {

	public UndoAction(ClipHistory clipHistory) {
		super(clipHistory);
		setText("Undo");
	}

	@Override
	public void update() {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(getClipHistory());
		CommandStack commandStack = domain.getCommandStack();
		boolean canUndo = commandStack.canUndo();
		setEnabled(canUndo);

		if (canUndo) {
			setText("Undo " + commandStack.getUndoCommand().getLabel());
		} else {
			setText("Undo");
		}
	}

	@Override
	public void run() {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(getClipHistory());
		CommandStack commandStack = domain.getCommandStack();
		commandStack.undo();
	}

}

package net.jeeeyul.pdetools.clipboard.internal;

import net.jeeeyul.pdetools.model.pdetools.ClipHistory;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;
import net.jeeeyul.pdetools.shared.ConfirmDialog;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;

public class RemoveAllAction extends ClipboardHistoryAction {
	public RemoveAllAction(ClipHistory clipHistory) {
		super(clipHistory);
		setId("net.jeeeyul.pdetools.clipboard.removeAll");
		setText("Remove All Clipboard History");
		setImageDescriptor(SharedImages.getImageDescriptor(SharedImages.DELETE_ALL));
	}

	@Override
	public void update() {
		setEnabled(getClipHistory().getEntries().size() > 0);
	}

	@Override
	public void run() {
		ConfirmDialog dialog = new ConfirmDialog(
				ClipboardPreferenceConstants.CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES);
		dialog.setMessage("Do you really want to remove all clipboard histories?");

		if (dialog.open() == IDialogConstants.YES_ID) {
			ClipHistory clipHistory = getClipHistory();
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(clipHistory);
			RemoveCommand command = new RemoveCommand(domain, clipHistory,
					PdetoolsPackage.eINSTANCE.getClipHistory_Entries(), clipHistory.getEntries());
			command.setLabel("Remove all clipboard contents");
			domain.getCommandStack().execute(command);
		}
	}
}

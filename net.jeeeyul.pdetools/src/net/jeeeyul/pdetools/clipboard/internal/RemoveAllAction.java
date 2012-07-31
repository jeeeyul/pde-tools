package net.jeeeyul.pdetools.clipboard.internal;

import org.eclipse.jface.dialogs.IDialogConstants;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.shared.ConfirmDialog;
import net.jeeeyul.pdetools.shared.SharedImages;

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
				ClipboardPreferenceConstants.DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES);
		dialog.setMessage("Do you really want to remove all clipboard histories?");

		if (dialog.open() == IDialogConstants.YES_ID) {
			getClipHistory().getEntries().clear();
		}
	}
}

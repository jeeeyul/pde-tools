package net.jeeeyul.pdetools.clipboard.internal;

import net.jeeeyul.pdetools.clipboard.ClipboardHistoryAction;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
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
		getClipHistory().getEntries().clear();
	}
}

package net.jeeeyul.pdetools.clipboard.internal;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;

import org.eclipse.jface.action.Action;

public abstract class ClipboardHistoryAction extends Action {
	private ClipHistory clipHistory;

	protected ClipHistory getClipHistory() {
		return clipHistory;
	}

	public ClipboardHistoryAction(ClipHistory clipHistory) {
		this.clipHistory = clipHistory;
	}

	public abstract void update();
}

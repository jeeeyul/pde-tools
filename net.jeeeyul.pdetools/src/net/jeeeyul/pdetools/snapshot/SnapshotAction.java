package net.jeeeyul.pdetools.snapshot;

import java.util.List;

import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry;
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository;

import org.eclipse.jface.action.Action;

public class SnapshotAction extends Action {
	private SnapshotRepository repository;
	private List<SnapshotEntry> selection;

	public List<SnapshotEntry> getSelection() {
		return selection;
	}

	public SnapshotRepository getRepository() {
		return repository;
	}

	public SnapshotAction(SnapshotRepository repository) {
		this.repository = repository;
	}

	public void update() {

	}

	public void setSelection(List<SnapshotEntry> selection) {
		this.selection = selection;

	}

}

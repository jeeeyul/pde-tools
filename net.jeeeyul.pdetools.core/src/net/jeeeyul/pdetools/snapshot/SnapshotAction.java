package net.jeeeyul.pdetools.snapshot;

import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;

import org.eclipse.jface.action.Action;

public class SnapshotAction extends Action {
	private SnapshotRepository repository;

	public SnapshotRepository getRepository() {
		return repository;
	}

	public SnapshotAction(SnapshotRepository repository) {
		this.repository = repository;
	}

	public void update() {

	}

}

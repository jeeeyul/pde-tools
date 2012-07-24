package net.jeeeyul.pdetools.snapshot;

import net.jeeeyul.pdetools.shared.SharedImages;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class SnapshotEditorInput implements IEditorInput {
	private SnapshotEntry snapshot;

	public SnapshotEditorInput(SnapshotEntry snapshotEntry) {
		snapshot = snapshotEntry;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		return null;
	}

	@Override
	public boolean exists() {
		return true;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return SharedImages.getImageDescriptor(SharedImages.CAMERA);
	}

	@Override
	public String getName() {
		return snapshot.getFileName();
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return null;
	}

	@Override
	public int hashCode() {
		return snapshot.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SnapshotEditorInput) {
			return this.snapshot == ((SnapshotEditorInput) obj).snapshot;
		}
		return super.equals(obj);
	}

}

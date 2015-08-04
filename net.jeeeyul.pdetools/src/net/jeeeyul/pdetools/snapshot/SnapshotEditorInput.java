package net.jeeeyul.pdetools.snapshot;

import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class SnapshotEditorInput implements IEditorInput {
	private SnapshotEntry snapshot;

	public SnapshotEntry getSnapshot() {
		return snapshot;
	}

	public SnapshotEditorInput(SnapshotEntry snapshotEntry) {
		snapshot = snapshotEntry;
	}

	@SuppressWarnings("unchecked")
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
		return snapshot.getOriginalFile();
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		/*
		 * eclipse 4.2 allows no tooltip text but 3.7.
		 * 
		 * 3: Can't open snapshot in eclipse 3.7
		 * https://github.com/jeeeyul/pde-tools/issues/issue/3
		 */
		return getName();
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

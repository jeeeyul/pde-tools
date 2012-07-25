package net.jeeeyul.pdetools.shared;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.progress.UIJob;

public abstract class DeferredViewerUpdate<T extends Viewer> extends UIJob {
	private ArrayList<Object> preservedSelection = new ArrayList<Object>();

	private T viewer;

	public DeferredViewerUpdate(T viewer) {
		super("뷰어 업데이트");
		setSystem(true);
		this.viewer = viewer;
	}

	public void preservedDeselect(Object oldValue) {
		this.preservedSelection.remove(oldValue);
	}

	public void preserveSelect(Object newValue) {
		if (newValue != null) {
			this.preservedSelection.add(newValue);
		}
	}

	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		update(this.viewer);
		if (this.preservedSelection.size() > 0) {
			this.viewer.setSelection(new StructuredSelection(this.preservedSelection.toArray()), true);
			this.preservedSelection.clear();
		}
		this.viewer.setData("scheduled-update", null);
		this.viewer.getControl().update();
		return Status.OK_STATUS;
	}

	protected abstract void update(T viewer);

}

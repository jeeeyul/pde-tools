package net.jeeeyul.pdetools.shared;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.progress.UIJob;

public abstract class DeferredViewerUpdate<T extends Viewer> extends UIJob {
	private T viewer;

	public DeferredViewerUpdate(T viewer) {
		super("뷰어 업데이트");
		setSystem(true);
		this.viewer = viewer;
	}

	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		if (viewer.getControl().isDisposed()) {
			return Status.OK_STATUS;
		}
		update(this.viewer);
		return Status.OK_STATUS;
	}

	protected abstract void update(T viewer);

}

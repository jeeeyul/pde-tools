package net.jeeeyul.pdetools.clipboard.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.progress.WorkbenchJob;

public class StartClipboardServiceJob extends WorkbenchJob implements IStartup {

	public StartClipboardServiceJob() {
		super("Starting clipboard service");
	}

	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		ClipboardServiceImpl.initailze();
		return Status.OK_STATUS;
	}

	@Override
	public void earlyStartup() {
		schedule();
	}

}

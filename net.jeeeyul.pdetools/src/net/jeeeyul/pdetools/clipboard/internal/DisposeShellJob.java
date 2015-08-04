package net.jeeeyul.pdetools.clipboard.internal;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.progress.UIJob;

public class DisposeShellJob extends UIJob {

	public DisposeShellJob(Shell shell) {
		super("Disposing Shell");
		Assert.isNotNull(shell);
		this.shell = shell;
		setSystem(true);

	}

	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		if (!shell.isDisposed())
			shell.dispose();
		return Status.OK_STATUS;
	}

	private Shell shell;

}

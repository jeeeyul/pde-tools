package net.jeeeyul.pdetools.clipboard.internal;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.progress.UIJob;

public class FocusingJob extends UIJob {
	private Control control;

	public FocusingJob(Control control) {
		super("Focusing");
		Assert.isNotNull(control);
		setSystem(true);
		this.control = control;
	}

	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		if (!control.isDisposed()) {
			Control finger = control;
			while (finger != null) {
				if (finger instanceof Shell) {
					Shell shell = (Shell) finger;
					shell.setFocus();
					break;
				}
				finger = finger.getParent();
			}
//			System.out.println(control.setFocus());

		}
		return Status.OK_STATUS;
	}

}

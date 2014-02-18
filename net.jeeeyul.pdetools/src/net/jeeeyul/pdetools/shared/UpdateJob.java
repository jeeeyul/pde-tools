package net.jeeeyul.pdetools.shared;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

public class UpdateJob extends UIJob {
	private Procedure0 procedure;

	public UpdateJob(Procedure0 procedure) {
		super("Update");
		this.procedure = procedure;
		setSystem(true);
	}

	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		if (procedure != null) {
			procedure.apply();
		}
		return Status.OK_STATUS;
	}

}

package net.jeeeyul.pdetools.icg

import org.eclipse.ui.progress.WorkbenchJob
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.ui.dialogs.PreferencesUtil

class OpenICGPropertyJob extends WorkbenchJob {
	IProject project
	new(IProject project){
		super("Open ICG Property")
		system = true
		this.project = project
	}

	override runInUIThread(IProgressMonitor monitor) {
		var dialog = PreferencesUtil::createPropertyDialogOn(display.activeShell, project, ICGPropertyPage::ID, null, null);
		dialog.open();
		return Status::OK_STATUS
	}
	
}
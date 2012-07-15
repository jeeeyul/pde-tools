package net.jeeeyul.pdetools.icg.refactor

import org.eclipse.ltk.core.refactoring.participants.MoveParticipant
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext
import org.eclipse.core.resources.IFolder
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import org.eclipse.core.runtime.Path
import org.eclipse.ltk.core.refactoring.RefactoringStatus

class MoveMonitorFolder extends MoveParticipant {
	IFolder currentMonitorFolder

	override checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
		new RefactoringStatus();
	}
	
	override createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		var project = currentMonitorFolder.project
		return new SetMonitorChangeFactory(project, project.getFolder(new Path(arguments.destination.toString))).createChange
	}
	
	override getName() {
		return "Change Monitoring Folder name in ICG Configuration";
	}
	
	override protected initialize(Object element) {
		if (!(element instanceof IFolder)) {
			return false;
		}
		var folder = element as IFolder;
		if (!folder.equals(new ICGConfiguration(folder.getProject()).getMonitoringFolder())) {
			return false;
		}
		this.currentMonitorFolder = folder;
		return true;
	}
	
}
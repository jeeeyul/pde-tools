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
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IPath

class MoveMonitorFolder extends MoveParticipant {
	IFolder currentMonitorFolder

	override checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
		new RefactoringStatus();
	}
	
	override createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		var project = currentMonitorFolder.project
		var IPath newPath = new Path(arguments.destination.toString) as IPath
		newPath = newPath.removeFirstSegments(1)
		newPath = newPath.append(currentMonitorFolder.name)
		
		return new SetMonitorChangeFactory(project, ResourcesPlugin::workspace.root.getFolder(newPath)).createChange
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
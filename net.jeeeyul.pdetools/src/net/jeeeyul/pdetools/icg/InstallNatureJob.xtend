package net.jeeeyul.pdetools.icg

import java.util.List
import org.eclipse.core.resources.ICommand
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.SubProgressMonitor
import org.eclipse.ui.progress.WorkbenchJob

class InstallNatureJob extends WorkbenchJob {
	IProject project
	new(IProject project) {
		super("Install ICG Nature")
		this.project = project
		user = true
	}

	override runInUIThread(IProgressMonitor monitor) {
		monitor.beginTask("Install ICG Nature", 100);
		project.refreshLocal(IResource::DEPTH_INFINITE, new SubProgressMonitor(monitor, 50));
		
		var description = project.description;
		var List<ICommand> buildCommands = newArrayList(description.buildSpec);
		
		buildCommands += description.newCommand() => [
			builderName = ICGConstants::BUILDER_ID
		];
		description.buildSpec = buildCommands;
		
		project.setDescription(description, new NullProgressMonitor());
		
		var config = new ICGConfiguration(project) =>[
			monitoringFolder = project.getFolder("icons")
			imageFileExtensions = newArrayList("jpg", "gif", "png")
			generateSrcFolder = project.getFolder("src-gen")
			generatePackageName = "shared"
			generateClassName = "SharedImages"
			markDerived = false
		]
		config.save();
		monitor	.done();
		new OpenICGPropertyJob(project).schedule();
		return Status::OK_STATUS
	}
	
}
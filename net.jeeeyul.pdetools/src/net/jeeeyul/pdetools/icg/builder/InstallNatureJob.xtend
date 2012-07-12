package net.jeeeyul.pdetools.icg.builder

import java.util.List
import net.jeeeyul.pdetools.icg.ICGConstants
import net.jeeeyul.pdetools.icg.ui.OpenICGPropertyJob
import org.eclipse.core.resources.ICommand
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.SubProgressMonitor
import org.eclipse.ui.progress.WorkbenchJob
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration

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
			if(monitoringFolder == null)
				monitoringFolder = project.getFolder("icons")
			if(imageFileExtensions == null)
				imageFileExtensions = newArrayList("jpg", "gif", "png")
			if(generateSrcFolder == null)
				generateSrcFolder = project.getFolder("src-gen")
			if(generatePackageName == null)
				generatePackageName = "shared"
			if(generateClassName == null)
				generateClassName = "SharedImages"
		]
		config.save();
		monitor	.done();
		new OpenICGPropertyJob(project).schedule();
		return Status::OK_STATUS
	}
}
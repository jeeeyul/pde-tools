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
		var icgBuilderCommand = description.newCommand() => [
			builderName = ICGConstants::BUILDER_ID
		];
		
		buildCommands.add(0, icgBuilderCommand)
		
		description.buildSpec = buildCommands;
		project.setDescription(description, new NullProgressMonitor());
		var config = new ICGConfiguration(project) =>[
			if(monitoringFolder == null)
				monitoringFolder = project.getFolder("icons")
			if(imageFileExtensions == null || imageFileExtensions.empty)
				imageFileExtensions = newArrayList("jpg", "gif", "png")
			if(generateSrcFolder == null)
				generateSrcFolder = project.getFolder("src-gen")
			if(generatePackageName.nullOrBlank)
				generatePackageName = "shared"
			if(generateClassName.nullOrBlank)
				generateClassName = "SharedImages"
			generateImagePreview = true
			markDerived = true
		]
		config.save();
		monitor.done();
		new OpenICGPropertyJob(project).schedule();
		return Status::OK_STATUS
	}

	def nullOrBlank(String string){
		if(string == null) {
			true
		} else {
			string.trim.empty
		}
	}
}
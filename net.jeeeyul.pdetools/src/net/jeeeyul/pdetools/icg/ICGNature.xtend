package net.jeeeyul.pdetools.icg

import org.eclipse.core.resources.IProjectNature
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.xtend.lib.Property
import java.util.List
import org.eclipse.core.resources.ICommand
import org.eclipse.core.runtime.NullProgressMonitor

class ICGNature implements IProjectNature {
	@Property IProject project
	
	override configure() throws CoreException {
		var description = project.description;
		var List<ICommand> buildCommands = newArrayList(description.buildSpec);
		
		buildCommands += description.newCommand() => [
			builderName = ICGConstants::BUILDER_ID
		];
		description.buildSpec = buildCommands;
		
		project.setDescription(description, new NullProgressMonitor());
	}
	
	override deconfigure() throws CoreException {
		var description = project.description;

		var newBuildSpec = description.buildSpec.filter[it.builderName != ICGConstants::BUILDER_ID];
		description.buildSpec = newBuildSpec;
		
		project.setDescription(description, new NullProgressMonitor());
	}
}
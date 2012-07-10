package net.jeeeyul.pdetools.icg.builder

import net.jeeeyul.pdetools.icg.ICGConstants
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectNature
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtend.lib.Property

class ICGNature implements IProjectNature {
	@Property IProject project

	override configure() throws CoreException {
		new InstallNatureJob(project).schedule()
	}

	override deconfigure() throws CoreException {
		var description = project.description; var newBuildSpec = description.buildSpec.filter[ it.builderName != ICGConstants::BUILDER_ID ]; description.buildSpec = newBuildSpec; project.setDescription(description, new NullProgressMonitor());
	}
}
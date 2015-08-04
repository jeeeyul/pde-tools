package net.jeeeyul.pdetools.icg.builder

import com.google.inject.Guice
import java.util.Map
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors

class ICGBuilder extends IncrementalProjectBuilder {
	new() {
	}
	@Accessors int kind

	override protected build(int kind, Map<String, String>args, IProgressMonitor monitor) throws CoreException {
		var building = new Building()
		Guice::createInjector(new BuildModule(this, kind)).injectMembers(building)
		return building.build(monitor)
	}
}
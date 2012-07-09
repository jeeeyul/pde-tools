package net.jeeeyul.pdetools.icg.builder

import java.util.Map
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.Property

class ICGBuilder extends IncrementalProjectBuilder {
	new() {
	}
	@Property int kind

	override protected build(int kind, Map<String, String>args, IProgressMonitor monitor) throws CoreException {
		var building = new Building(this, kind)
		return building.build(monitor)
	}
}
 
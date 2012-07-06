package net.jeeeyul.pdetools.icg

import org.eclipse.core.resources.IncrementalProjectBuilder
import java.util.Map
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor

class ICGBuilder extends IncrementalProjectBuilder {
	override protected build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
	}
} 
package net.jeeeyul.pdetools.icg

import org.eclipse.core.resources.IncrementalProjectBuilder
import java.util.Map
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import java.util.ArrayList
import org.eclipse.core.resources.IProject

class ICGBuilder extends IncrementalProjectBuilder {
	new() {
		println("ºô´õ »ý¼º")
	}
	
	override protected build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
		return new ArrayList<IProject>()
	}
	
	def hasToBuild(){
	}
	
} 
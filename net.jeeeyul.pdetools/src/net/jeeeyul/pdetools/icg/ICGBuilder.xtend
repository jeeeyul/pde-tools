package net.jeeeyul.pdetools.icg

import java.util.ArrayList
import java.util.Map
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor

class ICGBuilder extends IncrementalProjectBuilder {
	new() {
	}
	
	override protected build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
		var cfg = new ICGConfiguration(project)
		if(cfg.monitoringFolder.exists){
			var mg = new net.jeeeyul.pdetools.icg.model.ResourceMappingModelGenerator()
			var palette = mg.generatePalette(cfg.monitoringFolder);
		}
		
		return new ArrayList<IProject>()
	}
	
	def hasToBuild(){
	}
	
} 
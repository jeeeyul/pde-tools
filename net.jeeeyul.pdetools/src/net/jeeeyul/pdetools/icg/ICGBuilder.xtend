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
			// ÆÈ·¹Æ® ¸ðµ¨ »ý¼º
			var mg = new net.jeeeyul.pdetools.icg.model.PaletteModelGenerator(cfg);
			var palette = mg.generatePalette(cfg.monitoringFolder);
			
			// 
			var generator = new ImageCosntantGenerator();
			generator.rootPalette = palette;
			generator.config = cfg
			println(generator.generate())
		}
		
		return new ArrayList<IProject>()
	}
	
	def hasToBuild(){
	}
	
} 
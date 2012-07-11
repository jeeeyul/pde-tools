package net.jeeeyul.pdetools.icg.builder.parts

import com.google.inject.Inject
import net.jeeeyul.pdetools.icg.builder.model.BuildContext
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import org.eclipse.core.resources.IncrementalProjectBuilder
import com.google.inject.Singleton

@Singleton
class ResourceDeltaPart {
	@Inject
	extension IncrementalProjectBuilder builder
	
	@Inject
	ICGConfiguration config
	
	@Inject
	BuildContext buildContext
	
	def hasResourceDelta(){
		var monitoringFolder = config.monitoringFolder
		if(buildContext.buildKind != IncrementalProjectBuilder::CLEAN_BUILD && buildContext.buildKind != IncrementalProjectBuilder::FULL_BUILD) {
			var projectDelta = project.delta
			if(projectDelta == null) {
				return false;
			}
			
			if(monitoringFolder == null) {
				return false
			}
			if(!monitoringFolder.exists) {
				return false;
			}
			var monitoredDelta = projectDelta.findMember(config.monitoringFolder.projectRelativePath)
			if(monitoredDelta == null) {
				return false;
			}
		}
		
		if(!monitoringFolder.exists){
			return false
		}
		
		return true;
	}	
	
}
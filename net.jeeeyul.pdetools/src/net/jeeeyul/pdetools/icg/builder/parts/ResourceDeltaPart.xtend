package net.jeeeyul.pdetools.icg.builder.parts

import com.google.inject.Inject
import net.jeeeyul.pdetools.icg.builder.model.BuildContext
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import org.eclipse.core.resources.IncrementalProjectBuilder
import com.google.inject.Singleton
import java.util.List
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path

@Singleton
class ResourceDeltaPart {
	
	def private List<IPath> affectPathList(){
		val List<IPath> affectPathes = newArrayList();
		
		affectPathes += new Path(".settings/net.jeeeyul.pdetools.icg.prefs")
		affectPathes += config.monitoringFolder.projectRelativePath
		
		return affectPathes
	}
	
	@Inject
	extension IncrementalProjectBuilder builder
	
	@Inject
	ICGConfiguration config
	
	@Inject
	BuildContext buildContext
	
	def hasResourceDelta(){
		if(buildContext.buildKind == IncrementalProjectBuilder::CLEAN_BUILD || buildContext.buildKind == IncrementalProjectBuilder::FULL_BUILD) {
			return true;
		}
		
		var projectDelta = project.delta
		if(projectDelta == null) {
			return false;
		}
		
		for(eachPath : affectPathList){
			if(projectDelta.findMember(eachPath) != null){
				return true
			}
		}		
		
		return false;
	}	
	
}
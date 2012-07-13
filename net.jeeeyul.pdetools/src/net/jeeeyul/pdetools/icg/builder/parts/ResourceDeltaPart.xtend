package net.jeeeyul.pdetools.icg.builder.parts

import com.google.inject.Inject
import net.jeeeyul.pdetools.icg.builder.model.BuildContext
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import org.eclipse.core.resources.IncrementalProjectBuilder
import com.google.inject.Singleton
import java.util.List
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import net.jeeeyul.pdetools.Activator

@Singleton
class ResourceDeltaPart {
	
	def private List<IPath> affectPathList(){
		val List<IPath> affectPathes = newArrayList();
		
		/*
		 * 빌더 설정 변경시 다시 빌드
		 */
		affectPathes += new Path('''.settings/«Activator::PLUGIN_ID».icg.prefs''')
		
		/*
		 * 모니터링 폴더 내부의 컨텐츠 변경
		 */
		affectPathes += config.monitoringFolder.projectRelativePath
		
		/*
		 * 번들 아이디가 변경되면 다시 빌드 해야 함
		 */
		affectPathes += new Path("META-INF/MANIFEST.MF")
		
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
package net.jeeeyul.pdetools.icg.builder.parts

import java.util.List
import net.jeeeyul.pdetools.icg.builder.model.BuildError
import org.eclipse.core.resources.IProject
import com.google.inject.Inject
import org.eclipse.core.resources.IResource
import net.jeeeyul.pdetools.icg.ICGConstants
import org.eclipse.core.resources.IMarker
import com.google.inject.Singleton

@Singleton
class ErrorPart {
	@Inject
	IProject project
	
	List<BuildError>errors = newArrayList() ;

	def error(BuildError error) {
		errors += error
	}

	def getErrors() {
		errors
	}
	
	def error((BuildError)=>void initializer){
		var error = new BuildError()
		initializer.apply(error)
		error(error)
	}
	
	/**
	 * 빌드 가능 여부를 리턴한다.
	 */
	def canBuild(){
		errors.filter[fatal == true].size == 0
	}
	
	def generateMarkers(){
		for(e : errors){
			project.createMarker(ICGConstants::PROBLEM_MARKER_TYPE) =>[
				setAttribute(IMarker::MESSAGE, e.message)
				setAttribute(IMarker::SEVERITY, e.markerSeverity)
				setAttribute(IMarker::LOCATION, "ICG Configuration")
				if(type != null){
					setAttribute(ICGConstants::BUILD_ERROR_TYPE_MARKER_ATTRIBUTE, e.type)
				}
			]
		}
	}
	
	def cleanMarkers(){
		var markers = project.findMarkers(ICGConstants::PROBLEM_MARKER_TYPE, true, IResource::DEPTH_INFINITE)
		markers.forEach[delete()]
	}
	
	def int markerSeverity(BuildError e){
		if(e.fatal){
			IMarker::SEVERITY_ERROR
		}else{
			IMarker::SEVERITY_WARNING
		}
	}
}
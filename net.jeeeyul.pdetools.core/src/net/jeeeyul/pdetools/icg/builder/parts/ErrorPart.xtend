package net.jeeeyul.pdetools.icg.builder.parts

import java.util.List
import net.jeeeyul.pdetools.icg.builder.model.BuildError
import org.eclipse.core.resources.IProject
import com.google.inject.Inject
import org.eclipse.core.resources.IResource
import net.jeeeyul.pdetools.icg.ICGConstants
import org.eclipse.core.resources.IMarker
import com.google.inject.Singleton
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.ui.texteditor.DocumentProviderRegistry
import org.eclipse.ui.texteditor.IDocumentProvider
import org.eclipse.pde.internal.core.text.build.BuildModel
import org.eclipse.pde.internal.core.text.IDocumentKey
import org.eclipse.core.runtime.Path

@Singleton
class ErrorPart {
	@Inject
	ICGConfiguration config
	
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
			var resource = project as IResource
			if(e.relatedResource != null){
				resource = e.relatedResource
			}
			
			resource.createMarker(ICGConstants::PROBLEM_MARKER_TYPE) =>[
				setAttribute(IMarker::MESSAGE, e.message)
				setAttribute(IMarker::SEVERITY, e.markerSeverity)
				setAttribute(IMarker::LOCATION, "ICG Configuration")
				if(e.type != null){
					setAttribute(ICGConstants::BUILD_ERROR_TYPE_MARKER_ATTRIBUTE, e.type)
				}
				if(e.lineNumber >= 0){
					setAttribute(IMarker::LINE_NUMBER, e.lineNumber)
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
	
	def void validate(){
		if(config.monitoringFolder == null){
			error[
				fatal = true
				message = "Monitoring Folder is not set"
			];
		}
		
		else if(!config.monitoringFolder.exists){
			error[
				fatal = true
				message = '''Monitoring Folder(«config.monitoringFolder.fullPath.toPortableString») not exists'''
				type = "monitor-folder-not-exists"
			]
		}
		
		else{
			var buildFile = project.getFile("build.properties")
			var input = new FileEditorInput(buildFile);
			var IDocumentProvider provider = DocumentProviderRegistry::getDefault().getDocumentProvider(new FileEditorInput(buildFile)) as IDocumentProvider
			
			provider.connect(input)
			val doc = provider.getDocument(input)
			
			val buildModel = new BuildModel(doc, true)
			buildModel.load()
			
			val binaryBuildEntry = buildModel.build.buildEntries.findFirst[it.name == "bin.includes"]
			
			var included = binaryBuildEntry.tokens.exists[
				new Path(it).isPrefixOf(config.monitoringFolder.projectRelativePath)
			]
			
			if(!included){
				error[
					fatal = true
					message = '''Monitoring Folder(«config.monitoringFolder.fullPath.toPortableString») is not included to binary build entry'''
					relatedResource = project.getFile("build.properties")
					lineNumber = doc.getLineOfOffset((binaryBuildEntry as IDocumentKey).offset) + 1
					type = "missing-build-entry"
				]
				
				buildModel.dispose()
			}
			
			provider.disconnect(input)
			
		}
		
		if(config.generatePackageName.nullOrBlank){
			error[
				fatal = true
				message = "package to generate is not setted"
			]
		}
		
		if(config.generateClassName.nullOrBlank){
			error[
				fatal = true
				message = "class name to generate is not setted"
			]
		}
		
		if(config.generateSrcFolder == null){
			error[
				fatal = true
				message = "Source folder to generate is not setted"
			]
		}
		
		if(config.imageFileExtensions == null || config.imageFileExtensions.size == 0){
			error[
				fatal = false
				message = "No image file extensions are setted"
			]
		}
	}
	
	def boolean isNullOrBlank(String src){
		if(src == null){
			return true
		}else{
			return src.trim.empty
		}
	}
}
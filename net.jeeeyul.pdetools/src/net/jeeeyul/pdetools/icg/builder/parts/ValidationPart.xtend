package net.jeeeyul.pdetools.icg.builder.parts

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import com.google.inject.Inject
import net.jeeeyul.pdetools.icg.builder.parts.ErrorPart
import org.eclipse.pde.core.plugin.PluginRegistry
import org.eclipse.core.resources.IProject

class ValidationPart {
	@Inject
	ICGConfiguration config
	
	@Inject
	extension ErrorPart
	
	@Inject
	extension IProject project
	
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
			var pluginModel = PluginRegistry::findModel(project)
			var buildModel = PluginRegistry::createBuildModel(pluginModel)
			var binaryBuildEntry = buildModel.build.buildEntries.findFirst[it.name == "bin.includes"]
			
			if(!binaryBuildEntry.contains(config.monitoringFolder.projectRelativePath.toPortableString+"/")){
				error[
					fatal = false
					message = '''Monitoring Folder(«config.monitoringFolder.fullPath.toPortableString») is not included to binary build entry'''
					relatedResource = project.getFile("build.properties")
				]
				buildModel.dispose()
			}
			
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
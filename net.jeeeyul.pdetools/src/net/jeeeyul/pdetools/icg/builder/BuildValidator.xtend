package net.jeeeyul.pdetools.icg.builder

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import com.google.inject.Inject

class BuildValidator {
	@Inject
	ICGConfiguration config
	
	@Inject
	extension BuildErrorAcceptor
	
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
				message = "Monitoring Folder not exists"
				type = "monitor-folder-not-exists"
			]
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
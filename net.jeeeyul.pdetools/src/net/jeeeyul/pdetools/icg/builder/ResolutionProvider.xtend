package net.jeeeyul.pdetools.icg.builder

import java.util.ArrayList
import net.jeeeyul.pdetools.icg.ICGConstants
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.icg.builder.model.Resolution
import net.jeeeyul.pdetools.icg.ui.OpenICGPropertyJob
import net.jeeeyul.pdetools.shared.SharedImages
import org.eclipse.core.resources.IMarker
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.pde.core.IEditableModel
import org.eclipse.pde.core.plugin.PluginRegistry
import org.eclipse.ui.IMarkerResolution
import org.eclipse.ui.IMarkerResolutionGenerator
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.ide.undo.CreateFolderOperation

class ResolutionProvider implements IMarkerResolutionGenerator {
	override IMarkerResolution[] getResolutions(IMarker marker) {
		var result = new ArrayList<IMarkerResolution>
		
		switch(marker.errorType){
			case "missing-build-entry":{
				result += new Resolution => [
					label = "Add image monitoring folder to Binary Build Entry"
					description = "Image folder is not included as binary build entry."
					fixCode = [
						var cfg = new ICGConfiguration(resource.project)
						var plugin = PluginRegistry::findModel(marker.resource.project)
						var buildModel = PluginRegistry::createBuildModel(plugin)
						buildModel.build.getEntry("bin.includes").addToken(cfg.monitoringFolder.projectRelativePath.toPortableString + "/")
						(buildModel as IEditableModel).save()
						buildModel.dispose()
					]
					image = SharedImages::getImage(SharedImages::ADD)
				]
				result += marker.createReconfigResolution()		
			}
			
			case "monitor-folder-not-exists" :{
				result += new Resolution => [
					label = "Creates monitoring folder"
					fixCode = [
						var cfg = new ICGConfiguration(resource.project)
						var op = new CreateFolderOperation(cfg.monitoringFolder, null, "Monitoring folder creation");
						PlatformUI::workbench.operationSupport.operationHistory.execute(op, new NullProgressMonitor, null)
					]
					image = SharedImages::getImage(SharedImages::ADD)
					
				]
				result += marker.createReconfigResolution()
			}
			
			default:{
				result += marker.createReconfigResolution()
			}
			
		}
		return result
	}
	
	def private createReconfigResolution(IMarker marker){
		new Resolution => [
			label = "Re-config Image Constant Generator"
			fixCode = [new OpenICGPropertyJob(marker.resource.project).schedule]
			image = SharedImages::getImage(SharedImages::CONFIGURE)
		]	
	}
	
	def errorType(IMarker marker){
		marker.getAttribute(ICGConstants::BUILD_ERROR_TYPE_MARKER_ATTRIBUTE) 
	}
}
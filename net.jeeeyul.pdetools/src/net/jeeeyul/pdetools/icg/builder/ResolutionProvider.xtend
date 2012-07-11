package net.jeeeyul.pdetools.icg.builder

import java.util.ArrayList
import net.jeeeyul.pdetools.icg.ICGConstants
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.icg.ui.OpenICGPropertyJob
import org.eclipse.core.resources.IMarker
import org.eclipse.ui.IMarkerResolution
import org.eclipse.ui.IMarkerResolutionGenerator
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.ide.undo.CreateFolderOperation
import org.eclipse.core.runtime.NullProgressMonitor
import net.jeeeyul.pdetools.icg.builder.model.Resolution

class ResolutionProvider implements IMarkerResolutionGenerator {
	override IMarkerResolution[] getResolutions(IMarker marker) {
		var result = new ArrayList<IMarkerResolution>
		
		switch(marker.errorType){
			case "monitor-folder-not-exists" :{
				result += new Resolution => [
					label = "Creates monitoring folder"
					fixCode = [
						var cfg = new ICGConfiguration(resource.project)
						var op = new CreateFolderOperation(cfg.monitoringFolder, null, "Monitoring folder creation");
						PlatformUI::workbench.operationSupport.operationHistory.execute(op, new NullProgressMonitor, null)
					]
				]
				result += new Resolution => [
					label = "Reconfig Image Constant Generator"
					fixCode = [new OpenICGPropertyJob(marker.resource.project).schedule]
				]		
			}
			
			default:{
				result += new Resolution => [
					label = "Reconfig Image Constant Generator"
					fixCode = [new OpenICGPropertyJob(marker.resource.project).schedule]
				]
			}
			
		}
		return result
	}
	
	def errorType(IMarker marker){
		marker.getAttribute(ICGConstants::BUILD_ERROR_TYPE_MARKER_ATTRIBUTE) 
	}
}
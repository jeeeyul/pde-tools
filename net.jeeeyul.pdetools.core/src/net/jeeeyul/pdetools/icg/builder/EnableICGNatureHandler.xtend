package net.jeeeyul.pdetools.icg.builder

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jface.viewers.IStructuredSelection

import static extension org.eclipse.ui.handlers.HandlerUtil.*
import org.eclipse.core.runtime.Platform
import net.jeeeyul.pdetools.icg.ICGConstants
import org.eclipse.ui.PlatformUI

class EnableICGNatureHandler extends AbstractHandler {
	override execute(ExecutionEvent event) throws ExecutionException {
		if(!(event.currentSelection instanceof IStructuredSelection)){
			return null;
		}
		
		var saved = PlatformUI::workbench.saveAllEditors(true)
		if(!saved){
			return null
		}
		
		var selection = event.currentSelection as IStructuredSelection
		for(each : selection.toArray){
			var project = Platform::adapterManager.getAdapter(each, typeof(IProject)) as IProject;
			if(project != null){
				var description = project.description;
				var natures = newArrayList(description.natureIds)
				natures += ICGConstants::NATURE_ID
				description.natureIds = natures
				project.setDescription(description, new NullProgressMonitor());
			}
		}
		return null;
	}
}
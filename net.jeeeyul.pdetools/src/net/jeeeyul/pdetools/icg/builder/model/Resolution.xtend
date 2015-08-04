package net.jeeeyul.pdetools.icg.builder.model

import org.eclipse.ui.IMarkerResolution
import org.eclipse.core.resources.IMarker
import org.eclipse.ui.IMarkerResolution2
import org.eclipse.swt.graphics.Image

class Resolution implements IMarkerResolution, IMarkerResolution2{
	@Property String label
	@Property String description
	@Property Image image
	
	(IMarker)=>void fixCode
	
	def setFixCode((IMarker)=>void fixCode){
		this.fixCode = fixCode
	}
	
	override run(IMarker marker) {
		fixCode?.apply(marker)
	}
	
}
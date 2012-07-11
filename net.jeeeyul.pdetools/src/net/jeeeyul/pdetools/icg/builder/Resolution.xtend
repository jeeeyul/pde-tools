package net.jeeeyul.pdetools.icg.builder

import org.eclipse.ui.IMarkerResolution
import org.eclipse.core.resources.IMarker

class Resolution implements IMarkerResolution{
	@Property String label
	
	(IMarker)=>void fixCode
	
	def setFixCode((IMarker)=>void fixCode){
		this.fixCode = fixCode
	}
	
	override run(IMarker marker) {
		fixCode?.apply(marker)
	}
	
}
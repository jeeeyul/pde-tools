package net.jeeeyul.pdetools.icg.builder

import org.eclipse.core.resources.IMarker
import org.eclipse.ui.IMarkerResolution

class ReconfigResolution implements IMarkerResolution {
	override getLabel() {
		"Config ICG Settings"
	}

	override void run(IMarker marker) {
		
	}
}
package net.jeeeyul.pdetools.icg.builder

import org.eclipse.ui.IMarkerResolutionGenerator
import org.eclipse.ui.IMarkerResolution
import org.eclipse.core.resources.IMarker

class ResolutionProvider implements IMarkerResolutionGenerator {
	override IMarkerResolution[] getResolutions(IMarker marker) {
		return emptyList
	}
}
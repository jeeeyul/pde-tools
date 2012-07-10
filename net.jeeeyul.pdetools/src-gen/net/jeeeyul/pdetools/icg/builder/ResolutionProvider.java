package net.jeeeyul.pdetools.icg.builder;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

@SuppressWarnings("all")
public class ResolutionProvider implements IMarkerResolutionGenerator {
  public IMarkerResolution[] getResolutions(final IMarker marker) {
    return null;
  }
}

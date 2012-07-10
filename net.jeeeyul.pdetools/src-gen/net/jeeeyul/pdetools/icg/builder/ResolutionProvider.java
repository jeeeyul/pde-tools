package net.jeeeyul.pdetools.icg.builder;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class ResolutionProvider implements IMarkerResolutionGenerator {
  public IMarkerResolution[] getResolutions(final IMarker marker) {
    return ((IMarkerResolution[])Conversions.unwrapArray(CollectionLiterals.<IMarkerResolution>emptyList(), IMarkerResolution.class));
  }
}

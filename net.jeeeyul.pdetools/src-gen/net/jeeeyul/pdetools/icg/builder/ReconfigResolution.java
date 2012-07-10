package net.jeeeyul.pdetools.icg.builder;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;

@SuppressWarnings("all")
public class ReconfigResolution implements IMarkerResolution {
  public String getLabel() {
    return "Config ICG Settings";
  }
  
  public void run(final IMarker marker) {
  }
}

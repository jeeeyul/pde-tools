package net.jeeeyul.pdetools.icg.builder;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Resolution implements IMarkerResolution {
  private String _label;
  
  public String getLabel() {
    return this._label;
  }
  
  public void setLabel(final String label) {
    this._label = label;
  }
  
  private Procedure1<? super IMarker> fixCode;
  
  public Procedure1<? super IMarker> setFixCode(final Procedure1<? super IMarker> fixCode) {
    Procedure1<? super IMarker> _fixCode = this.fixCode = fixCode;
    return _fixCode;
  }
  
  public void run(final IMarker marker) {
    if (this.fixCode!=null) this.fixCode.apply(marker);
  }
}

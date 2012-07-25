package net.jeeeyul.pdetools.icg.builder.model;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Resolution implements IMarkerResolution, IMarkerResolution2 {
  private String _label;
  
  public String getLabel() {
    return this._label;
  }
  
  public void setLabel(final String label) {
    this._label = label;
  }
  
  private String _description;
  
  public String getDescription() {
    return this._description;
  }
  
  public void setDescription(final String description) {
    this._description = description;
  }
  
  private Image _image;
  
  public Image getImage() {
    return this._image;
  }
  
  public void setImage(final Image image) {
    this._image = image;
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

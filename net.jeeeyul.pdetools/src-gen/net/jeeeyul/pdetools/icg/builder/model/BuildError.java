package net.jeeeyul.pdetools.icg.builder.model;

import org.eclipse.core.resources.IResource;

@SuppressWarnings("all")
public class BuildError {
  private String _type;
  
  public String getType() {
    return this._type;
  }
  
  public void setType(final String type) {
    this._type = type;
  }
  
  private boolean _fatal;
  
  public boolean isFatal() {
    return this._fatal;
  }
  
  public void setFatal(final boolean fatal) {
    this._fatal = fatal;
  }
  
  private String _message;
  
  public String getMessage() {
    return this._message;
  }
  
  public void setMessage(final String message) {
    this._message = message;
  }
  
  private IResource _relatedResource;
  
  public IResource getRelatedResource() {
    return this._relatedResource;
  }
  
  public void setRelatedResource(final IResource relatedResource) {
    this._relatedResource = relatedResource;
  }
}

package net.jeeeyul.pdetools.icg.builder.model;

@SuppressWarnings("all")
public class ValidationResult {
  private int _severity;
  
  public int getSeverity() {
    return this._severity;
  }
  
  public void setSeverity(final int severity) {
    this._severity = severity;
  }
  
  private String _message;
  
  public String getMessage() {
    return this._message;
  }
  
  public void setMessage(final String message) {
    this._message = message;
  }
}

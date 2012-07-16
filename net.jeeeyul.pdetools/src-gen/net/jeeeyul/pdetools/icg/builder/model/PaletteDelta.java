package net.jeeeyul.pdetools.icg.builder.model;

import net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner;

@SuppressWarnings("all")
public class PaletteDelta {
  private FieldNameOwner _before;
  
  public FieldNameOwner getBefore() {
    return this._before;
  }
  
  public void setBefore(final FieldNameOwner before) {
    this._before = before;
  }
  
  private FieldNameOwner _after;
  
  public FieldNameOwner getAfter() {
    return this._after;
  }
  
  public void setAfter(final FieldNameOwner after) {
    this._after = after;
  }
}

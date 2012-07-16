package net.jeeeyul.pdetools.icg.builder.model;

import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile;

@SuppressWarnings("all")
public class PaletteDelta {
  private ImageFile _before;
  
  public ImageFile getBefore() {
    return this._before;
  }
  
  public void setBefore(final ImageFile before) {
    this._before = before;
  }
  
  private ImageFile _after;
  
  public ImageFile getAfter() {
    return this._after;
  }
  
  public void setAfter(final ImageFile after) {
    this._after = after;
  }
}

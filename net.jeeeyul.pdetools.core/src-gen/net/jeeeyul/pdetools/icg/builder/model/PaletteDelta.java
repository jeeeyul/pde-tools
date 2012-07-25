package net.jeeeyul.pdetools.icg.builder.model;

import com.google.common.base.Objects;
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
  
  public boolean isRefactorTarget() {
    boolean _and = false;
    FieldNameOwner _before = this.getBefore();
    boolean _notEquals = (!Objects.equal(_before, null));
    if (!_notEquals) {
      _and = false;
    } else {
      FieldNameOwner _after = this.getAfter();
      boolean _notEquals_1 = (!Objects.equal(_after, null));
      _and = (_notEquals && _notEquals_1);
    }
    return _and;
  }
}

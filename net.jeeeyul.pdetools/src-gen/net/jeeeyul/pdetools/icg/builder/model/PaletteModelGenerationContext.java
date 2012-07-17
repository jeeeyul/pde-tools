package net.jeeeyul.pdetools.icg.builder.model;

import com.google.common.base.Objects;
import java.util.HashSet;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;

@SuppressWarnings("all")
public class PaletteModelGenerationContext {
  private PaletteModelGenerationContext _parent;
  
  public PaletteModelGenerationContext getParent() {
    return this._parent;
  }
  
  public void setParent(final PaletteModelGenerationContext parent) {
    this._parent = parent;
  }
  
  private Palette palette;
  
  private HashSet<String> takenNames;
  
  public PaletteModelGenerationContext(final Palette palette) {
    HashSet<String> _hashSet = new HashSet<String>();
    this.takenNames = _hashSet;
    this.palette = palette;
  }
  
  public Palette getPalette() {
    return this.palette;
  }
  
  public boolean isRegisteredIconFieldName(final String fieldName) {
    return this.takenNames.contains(fieldName);
  }
  
  public boolean isRegisteredPaletteFieldName(final String fieldName) {
    PaletteModelGenerationContext ctx = this;
    boolean _isRegisteredIconFieldName = this.isRegisteredIconFieldName(fieldName);
    if (_isRegisteredIconFieldName) {
      return true;
    }
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(ctx, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(ctx.palette, null));
      _and = (_notEquals && _notEquals_1);
    }
    boolean _while = _and;
    while (_while) {
      {
        String _fieldName = ctx.palette.getFieldName();
        boolean _equals = Objects.equal(_fieldName, fieldName);
        if (_equals) {
          return true;
        }
        PaletteModelGenerationContext _parent = ctx.getParent();
        ctx = _parent;
      }
      boolean _and_1 = false;
      boolean _notEquals_2 = (!Objects.equal(ctx, null));
      if (!_notEquals_2) {
        _and_1 = false;
      } else {
        boolean _notEquals_3 = (!Objects.equal(ctx.palette, null));
        _and_1 = (_notEquals_2 && _notEquals_3);
      }
      _while = _and_1;
    }
    return false;
  }
  
  public boolean registerFieldName(final String fieldName) {
    boolean _add = this.takenNames.add(fieldName);
    return _add;
  }
}

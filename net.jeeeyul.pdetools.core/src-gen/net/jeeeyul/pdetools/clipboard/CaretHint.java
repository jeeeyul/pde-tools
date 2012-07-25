package net.jeeeyul.pdetools.clipboard;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CaretHint {
  private int _x;
  
  public int getX() {
    return this._x;
  }
  
  public void setX(final int x) {
    this._x = x;
  }
  
  private int _y;
  
  public int getY() {
    return this._y;
  }
  
  public void setY(final int y) {
    this._y = y;
  }
  
  private int _height;
  
  public int getHeight() {
    return this._height;
  }
  
  public void setHeight(final int height) {
    this._height = height;
  }
  
  public static CaretHint capture(final StyledText styledText) {
    CaretHint _caretHint = new CaretHint();
    final Procedure1<CaretHint> _function = new Procedure1<CaretHint>() {
        public void apply(final CaretHint it) {
          Caret _caret = styledText.getCaret();
          Point location = _caret.getLocation();
          Point _display = styledText.toDisplay(location);
          location = _display;
          it.setX(location.x);
          it.setY(location.y);
          Caret _caret_1 = styledText.getCaret();
          Rectangle _bounds = _caret_1.getBounds();
          it.setHeight(_bounds.height);
        }
      };
    CaretHint _doubleArrow = ObjectExtensions.<CaretHint>operator_doubleArrow(_caretHint, _function);
    return _doubleArrow;
  }
  
  public static CaretHint capture(final Text text) {
    CaretHint _caretHint = new CaretHint();
    final Procedure1<CaretHint> _function = new Procedure1<CaretHint>() {
        public void apply(final CaretHint it) {
          Point location = text.getCaretLocation();
          Point _display = text.toDisplay(location);
          location = _display;
          it.setX(location.x);
          it.setY(location.y);
          int _lineHeight = text.getLineHeight();
          it.setHeight(_lineHeight);
        }
      };
    CaretHint _doubleArrow = ObjectExtensions.<CaretHint>operator_doubleArrow(_caretHint, _function);
    return _doubleArrow;
  }
}

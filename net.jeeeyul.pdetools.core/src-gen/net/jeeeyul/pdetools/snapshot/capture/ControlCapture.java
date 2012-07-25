package net.jeeeyul.pdetools.snapshot.capture;

import com.google.common.base.Objects;
import java.util.Arrays;
import net.jeeeyul.pdetools.shared.SWTExtensions;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

@SuppressWarnings("all")
public class ControlCapture {
  protected Image _capture(final Control control) {
    Point size = control.getSize();
    Display _display = this.getDisplay();
    Image _image = new Image(_display, size.x, size.y);
    Image image = _image;
    GC _gC = new GC(control);
    GC gc = _gC;
    gc.copyArea(image, 0, 0);
    gc.dispose();
    return image;
  }
  
  protected Image _capture(final Shell shell) {
    Rectangle clientArea = shell.getClientArea();
    Point _location = SWTExtensions.getLocation(clientArea);
    Point _display = shell.toDisplay(_location);
    SWTExtensions.setLocation(clientArea, _display);
    Menu _menuBar = shell.getMenuBar();
    boolean _notEquals = (!Objects.equal(_menuBar, null));
    if (_notEquals) {
      int _menubarHeight = SWTExtensions.getMenubarHeight();
      int _minus = (-_menubarHeight);
      Rectangle _translate = SWTExtensions.translate(clientArea, 0, _minus);
      int _menubarHeight_1 = SWTExtensions.getMenubarHeight();
      SWTExtensions.expand(_translate, 0, _menubarHeight_1);
    }
    Display _display_1 = this.getDisplay();
    Image _image = new Image(_display_1, clientArea.width, clientArea.height);
    Image image = _image;
    Display _display_2 = this.getDisplay();
    GC _gC = new GC(_display_2);
    GC gc = _gC;
    gc.copyArea(image, clientArea.x, clientArea.y);
    gc.dispose();
    return image;
  }
  
  private Display getDisplay() {
    Display _current = Display.getCurrent();
    boolean _equals = Objects.equal(_current, null);
    if (_equals) {
      SWTException _sWTException = new SWTException("Invalid Thread Exception");
      throw _sWTException;
    }
    return Display.getCurrent();
  }
  
  public Image capture(final Control shell) {
    if (shell instanceof Shell) {
      return _capture((Shell)shell);
    } else if (shell != null) {
      return _capture(shell);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(shell).toString());
    }
  }
}

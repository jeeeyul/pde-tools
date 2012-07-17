package net.jeeeyul.pdetools.snapshot;

import com.google.common.base.Objects;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SnapshotHook {
  private Control _control;
  
  private void setControl(final Control control) {
    boolean _equals = Objects.equal(this._control, control);
    if (_equals) {
      return;
    }
    this._control = control;
  }
  
  private Control getControl() {
    return this._control;
  }
  
  public void hook() {
    Display _default = Display.getDefault();
    final Procedure1<Event> _function = new Procedure1<Event>() {
        public void apply(final Event it) {
          SnapshotHook.this.handleMouseMove(it);
        }
      };
    _default.addFilter(SWT.MouseMove, new Listener() {
        public void handleEvent(Event event) {
          _function.apply(event);
        }
    });
  }
  
  public Event handleMouseMove(final Event e) {
    Event _println = InputOutput.<Event>println(e);
    return _println;
  }
}

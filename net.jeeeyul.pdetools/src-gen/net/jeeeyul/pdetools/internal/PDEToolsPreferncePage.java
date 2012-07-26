package net.jeeeyul.pdetools.internal;

import net.jeeeyul.pdetools.shared.SWTExtensions;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PDEToolsPreferncePage extends PreferencePage implements IWorkbenchPreferencePage {
  public static String getId() {
    String _canonicalName = PDEToolsPreferncePage.class.getCanonicalName();
    return _canonicalName;
  }
  
  private SWTExtensions _sWTExtensions = new Function0<SWTExtensions>() {
    public SWTExtensions apply() {
      SWTExtensions _sWTExtensions = new SWTExtensions();
      return _sWTExtensions;
    }
  }.apply();
  
  protected Control createContents(final Composite parent) {
    Composite _composite = new Composite(parent, SWT.NORMAL);
    final Procedure1<Composite> _function = new Procedure1<Composite>() {
        public void apply(final Composite it) {
          GridLayout _GridLayout = PDEToolsPreferncePage.this._sWTExtensions.GridLayout();
          it.setLayout(_GridLayout);
        }
      };
    Composite result = ObjectExtensions.<Composite>operator_doubleArrow(_composite, _function);
    this.update();
    return result;
  }
  
  public Object update() {
    return null;
  }
  
  public void init(final IWorkbench workbench) {
  }
}

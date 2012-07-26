package net.jeeeyul.pdetools.clipboard.internal;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.clipboard.internal.ClipboardPreferenceConstants;
import net.jeeeyul.pdetools.shared.SWTExtensions;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ClipboardPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
  public static String getId() {
    String _canonicalName = ClipboardPreferencePage.class.getCanonicalName();
    return _canonicalName;
  }
  
  private SWTExtensions _sWTExtensions = new Function0<SWTExtensions>() {
    public SWTExtensions apply() {
      SWTExtensions _sWTExtensions = new SWTExtensions();
      return _sWTExtensions;
    }
  }.apply();
  
  private Button dontAskRemoveAllButton;
  
  public ClipboardPreferencePage() {
    PDEToolsCore _default = PDEToolsCore.getDefault();
    IPreferenceStore _preferenceStore = _default.getPreferenceStore();
    this.setPreferenceStore(_preferenceStore);
  }
  
  protected Control createContents(final Composite parent) {
    Composite _composite = new Composite(parent, SWT.NORMAL);
    final Procedure1<Composite> _function = new Procedure1<Composite>() {
        public void apply(final Composite it) {
          GridLayout _GridLayout = ClipboardPreferencePage.this._sWTExtensions.GridLayout();
          it.setLayout(_GridLayout);
          final Procedure1<Button> _function = new Procedure1<Button>() {
              public void apply(final Button it) {
                it.setText("Do not ask when remove all clip board entries.");
              }
            };
          Button _Checkbox = ClipboardPreferencePage.this._sWTExtensions.Checkbox(it, _function);
          ClipboardPreferencePage.this.dontAskRemoveAllButton = _Checkbox;
        }
      };
    Composite result = ObjectExtensions.<Composite>operator_doubleArrow(_composite, _function);
    this.update();
    return result;
  }
  
  private void update() {
    IPreferenceStore _preferenceStore = this.getPreferenceStore();
    boolean _boolean = _preferenceStore.getBoolean(ClipboardPreferenceConstants.DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES);
    this.dontAskRemoveAllButton.setSelection(_boolean);
  }
  
  public boolean performOk() {
    IPreferenceStore _preferenceStore = this.getPreferenceStore();
    boolean _selection = this.dontAskRemoveAllButton.getSelection();
    _preferenceStore.setValue(ClipboardPreferenceConstants.DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES, _selection);
    return true;
  }
  
  protected void performDefaults() {
    IPreferenceStore _preferenceStore = this.getPreferenceStore();
    boolean _defaultBoolean = _preferenceStore.getDefaultBoolean(ClipboardPreferenceConstants.DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES);
    this.dontAskRemoveAllButton.setSelection(_defaultBoolean);
  }
  
  public void init(final IWorkbench workbench) {
  }
}

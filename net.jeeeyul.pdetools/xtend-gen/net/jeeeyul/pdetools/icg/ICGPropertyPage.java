package net.jeeeyul.pdetools.icg;

import java.util.ArrayList;
import java.util.HashMap;
import net.jeeeyul.pdetools.icg.ICGConfiguration;
import net.jeeeyul.pdetools.shared.SWTExtensions;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ICGPropertyPage extends PropertyPage {
  private SWTExtensions _sWTExtensions = new Function0<SWTExtensions>() {
    public SWTExtensions apply() {
      SWTExtensions _sWTExtensions = new SWTExtensions();
      return _sWTExtensions;
    }
  }.apply();
  
  private Text monitoringFolderField;
  
  protected Control createContents(final Composite parent) {
    final Procedure1<Composite> _function = new Procedure1<Composite>() {
        public void apply(final Composite it) {
          final Procedure1<GridLayout> _function = new Procedure1<GridLayout>() {
              public void apply(final GridLayout it) {
                it.numColumns = 3;
              }
            };
          GridLayout _GridLayout = ICGPropertyPage.this._sWTExtensions.GridLayout(_function);
          it.setLayout(_GridLayout);
          final Procedure1<Label> _function_1 = new Procedure1<Label>() {
              public void apply(final Label it) {
                it.setText("Monitoring Folder:");
              }
            };
          ICGPropertyPage.this._sWTExtensions.Label(it, _function_1);
          final Procedure1<Text> _function_2 = new Procedure1<Text>() {
              public void apply(final Text it) {
                GridData _FILL_HORIZONTAL = ICGPropertyPage.this._sWTExtensions.FILL_HORIZONTAL();
                it.setLayoutData(_FILL_HORIZONTAL);
              }
            };
          Text _TextField = ICGPropertyPage.this._sWTExtensions.TextField(it, _function_2);
          ICGPropertyPage.this.monitoringFolderField = _TextField;
          final Procedure1<Button> _function_3 = new Procedure1<Button>() {
              public void apply(final Button it) {
                it.setText("Browse");
                final Procedure1<Button> _function = new Procedure1<Button>() {
                    public void apply(final Button it) {
                      ICGPropertyPage.this.browserMonitoringFolder();
                    }
                  };
                ICGPropertyPage.this._sWTExtensions.setOnClick(it, _function);
              }
            };
          ICGPropertyPage.this._sWTExtensions.PushButton(it, _function_3);
        }
      };
    Composite _Composite = this._sWTExtensions.Composite(parent, _function);
    return _Composite;
  }
  
  public Object browserMonitoringFolder() {
    return null;
  }
  
  public ICGConfiguration config() {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList();
    final ICGConfiguration _result;
    synchronized (_createCache_config) {
      if (_createCache_config.containsKey(_cacheKey)) {
        return _createCache_config.get(_cacheKey);
      }
      IProject _project = this.getProject();
      ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
      _result = _iCGConfiguration;
      _createCache_config.put(_cacheKey, _result);
    }
    _init_config(_result);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,ICGConfiguration> _createCache_config = CollectionLiterals.newHashMap();
  
  private void _init_config(final ICGConfiguration it) {
  }
  
  public IProject getProject() {
    IAdaptable _element = this.getElement();
    if ((_element instanceof IProject)) {
      IAdaptable _element_1 = this.getElement();
      return ((IProject) _element_1);
    } else {
      IAdaptable _element_2 = this.getElement();
      Object _adapter = _element_2.getAdapter(IProject.class);
      return ((IProject) _adapter);
    }
  }
}

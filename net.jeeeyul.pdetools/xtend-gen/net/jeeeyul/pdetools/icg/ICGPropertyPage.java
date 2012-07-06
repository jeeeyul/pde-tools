package net.jeeeyul.pdetools.icg;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.jeeeyul.pdetools.icg.ICGConfiguration;
import net.jeeeyul.pdetools.shared.SWTExtensions;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ICGPropertyPage extends PropertyPage {
  private SWTExtensions _sWTExtensions = new Function0<SWTExtensions>() {
    public SWTExtensions apply() {
      SWTExtensions _sWTExtensions = new SWTExtensions();
      return _sWTExtensions;
    }
  }.apply();
  
  private ICGConfiguration _config;
  
  private Text monitoringFolderField;
  
  private Text generateSrcFolderField;
  
  private Text generateSrcPackageField;
  
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
          final Procedure1<Group> _function_4 = new Procedure1<Group>() {
              public void apply(final Group it) {
                it.setText("Generation");
                final Procedure1<GridLayout> _function = new Procedure1<GridLayout>() {
                    public void apply(final GridLayout it) {
                      it.numColumns = 3;
                    }
                  };
                GridLayout _GridLayout = ICGPropertyPage.this._sWTExtensions.GridLayout(_function);
                it.setLayout(_GridLayout);
                final Procedure1<GridData> _function_1 = new Procedure1<GridData>() {
                    public void apply(final GridData it) {
                      it.horizontalSpan = 3;
                    }
                  };
                GridData _FILL_HORIZONTAL = ICGPropertyPage.this._sWTExtensions.FILL_HORIZONTAL(_function_1);
                it.setLayoutData(_FILL_HORIZONTAL);
                final Procedure1<Label> _function_2 = new Procedure1<Label>() {
                    public void apply(final Label it) {
                      it.setText("Source Folder:");
                    }
                  };
                ICGPropertyPage.this._sWTExtensions.Label(it, _function_2);
                final Procedure1<Text> _function_3 = new Procedure1<Text>() {
                    public void apply(final Text it) {
                      GridData _FILL_HORIZONTAL = ICGPropertyPage.this._sWTExtensions.FILL_HORIZONTAL();
                      it.setLayoutData(_FILL_HORIZONTAL);
                    }
                  };
                Text _TextField = ICGPropertyPage.this._sWTExtensions.TextField(it, _function_3);
                ICGPropertyPage.this.generateSrcFolderField = _TextField;
                final Procedure1<Button> _function_4 = new Procedure1<Button>() {
                    public void apply(final Button it) {
                      it.setText("Browse");
                      final Procedure1<Button> _function = new Procedure1<Button>() {
                          public void apply(final Button it) {
                            ICGPropertyPage.this.browseSrcFolder();
                          }
                        };
                      ICGPropertyPage.this._sWTExtensions.setOnClick(it, _function);
                    }
                  };
                ICGPropertyPage.this._sWTExtensions.PushButton(it, _function_4);
                final Procedure1<Label> _function_5 = new Procedure1<Label>() {
                    public void apply(final Label it) {
                      it.setText("Package:");
                    }
                  };
                ICGPropertyPage.this._sWTExtensions.Label(it, _function_5);
                final Procedure1<Text> _function_6 = new Procedure1<Text>() {
                    public void apply(final Text it) {
                      GridData _FILL_HORIZONTAL = ICGPropertyPage.this._sWTExtensions.FILL_HORIZONTAL();
                      it.setLayoutData(_FILL_HORIZONTAL);
                    }
                  };
                Text _TextField_1 = ICGPropertyPage.this._sWTExtensions.TextField(it, _function_6);
                ICGPropertyPage.this.generateSrcPackageField = _TextField_1;
                final Procedure1<Button> _function_7 = new Procedure1<Button>() {
                    public void apply(final Button it) {
                      it.setText("Browse");
                      final Procedure1<Button> _function = new Procedure1<Button>() {
                          public void apply(final Button it) {
                            ICGPropertyPage.this.browsePackage();
                          }
                        };
                      ICGPropertyPage.this._sWTExtensions.setOnClick(it, _function);
                    }
                  };
                ICGPropertyPage.this._sWTExtensions.PushButton(it, _function_7);
                final Procedure1<Button> _function_8 = new Procedure1<Button>() {
                    public void apply(final Button it) {
                      final Procedure1<GridData> _function = new Procedure1<GridData>() {
                          public void apply(final GridData it) {
                            it.horizontalSpan = 3;
                          }
                        };
                      GridData _GridData = ICGPropertyPage.this._sWTExtensions.GridData(_function);
                      it.setLayoutData(_GridData);
                      it.setText("Mark derived");
                    }
                  };
                ICGPropertyPage.this._sWTExtensions.Checkbox(it, _function_8);
              }
            };
          ICGPropertyPage.this._sWTExtensions.Group(it, _function_4);
        }
      };
    Composite _Composite = this._sWTExtensions.Composite(parent, _function);
    return _Composite;
  }
  
  public void browsePackage() {
    try {
      IJavaProject _javaProject = this.javaProject();
      IPackageFragmentRoot[] _allPackageFragmentRoots = _javaProject.getAllPackageFragmentRoots();
      final Function1<IPackageFragmentRoot,Boolean> _function = new Function1<IPackageFragmentRoot,Boolean>() {
          public Boolean apply(final IPackageFragmentRoot it) {
            boolean _xtrycatchfinallyexpression = false;
            try {
              int _kind = it.getKind();
              boolean _equals = (_kind == IPackageFragmentRoot.K_SOURCE);
              _xtrycatchfinallyexpression = _equals;
            } catch (final Throwable _t) {
              if (_t instanceof Exception) {
                final Exception e = (Exception)_t;
                _xtrycatchfinallyexpression = false;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            return Boolean.valueOf(_xtrycatchfinallyexpression);
          }
        };
      Iterable<IPackageFragmentRoot> srcFolders = IterableExtensions.<IPackageFragmentRoot>filter(((Iterable<IPackageFragmentRoot>)Conversions.doWrapArray(_allPackageFragmentRoots)), _function);
      IJavaSearchScope scope = SearchEngine.createJavaSearchScope(((IJavaElement[]) ((IJavaElement[])Conversions.unwrapArray(srcFolders, IJavaElement.class))));
      Control _control = this.getControl();
      Shell _shell = _control.getShell();
      IWorkbench _workbench = PlatformUI.getWorkbench();
      IProgressService _progressService = _workbench.getProgressService();
      SelectionDialog dialog = JavaUI.createPackageDialog(_shell, _progressService, scope, false, true, null);
      int _open = dialog.open();
      boolean _equals = (_open == IDialogConstants.OK_ID);
      if (_equals) {
        Object[] _result = dialog.getResult();
        Object _get = ((List<Object>)Conversions.doWrapArray(_result)).get(0);
        IPackageFragment fragment = ((IPackageFragment) _get);
        String _elementName = fragment.getElementName();
        this.generateSrcPackageField.setText(_elementName);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IJavaProject javaProject() {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList();
    final IJavaProject _result;
    synchronized (_createCache_javaProject) {
      if (_createCache_javaProject.containsKey(_cacheKey)) {
        return _createCache_javaProject.get(_cacheKey);
      }
      IProject _project = this.getProject();
      IJavaProject _create = JavaCore.create(_project);
      _result = _create;
      _createCache_javaProject.put(_cacheKey, _result);
    }
    _init_javaProject(_result);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,IJavaProject> _createCache_javaProject = CollectionLiterals.newHashMap();
  
  private void _init_javaProject(final IJavaProject it) {
  }
  
  public void browseSrcFolder() {
    try {
      IJavaProject _javaProject = this.javaProject();
      IPackageFragmentRoot[] _allPackageFragmentRoots = _javaProject.getAllPackageFragmentRoots();
      final Function1<IPackageFragmentRoot,Boolean> _function = new Function1<IPackageFragmentRoot,Boolean>() {
          public Boolean apply(final IPackageFragmentRoot it) {
            boolean _xtrycatchfinallyexpression = false;
            try {
              int _kind = it.getKind();
              boolean _equals = (_kind == IPackageFragmentRoot.K_SOURCE);
              _xtrycatchfinallyexpression = _equals;
            } catch (final Throwable _t) {
              if (_t instanceof Exception) {
                final Exception e = (Exception)_t;
                _xtrycatchfinallyexpression = false;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            return Boolean.valueOf(_xtrycatchfinallyexpression);
          }
        };
      Iterable<IPackageFragmentRoot> srcFolders = IterableExtensions.<IPackageFragmentRoot>filter(((Iterable<IPackageFragmentRoot>)Conversions.doWrapArray(_allPackageFragmentRoots)), _function);
      Control _control = this.getControl();
      Shell _shell = _control.getShell();
      ILabelProvider _decoratingWorkbenchLabelProvider = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
      ElementListSelectionDialog _elementListSelectionDialog = new ElementListSelectionDialog(_shell, _decoratingWorkbenchLabelProvider);
      ElementListSelectionDialog dialog = _elementListSelectionDialog;
      final Iterable<IPackageFragmentRoot> _converted_srcFolders = (Iterable<IPackageFragmentRoot>)srcFolders;
      dialog.setElements(((Object[])Conversions.unwrapArray(_converted_srcFolders, Object.class)));
      dialog.setMessage("Select source folder to generate");
      dialog.setTitle("Image Constants Generator");
      int _open = dialog.open();
      boolean _equals = (_open == IDialogConstants.OK_ID);
      if (_equals) {
        Object[] _result = dialog.getResult();
        Object _get = ((List<Object>)Conversions.doWrapArray(_result)).get(0);
        IPackageFragmentRoot srcFolder = ((IPackageFragmentRoot) _get);
        IResource _resource = srcFolder.getResource();
        IPath _projectRelativePath = _resource.getProjectRelativePath();
        String _portableString = _projectRelativePath.toPortableString();
        this.generateSrcFolderField.setText(_portableString);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object browserMonitoringFolder() {
    return null;
  }
  
  public ICGConfiguration config() {
    boolean _equals = Objects.equal(this._config, null);
    if (_equals) {
      IProject _project = this.getProject();
      ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
      this._config = _iCGConfiguration;
    }
    return this._config;
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

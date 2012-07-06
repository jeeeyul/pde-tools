package net.jeeeyul.pdetools.icg;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.jeeeyul.pdetools.icg.ICGConfiguration;
import net.jeeeyul.pdetools.shared.SWTExtensions;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.swt.widgets.Display;
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
  public final static String ID = "net.jeeeyul.pdetools.icg.propertyPage";
  
  private SWTExtensions _sWTExtensions = new Function0<SWTExtensions>() {
    public SWTExtensions apply() {
      SWTExtensions _sWTExtensions = new SWTExtensions();
      return _sWTExtensions;
    }
  }.apply();
  
  private ICGConfiguration _config;
  
  private Text monitoringFolderField;
  
  private Text imageFileExtensionsField;
  
  private Text generateSrcFolderField;
  
  private Text generateSrcPackageField;
  
  private Button markDerivedField;
  
  protected Control createContents(final Composite parent) {
    Composite _xblockexpression = null;
    {
      final Procedure1<Display> _function = new Procedure1<Display>() {
          public void apply(final Display it) {
            ICGPropertyPage.this.refresh();
          }
        };
      this._sWTExtensions.schedule(_function);
      final Procedure1<Composite> _function_1 = new Procedure1<Composite>() {
          public void apply(final Composite it) {
            GridLayout _GridLayout = ICGPropertyPage.this._sWTExtensions.GridLayout();
            it.setLayout(_GridLayout);
            final Procedure1<Group> _function = new Procedure1<Group>() {
                public void apply(final Group it) {
                  it.setText("Monitoring");
                  final Procedure1<GridLayout> _function = new Procedure1<GridLayout>() {
                      public void apply(final GridLayout it) {
                        it.numColumns = 3;
                      }
                    };
                  GridLayout _GridLayout = ICGPropertyPage.this._sWTExtensions.GridLayout(_function);
                  it.setLayout(_GridLayout);
                  GridData _FILL_HORIZONTAL = ICGPropertyPage.this._sWTExtensions.FILL_HORIZONTAL();
                  it.setLayoutData(_FILL_HORIZONTAL);
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
                  final Procedure1<Label> _function_4 = new Procedure1<Label>() {
                      public void apply(final Label it) {
                        it.setText("Image File Extensions:");
                      }
                    };
                  ICGPropertyPage.this._sWTExtensions.Label(it, _function_4);
                  final Procedure1<Text> _function_5 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        final Procedure1<GridData> _function = new Procedure1<GridData>() {
                            public void apply(final GridData it) {
                              it.horizontalSpan = 2;
                            }
                          };
                        GridData _FILL_HORIZONTAL = ICGPropertyPage.this._sWTExtensions.FILL_HORIZONTAL(_function);
                        it.setLayoutData(_FILL_HORIZONTAL);
                      }
                    };
                  Text _TextField_1 = ICGPropertyPage.this._sWTExtensions.TextField(it, _function_5);
                  ICGPropertyPage.this.imageFileExtensionsField = _TextField_1;
                }
              };
            ICGPropertyPage.this._sWTExtensions.Group(it, _function);
            final Procedure1<Group> _function_1 = new Procedure1<Group>() {
                public void apply(final Group it) {
                  it.setText("Generation");
                  final Procedure1<GridLayout> _function = new Procedure1<GridLayout>() {
                      public void apply(final GridLayout it) {
                        it.numColumns = 3;
                      }
                    };
                  GridLayout _GridLayout = ICGPropertyPage.this._sWTExtensions.GridLayout(_function);
                  it.setLayout(_GridLayout);
                  GridData _FILL_HORIZONTAL = ICGPropertyPage.this._sWTExtensions.FILL_HORIZONTAL();
                  it.setLayoutData(_FILL_HORIZONTAL);
                  final Procedure1<Label> _function_1 = new Procedure1<Label>() {
                      public void apply(final Label it) {
                        it.setText("Source Folder:");
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
                  ICGPropertyPage.this.generateSrcFolderField = _TextField;
                  final Procedure1<Button> _function_3 = new Procedure1<Button>() {
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
                  ICGPropertyPage.this._sWTExtensions.PushButton(it, _function_3);
                  final Procedure1<Label> _function_4 = new Procedure1<Label>() {
                      public void apply(final Label it) {
                        it.setText("Package:");
                      }
                    };
                  ICGPropertyPage.this._sWTExtensions.Label(it, _function_4);
                  final Procedure1<Text> _function_5 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        GridData _FILL_HORIZONTAL = ICGPropertyPage.this._sWTExtensions.FILL_HORIZONTAL();
                        it.setLayoutData(_FILL_HORIZONTAL);
                      }
                    };
                  Text _TextField_1 = ICGPropertyPage.this._sWTExtensions.TextField(it, _function_5);
                  ICGPropertyPage.this.generateSrcPackageField = _TextField_1;
                  final Procedure1<Button> _function_6 = new Procedure1<Button>() {
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
                  ICGPropertyPage.this._sWTExtensions.PushButton(it, _function_6);
                  final Procedure1<Button> _function_7 = new Procedure1<Button>() {
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
                  Button _Checkbox = ICGPropertyPage.this._sWTExtensions.Checkbox(it, _function_7);
                  ICGPropertyPage.this.markDerivedField = _Checkbox;
                }
              };
            ICGPropertyPage.this._sWTExtensions.Group(it, _function_1);
          }
        };
      Composite _Composite = this._sWTExtensions.Composite(parent, _function_1);
      _xblockexpression = (_Composite);
    }
    return _xblockexpression;
  }
  
  private void refresh() {
    ICGConfiguration _config = this.config();
    IFolder _monitoringFolder = _config.getMonitoringFolder();
    boolean _notEquals = (!Objects.equal(_monitoringFolder, null));
    if (_notEquals) {
      ICGConfiguration _config_1 = this.config();
      IFolder _monitoringFolder_1 = _config_1.getMonitoringFolder();
      IPath _projectRelativePath = _monitoringFolder_1.getProjectRelativePath();
      String _portableString = _projectRelativePath.toPortableString();
      this.monitoringFolderField.setText(_portableString);
    } else {
      this.monitoringFolderField.setText("");
    }
    ICGConfiguration _config_2 = this.config();
    IFolder _generateSrcFolder = _config_2.getGenerateSrcFolder();
    boolean _notEquals_1 = (!Objects.equal(_generateSrcFolder, null));
    if (_notEquals_1) {
      ICGConfiguration _config_3 = this.config();
      IFolder _generateSrcFolder_1 = _config_3.getGenerateSrcFolder();
      IPath _projectRelativePath_1 = _generateSrcFolder_1.getProjectRelativePath();
      String _portableString_1 = _projectRelativePath_1.toPortableString();
      this.generateSrcFolderField.setText(_portableString_1);
    } else {
      this.generateSrcFolderField.setText("");
    }
    ICGConfiguration _config_4 = this.config();
    String _generatePackageName = _config_4.getGeneratePackageName();
    String _nullSafeString = this.nullSafeString(_generatePackageName);
    this.generateSrcPackageField.setText(_nullSafeString);
    ICGConfiguration _config_5 = this.config();
    boolean _isMarkDerived = _config_5.isMarkDerived();
    this.markDerivedField.setSelection(_isMarkDerived);
    ICGConfiguration _config_6 = this.config();
    String[] _imageFileExtensions = _config_6.getImageFileExtensions();
    boolean _notEquals_2 = (!Objects.equal(_imageFileExtensions, null));
    if (_notEquals_2) {
      ICGConfiguration _config_7 = this.config();
      String[] _imageFileExtensions_1 = _config_7.getImageFileExtensions();
      String _join = IterableExtensions.join(((Iterable<? extends Object>)Conversions.doWrapArray(_imageFileExtensions_1)), ", ");
      this.imageFileExtensionsField.setText(_join);
    } else {
      this.imageFileExtensionsField.setText("");
    }
  }
  
  private void browsePackage() {
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
  
  private IJavaProject javaProject() {
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
  
  private void browseSrcFolder() {
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
  
  private Object browserMonitoringFolder() {
    return null;
  }
  
  private ICGConfiguration config() {
    boolean _equals = Objects.equal(this._config, null);
    if (_equals) {
      IProject _project = this.getProject();
      ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
      this._config = _iCGConfiguration;
    }
    return this._config;
  }
  
  private IProject getProject() {
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
  
  public String nullSafeString(final String string) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(string, null);
    if (_equals) {
      _xifexpression = "";
    } else {
      _xifexpression = string;
    }
    return _xifexpression;
  }
  
  public boolean performOk() {
    boolean _xblockexpression = false;
    {
      String _text = this.monitoringFolderField.getText();
      boolean _isEmpty = _text.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        ICGConfiguration _config = this.config();
        IProject _project = this.getProject();
        String _text_1 = this.monitoringFolderField.getText();
        String _trim = _text_1.trim();
        Path _path = new Path(_trim);
        IFolder _folder = _project.getFolder(_path);
        _config.setMonitoringFolder(_folder);
      } else {
        ICGConfiguration _config_1 = this.config();
        _config_1.setMonitoringFolder(null);
      }
      String _text_2 = this.generateSrcFolderField.getText();
      boolean _isEmpty_1 = _text_2.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        ICGConfiguration _config_2 = this.config();
        IProject _project_1 = this.getProject();
        String _text_3 = this.generateSrcFolderField.getText();
        String _trim_1 = _text_3.trim();
        Path _path_1 = new Path(_trim_1);
        IFolder _folder_1 = _project_1.getFolder(_path_1);
        _config_2.setGenerateSrcFolder(_folder_1);
      } else {
        ICGConfiguration _config_3 = this.config();
        _config_3.setGenerateSrcFolder(null);
      }
      ICGConfiguration _config_4 = this.config();
      String _text_4 = this.imageFileExtensionsField.getText();
      String _trim_2 = _text_4.trim();
      String[] _split = _trim_2.split("[ ,]+");
      _config_4.setImageFileExtensions(_split);
      ICGConfiguration _config_5 = this.config();
      String _text_5 = this.generateSrcPackageField.getText();
      String _trim_3 = _text_5.trim();
      _config_5.setGeneratePackageName(_trim_3);
      ICGConfiguration _config_6 = this.config();
      boolean _selection = this.markDerivedField.getSelection();
      _config_6.setMarkDerived(_selection);
      ICGConfiguration _config_7 = this.config();
      _config_7.save();
      boolean _performOk = super.performOk();
      _xblockexpression = (_performOk);
    }
    return _xblockexpression;
  }
  
  protected void performDefaults() {
    this.refresh();
  }
}

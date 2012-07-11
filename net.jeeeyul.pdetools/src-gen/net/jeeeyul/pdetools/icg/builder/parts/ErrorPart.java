package net.jeeeyul.pdetools.icg.builder.parts;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import net.jeeeyul.pdetools.icg.ICGConstants;
import net.jeeeyul.pdetools.icg.builder.model.BuildError;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.internal.core.text.IDocumentKey;
import org.eclipse.pde.internal.core.text.build.BuildModel;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.DocumentProviderRegistry;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class ErrorPart {
  @Inject
  private ICGConfiguration config;
  
  @Inject
  private IProject project;
  
  private List<BuildError> errors = new Function0<List<BuildError>>() {
    public List<BuildError> apply() {
      ArrayList<BuildError> _newArrayList = CollectionLiterals.<BuildError>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public boolean error(final BuildError error) {
    boolean _add = this.errors.add(error);
    return _add;
  }
  
  public List<BuildError> getErrors() {
    return this.errors;
  }
  
  public boolean error(final Procedure1<? super BuildError> initializer) {
    boolean _xblockexpression = false;
    {
      BuildError _buildError = new BuildError();
      BuildError error = _buildError;
      initializer.apply(error);
      boolean _error = this.error(error);
      _xblockexpression = (_error);
    }
    return _xblockexpression;
  }
  
  /**
   * 빌드 가능 여부를 리턴한다.
   */
  public boolean canBuild() {
    final Function1<BuildError,Boolean> _function = new Function1<BuildError,Boolean>() {
        public Boolean apply(final BuildError it) {
          boolean _isFatal = it.isFatal();
          boolean _equals = (_isFatal == true);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<BuildError> _filter = IterableExtensions.<BuildError>filter(this.errors, _function);
    int _size = IterableExtensions.size(_filter);
    boolean _equals = (_size == 0);
    return _equals;
  }
  
  public void generateMarkers() {
    try {
      for (final BuildError e : this.errors) {
        {
          IResource resource = ((IResource) this.project);
          IResource _relatedResource = e.getRelatedResource();
          boolean _notEquals = (!Objects.equal(_relatedResource, null));
          if (_notEquals) {
            IResource _relatedResource_1 = e.getRelatedResource();
            resource = _relatedResource_1;
          }
          IMarker _createMarker = resource.createMarker(ICGConstants.PROBLEM_MARKER_TYPE);
          final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
              public void apply(final IMarker it) {
                try {
                  String _message = e.getMessage();
                  it.setAttribute(IMarker.MESSAGE, _message);
                  int _markerSeverity = ErrorPart.this.markerSeverity(e);
                  it.setAttribute(IMarker.SEVERITY, _markerSeverity);
                  it.setAttribute(IMarker.LOCATION, "ICG Configuration");
                  String _type = e.getType();
                  boolean _notEquals = (!Objects.equal(_type, null));
                  if (_notEquals) {
                    String _type_1 = e.getType();
                    it.setAttribute(ICGConstants.BUILD_ERROR_TYPE_MARKER_ATTRIBUTE, _type_1);
                  }
                  int _lineNumber = e.getLineNumber();
                  boolean _greaterEqualsThan = (_lineNumber >= 0);
                  if (_greaterEqualsThan) {
                    int _lineNumber_1 = e.getLineNumber();
                    it.setAttribute(IMarker.LINE_NUMBER, _lineNumber_1);
                  }
                } catch (Exception _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
          ObjectExtensions.<IMarker>operator_doubleArrow(_createMarker, _function);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void cleanMarkers() {
    try {
      IMarker[] markers = this.project.findMarkers(ICGConstants.PROBLEM_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
      final IMarker[] _converted_markers = (IMarker[])markers;
      final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
          public void apply(final IMarker it) {
            try {
              it.delete();
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      IterableExtensions.<IMarker>forEach(((Iterable<IMarker>)Conversions.doWrapArray(_converted_markers)), _function);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public int markerSeverity(final BuildError e) {
    int _xifexpression = (int) 0;
    boolean _isFatal = e.isFatal();
    if (_isFatal) {
      _xifexpression = IMarker.SEVERITY_ERROR;
    } else {
      _xifexpression = IMarker.SEVERITY_WARNING;
    }
    return _xifexpression;
  }
  
  public void validate() {
    try {
      IFolder _monitoringFolder = this.config.getMonitoringFolder();
      boolean _equals = Objects.equal(_monitoringFolder, null);
      if (_equals) {
        final Procedure1<BuildError> _function = new Procedure1<BuildError>() {
            public void apply(final BuildError it) {
              it.setFatal(true);
              it.setMessage("Monitoring Folder is not set");
            }
          };
        this.error(_function);
      } else {
        IFolder _monitoringFolder_1 = this.config.getMonitoringFolder();
        boolean _exists = _monitoringFolder_1.exists();
        boolean _not = (!_exists);
        if (_not) {
          final Procedure1<BuildError> _function_1 = new Procedure1<BuildError>() {
              public void apply(final BuildError it) {
                it.setFatal(true);
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Monitoring Folder(");
                IFolder _monitoringFolder = ErrorPart.this.config.getMonitoringFolder();
                IPath _fullPath = _monitoringFolder.getFullPath();
                String _portableString = _fullPath.toPortableString();
                _builder.append(_portableString, "");
                _builder.append(") not exists");
                it.setMessage(_builder.toString());
                it.setType("monitor-folder-not-exists");
              }
            };
          this.error(_function_1);
        } else {
          IFile buildFile = this.project.getFile("build.properties");
          FileEditorInput _fileEditorInput = new FileEditorInput(buildFile);
          FileEditorInput input = _fileEditorInput;
          DocumentProviderRegistry _default = DocumentProviderRegistry.getDefault();
          FileEditorInput _fileEditorInput_1 = new FileEditorInput(buildFile);
          IDocumentProvider _documentProvider = _default.getDocumentProvider(_fileEditorInput_1);
          IDocumentProvider provider = ((IDocumentProvider) _documentProvider);
          provider.connect(input);
          final IDocument doc = provider.getDocument(input);
          BuildModel _buildModel = new BuildModel(doc, true);
          final BuildModel buildModel = _buildModel;
          buildModel.load();
          IBuild _build = buildModel.getBuild();
          IBuildEntry[] _buildEntries = _build.getBuildEntries();
          final Function1<IBuildEntry,Boolean> _function_2 = new Function1<IBuildEntry,Boolean>() {
              public Boolean apply(final IBuildEntry it) {
                String _name = it.getName();
                boolean _equals = Objects.equal(_name, "bin.includes");
                return Boolean.valueOf(_equals);
              }
            };
          final IBuildEntry binaryBuildEntry = IterableExtensions.<IBuildEntry>findFirst(((Iterable<IBuildEntry>)Conversions.doWrapArray(_buildEntries)), _function_2);
          IFolder _monitoringFolder_2 = this.config.getMonitoringFolder();
          IPath _projectRelativePath = _monitoringFolder_2.getProjectRelativePath();
          String _portableString = _projectRelativePath.toPortableString();
          String _plus = (_portableString + "/");
          boolean _contains = binaryBuildEntry.contains(_plus);
          boolean _not_1 = (!_contains);
          if (_not_1) {
            final Procedure1<BuildError> _function_3 = new Procedure1<BuildError>() {
                public void apply(final BuildError it) {
                  try {
                    it.setFatal(false);
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("Monitoring Folder(");
                    IFolder _monitoringFolder = ErrorPart.this.config.getMonitoringFolder();
                    IPath _fullPath = _monitoringFolder.getFullPath();
                    String _portableString = _fullPath.toPortableString();
                    _builder.append(_portableString, "");
                    _builder.append(") is not included to binary build entry");
                    it.setMessage(_builder.toString());
                    IFile _file = ErrorPart.this.project.getFile("build.properties");
                    it.setRelatedResource(_file);
                    int _offset = ((IDocumentKey) binaryBuildEntry).getOffset();
                    int _lineOfOffset = doc.getLineOfOffset(_offset);
                    it.setLineNumber(_lineOfOffset);
                    it.setType("missing-build-entry");
                  } catch (Exception _e) {
                    throw Exceptions.sneakyThrow(_e);
                  }
                }
              };
            this.error(_function_3);
            buildModel.dispose();
          }
          provider.disconnect(input);
        }
      }
      String _generatePackageName = this.config.getGeneratePackageName();
      boolean _isNullOrBlank = this.isNullOrBlank(_generatePackageName);
      if (_isNullOrBlank) {
        final Procedure1<BuildError> _function_4 = new Procedure1<BuildError>() {
            public void apply(final BuildError it) {
              it.setFatal(true);
              it.setMessage("package to generate is not setted");
            }
          };
        this.error(_function_4);
      }
      String _generateClassName = this.config.getGenerateClassName();
      boolean _isNullOrBlank_1 = this.isNullOrBlank(_generateClassName);
      if (_isNullOrBlank_1) {
        final Procedure1<BuildError> _function_5 = new Procedure1<BuildError>() {
            public void apply(final BuildError it) {
              it.setFatal(true);
              it.setMessage("class name to generate is not setted");
            }
          };
        this.error(_function_5);
      }
      IFolder _generateSrcFolder = this.config.getGenerateSrcFolder();
      boolean _equals_1 = Objects.equal(_generateSrcFolder, null);
      if (_equals_1) {
        final Procedure1<BuildError> _function_6 = new Procedure1<BuildError>() {
            public void apply(final BuildError it) {
              it.setFatal(true);
              it.setMessage("Source folder to generate is not setted");
            }
          };
        this.error(_function_6);
      }
      boolean _or = false;
      String[] _imageFileExtensions = this.config.getImageFileExtensions();
      boolean _equals_2 = Objects.equal(_imageFileExtensions, null);
      if (_equals_2) {
        _or = true;
      } else {
        String[] _imageFileExtensions_1 = this.config.getImageFileExtensions();
        int _size = ((List<String>)Conversions.doWrapArray(_imageFileExtensions_1)).size();
        boolean _equals_3 = (_size == 0);
        _or = (_equals_2 || _equals_3);
      }
      if (_or) {
        final Procedure1<BuildError> _function_7 = new Procedure1<BuildError>() {
            public void apply(final BuildError it) {
              it.setFatal(false);
              it.setMessage("No image file extensions are setted");
            }
          };
        this.error(_function_7);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isNullOrBlank(final String src) {
    boolean _equals = Objects.equal(src, null);
    if (_equals) {
      return true;
    } else {
      String _trim = src.trim();
      return _trim.isEmpty();
    }
  }
}

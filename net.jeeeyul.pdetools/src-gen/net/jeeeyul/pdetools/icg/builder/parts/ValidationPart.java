package net.jeeeyul.pdetools.icg.builder.parts;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import net.jeeeyul.pdetools.icg.builder.model.BuildError;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.parts.ErrorPart;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ValidationPart {
  @Inject
  private ICGConfiguration config;
  
  @Inject
  private ErrorPart _errorPart;
  
  @Inject
  private IProject project;
  
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
        this._errorPart.error(_function);
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
                IFolder _monitoringFolder = ValidationPart.this.config.getMonitoringFolder();
                IPath _fullPath = _monitoringFolder.getFullPath();
                String _portableString = _fullPath.toPortableString();
                _builder.append(_portableString, "");
                _builder.append(") not exists");
                it.setMessage(_builder.toString());
                it.setType("monitor-folder-not-exists");
              }
            };
          this._errorPart.error(_function_1);
        } else {
          IPluginModelBase pluginModel = PluginRegistry.findModel(this.project);
          IBuildModel buildModel = PluginRegistry.createBuildModel(pluginModel);
          IBuild _build = buildModel.getBuild();
          IBuildEntry[] _buildEntries = _build.getBuildEntries();
          final Function1<IBuildEntry,Boolean> _function_2 = new Function1<IBuildEntry,Boolean>() {
              public Boolean apply(final IBuildEntry it) {
                String _name = it.getName();
                boolean _equals = Objects.equal(_name, "bin.includes");
                return Boolean.valueOf(_equals);
              }
            };
          IBuildEntry binaryBuildEntry = IterableExtensions.<IBuildEntry>findFirst(((Iterable<IBuildEntry>)Conversions.doWrapArray(_buildEntries)), _function_2);
          IFolder _monitoringFolder_2 = this.config.getMonitoringFolder();
          IPath _projectRelativePath = _monitoringFolder_2.getProjectRelativePath();
          String _portableString = _projectRelativePath.toPortableString();
          String _plus = (_portableString + "/");
          boolean _contains = binaryBuildEntry.contains(_plus);
          boolean _not_1 = (!_contains);
          if (_not_1) {
            final Procedure1<BuildError> _function_3 = new Procedure1<BuildError>() {
                public void apply(final BuildError it) {
                  it.setFatal(false);
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("Monitoring Folder(");
                  IFolder _monitoringFolder = ValidationPart.this.config.getMonitoringFolder();
                  IPath _fullPath = _monitoringFolder.getFullPath();
                  String _portableString = _fullPath.toPortableString();
                  _builder.append(_portableString, "");
                  _builder.append(") is not included to binary build entry");
                  it.setMessage(_builder.toString());
                  IFile _file = ValidationPart.this.project.getFile("build.properties");
                  it.setRelatedResource(_file);
                }
              };
            this._errorPart.error(_function_3);
            buildModel.dispose();
          }
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
        this._errorPart.error(_function_4);
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
        this._errorPart.error(_function_5);
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
        this._errorPart.error(_function_6);
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
        this._errorPart.error(_function_7);
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

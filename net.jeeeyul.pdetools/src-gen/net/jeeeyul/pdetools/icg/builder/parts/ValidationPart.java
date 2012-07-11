package net.jeeeyul.pdetools.icg.builder.parts;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import net.jeeeyul.pdetools.icg.builder.model.BuildError;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.parts.ErrorPart;
import org.eclipse.core.resources.IFolder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ValidationPart {
  @Inject
  private ICGConfiguration config;
  
  @Inject
  private ErrorPart _errorPart;
  
  public void validate() {
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
              it.setMessage("Monitoring Folder not exists");
              it.setType("monitor-folder-not-exists");
            }
          };
        this._errorPart.error(_function_1);
      }
    }
    String _generatePackageName = this.config.getGeneratePackageName();
    boolean _isNullOrBlank = this.isNullOrBlank(_generatePackageName);
    if (_isNullOrBlank) {
      final Procedure1<BuildError> _function_2 = new Procedure1<BuildError>() {
          public void apply(final BuildError it) {
            it.setFatal(true);
            it.setMessage("package to generate is not setted");
          }
        };
      this._errorPart.error(_function_2);
    }
    String _generateClassName = this.config.getGenerateClassName();
    boolean _isNullOrBlank_1 = this.isNullOrBlank(_generateClassName);
    if (_isNullOrBlank_1) {
      final Procedure1<BuildError> _function_3 = new Procedure1<BuildError>() {
          public void apply(final BuildError it) {
            it.setFatal(true);
            it.setMessage("class name to generate is not setted");
          }
        };
      this._errorPart.error(_function_3);
    }
    IFolder _generateSrcFolder = this.config.getGenerateSrcFolder();
    boolean _equals_1 = Objects.equal(_generateSrcFolder, null);
    if (_equals_1) {
      final Procedure1<BuildError> _function_4 = new Procedure1<BuildError>() {
          public void apply(final BuildError it) {
            it.setFatal(true);
            it.setMessage("Source folder to generate is not setted");
          }
        };
      this._errorPart.error(_function_4);
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
      final Procedure1<BuildError> _function_5 = new Procedure1<BuildError>() {
          public void apply(final BuildError it) {
            it.setFatal(false);
            it.setMessage("No image file extensions are setted");
          }
        };
      this._errorPart.error(_function_5);
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

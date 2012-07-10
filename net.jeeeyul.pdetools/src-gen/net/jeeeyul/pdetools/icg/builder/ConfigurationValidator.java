package net.jeeeyul.pdetools.icg.builder;

import com.google.common.base.Objects;
import java.util.ArrayList;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.model.ValidationResult;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ConfigurationValidator {
  public ValidationResult newWarning(final String message) {
    ValidationResult _validationResult = new ValidationResult();
    final Procedure1<ValidationResult> _function = new Procedure1<ValidationResult>() {
        public void apply(final ValidationResult it) {
          it.setSeverity(IMarker.SEVERITY_WARNING);
          it.setMessage(message);
        }
      };
    ValidationResult _doubleArrow = ObjectExtensions.<ValidationResult>operator_doubleArrow(_validationResult, _function);
    return _doubleArrow;
  }
  
  public ValidationResult newError(final String message) {
    ValidationResult _validationResult = new ValidationResult();
    final Procedure1<ValidationResult> _function = new Procedure1<ValidationResult>() {
        public void apply(final ValidationResult it) {
          it.setSeverity(IMarker.SEVERITY_ERROR);
          it.setMessage(message);
        }
      };
    ValidationResult _doubleArrow = ObjectExtensions.<ValidationResult>operator_doubleArrow(_validationResult, _function);
    return _doubleArrow;
  }
  
  public ValidationResult[] validate(final ICGConfiguration config) {
    ArrayList<ValidationResult> _arrayList = new ArrayList<ValidationResult>();
    ArrayList<ValidationResult> result = _arrayList;
    IFolder _monitoringFolder = config.getMonitoringFolder();
    boolean _equals = Objects.equal(_monitoringFolder, null);
    if (_equals) {
      ValidationResult _newWarning = this.newWarning("Monitoring folder is not set");
      result.add(_newWarning);
    } else {
      IFolder _monitoringFolder_1 = config.getMonitoringFolder();
      boolean _exists = _monitoringFolder_1.exists();
      if (_exists) {
        ValidationResult _newError = this.newError("Monitoring folder not exists");
        result.add(_newError);
      }
    }
    return ((ValidationResult[])Conversions.unwrapArray(result, ValidationResult.class));
  }
}

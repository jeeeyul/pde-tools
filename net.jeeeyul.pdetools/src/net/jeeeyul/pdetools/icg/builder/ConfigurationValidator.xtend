package net.jeeeyul.pdetools.icg.builder

import net.jeeeyul.pdetools.icg.builder.model.ValidationResult
import org.eclipse.core.resources.IMarker
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import java.util.ArrayList

class ConfigurationValidator {
	def newWarning(String message) {
		new ValidationResult() =>[ severity = IMarker::SEVERITY_WARNING it.message = message ]
	}

	def newError(String message) {
		new ValidationResult() =>[ severity = IMarker::SEVERITY_ERROR it.message = message ]
	}

	def ValidationResult[ ] validate(ICGConfiguration config) {
		var result = new ArrayList<ValidationResult>()
		if(config.monitoringFolder == null) {
			result += newWarning("Monitoring folder is not set")
		} else	if(config.monitoringFolder.exists) {
			result += newError("Monitoring folder not exists")
		}
		return result
	}
}
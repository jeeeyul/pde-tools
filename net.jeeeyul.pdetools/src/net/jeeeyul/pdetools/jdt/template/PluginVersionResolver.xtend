package net.jeeeyul.pdetools.jdt.template

import org.eclipse.jface.text.templates.TemplateVariableResolver
import org.eclipse.jface.text.templates.TemplateContext
import org.eclipse.pde.core.plugin.PluginRegistry
import static extension net.jeeeyul.pdetools.jdt.template.JDTHackExtensions.*

class PluginVersionResolver extends TemplateVariableResolver {

	override protected resolve(TemplateContext context) {
		var model = PluginRegistry::findModel(context.compilationUnit.javaProject.project)
		if (model == null) {
			return "Not a plugin project"
		}
		var version = model.bundleDescription.version
		return '''«version.major».«version.minor»'''
	}

}

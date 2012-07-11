package net.jeeeyul.pdetools.icg.builder.model

import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.xtend.lib.Property

class BuildContext {
	@Property IncrementalProjectBuilder builder
	@Property int buildKind
}
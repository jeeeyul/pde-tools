package net.jeeeyul.pdetools.icg.builder.model

import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.xtend.lib.annotations.Accessors

class BuildContext {
	@Accessors IncrementalProjectBuilder builder
	@Accessors int buildKind
}
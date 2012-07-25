package net.jeeeyul.pdetools.icg.builder.model

import org.eclipse.xtend.lib.Property
import org.eclipse.core.resources.IResource

class BuildError {
	@Property String type
	@Property boolean fatal
	@Property String message
	@Property IResource relatedResource
	@Property int lineNumber =-1
}
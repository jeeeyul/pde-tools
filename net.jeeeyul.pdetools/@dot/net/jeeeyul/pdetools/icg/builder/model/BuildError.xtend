package net.jeeeyul.pdetools.icg.builder.model

import org.eclipse.core.resources.IResource
import org.eclipse.xtend.lib.annotations.Accessors

class BuildError {
	@Accessors String type
	@Accessors boolean fatal
	@Accessors String message
	@Accessors IResource relatedResource
	@Accessors int lineNumber =-1
}
package net.jeeeyul.pdetools.icg.builder.model

import org.eclipse.xtend.lib.Property

class BuildError {
	@Property String type
	@Property boolean fatal
	@Property String message
}
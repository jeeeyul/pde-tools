package net.jeeeyul.pdetools.icg.builder.model

import org.eclipse.xtend.lib.Property
import net.jeeeyul.pdetools.model.pdetools.FieldNameOwner

class PaletteDelta {
	@Property FieldNameOwner before
	@Property FieldNameOwner after
	
	def boolean isRefactorTarget(){
		before != null && after != null
	}
	
}
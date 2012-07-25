package net.jeeeyul.pdetools.icg.builder.model

import net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner
import org.eclipse.xtend.lib.Property

class PaletteDelta {
	@Property FieldNameOwner before
	@Property FieldNameOwner after
	
	def boolean isRefactorTarget(){
		before != null && after != null
	}
	
}
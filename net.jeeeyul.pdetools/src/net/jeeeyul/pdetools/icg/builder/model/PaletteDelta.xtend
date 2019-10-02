package net.jeeeyul.pdetools.icg.builder.model

import net.jeeeyul.pdetools.model.pdetools.FieldNameOwner
import org.eclipse.xtend.lib.annotations.Accessors

class PaletteDelta {
	@Accessors FieldNameOwner before
	@Accessors FieldNameOwner after
	
	def boolean isRefactorTarget(){
		before !== null && after !== null
	}
	
}
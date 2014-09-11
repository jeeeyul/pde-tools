package net.jeeeyul.pdetools.icg.builder.model

import java.util.HashSet
import net.jeeeyul.pdetools.model.pdetools.Palette
import org.eclipse.xtend.lib.annotations.Accessors

class PaletteModelGenerationContext {
	@Accessors PaletteModelGenerationContext parent
	
	Palette palette
	HashSet<String> takenNames
	
	new(Palette palette){
		takenNames = new HashSet<String>
		this.palette = palette
	}
	
	def getPalette(){
		return palette
	}
	
	def isRegisteredIconFieldName(String fieldName){
		return takenNames.contains(fieldName)
	}
	
	def isRegisteredPaletteFieldName(String fieldName){
		var ctx = this
		
		if(isRegisteredIconFieldName(fieldName)){
			return true
		}
		
		while(ctx != null && ctx.palette != null){
			if(ctx.palette.fieldName == fieldName){
				return true
			}
			ctx = ctx.parent
		}
		
		return false
	}
	
	def registerFieldName(String fieldName){
		takenNames.add(fieldName)
	}
}
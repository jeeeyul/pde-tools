package net.jeeeyul.pdetools.icg.builder.model

import java.util.HashSet
import org.eclipse.xtend.lib.Property
import net.jeeeyul.pdetools.model.pdetools.Palette

class PaletteModelGenerationContext {
	@Property PaletteModelGenerationContext parent
	
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
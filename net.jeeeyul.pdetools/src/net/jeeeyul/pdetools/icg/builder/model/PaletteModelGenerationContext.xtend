package net.jeeeyul.pdetools.icg.builder.model

import java.util.HashSet
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette

class PaletteModelGenerationContext {
	Palette palette
	HashSet<String> takenNames
	
	new(Palette palette){
		takenNames = new HashSet<String>
		this.palette = palette
	}
	
	def getPalette(){
		return palette
	}
	
	def isRegisterdFieldName(String fieldName){
		return takenNames.contains(fieldName)
	} 
	
	def registerFieldName(String fieldName){
		takenNames.add(fieldName)
	}
}
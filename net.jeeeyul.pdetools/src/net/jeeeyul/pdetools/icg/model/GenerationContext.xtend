package net.jeeeyul.pdetools.icg.model

import net.jeeeyul.pdetools.icg.model.imageResource.Palette
import java.util.HashSet

class GenerationContext {
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
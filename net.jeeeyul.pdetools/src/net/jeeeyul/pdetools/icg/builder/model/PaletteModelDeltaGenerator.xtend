package net.jeeeyul.pdetools.icg.builder.model

import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.core.resources.IResource
import net.jeeeyul.pdetools.model.pdetools.Palette
import net.jeeeyul.pdetools.model.pdetools.FieldNameOwner
import net.jeeeyul.pdetools.model.pdetools.ImageFile

class PaletteModelDeltaGenerator {
	def compare(Palette a, Palette b){
		val List<PaletteDelta> deltas = newArrayList()
		val Map<IResource, FieldNameOwner> original = new HashMap()
		a.eAllContents.filter(typeof(FieldNameOwner)).forEach[
			original.put(it.resource, it)
		]
		
		for(each : b.eAllContents.filter(typeof(FieldNameOwner)).toIterable){
			val eachOriginal = original.get(each.resource)
			if(eachOriginal.fieldName != each.fieldName){
				deltas += new PaletteDelta => [
					before = eachOriginal
					after = each
				]
			}
		}
		return deltas
	}
	
	def dispatch getResource(FieldNameOwner obj){
		null
	}
	
	def dispatch getResource(Palette palette){
		palette.folder
	}
	
	def dispatch getResource(ImageFile file){
		file.file
	}
}
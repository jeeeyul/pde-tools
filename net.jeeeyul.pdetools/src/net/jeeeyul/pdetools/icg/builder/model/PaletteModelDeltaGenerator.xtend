package net.jeeeyul.pdetools.icg.builder.model

import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile
import java.util.ArrayList
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette
import java.util.Map
import java.util.HashMap
import java.util.List
import org.eclipse.core.resources.IFile

class PaletteModelDeltaGenerator {
	def String quallifiedIdentifier(ImageFile imageFile){
		var result = new ArrayList<String>
		result.add(imageFile.fieldName)
		var parent = imageFile.parent
		while(parent != null && parent.fieldName != null){
			result.add(parent.fieldName)
			parent = parent.parent
		}
		return result.reverse.join(".")
	}

	def compare(Palette a, Palette b){
		val List<PaletteDelta> deltas = newArrayList()
		val Map<IFile, ImageFile> original = new HashMap()
		a.eAllContents.filter(typeof(ImageFile)).forEach[
			original.put(it.file, it)
		]
		for(each : b.eAllContents.filter(typeof(ImageFile)).toIterable){
			val eachOriginal = original.get(each.file)
			if(eachOriginal.quallifiedIdentifier != each.quallifiedIdentifier){
				deltas += new PaletteDelta => [
					before = eachOriginal
					after = each
				]
			}
		}
		return deltas
	}
}
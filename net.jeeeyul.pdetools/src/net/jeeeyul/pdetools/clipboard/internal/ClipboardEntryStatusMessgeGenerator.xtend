package net.jeeeyul.pdetools.clipboard.internal

import java.text.SimpleDateFormat
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry

class ClipboardEntryStatusMessgeGenerator {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	
	def private String doGenerate(ClipboardEntry entry)'''
		«IF entry.usingCount > 1»
			«entry.usingCount» times used,
		«ELSE»
			«entry.usingCount» time used,
		«ENDIF»
		
		«IF entry.releatedFile !== null»
			captured from "«entry.releatedFile.name»",
		«ENDIF»
		
		«format.format(entry.takenTime)»
	'''
	
	def String generate(ClipboardEntry entry){
		return doGenerate(entry).replaceAll("\r\n|\r|\n", " ").replaceAll("[\\s]+", " ")
	}
}
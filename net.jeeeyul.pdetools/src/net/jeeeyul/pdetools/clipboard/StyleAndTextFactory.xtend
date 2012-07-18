package net.jeeeyul.pdetools.clipboard

import javax.swing.text.rtf.RTFEditorKit
import java.io.StringReader
import javax.swing.text.StyledDocument
import java.util.List
import javax.swing.text.Element
import java.util.ArrayList

class StyleAndTextFactory {
	def  StyleAndText createFromRTFString(String rtfString){
		var result = new StyleAndText()
		var kit = new RTFEditorKit()
		val doc = kit.createDefaultDocument() as StyledDocument
		kit.read(new StringReader(rtfString), doc, 0)
		val List<Element> leafs = new ArrayList()
		val (Element)=>void leafCollector = []
		doc.rootElements.forEach[
			it.accept(leafCollector)
		]
		return result
	}

	def  accept(Element element, (Element)=>void visitor){
		visitor.apply(element)
		if(!element.leaf) {
			for(i : 0..(element.elementCount-1)){
				element.getElement(i).accept(visitor)
			}
		}
	}
}
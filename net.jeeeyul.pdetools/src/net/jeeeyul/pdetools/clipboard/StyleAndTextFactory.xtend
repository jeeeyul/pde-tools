package net.jeeeyul.pdetools.clipboard

import javax.swing.text.rtf.RTFEditorKit
import java.io.StringReader
import javax.swing.text.StyledDocument
import java.util.List
import javax.swing.text.Element
import java.util.ArrayList
import org.eclipse.swt.custom.StyleRange
import javax.swing.text.StyleConstants
import java.awt.Color
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.SWT
import net.jeeeyul.pdetools.shared.BitExtensions

class StyleAndTextFactory {
	extension BitExtensions = new BitExtensions()
	
	IColorProvider colorProvider
	
	new(IColorProvider colorProvider){
		this.colorProvider = colorProvider
	}
	
	def StyleAndText createFromRTFString(String rtfString){
		var result = new StyleAndText()
		var kit = new RTFEditorKit()
		val doc = kit.createDefaultDocument() as StyledDocument
		kit.read(new StringReader(rtfString), doc, 0)
		val List<Element> leafs = new ArrayList()
		val (Element)=>void leafCollector = [
			if(it.leaf && it.name == "content") {
				leafs += it
			}
		]
		doc.rootElements.forEach[
			it.accept(leafCollector)
		]
		result.text = leafs.join("")[ doc.getText(it.startOffset, it.endOffset - it.startOffset) ]
		
		val List<StyleRange> ranges = new ArrayList()
		leafs.forEach[
			var each = new StyleRange()
			each.start = it.startOffset
			each.length = it.endOffset - it.startOffset
			
			var foreground = it.attributes.getAttribute(StyleConstants::Foreground) as Color
			if(foreground != null){
				each.foreground = colorProvider.getColor(foreground.asRGB)
			}
			var fontStyle = SWT::NORMAL
			if(StyleConstants::isBold(it.attributes)){
				fontStyle = fontStyle || SWT::BOLD
			}
			if(StyleConstants::isItalic(it.attributes)){
				fontStyle = fontStyle || SWT::ITALIC
			}
			each.fontStyle = fontStyle
			
			ranges += each
		]
		result.styleRanges = ranges
		return result
	}

	def accept(Element element, (Element)=>void visitor){
		visitor.apply(element)
		if(!element.leaf) {
			for(i : 0..(element.elementCount-1)){
				element.getElement(i).accept(visitor)
			}
		}
	}
	
	def asRGB(Color awtColor){
		return new RGB(awtColor.red, awtColor.green, awtColor.blue)
	}
}
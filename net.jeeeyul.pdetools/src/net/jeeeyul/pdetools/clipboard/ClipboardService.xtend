package net.jeeeyul.pdetools.clipboard

import net.jeeeyul.pdetools.clipboard.AbstractClipboardService
import javax.swing.text.rtf.RTFEditorKit
import java.io.StringReader
import javax.swing.text.StyledDocument
import java.util.List
import javax.swing.text.Element
import java.util.ArrayList
import sun.reflect.generics.visitor.Visitor
import javax.swing.text.StyleConstants

class ClipboardService extends AbstractClipboardService {
	static ClipboardService INSTANCE;
	
	def static initailze(){
		if(INSTANCE == null){
			INSTANCE = new ClipboardService()
		}
	}
	
	def static getInstance(){
		if(INSTANCE == null){
			throw new IllegalStateException("초기화 되지 않았습니다.");
		}
		return INSTANCE
	}
	
	private new(){
	}
	
	override protected handleCopy() {
		var hasTextContents = nativeClipboard.availableTypes.exists[textTransfer.isSupportedType(it)]
		if(!hasTextContents){
			return;
		}
		
		var rtfText = nativeClipboard.getContents(RTFTransfer) as String
		
		var kit = new RTFEditorKit()
		val doc = kit.createDefaultDocument() as StyledDocument
		kit.read(new StringReader(rtfText), doc, 0)
		
		val List<Element> leafs = new ArrayList()
		
		val (Element)=>void visitor = [
			if(elementCount == 0 && it.name == "content" && it.startOffset != it.endOffset){
				leafs += it
			}
		]
		
		doc.rootElements.forEach[
			accept(visitor)
		]
		
		leafs.forEach[
			var text = doc.getText(it.startOffset, it.endOffset - it.startOffset)
			var enum = it.attributes.attributeNames
			while(enum.hasMoreElements){
				println(enum.nextElement)
			}
			println(it.attributes.getAttribute(StyleConstants::Foreground))
		]
		
	}
	
	def accept(Element element, (Element)=>void visitor){
		visitor.apply(element)
		
		if(!element.leaf){
			for(i : 0..(element.elementCount-1)){
				element.getElement(i).accept(visitor)
			}
		}
	}
}
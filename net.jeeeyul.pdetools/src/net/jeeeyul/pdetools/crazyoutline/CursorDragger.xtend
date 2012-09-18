package net.jeeeyul.pdetools.crazyoutline

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Event
import net.jeeeyul.pdetools.shared.SWTExtensions
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.graphics.Rectangle

class CursorDragger {
	extension SWTExtensions = SWTExtensions::INSTANCE
	
	static val int STATE_NONE = 0
	static val int STATE_DRAGGING = 1
	
	int state
	Point original
	Rectangle cursor
	
	COPage page
	
	new (COPage page){
		this.page = page
		page.canvas.addListener(SWT::MouseDown)[
			onMouseDown(it)
		]
		page.canvas.addListener(SWT::MouseUp)[
			onMouseUp(it)
		]
		
		page.canvas.addListener(SWT::MouseMove)[
			onMouseMove(it)
		]
	}

	def void onMouseDown(Event event) {
		var p = new Point(event.x, event.y)
		p.scale(1f / page.scale)
		 
		if(state == STATE_NONE){
			if(page.cursor.contains(p)){
				original = p
				cursor = page.cursor.copy
				state = STATE_DRAGGING
			}else{
				cursor = page.cursor.copy
				cursor.x = p.x - cursor.width / 2
				cursor.y = p.y - cursor.height / 2
				original = p
				state = STATE_DRAGGING
				page.styledText.topPixel = cursor.y
				page.styledText.horizontalPixel = cursor.x
			}
		} 
	}
	
	def void onMouseUp(Event event){
		state = STATE_NONE
	}
	
	def void onMouseMove(Event event){
		var p = new Point(event.x, event.y)
		p.scale(1f / page.scale)
		
		if(state == STATE_DRAGGING){
			var diff = original.getDifference(p)
			var translate = cursor.getTranslated(diff)
			page.styledText.topPixel = translate.y
			page.styledText.horizontalPixel = translate.x
		}
	}
}
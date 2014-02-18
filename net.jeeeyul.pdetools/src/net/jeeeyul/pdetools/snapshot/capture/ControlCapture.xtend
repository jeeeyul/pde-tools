package net.jeeeyul.pdetools.snapshot.capture

import net.jeeeyul.swtend.SWTExtensions
import org.eclipse.swt.SWTException
import org.eclipse.swt.graphics.GC
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell

class ControlCapture {
	extension SWTExtensions = new SWTExtensions
	
	def dispatch Image capture(Control control){
		control.redraw();
		control.update();
		var size = control.size
		var image = new Image(display, size.x, size.y)
		var gc = new GC(control)
		gc.copyArea(image, 0, 0)
		gc.dispose()
		return image
	}

	def dispatch Image capture(Shell shell){
		shell.redraw();
		shell.update();
		
		var clientArea = shell.clientArea
		clientArea.location = shell.toDisplay(clientArea.location)
		if(shell.menuBar != null) {
			clientArea.translate(0, -menubarHeight).expand(0, menubarHeight)
		}
		var image = new Image(display, clientArea.width, clientArea.height)
		var gc = new GC(display)
		gc.copyArea(image, clientArea.x, clientArea.y)
		gc.dispose()
		return image
	}

	def private Display getDisplay(){
		if(Display::current == null) {
			throw new SWTException("Invalid Thread Exception")
		}
		return Display::current
	}
}
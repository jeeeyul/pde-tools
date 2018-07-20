package net.jeeeyul.pdetools.snapshot.capture

import org.eclipse.swt.graphics.Rectangle
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Shell
import net.jeeeyul.swtend.SWTExtensions

class CaptureBoundsComputer {
	extension SWTExtensions = SWTExtensions.INSTANCE
	
	def dispatch compute(Control control){
		var result = new Rectangle(0, 0, 0, 0)
		result.location = control.parent.toDisplay(control.location)
		result.size = control.size
		return result
	}
	
	def dispatch compute(Shell shell){
		var result = new Rectangle(0, 0, 0, 0)
		result.size = shell.clientArea.size
		result.location = shell.toDisplay(0, 0)
		return result
	}
}
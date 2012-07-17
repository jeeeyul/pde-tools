package net.jeeeyul.pdetools.snapshot

import org.eclipse.swt.widgets.Display
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Event
import org.eclipse.swt.widgets.Control

class SnapshotHook {
	Control _control
	
	def private void setControl(Control control){
		if(_control == control){
			return;
		}
		_control = control
	}
	
	def private Control getControl(){
		_control
	}

	def hook(){
		Display::^default.addFilter(SWT::MouseMove)[
			handleMouseMove(it)
		]
	}
	
	def handleMouseMove(Event e){
		println(e)
	}
}
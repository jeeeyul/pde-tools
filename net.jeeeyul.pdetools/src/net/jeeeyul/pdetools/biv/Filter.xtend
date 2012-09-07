package net.jeeeyul.pdetools.biv

import org.eclipse.swt.widgets.Composite
import net.jeeeyul.pdetools.shared.SWTExtensions
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.SWT
import net.jeeeyul.pdetools.shared.SharedImages

class Filter {
	extension SWTExtensions = SWTExtensions::INSTANCE
	
	Text textField
	Composite container
	
	new(Composite parent){
		container = parent.Composite[
			layout = GridLayout[
				numColumns = 3
				marginWidth = 0
				marginHeight = 0
			]
			
			Label[
				text = "Bundle Filter:"
			]
			
			textField = TextField(SWT::NONE)[
				message = "type bundle filter text"
				layoutData = FILL_HORIZONTAL
			]
			
			ToolBar[
				ToolItem[
					image = SharedImages::getImage(SharedImages::ERASER)
					onSelection = [
						textField.text = ""
					]
				]
			]
		]
	}
	
	def getTextField(){
		textField
	}
	
	def getControl(){
		container
	}
}
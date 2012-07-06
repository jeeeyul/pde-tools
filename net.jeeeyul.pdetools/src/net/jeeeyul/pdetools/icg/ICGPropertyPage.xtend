package net.jeeeyul.pdetools.icg

import net.jeeeyul.pdetools.shared.SWTExtensions
import org.eclipse.core.resources.IProject
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.dialogs.PropertyPage

class ICGPropertyPage extends PropertyPage {
	extension SWTExtensions = new SWTExtensions()
	
	Text monitoringFolderField;
	
	override protected createContents(Composite parent) {
		parent.Composite[
			layout = GridLayout[numColumns = 3]
			
			Label[text="Monitoring Folder:"]
			
			monitoringFolderField = TextField[
				layoutData = FILL_HORIZONTAL
			]
			
			PushButton[
				text = "Browse"
				onClick = [browserMonitoringFolder()]
			]
		]
	}
	
	def browserMonitoringFolder(){
	}
	
	def ICGConfiguration create  new ICGConfiguration(project)  config(){
	}
	
	def IProject getProject(){
		if(element instanceof IProject){
			return element as IProject;
		}else{
			return element.getAdapter(typeof(IProject)) as IProject
		}
	}
}
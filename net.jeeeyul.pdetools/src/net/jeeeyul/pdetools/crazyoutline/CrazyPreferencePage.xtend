package net.jeeeyul.pdetools.crazyoutline

import net.jeeeyul.pdetools.shared.ColorPicker
import net.jeeeyul.pdetools.shared.ColorWell
import net.jeeeyul.pdetools.shared.SWTExtensions
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.preference.PreferencePage
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchPreferencePage
import org.eclipse.swt.widgets.Scale
import net.jeeeyul.pdetools.PDEToolsCore
import static net.jeeeyul.pdetools.crazyoutline.CrazyOutlineConstants.*
import net.jeeeyul.pdetools.shared.HSB

class CrazyPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	public static val String ID = "net.jeeeyul.pdetools.crazyoutline.CrazyPreferencePage"
	
	extension SWTExtensions = SWTExtensions::INSTANCE

	ColorWell fogColorWell
	Scale fogTransparencyScale
	
	def store(){
		PDEToolsCore::getDefault().preferenceStore
	}

	override protected createContents(Composite parent) {
		return parent.Composite[
			layout = GridLayout[
				numColumns = 3
			]
			
			Label[
				text = "Fog Color:"
			]
			
			fogColorWell = ColorWell[
				selection = HSB::createFromString(store.getString(FOG_COLOR))
			]
			
			PushButton[
				text = "change"
				onClick = [
					fogColorWell.showColorPicker()
				]
			]
			
			Label[
				text = "Fog Transparency"
			]
			
			fogTransparencyScale = Scale[
				minimum = 0
				maximum = 255
				selection = 0
				pageIncrement = 17
				
				selection = store.getInt(FOG_TRANSPARENCY)
				
				layoutData = FILL_HORIZONTAL[
					horizontalSpan = 2
				]
			]
		]
	}

	override init(IWorkbench workbench) {
	}
	
	def private void showColorPicker(ColorWell well) { 
		var picker = new ColorPicker()
		var original = well.selection
		
		picker.selection = well.selection
		picker.continuosSelectionHandler = [
			well.selection = it
		]
		if(well.getData("lock-hue") == true){
			picker.lockHue = true
		}

		if(picker.open() == IDialogConstants::OK_ID){
			well.selection = picker.selection
		}else{
			well.selection = original
		}
	}
	
	override performOk() {
		store.setValue(FOG_COLOR, fogColorWell.selection.serialize)
		store.setValue(FOG_TRANSPARENCY, fogTransparencyScale.selection)
		super.performOk()
	}
	
	override protected performDefaults() {
		fogColorWell.selection = HSB::createFromString(store.getDefaultString(FOG_COLOR))
		fogTransparencyScale.selection = store.getDefaultInt(FOG_TRANSPARENCY)
		super.performDefaults()
	}
		
}
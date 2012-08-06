package net.jeeeyul.pdetools.clipboard.internal

import org.eclipse.jface.preference.PreferencePage
import org.eclipse.ui.IWorkbenchPreferencePage
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.IWorkbench
import org.eclipse.swt.SWT
import net.jeeeyul.pdetools.shared.SWTExtensions
import org.eclipse.swt.widgets.Button
import net.jeeeyul.pdetools.PDEToolsCore

import static net.jeeeyul.pdetools.clipboard.internal.ClipboardPreferenceConstants.*
import org.eclipse.swt.widgets.Text

class ClipboardPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	def static getId(){
		typeof(ClipboardPreferencePage).canonicalName
	} 
	
	extension SWTExtensions = new SWTExtensions
	Button dontAskRemoveAllButton
	Button colorizeSelectionButton
	Text linePerRowText

	new(){
		preferenceStore = PDEToolsCore::^default.preferenceStore
	}

	override protected createContents(Composite parent) {
		var result = new Composite(parent, SWT::NORMAL) => [
			layout = GridLayout[
				numColumns = 2
			]
			
			dontAskRemoveAllButton = Checkbox[
				layoutData = FILL_HORIZONTAL[horizontalSpan = 2]
				text = "Do not ask when remove all clip board entries."
			]
			
			colorizeSelectionButton = Checkbox[
				layoutData = FILL_HORIZONTAL[horizontalSpan = 2]
				text = "Colorize text on selection."
			]
			
			Label[
				text = "Lines per row:"
			]
			
			linePerRowText = TextField[
			]
			
			
		]
		update()
		return result
	}

	def private update() {
		dontAskRemoveAllButton.selection = preferenceStore.getBoolean(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES)
		colorizeSelectionButton.selection = preferenceStore.getBoolean(CLIPBOARD_COLORLIZE_IN_SELECTION)
	}
	
	override performOk() {
		preferenceStore.setValue(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES, dontAskRemoveAllButton.selection)
		preferenceStore.setValue(CLIPBOARD_COLORLIZE_IN_SELECTION, colorizeSelectionButton.selection)
		
		return true
	}
	
	override protected performDefaults() {
		dontAskRemoveAllButton.selection = preferenceStore.getDefaultBoolean(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES)
		colorizeSelectionButton.selection = preferenceStore.getDefaultBoolean(CLIPBOARD_COLORLIZE_IN_SELECTION)
	}

	override init(IWorkbench workbench) {
	}
}
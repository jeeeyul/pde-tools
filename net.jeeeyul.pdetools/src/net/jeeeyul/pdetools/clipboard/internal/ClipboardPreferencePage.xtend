package net.jeeeyul.pdetools.clipboard.internal

import net.jeeeyul.pdetools.PDEToolsCore
import net.jeeeyul.pdetools.shared.SWTExtensions
import org.eclipse.jface.preference.PreferencePage
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchPreferencePage

import static net.jeeeyul.pdetools.clipboard.internal.ClipboardPreferenceConstants.*
import org.eclipse.swt.widgets.Text

class ClipboardPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	def static getId(){
		typeof(ClipboardPreferencePage).canonicalName
	} 
	
	extension SWTExtensions = new SWTExtensions
	Button dontAskRemoveAllButton
	Button colorizeSelectionButton
	Text maxItemCountField

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
				text = "Max item count:"
			]
			
			maxItemCountField = TextField[
				validExpression = "[0-9]{0,3}"
				layoutData = GridData[
					widthHint = 100
				]
			]
			
		]
		update()
		return result
	}
	
	def private setValidExpression(Text text, String regExp){
		text.addListener(SWT::Verify)[
			var before = text.text
			var after = before.subSequence(0, text.selection.x) + it.text + before.substring(text.selection.y)
			var evaluate = after.trim()
			it.doit = evaluate.matches(regExp)
		]
	}

	def private update() {
		dontAskRemoveAllButton.selection = preferenceStore.getBoolean(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES)
		colorizeSelectionButton.selection = preferenceStore.getBoolean(CLIPBOARD_COLORLIZE_IN_SELECTION)
		maxItemCountField.text = Integer::toString(preferenceStore.getInt(CLIPBOARD_MAXIMUM_HISTORY_SIZE))
	}
	
	override performOk() {
		preferenceStore.setValue(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES, dontAskRemoveAllButton.selection)
		preferenceStore.setValue(CLIPBOARD_COLORLIZE_IN_SELECTION, colorizeSelectionButton.selection)
		preferenceStore.setValue(CLIPBOARD_MAXIMUM_HISTORY_SIZE, Integer::parseInt(maxItemCountField.text))
		
		return true
	}
	
	override protected performDefaults() {
		dontAskRemoveAllButton.selection = preferenceStore.getDefaultBoolean(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES)
		colorizeSelectionButton.selection = preferenceStore.getDefaultBoolean(CLIPBOARD_COLORLIZE_IN_SELECTION)
		maxItemCountField.text = Integer::toString(preferenceStore.getDefaultInt(CLIPBOARD_MAXIMUM_HISTORY_SIZE))
	}

	override init(IWorkbench workbench) {
	}
}
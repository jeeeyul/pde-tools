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
import net.jeeeyul.pdetools.shared.SharedImages

class ClipboardPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	def static getId(){
		typeof(ClipboardPreferencePage).canonicalName
	} 
	
	extension SWTExtensions = new SWTExtensions
	Button dontAskRemoveAllButton
	Button colorizeSelectionButton
	Text maxItemCountField
	Text numberLineField

	new(){
		preferenceStore = PDEToolsCore::getDefault().preferenceStore
	}

	override protected createContents(Composite parent) {
		var result = new Composite(parent, SWT::NORMAL) => [
			layout = newGridLayout
			
			newGroup[
				text = "Rendering"
				layoutData = FILL_HORIZONTAL
				layout = newGridLayout[
					numColumns = 2
				]
					
				colorizeSelectionButton = newCheckbox[
					layoutData = FILL_HORIZONTAL[horizontalSpan = 2]
					text = "Colorize text on selection."
				]
				
				newLabel[
					text = "Max item count:"
				]
				
				maxItemCountField = newTextField[
					validExpression = "[0-9]{0,3}"
					layoutData = newGridData[
						widthHint = 100
					]
				]
				
				newLabel[
					text = "Number of lines per item:"
				]
				
				numberLineField = newTextField[
					validExpression = "[0-9]{0,2}"
					layoutData = newGridData[
						widthHint = 100
					]
				]
				
				newCLabel[
					text = "Clipboard view should have to be re-opened to apply this settings."
					image = SharedImages::getImage(SharedImages::WARN)
					layoutData = newGridData[
						horizontalIndent = 16
						horizontalSpan = 2
					]
				]
			]
			
			dontAskRemoveAllButton = newCheckbox[
				layoutData = FILL_HORIZONTAL[horizontalSpan = 2]
				text = "Do not ask when remove all clip board entries."
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
		numberLineField.text = Integer::toString(preferenceStore.getInt(CLIPBOARD_NUMBER_OF_LINES_PER_EACH_ITEM))
	}
	
	override performOk() {
		preferenceStore.setValue(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES, dontAskRemoveAllButton.selection)
		preferenceStore.setValue(CLIPBOARD_COLORLIZE_IN_SELECTION, colorizeSelectionButton.selection)
		preferenceStore.setValue(CLIPBOARD_MAXIMUM_HISTORY_SIZE, Integer::parseInt(maxItemCountField.text))
		preferenceStore.setValue(CLIPBOARD_NUMBER_OF_LINES_PER_EACH_ITEM, Integer::parseInt(numberLineField.text))
		return true
	}
	
	override protected performDefaults() {
		dontAskRemoveAllButton.selection = preferenceStore.getDefaultBoolean(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES)
		colorizeSelectionButton.selection = preferenceStore.getDefaultBoolean(CLIPBOARD_COLORLIZE_IN_SELECTION)
		maxItemCountField.text = Integer::toString(preferenceStore.getDefaultInt(CLIPBOARD_MAXIMUM_HISTORY_SIZE))
		numberLineField.text = Integer::toString(preferenceStore.getDefaultInt(CLIPBOARD_NUMBER_OF_LINES_PER_EACH_ITEM))
	}

	override init(IWorkbench workbench) {
	}
}
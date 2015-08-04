package net.jeeeyul.pdetools.clipboard.internal

import net.jeeeyul.pdetools.PDEToolsCore
import net.jeeeyul.swtend.SWTExtensions
import org.eclipse.jface.preference.PreferencePage
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchPreferencePage

import static net.jeeeyul.pdetools.clipboard.internal.ClipboardPreferenceConstants.*

class ClipboardPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	def static getId(){
		typeof(ClipboardPreferencePage).canonicalName
	} 
	
	extension SWTExtensions = new SWTExtensions
	Button dontAskRemoveAllButton
	Button colorizeSelectionButton
	Text maxItemCountField
	Text numberLineField
	SortOptionEditor sortOptionEditor
	Button setActiveButton

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
					numColumns = 3
				]
					
				colorizeSelectionButton = newCheckbox[
					layoutData = FILL_HORIZONTAL[horizontalSpan = 3]
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
					text = "0(no limit) to 100"
					foreground = COLOR_DARK_GRAY
				]
				
				newLabel[
					text = "Setting takes effect at next copy operation."
					foreground = COLOR_DARK_GRAY
					layoutData = newGridData[
						horizontalIndent = 16
						horizontalSpan = 3
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
				
				newLabel[
					text = "1 to 10"
					foreground = COLOR_DARK_GRAY
				]
				
				newLabel[
					text = "Clipboard view needs to be reopened for setting to take effect."
					foreground = COLOR_DARK_GRAY
					layoutData = newGridData[
						horizontalIndent = 16
						horizontalSpan = 3
					]
				]
			]
			
			newGroup[
				text = "Sort Priority"
				layoutData = FILL_HORIZONTAL
				layout = newGridLayout[
					numColumns = 2
				]
				
				sortOptionEditor = new SortOptionEditor(it) => [
					control.layoutData = FILL_HORIZONTAL
				]
			]
			
			newGroup[
				text = "Acceptance Style"
				layoutData = FILL_HORIZONTAL
				layout = newGridLayout[]
				
				setActiveButton = newCheckbox[
					text = "Set accepted clip as active clipbaord contents."
				]
			]
			
			newGroup[
				text = "Dialogs"
				layout = newGridLayout
				layoutData = FILL_HORIZONTAL
				
				dontAskRemoveAllButton = newCheckbox[
					layoutData = FILL_HORIZONTAL[horizontalSpan = 2]
					text = "Do not ask when remove all clip board entries."
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
		numberLineField.text = Integer::toString(preferenceStore.getInt(CLIPBOARD_NUMBER_OF_LINES_PER_EACH_ITEM))
		sortOptionEditor.input = preferenceStore.getString(CLIPBOARD_SORT_ORDER)
		setActiveButton.selection = preferenceStore.getBoolean(CLIPBOARD_SET_ACCEPTED_ITEM_ACITVE);
	}
	
	override performOk() {
		preferenceStore.setValue(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES, dontAskRemoveAllButton.selection)
		preferenceStore.setValue(CLIPBOARD_COLORLIZE_IN_SELECTION, colorizeSelectionButton.selection)
		preferenceStore.setValue(CLIPBOARD_MAXIMUM_HISTORY_SIZE, Integer::parseInt(maxItemCountField.text).limit(0, 100))
		preferenceStore.setValue(CLIPBOARD_NUMBER_OF_LINES_PER_EACH_ITEM, Integer::parseInt(numberLineField.text).limit(1, 10))
		preferenceStore.setValue(CLIPBOARD_SORT_ORDER, sortOptionEditor.input)
		preferenceStore.setValue(CLIPBOARD_SET_ACCEPTED_ITEM_ACITVE, setActiveButton.selection);
		return true
	}
	
	override protected performDefaults() {
		dontAskRemoveAllButton.selection = preferenceStore.getDefaultBoolean(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES)
		colorizeSelectionButton.selection = preferenceStore.getDefaultBoolean(CLIPBOARD_COLORLIZE_IN_SELECTION)
		maxItemCountField.text = Integer::toString(preferenceStore.getDefaultInt(CLIPBOARD_MAXIMUM_HISTORY_SIZE))
		numberLineField.text = Integer::toString(preferenceStore.getDefaultInt(CLIPBOARD_NUMBER_OF_LINES_PER_EACH_ITEM))
		sortOptionEditor.input = preferenceStore.getDefaultString(CLIPBOARD_SORT_ORDER)
		setActiveButton.selection = preferenceStore.getDefaultBoolean(CLIPBOARD_SET_ACCEPTED_ITEM_ACITVE);
	}

	def int limit(int original, int min, int max){
		return Math::max(Math::min(original, max), min)
	}

	override init(IWorkbench workbench) {
	}
}
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

class ClipboardPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	def static getId(){
		typeof(ClipboardPreferencePage).canonicalName
	} 
	
	extension SWTExtensions = new SWTExtensions
	Button dontAskRemoveAllButton

	new(){
		preferenceStore = PDEToolsCore::^default.preferenceStore
	}

	override protected createContents(Composite parent) {
		var result = new Composite(parent, SWT::NORMAL) => [
			layout = GridLayout
			
			dontAskRemoveAllButton = Checkbox[
				text = "Do not ask when remove all clip board entries."
			]
		]
		update()
		return result
	}

	def private update() {
		dontAskRemoveAllButton.selection = preferenceStore.getBoolean(DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES);
	}
	
	override performOk() {
		preferenceStore.setValue(DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES, dontAskRemoveAllButton.selection);
		return true
	}
	
	override protected performDefaults() {
		dontAskRemoveAllButton.selection = preferenceStore.getDefaultBoolean(DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES)
	}

	override init(IWorkbench workbench) {
	}
}
package net.jeeeyul.pdetools.internal

import org.eclipse.jface.preference.PreferencePage
import org.eclipse.ui.IWorkbenchPreferencePage
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.IWorkbench
import net.jeeeyul.pdetools.shared.SWTExtensions
import org.eclipse.swt.SWT

class PDEToolsPreferncePage extends PreferencePage implements IWorkbenchPreferencePage {
	def static getId(){
		typeof(PDEToolsPreferncePage).canonicalName
	}

	extension SWTExtensions = new SWTExtensions

	override protected createContents(Composite parent) {
		var result = new Composite(parent, SWT::NORMAL) => [
			layout = GridLayout
		]
		update()
		return result
	}

	def update() {
	}

	override init(IWorkbench workbench) {
	}
}
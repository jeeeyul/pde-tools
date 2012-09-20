package net.jeeeyul.pdetools.jdt

import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.jface.text.IDocument
import net.jeeeyul.pdetools.shared.ColorPicker
import org.eclipse.swt.widgets.Display
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.swt.graphics.Point

class RGBProposal implements ICompletionProposal {
	int offset
	String value
	
	new(int offset){
		this.offset = offset
	}

	override apply(IDocument document) {
		var picker = new ColorPicker(Display::getDefault().activeShell)
		if(picker.open == IDialogConstants::OK_ID){
			var rgb = picker.selection.toRGB
			value = '''new RGB(«rgb.red», «rgb.green», «rgb.blue»)'''
			document.replace(offset, 0, value)
		}
	}
	
	override getAdditionalProposalInfo() {
	}
	
	override getContextInformation() {
	}
	
	override getDisplayString() {
		"new RGB"
	}
	
	override getImage() {
	}
	
	override getSelection(IDocument document) {
		return new Point(offset + value.length, 0)
	}
	
}
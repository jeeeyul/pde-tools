package net.jeeeyul.pdetools.jdt

import net.jeeeyul.pdetools.shared.ColorPicker
import net.jeeeyul.pdetools.shared.SharedImages
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.text.IDocument
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.widgets.Display

class ColorProposal extends AbstractJavaProposal{
	String value
	int expanded
	int prefix
	
	new(JavaContentAssistInvocationContext context, int prefix) {
		super(context)
		this.prefix = prefix
	}	

	override apply(IDocument document) {
		var picker = new ColorPicker(Display::getDefault().activeShell)
		
		if(picker.open == IDialogConstants::OK_ID){
			var cu = context.compilationUnit
			
			cu.becomeWorkingCopy(new NullProgressMonitor)
			
			var rgb = picker.selection.toRGB
			
			value = '''Color(Display.getDefault(), «rgb.red», «rgb.green», «rgb.blue»)'''
			document.replace(context.invocationOffset - prefix, prefix, value)
			
			var beforeImport = context.document.length
			
			cu.createImport("org.eclipse.swt.graphics.Color", null, new NullProgressMonitor)
			cu.createImport("org.eclipse.swt.widgets.Display", null, new NullProgressMonitor)
			
			expanded = context.document.length - beforeImport
			
			cu.commitWorkingCopy(true, new NullProgressMonitor)
		}
	}
	
	override getAdditionalProposalInfo() {
	}
	
	override getContextInformation() {
	}
	
	override getDisplayString() {
		"Pick a color..."
	}
	
	override getImage() {
		SharedImages::getImage(SharedImages::PALETTE)
	}
	
	override getSelection(IDocument document) {
		if(value != null)
			new Point(context.invocationOffset - prefix + value.length + expanded, 0)
		else 
			null
	}
	
}
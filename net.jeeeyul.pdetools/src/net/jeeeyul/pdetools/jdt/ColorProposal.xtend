package net.jeeeyul.pdetools.jdt

import java.util.ArrayList
import net.jeeeyul.pdetools.shared.SharedImages
import net.jeeeyul.swtend.ui.ColorPicker
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jdt.core.ICompilationUnit
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
			
			value = '''«"org.eclipse.swt.graphics.Color".asTypeRef(cu)»(«"org.eclipse.swt.widgets.Display".asTypeRef(cu)».getDefault(), «rgb.red», «rgb.green», «rgb.blue»)'''
			document.replace(context.invocationOffset - prefix, prefix, value)
			
			var beforeImport = context.document.length
			
			if(cu.canImport("org.eclipse.swt.graphics.Color"))
				cu.createImport("org.eclipse.swt.graphics.Color", null, new NullProgressMonitor)
			
			if(cu.canImport("org.eclipse.swt.widgets.Display"))
				cu.createImport("org.eclipse.swt.widgets.Display", null, new NullProgressMonitor)
			
			expanded = context.document.length - beforeImport
			
			cu.commitWorkingCopy(true, new NullProgressMonitor)
		}
	}
	
	def canImport(ICompilationUnit cu, String qualifiedName){
		if(cu.imports.exists[it.elementName == qualifiedName]){
			return true
		}
		
		var path = new ArrayList<String>(qualifiedName.split("\\.").toList)
		path.remove(path.size-1)
		path.add("*")
		val wildImport = path.join(".")
		if(cu.imports.exists[it.elementName == wildImport]){
			return true
		}
		
		val simpleName = qualifiedName.split("\\.").last
		return !cu.imports.exists[it.elementName.split("\\.").last == simpleName]
	}
	
	def asTypeRef(String qualifiedName, ICompilationUnit cu){
		if(cu.canImport(qualifiedName)){
			return qualifiedName.split("\\.").last
		}else{
			qualifiedName
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
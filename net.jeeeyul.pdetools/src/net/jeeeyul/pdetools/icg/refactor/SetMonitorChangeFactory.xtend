package net.jeeeyul.pdetools.icg.refactor

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.jface.text.FindReplaceDocumentAdapter
import org.eclipse.ltk.core.refactoring.TextFileChange
import org.eclipse.text.edits.ReplaceEdit
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.ui.texteditor.DocumentProviderRegistry
import org.eclipse.ltk.core.refactoring.CompositeChange

class SetMonitorChangeFactory {
	IProject project
	IFolder newFolder

	new(IProject project, IFolder newMonitorFolder) {
		this.project = project
		this.newFolder = newMonitorFolder
	}

	def createChange(){
		var cfg = new ICGConfiguration(project)
		println(cfg.saveFile)
		var TextFileChange change = null
		var editorInput = new FileEditorInput(cfg.saveFile)
		var provider = DocumentProviderRegistry::getDefault().getDocumentProvider(editorInput)
		try{
			provider.connect(editorInput);
			var doc = provider.getDocument(editorInput)
			var finder = new FindReplaceDocumentAdapter(doc)
			println(cfg.monitoringFolder.projectRelativePath.toPortableString)
			var region = finder.find(0, '''monitoring-folder=«cfg.monitoringFolder.projectRelativePath.toPortableString.asISO_8859_1»''', true, true, false, false)
			change = new TextFileChange("Update Image Constant Generator settings", cfg.saveFile)
			change.edit = new ReplaceEdit(region.offset, region.length, '''monitoring-folder=«newFolder.projectRelativePath.toPortableString.asISO_8859_1»''');
		}catch(Exception e){
			e.printStackTrace();
			return null
		}
		
		finally{
			provider.disconnect(cfg.saveFile);
		}
		return new CompositeChange("ICG", newArrayList(change))
	}

	def asISO_8859_1(String string){
		var result = new StringBuffer
		for(c : string.toCharArray){
			if(c > 255) {
				result.append(String::format("\\u%2x", c as int))
			} else {
				result.append(c)
			}
		}
		return result.toString
	}
}
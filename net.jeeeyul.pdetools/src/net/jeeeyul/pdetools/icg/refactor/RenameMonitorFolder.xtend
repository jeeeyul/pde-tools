package net.jeeeyul.pdetools.icg.refactor

import org.eclipse.ltk.core.refactoring.participants.RenameParticipant
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext
import org.eclipse.core.runtime.Platform
import org.eclipse.core.resources.IResource
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import org.eclipse.core.runtime.IPath
import org.eclipse.core.resources.IFolder
import org.eclipse.ltk.core.refactoring.CompositeChange
import org.eclipse.text.edits.ReplaceEdit
import org.eclipse.ltk.core.refactoring.TextFileChange
import org.eclipse.ui.texteditor.DocumentProviderRegistry
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.jface.text.FindReplaceDocumentAdapter
import org.eclipse.core.runtime.Assert

class RenameMonitorFolder extends RenameParticipant {
	private IPath before
	private IPath after
	private ICGConfiguration config

	override checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
	}

	override createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		var TextFileChange change = null
		var editorInput = new FileEditorInput(config.saveFile)
		var documentProvider = DocumentProviderRegistry::getDefault().getDocumentProvider(editorInput)
		try{
			documentProvider.connect(editorInput)
			var doc = documentProvider.getDocument(editorInput)
			var finder = new FindReplaceDocumentAdapter(doc)
			var region = finder.find(0, '''monitoring-folder=«before.toPortableString.asISO_8859_1»''', true, true, false, false )
			change = new TextFileChange("Update Image Constant Generator settings", config.saveFile)
			change.edit = new ReplaceEdit(region.offset, region.length, '''monitoring-folder=«after.toPortableString.asISO_8859_1»''');
		}finally{
			documentProvider.disconnect(editorInput)
		}
		return new CompositeChange("Update Shared Image Generator settings", newArrayList(change))
	}

	override getName() {
		"Update Shared Image Generator settings"
	}

	override protected initialize(Object element) {
		var renamingResource = element.getAdapter(typeof(IResource))
		if(!(renamingResource instanceof IFolder)) {
			return false
		}
		config = new ICGConfiguration(renamingResource.project)
		
		// 이름이 변경되는 폴더가 모니터링 폴더를 포함하는 지 검사
		if(!renamingResource.fullPath.isPrefixOf(config.monitoringFolder.fullPath)) {
			return false
		}
		
		// 이전 설정값
		before = config.monitoringFolder.projectRelativePath
		
		// 변경될 설정값 계산
		var relPath = config.monitoringFolder.fullPath.makeRelativeTo(renamingResource.fullPath)
		after = renamingResource.projectRelativePath.removeLastSegments(1).append(arguments.newName).append(relPath)
		return true
	}

	def <T> T getAdapter(Object target, Class<T> service){
		Assert::isNotNull(target)
		return Platform::adapterManager.getAdapter(target, service) as T;
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
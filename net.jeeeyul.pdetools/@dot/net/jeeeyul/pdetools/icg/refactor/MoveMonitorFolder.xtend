package net.jeeeyul.pdetools.icg.refactor

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.Assert
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Platform
import org.eclipse.jface.text.FindReplaceDocumentAdapter
import org.eclipse.ltk.core.refactoring.CompositeChange
import org.eclipse.ltk.core.refactoring.RefactoringStatus
import org.eclipse.ltk.core.refactoring.TextFileChange
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant
import org.eclipse.text.edits.ReplaceEdit
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.ui.texteditor.DocumentProviderRegistry

class MoveMonitorFolder extends MoveParticipant {
	IPath after
	IPath before
	ICGConfiguration config

	override checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
		new RefactoringStatus();
	}
	
	override createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		try{
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
		}catch(Exception e){
			return null
		}
	}
	
	override getName() {
		return "Change Monitoring Folder name in ICG Configuration";
	}
	
	override protected initialize(Object element) {
		try{
			var movingResource = element.getAdapter(typeof(IResource))
			if(!(movingResource instanceof IFolder)) {
				return false
			}
			config = new ICGConfiguration(movingResource.project)
			
			// 이동 될 폴더가 모니터링 폴더를 포함하는 지 검사
			if(!movingResource.fullPath.isPrefixOf(config.monitoringFolder.fullPath)) {
				return false
			}
			
			// 이전 설정값
			before = config.monitoringFolder.projectRelativePath
			
			// 변경될 설정값 계산
			var relPath = config.monitoringFolder.fullPath.makeRelativeTo(movingResource.fullPath)
			after = new Path(arguments.destination.toString).append(movingResource.name).append(relPath).removeFirstSegments(2)
		}catch(Exception e){
			return false;
		}
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
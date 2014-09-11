package net.jeeeyul.pdetools.icg.builder.model

import java.util.List
import java.util.Stack
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IResource
import net.jeeeyul.pdetools.model.pdetools.Palette
import net.jeeeyul.pdetools.model.pdetools.FieldNameOwner
import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory
import net.jeeeyul.pdetools.model.pdetools.ImageFile

/**
 * ����͸� ���� ������ �������� �ȷ�Ʈ ���� �����մϴ�.
 */
class PaletteModelGenerator {
	Stack<PaletteModelGenerationContext> stack
	ICGConfiguration config
	(IResource)=>String nameProvider
	(IFolder)=>IResource[] contentProvider
	
	def setNameProvider((IResource)=>String provider){
		this.nameProvider = provider
	}
	
	def setContentProvider((IFolder)=>IResource[] provider){
		this.contentProvider = provider
	}

	new(ICGConfiguration config){
		this.config = config
		stack = new Stack<PaletteModelGenerationContext>(); 
		pushContext(null);
	}
	
	def Palette generate(){
		return config.monitoringFolder.generatePalette()
	}

	def Palette generatePalette(IFolder folder){
		var palette = PdetoolsFactory::eINSTANCE.createPalette();
		palette.folder = folder
		palette.assigneFieldName(folder.preferFieldName);
		if(currentContext.palette != null) {
			currentContext.palette.subPalettes += palette
		}
		pushContext(palette);
		{
			folder.validMembers.filter(typeof(IFolder)).forEach[ it.generatePalette ];
			for(eachFile : folder.validMembers.filter(typeof(IFile))){
				palette.imageFiles += eachFile.generateImageFile();
			}
		}
		popContext();
		return palette
	}

	def ImageFile generateImageFile(IFile file) {
		return PdetoolsFactory::eINSTANCE.createImageFile() => [
			it.file = file
			assigneFieldName(file.preferFieldName)
		]
	}

	def private popContext() {
		stack.pop();
	}

	def private dispatch assigneFieldName(Palette fieldNameOwner, String preferName){
		if(!currentContext.isRegisteredPaletteFieldName(preferName)) {
			fieldNameOwner.fieldName = preferName;
			currentContext.registerFieldName(preferName)
		} else {
			var step = 2
			var newName = preferName + "_" + step;
			while(currentContext.isRegisteredPaletteFieldName(newName)){
				step = step + 1
				newName = preferName + "_" + step;
			}
			fieldNameOwner.fieldName = newName;
			currentContext.registerFieldName(newName);
		}
	}
	
	def private dispatch assigneFieldName(FieldNameOwner fieldNameOwner, String preferName){
		if(!currentContext.isRegisteredIconFieldName(preferName)) {
			fieldNameOwner.fieldName = preferName;
			currentContext.registerFieldName(preferName)
		} else {
			var step = 2
			var newName = preferName + "_" + step;
			while(currentContext.isRegisteredIconFieldName(newName)){
				step = step + 1
				newName = preferName + "_" + step;
			}
			fieldNameOwner.fieldName = newName;
			currentContext.registerFieldName(newName);
		}
	}

	def private currentContext(){
		stack.peek
	}

	def private pushContext(Palette palette){
		var newCtx = new PaletteModelGenerationContext(palette)
		if(stack.size > 0){
			newCtx.parent = stack.peek	
		}
		
		stack.push(newCtx);
	}

	def private safeFieldName(String preferName){
		var result = preferName.replaceAll("[^a-zA-Z0-9_]", "_").toUpperCase;
		if(result.matches("[0-9].*")) {
			result = "_" + result
		}
		return result;
	}

	def private IResource[] validMembers(IFolder folder){
		var List<IResource> elements = null
		
		if(contentProvider != null){
		 	elements = contentProvider.apply(folder)
		}
		else{
			elements = folder.members
		}
		
		var list = elements.filter[
			if(it instanceof IFolder) {
				true;
			} else if(it.fileExtension != null){
				config.imageFileExtensions.map[toLowerCase].contains(it.fileExtension.toLowerCase);
			} else{
				false
			}
		];
		
		list.sortWith[a, b|
			if(a instanceof IFolder && b instanceof IFile) {
				return -1;
			} else
				if(a instanceof IFile && b instanceof IFolder) {
					return 1;
				} else {
					return a.name.compareTo(b.name)
				}
		];
	}

	def preferFieldName(IResource resource){
		var String result = null
		var String name = null
		if(nameProvider != null) {
			name = nameProvider.apply(resource)
		}
		if(name == null){
			name = resource.fullPath.removeFileExtension.lastSegment
		}
		result = name.safeFieldName
		return result
	}
}
package net.jeeeyul.pdetools.icg.builder.model

import java.util.Stack
import net.jeeeyul.pdetools.icg.ICGConfiguration
import net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette
import net.jeeeyul.pdetools.icg.builder.model.palette.PaletteFactory
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IResource

/**
 * 모니터링 중인 폴더를 바탕으로 팔레트 모델을 생성합니다.
 */
class PaletteModelGenerator {
	Stack<PaletteModelGenerationContext> stack
	ICGConfiguration config
	
	new(ICGConfiguration config){
		this.config = config
		stack = new Stack<PaletteModelGenerationContext>(); 
		pushContext(null);
	}
	
	def Palette generatePalette(IFolder folder){
		var palette = PaletteFactory::eINSTANCE.createPalette();
		palette.folder = folder
		palette.assigneFieldName(folder.name.safeFieldName);
		if(currentContext.palette != null){
			currentContext.palette.subPalettes += palette
		}
	
		pushContext(palette);
		{
			folder.validMembers.filter(typeof(IFolder)).forEach[it.generatePalette];
			
			for(eachFile : folder.validMembers.filter(typeof(IFile))){
				palette.imageFiles += eachFile.generateImageFile();	
			}
		}
		popContext();
		
		return palette
	}
	
	def ImageFile generateImageFile(IFile file) {
		return  PaletteFactory::eINSTANCE.createImageFile() => [
			it.file = file
			assigneFieldName(file.fullPath.removeFileExtension.lastSegment.safeFieldName)
		]
	}

	
	def private popContext() { 
		stack.pop();
	}
	
	def private assigneFieldName(FieldNameOwner fieldNameOwner, String preferName){
		if(!currentContext.isRegisterdFieldName(preferName)){
			fieldNameOwner.fieldName = preferName;
			currentContext.registerFieldName(preferName)
		}else{
			var step = 2
			var newName = preferName + "_" + step ;
			while(currentContext.isRegisterdFieldName(newName)){
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
		stack.push(new net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerationContext(palette));
	}
	
	def private safeFieldName(String preferName){
		var result = preferName.replaceAll("[^a-zA-Z0-9_]", "_").toUpperCase;
		if(result.matches("[0-9].*")){
			result = "_" + result
		}
		return result;
	}
	
	def private IResource[] validMembers(IFolder folder){
		var list = folder.members.filter[
			if(it instanceof IFolder){
				 true;
			}else{
				config.imageFileExtensions.map[toLowerCase].contains(it.fileExtension.toLowerCase);
			}
		];
		
		list.sort[a, b|
			if(a instanceof IFolder && b instanceof IFile){
				return -1;
			}
			else if(a instanceof IFile && b instanceof IFolder){
				return 1;
			}
			else{
				return a.name.compareTo(b.name)	
			}
		];
	}
}
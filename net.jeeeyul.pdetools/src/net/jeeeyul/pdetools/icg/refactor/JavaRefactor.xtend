package net.jeeeyul.pdetools.icg.refactor

import java.util.ArrayList
import java.util.List
import net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette
import net.jeeeyul.pdetools.icg.refactor.TargetFieldFinder
import net.jeeeyul.pdetools.icg.refactor.TargetInterfaceFinder
import org.eclipse.core.resources.IProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.refactoring.IJavaRefactorings
import org.eclipse.jdt.core.refactoring.descriptors.RenameJavaElementDescriptor
import org.eclipse.ltk.core.refactoring.RefactoringContribution
import org.eclipse.ltk.core.refactoring.RefactoringCore
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.icg.builder.model.PaletteDelta

class JavaRefactor {
	ICGConfiguration config
	
	new(IProject project){
		this.config = new ICGConfiguration(project)
	}
		
	def RenameJavaElementDescriptor createDescriptor(PaletteDelta delta){
		var RefactoringContribution contribution = null
		if(delta.before instanceof Palette){
			contribution = RefactoringCore::getRefactoringContribution(IJavaRefactorings::RENAME_TYPE)
		}else{
			contribution = RefactoringCore::getRefactoringContribution(IJavaRefactorings::RENAME_FIELD)
		}
		
		var desc = contribution.createDescriptor as RenameJavaElementDescriptor
		desc.setJavaElement(delta.before.asType)
		desc.setNewName(delta.after.fieldName)
		desc.setUpdateReferences(true)
		return desc
	}
	
	
	def dispatch asType(FieldNameOwner owner){
		return null
	}
	
	def dispatch asType(Palette palette){
		var cu = JavaCore::create(config.ouputFile)
		var finder = new TargetInterfaceFinder(palette.qualifiedName)
		finder.visit(cu)
		return finder.result 
	}
	
	def dispatch asType(ImageFile file){
		var cu = JavaCore::create(config.ouputFile)
		var finder = new TargetFieldFinder(file.file.projectRelativePath.toPortableString)
		finder.visit(cu)
		return finder.result
	}
	
	def parent(FieldNameOwner owner){
		switch(owner){
			Palette: owner.parent
			ImageFile: owner.parent
		}
	}
	
	def String qualifiedName(FieldNameOwner owner){
		var List<String> segments = new ArrayList()
		segments.add(owner.fieldName)
		var parent = owner.parent
		
		while(parent != null && parent.fieldName != null && !parent.root){
			segments.add(parent.fieldName)
			parent = parent.parent
		}
		
		return '''«config.generatePackageName».«config.generateClassName»$«segments.reverse.join("$")»'''
	}
	
	def isRoot(Palette palette){
		return palette.parent == null
	}
}
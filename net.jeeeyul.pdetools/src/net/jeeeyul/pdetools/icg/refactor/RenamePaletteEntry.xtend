package net.jeeeyul.pdetools.icg.refactor

import java.util.HashMap
import java.util.List
import net.jeeeyul.pdetools.Activator
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelDeltaGenerator
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator
import net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Platform
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl
import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.search.IJavaSearchConstants
import org.eclipse.jdt.core.search.SearchEngine
import org.eclipse.jdt.core.search.SearchParticipant
import org.eclipse.jdt.core.search.SearchPattern
import org.eclipse.ltk.core.refactoring.Change
import org.eclipse.ltk.core.refactoring.CompositeChange
import org.eclipse.ltk.core.refactoring.TextFileChange
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant
import org.eclipse.text.edits.MultiTextEdit
import org.eclipse.text.edits.ReplaceEdit

class RenamePaletteEntry extends RenameParticipant {
	ICGConfiguration config
	IResource resource
	List<Change> result
	
	new(){
	}

	override checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
	}

	override createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		result = newArrayList()
		var palette = loadPreviousPaletteModel()
		var newPalette = createNewPaletteModel()
		var deltaGenerator = new PaletteModelDeltaGenerator();
		var diffs = deltaGenerator.compare(palette, newPalette)
		
		for(eachDelta : diffs){
			var target = palette.eAllContents.filter(typeof(FieldNameOwner)).findFirst[ it.resource == eachDelta.before.resource ]
			val cu = JavaCore::create(config.ouputFile) as ICompilationUnit
			var JavaVisitor<IJavaElement> visitor = null
		
			if(eachDelta.before.resource instanceof IFile){
				visitor = new TargetFieldFinder(target.resource.projectRelativePath.toPortableString);	
			}else{
				visitor = new TargetInterfaceFinder((eachDelta.before as Palette).qualifiedName);
			}
			
			visitor.visit(cu)
			
			if(visitor.result != null) {
				var pattern = SearchPattern::createPattern(visitor.result, IJavaSearchConstants::READ_ACCESSES)
				var scope = SearchEngine::createWorkspaceScope()
				var List<SearchParticipant> participants = newArrayList(SearchEngine::defaultSearchParticipant)
				
				var mather = new SearchMatcher()
				mather.handler = [
					val match = it
					var file = it.resource as IFile
					var change = file.newTextFilecChange()
					change.addEdit(new ReplaceEdit(match.offset, match.length, eachDelta.after.getUpdatedReference(JavaCore::create(file) as ICompilationUnit)))
				]
				new SearchEngine().search(pattern, participants, scope, mather , pm)
			}
		}
		
		if(!result.empty){
			return new CompositeChange("아오 씨바", result)
		}
		return null
	} 

	override getName() {
	}

	override protected initialize(Object element) {
		resource = Platform::adapterManager.getAdapter(element, typeof(IResource)) as IResource
		config = new ICGConfiguration(resource.project)
		if(!config.monitoringFolder.fullPath.isPrefixOf(resource.fullPath)) {
			return false
		}
		return true
	}

	def loadPreviousPaletteModel(){
		try{
			var uri = URI::createPlatformResourceURI(resource.project.fullPath.append('''.settings/«Activator::^default.bundle.symbolicName».palette.xml''').toPortableString, true)
			var resource = new XMLResourceImpl(uri)
			resource.load(new HashMap)
			resource.contents.get(0) as Palette
		}catch(Exception e){
			e.printStackTrace()
			return null
		}
	}

	def createNewPaletteModel(){
		var generator = new PaletteModelGenerator(config)
		generator.nameProvider = [
			if(it == resource) {
				new Path(arguments.newName).removeFileExtension.lastSegment
			}
		]
		generator.generate()
	}
	
	def TextFileChange create new TextFileChange("알거 없다", file) newTextFilecChange(IFile file){
		it.edit = new MultiTextEdit() 
		result.add(it)
	}
	
	def String qualifiedName(Palette owner){
		var List<String> segments = newArrayList()
		segments.add(owner.fieldName)
		
		var parent = owner.parent
		while(parent != null && parent.fieldName != null && parent.parent != null){
			segments.add(parent.fieldName)
			parent = parent.parent
		}
		
		return '''«config.generatePackageName».«config.generateClassName»$«segments.reverse.join("$")»'''
	}
	
	def String qualifiedNameForUpdate(Palette owner){
		var List<String> segments = newArrayList()
		segments.add(owner.fieldName)
		
		var parent = owner.parent
		while(parent != null && parent.fieldName != null && parent.parent != null){
			segments.add(parent.fieldName)
			parent = parent.parent
		}
		
		return '''«config.generateClassName».«segments.reverse.join(".")»'''
	}
	
	def parent(FieldNameOwner owner){
		switch(owner){
			Palette:{
				return owner.parent
			}
			ImageFile:{
				return owner.parent
			}
		}
	}
	
	
	def dispatch getResource(FieldNameOwner obj){
		null
	}
	
	def dispatch getResource(Palette palette){
		palette.folder
	}
	
	def dispatch getResource(ImageFile file){
		file.file
	}
	
	def dispatch String getUpdatedReference(FieldNameOwner obj, ICompilationUnit cu){
		null
	}
	
	def dispatch getUpdatedReference(Palette palette, ICompilationUnit cu){
		var String result = palette.qualifiedNameForUpdate
		
		val fullyQualifiedName = '''«config.generatePackageName».«config.generateClassName»'''.toString
		var imported = cu.imports.exists[it.elementName == fullyQualifiedName || it.elementName == config.generatePackageName + ".*"]

		cu.imports.forEach[println(it.elementName)]
		if(!imported){
			result = '''«config.generatePackageName».«result»'''
		}
		
		return result
	}
	
	def dispatch getUpdatedReference(ImageFile file, ICompilationUnit cu){
		file.fieldName
	}
}
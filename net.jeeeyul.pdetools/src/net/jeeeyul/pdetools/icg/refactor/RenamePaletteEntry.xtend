package net.jeeeyul.pdetools.icg.refactor

import java.util.HashMap
import java.util.List
import net.jeeeyul.pdetools.Activator
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelDeltaGenerator
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl
import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.search.IJavaSearchConstants
import org.eclipse.jdt.core.search.SearchEngine
import org.eclipse.jdt.core.search.SearchParticipant
import org.eclipse.jdt.core.search.SearchPattern
import org.eclipse.ltk.core.refactoring.TextFileChange
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant
import org.eclipse.text.edits.ReplaceEdit
import org.eclipse.ltk.core.refactoring.CompositeChange
import org.eclipse.ltk.core.refactoring.Change
import org.eclipse.text.edits.MultiTextEdit
import org.eclipse.core.runtime.Path

class RenamePaletteEntry extends RenameParticipant {
	ICGConfiguration config
	IFile file
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
			var target = palette.eAllContents.filter(typeof(ImageFile)).findFirst[ it.file == eachDelta.before.file ]
			var cu = JavaCore::create(config.ouputFile) as ICompilationUnit
			var visitor = new TargetFieldFinder(target.file.projectRelativePath.toPortableString);
			visitor.visit(cu)
			if(visitor.result != null) {
				println("필드 찾음")
				var pattern = SearchPattern::createPattern(visitor.result, IJavaSearchConstants::REFERENCES)
				var scope = SearchEngine::createWorkspaceScope()
				var List<SearchParticipant> participants = newArrayList(SearchEngine::defaultSearchParticipant)
				
				var mather = new SearchMatcher()
				mather.handler = [
					val match = it
					var file = it.resource as IFile
					var change = file.newTextFilecChange()
					change.addEdit(new ReplaceEdit(match.offset, match.length, eachDelta.after.fieldName))
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
		file = element as IFile
		config = new ICGConfiguration(file.project)
		if(!config.monitoringFolder.fullPath.isPrefixOf(file.fullPath)) {
			return false
		}
		return true
	}

	def loadPreviousPaletteModel(){
		try{
			var uri = URI::createPlatformResourceURI(file.project.fullPath.append('''.settings/«Activator::^default.bundle.symbolicName».palette.xml''').toPortableString, true)
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
			if(it == file) {
				new Path(arguments.newName).removeFileExtension.lastSegment
			}
		]
		generator.generate()
	}
	
	def TextFileChange create new TextFileChange("알거 없다", file) newTextFilecChange(IFile file){
		it.edit = new MultiTextEdit() 
		result.add(it)
	}
}
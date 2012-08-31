package net.jeeeyul.pdetools.icg.builder.model

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ProjectScope
import org.eclipse.core.runtime.Assert
import org.eclipse.core.runtime.Path
import org.eclipse.jface.preference.IPreferenceStore
import org.eclipse.pde.core.plugin.PluginRegistry
import org.eclipse.ui.preferences.ScopedPreferenceStore

import static net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration.*

class ICGConfiguration {
	private static val MONITORING_FOLDER = "monitoring-folder" ;
	private static val GENERATE_SRC_FOLDER = "generate-src-folder" ;
	private static val GENERATE_PACKAGE = "generate-package" ;
	private static val GENERATE_CLASS = "generate-class" ;
	private static val MARK_DEREIVED = "mark-derived" ;
	private static val IMAGE_FILE_EXTENSIONS = "image-file-extensions";
	private static val GENERATE_IMAGE_PREVIEW = "generate-image-preview";
	private static val GENERATE_TYPE="generate-type"
	
	public static val GENERATE_TYPE_STANDARD = "generate-type-standard"
	public static val GENERATE_TYPE_GRAPHITI="generate-type-graphiti"
	
	IProject project ;
	ScopedPreferenceStore _store ;

	new(IProject project) {
		Assert::isNotNull(project); this.project = project
	}

	def IProject getProject(){
		project
	}

	def IFolder getGenerateSrcFolder() {
		store.getFolder(GENERATE_SRC_FOLDER)
	}

	def void setGenerateSrcFolder(IFolder folder) {
		store.setValue(GENERATE_SRC_FOLDER, folder)
	}

	def String getGeneratePackageName() {
		store.getString(GENERATE_PACKAGE);
	}

	def void setGeneratePackageName(String packageName) {
		store.setValue(GENERATE_PACKAGE, packageName)
	}

	def getGenerateClassName() {
		store.getString(GENERATE_CLASS)
	}

	def void setGenerateClassName(String className) {
		store.setValue(GENERATE_CLASS, className)
	}

	def IFolder getMonitoringFolder() {
		store.getFolder(MONITORING_FOLDER)
	}

	def void setMonitoringFolder(IFolder folder) {
		store.setValue(MONITORING_FOLDER, folder)
	}

	def isMarkDerived() {
		store.getBoolean(MARK_DEREIVED)
	}

	def setMarkDerived(boolean markDerived) {
		store.setValue(MARK_DEREIVED, markDerived)
	}

	def String[ ] getImageFileExtensions() {
		var expression = store.getString(IMAGE_FILE_EXTENSIONS)
		if(expression == null) {
			return emptyList
		}
		return expression.split("[ ,]+").map[ it.trim ].filter[ length>0 ]
	}

	def void setImageFileExtensions(String[ ] extensions) {
		store.setValue(IMAGE_FILE_EXTENSIONS, extensions.join(", "))
	}

	def private store() {
		if(_store == null) {
			var projectScope = new ProjectScope(project)
			_store = new ScopedPreferenceStore(projectScope, '''«net::jeeeyul::pdetools::PDEToolsCore::getDefault.bundle.symbolicName».icg''');
			_store.setDefault(GENERATE_TYPE, GENERATE_TYPE_STANDARD)
		}
		return _store;
	}

	def private getFolder(IPreferenceStore store, String key) {
		var value = store.getString(key)
		if(value.nullOrEmpty) {
			return null;
		}
		project.getFolder(value)
	}

	def private setValue(IPreferenceStore store, String key, IFolder folder) {
		if(folder == null) {
			store.setValue(key, "")
		} else {
			store.setValue(key, folder.projectRelativePath.toPortableString)
		}
	}

	def IFile getOuputFile() {
		var segments = generatePackageName.split("\\.")
		var pointer = generateSrcFolder
		for(s : segments) {
			pointer = pointer.getFolder(s)
		}
		return pointer.getFile('''«generateClassName».java''')
	}

	def getBundleId() {
		var pluginModel = PluginRegistry::findModel(project)
		return pluginModel.bundleDescription.symbolicName
	}

	def save() {
		store.save();
	}

	def isGenerateImagePreview() {
		store.getBoolean(GENERATE_IMAGE_PREVIEW)
	}

	def setGenerateImagePreview(boolean generatePreview) {
		store.setValue(GENERATE_IMAGE_PREVIEW, generatePreview)
	}
	
	def getSaveFile(){
		project.getFile(new Path('''.settings/«net::jeeeyul::pdetools::PDEToolsCore::getDefault().bundle.symbolicName».icg.prefs'''))
	}
	
	def getGenerateType(){
		store.getString(GENERATE_TYPE)
	}
	
	def setGenerateType(String type){
		store.setValue(GENERATE_TYPE, type)
	}
}
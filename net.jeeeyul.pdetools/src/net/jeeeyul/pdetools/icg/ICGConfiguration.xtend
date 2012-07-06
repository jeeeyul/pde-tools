package net.jeeeyul.pdetools.icg

import org.eclipse.ui.preferences.ScopedPreferenceStore
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.IPath
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ProjectScope
import net.jeeeyul.pdetools.Activator
import org.eclipse.core.runtime.Assert

class ICGConfiguration {
	private static val MONITORING_FOLDER = "monitoring-folder";
	private static val GENERATE_SRC_FOLDER  = "generate-src-folder";
	private static val GENERATE_PACKAGE  = "generate-package";
	private static val GENERATE_CLASS  = "generate-class";
	private static val MARK_DEREIVED = "mark-derived";
	
	IProject project;
	ScopedPreferenceStore _store;
	
	new(IProject project){
		Assert::isNotNull(project);
		this.project = project
	}
	
	def IPath getGenerateSrcFolder(){
		var value = store.getString(GENERATE_SRC_FOLDER)
		if(value != null){
			return new Path(value);
		}else{
			return null;
		}
	}
	
	def void setGenerateSrcFolder(IPath path){
		store.setValue(GENERATE_SRC_FOLDER, path.toPortableString)
	}
	
	def IPath getMonitoringFolder(){
		return new Path(store.getString(MONITORING_FOLDER));
	}
	
	def void setMonitoringFolder(IPath path){
		store.putValue(MONITORING_FOLDER, path.toPortableString);
	}
	
	def private  store(){
		if(_store == null){
			_store = new ScopedPreferenceStore(new ProjectScope(project), Activator::PLUGIN_ID + ".icg"); 
		}
		return _store;
	}
	
	def save(){
		store.save();
	}
}
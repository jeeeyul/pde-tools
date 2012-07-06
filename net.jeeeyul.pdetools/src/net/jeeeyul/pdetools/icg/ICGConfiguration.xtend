package net.jeeeyul.pdetools.icg

import org.eclipse.ui.preferences.ScopedPreferenceStore
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.IPath

/**
 * Image Constants Generator의 환경설정 객체.
 */
class ICGConfiguration {
	private static val MONITORING_FOLDER = "monitoring-folder";
	
	@Property ScopedPreferenceStore store;
	
	/**
	 * 이미지 리소스를 모니터링할 폴더의 경로를 얻습니다.
	 * 
	 * @returns 
	 * 	이미지 리소스를 모니터링할 폴더의 프로젝트 상대 경로.
	 */
	def IPath getMonitoringFolder(){
		return new Path(store.getString(MONITORING_FOLDER));
	}
	
	/**
	 * 이미지 리소스를 모니터링할 폴더의 경로를 지정합니다.
	 * 
	 * @param path
	 * 	이미지 리소스를 모니터링할 폴더의 프로젝트 상대 경로.
	 */
	def void setMonitoringFolder(IPath path){
		store.putValue(MONITORING_FOLDER, path.toPortableString);
	}
}
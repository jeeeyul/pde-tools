package net.jeeeyul.pdetools.icg;

import net.jeeeyul.pdetools.Activator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * Image Constants Generator의 환경설정 객체.
 */
@SuppressWarnings("all")
public class ICGConfiguration {
  private final static String MONITORING_FOLDER = "monitoring-folder";
  
  private IProject project;
  
  public ICGConfiguration(final IProject project) {
    Assert.isNotNull(project);
    this.project = project;
  }
  
  /**
   * 이미지 리소스를 모니터링할 폴더의 경로를 얻습니다.
   * 
   * @returns
   * 	이미지 리소스를 모니터링할 폴더의 프로젝트 상대 경로.
   */
  public IPath getMonitoringFolder() {
    ScopedPreferenceStore _store = this.store();
    String _string = _store.getString(ICGConfiguration.MONITORING_FOLDER);
    Path _path = new Path(_string);
    return _path;
  }
  
  /**
   * 이미지 리소스를 모니터링할 폴더의 경로를 지정합니다.
   * 
   * @param path
   * 	이미지 리소스를 모니터링할 폴더의 프로젝트 상대 경로.
   */
  public void setMonitoringFolder(final IPath path) {
    ScopedPreferenceStore _store = this.store();
    String _portableString = path.toPortableString();
    _store.putValue(ICGConfiguration.MONITORING_FOLDER, _portableString);
  }
  
  public ScopedPreferenceStore store() {
    ProjectScope _projectScope = new ProjectScope(this.project);
    String _plus = (Activator.PLUGIN_ID + ".icg");
    ScopedPreferenceStore _scopedPreferenceStore = new ScopedPreferenceStore(_projectScope, _plus);
    return _scopedPreferenceStore;
  }
}

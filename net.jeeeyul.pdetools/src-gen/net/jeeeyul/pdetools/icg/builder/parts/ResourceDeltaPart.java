package net.jeeeyul.pdetools.icg.builder.parts;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.jeeeyul.pdetools.icg.builder.model.BuildContext;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.IPath;

@Singleton
@SuppressWarnings("all")
public class ResourceDeltaPart {
  @Inject
  private IncrementalProjectBuilder builder;
  
  @Inject
  private ICGConfiguration config;
  
  @Inject
  private BuildContext buildContext;
  
  public boolean hasResourceDelta() {
    IFolder monitoringFolder = this.config.getMonitoringFolder();
    boolean _and = false;
    int _buildKind = this.buildContext.getBuildKind();
    boolean _notEquals = (_buildKind != IncrementalProjectBuilder.CLEAN_BUILD);
    if (!_notEquals) {
      _and = false;
    } else {
      int _buildKind_1 = this.buildContext.getBuildKind();
      boolean _notEquals_1 = (_buildKind_1 != IncrementalProjectBuilder.FULL_BUILD);
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      IProject _project = this.builder.getProject();
      IResourceDelta projectDelta = this.builder.getDelta(_project);
      boolean _equals = Objects.equal(projectDelta, null);
      if (_equals) {
        return false;
      }
      boolean _equals_1 = Objects.equal(monitoringFolder, null);
      if (_equals_1) {
        return false;
      }
      boolean _exists = monitoringFolder.exists();
      boolean _not = (!_exists);
      if (_not) {
        return false;
      }
      IFolder _monitoringFolder = this.config.getMonitoringFolder();
      IPath _projectRelativePath = _monitoringFolder.getProjectRelativePath();
      IResourceDelta monitoredDelta = projectDelta.findMember(_projectRelativePath);
      boolean _equals_2 = Objects.equal(monitoredDelta, null);
      if (_equals_2) {
        return false;
      }
    }
    boolean _exists_1 = monitoringFolder.exists();
    boolean _not_1 = (!_exists_1);
    if (_not_1) {
      return false;
    }
    return true;
  }
}

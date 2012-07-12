package net.jeeeyul.pdetools.icg.builder.parts;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import net.jeeeyul.pdetools.Activator;
import net.jeeeyul.pdetools.icg.builder.model.BuildContext;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@Singleton
@SuppressWarnings("all")
public class ResourceDeltaPart {
  private List<IPath> affectPathList() {
    final List<IPath> affectPathes = CollectionLiterals.<IPath>newArrayList();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".settings/");
    _builder.append(Activator.PLUGIN_ID, "");
    _builder.append(".icg.prefs");
    Path _path = new Path(_builder.toString());
    affectPathes.add(_path);
    IFolder _monitoringFolder = this.config.getMonitoringFolder();
    IPath _projectRelativePath = _monitoringFolder.getProjectRelativePath();
    affectPathes.add(_projectRelativePath);
    return affectPathes;
  }
  
  @Inject
  private IncrementalProjectBuilder builder;
  
  @Inject
  private ICGConfiguration config;
  
  @Inject
  private BuildContext buildContext;
  
  public boolean hasResourceDelta() {
    boolean _or = false;
    int _buildKind = this.buildContext.getBuildKind();
    boolean _equals = (_buildKind == IncrementalProjectBuilder.CLEAN_BUILD);
    if (_equals) {
      _or = true;
    } else {
      int _buildKind_1 = this.buildContext.getBuildKind();
      boolean _equals_1 = (_buildKind_1 == IncrementalProjectBuilder.FULL_BUILD);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      return true;
    }
    IProject _project = this.builder.getProject();
    IResourceDelta projectDelta = this.builder.getDelta(_project);
    boolean _equals_2 = Objects.equal(projectDelta, null);
    if (_equals_2) {
      return false;
    }
    List<IPath> _affectPathList = this.affectPathList();
    for (final IPath eachPath : _affectPathList) {
      IResourceDelta _findMember = projectDelta.findMember(eachPath);
      boolean _notEquals = (!Objects.equal(_findMember, null));
      if (_notEquals) {
        return true;
      }
    }
    return false;
  }
}

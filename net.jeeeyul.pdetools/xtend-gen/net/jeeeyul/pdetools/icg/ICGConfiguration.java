package net.jeeeyul.pdetools.icg;

import com.google.common.base.Objects;
import net.jeeeyul.pdetools.Activator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ICGConfiguration {
  private final static String MONITORING_FOLDER = "monitoring-folder";
  
  private final static String GENERATE_SRC_FOLDER = "generate-src-folder";
  
  private final static String GENERATE_PACKAGE = "generate-package";
  
  private final static String GENERATE_CLASS = "generate-class";
  
  private final static String MARK_DEREIVED = "mark-derived";
  
  private IProject project;
  
  private ScopedPreferenceStore _store;
  
  public ICGConfiguration(final IProject project) {
    Assert.isNotNull(project);
    this.project = project;
  }
  
  public IPath getGenerateSrcFolder() {
    ScopedPreferenceStore _store = this.store();
    String value = _store.getString(ICGConfiguration.GENERATE_SRC_FOLDER);
    boolean _notEquals = (!Objects.equal(value, null));
    if (_notEquals) {
      Path _path = new Path(value);
      return _path;
    } else {
      return null;
    }
  }
  
  public void setGenerateSrcFolder(final IPath path) {
    ScopedPreferenceStore _store = this.store();
    String _portableString = path.toPortableString();
    _store.setValue(ICGConfiguration.GENERATE_SRC_FOLDER, _portableString);
  }
  
  public IPath getMonitoringFolder() {
    ScopedPreferenceStore _store = this.store();
    String _string = _store.getString(ICGConfiguration.MONITORING_FOLDER);
    Path _path = new Path(_string);
    return _path;
  }
  
  public void setMonitoringFolder(final IPath path) {
    ScopedPreferenceStore _store = this.store();
    String _portableString = path.toPortableString();
    _store.putValue(ICGConfiguration.MONITORING_FOLDER, _portableString);
  }
  
  private ScopedPreferenceStore store() {
    boolean _equals = Objects.equal(this._store, null);
    if (_equals) {
      ProjectScope _projectScope = new ProjectScope(this.project);
      String _plus = (Activator.PLUGIN_ID + ".icg");
      ScopedPreferenceStore _scopedPreferenceStore = new ScopedPreferenceStore(_projectScope, _plus);
      this._store = _scopedPreferenceStore;
    }
    return this._store;
  }
  
  public void save() {
    try {
      ScopedPreferenceStore _store = this.store();
      _store.save();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

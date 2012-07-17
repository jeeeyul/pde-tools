package net.jeeeyul.pdetools.icg.builder.model;

import com.google.common.base.Objects;
import java.util.List;
import net.jeeeyul.pdetools.Activator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.osgi.framework.Bundle;

@SuppressWarnings("all")
public class ICGConfiguration {
  private final static String MONITORING_FOLDER = "monitoring-folder";
  
  private final static String GENERATE_SRC_FOLDER = "generate-src-folder";
  
  private final static String GENERATE_PACKAGE = "generate-package";
  
  private final static String GENERATE_CLASS = "generate-class";
  
  private final static String MARK_DEREIVED = "mark-derived";
  
  private final static String IMAGE_FILE_EXTENSIONS = "image-file-extensions";
  
  private final static String GENERATE_IMAGE_PREVIEW = "generate-image-preview";
  
  private IProject project;
  
  private ScopedPreferenceStore _store;
  
  public ICGConfiguration(final IProject project) {
    Assert.isNotNull(project);
    this.project = project;
  }
  
  public IProject getProject() {
    return this.project;
  }
  
  public IFolder getGenerateSrcFolder() {
    ScopedPreferenceStore _store = this.store();
    IFolder _folder = this.getFolder(_store, ICGConfiguration.GENERATE_SRC_FOLDER);
    return _folder;
  }
  
  public void setGenerateSrcFolder(final IFolder folder) {
    ScopedPreferenceStore _store = this.store();
    this.setValue(_store, ICGConfiguration.GENERATE_SRC_FOLDER, folder);
  }
  
  public String getGeneratePackageName() {
    ScopedPreferenceStore _store = this.store();
    String _string = _store.getString(ICGConfiguration.GENERATE_PACKAGE);
    return _string;
  }
  
  public void setGeneratePackageName(final String packageName) {
    ScopedPreferenceStore _store = this.store();
    _store.setValue(ICGConfiguration.GENERATE_PACKAGE, packageName);
  }
  
  public String getGenerateClassName() {
    ScopedPreferenceStore _store = this.store();
    String _string = _store.getString(ICGConfiguration.GENERATE_CLASS);
    return _string;
  }
  
  public void setGenerateClassName(final String className) {
    ScopedPreferenceStore _store = this.store();
    _store.setValue(ICGConfiguration.GENERATE_CLASS, className);
  }
  
  public IFolder getMonitoringFolder() {
    ScopedPreferenceStore _store = this.store();
    IFolder _folder = this.getFolder(_store, ICGConfiguration.MONITORING_FOLDER);
    return _folder;
  }
  
  public void setMonitoringFolder(final IFolder folder) {
    ScopedPreferenceStore _store = this.store();
    this.setValue(_store, ICGConfiguration.MONITORING_FOLDER, folder);
  }
  
  public boolean isMarkDerived() {
    ScopedPreferenceStore _store = this.store();
    boolean _boolean = _store.getBoolean(ICGConfiguration.MARK_DEREIVED);
    return _boolean;
  }
  
  public void setMarkDerived(final boolean markDerived) {
    ScopedPreferenceStore _store = this.store();
    _store.setValue(ICGConfiguration.MARK_DEREIVED, markDerived);
  }
  
  public String[] getImageFileExtensions() {
    ScopedPreferenceStore _store = this.store();
    String expression = _store.getString(ICGConfiguration.IMAGE_FILE_EXTENSIONS);
    boolean _equals = Objects.equal(expression, null);
    if (_equals) {
      return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>emptyList(), String.class));
    }
    String[] _split = expression.split("[ ,]+");
    final Function1<String,String> _function = new Function1<String,String>() {
        public String apply(final String it) {
          String _trim = it.trim();
          return _trim;
        }
      };
    List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
    final Function1<String,Boolean> _function_1 = new Function1<String,Boolean>() {
        public Boolean apply(final String it) {
          int _length = it.length();
          boolean _greaterThan = (_length > 0);
          return Boolean.valueOf(_greaterThan);
        }
      };
    return ((String[])Conversions.unwrapArray(IterableExtensions.<String>filter(_map, _function_1), String.class));
  }
  
  public void setImageFileExtensions(final String[] extensions) {
    ScopedPreferenceStore _store = this.store();
    String _join = IterableExtensions.join(((Iterable<? extends Object>)Conversions.doWrapArray(extensions)), ", ");
    _store.setValue(ICGConfiguration.IMAGE_FILE_EXTENSIONS, _join);
  }
  
  private ScopedPreferenceStore store() {
    boolean _equals = Objects.equal(this._store, null);
    if (_equals) {
      ProjectScope _projectScope = new ProjectScope(this.project);
      StringConcatenation _builder = new StringConcatenation();
      Activator _default = Activator.getDefault();
      Bundle _bundle = _default.getBundle();
      String _symbolicName = _bundle.getSymbolicName();
      _builder.append(_symbolicName, "");
      _builder.append(".icg");
      ScopedPreferenceStore _scopedPreferenceStore = new ScopedPreferenceStore(_projectScope, _builder.toString());
      this._store = _scopedPreferenceStore;
    }
    return this._store;
  }
  
  private IFolder getFolder(final IPreferenceStore store, final String key) {
    IFolder _xblockexpression = null;
    {
      String value = store.getString(key);
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
      if (_isNullOrEmpty) {
        return null;
      }
      IFolder _folder = this.project.getFolder(value);
      _xblockexpression = (_folder);
    }
    return _xblockexpression;
  }
  
  private void setValue(final IPreferenceStore store, final String key, final IFolder folder) {
    boolean _equals = Objects.equal(folder, null);
    if (_equals) {
      store.setValue(key, "");
    } else {
      IPath _projectRelativePath = folder.getProjectRelativePath();
      String _portableString = _projectRelativePath.toPortableString();
      store.setValue(key, _portableString);
    }
  }
  
  public IFile getOuputFile() {
    String _generatePackageName = this.getGeneratePackageName();
    String[] segments = _generatePackageName.split("\\.");
    IFolder pointer = this.getGenerateSrcFolder();
    for (final String s : segments) {
      IFolder _folder = pointer.getFolder(s);
      pointer = _folder;
    }
    StringConcatenation _builder = new StringConcatenation();
    String _generateClassName = this.getGenerateClassName();
    _builder.append(_generateClassName, "");
    _builder.append(".java");
    return pointer.getFile(_builder.toString());
  }
  
  public String getBundleId() {
    IPluginModelBase pluginModel = PluginRegistry.findModel(this.project);
    BundleDescription _bundleDescription = pluginModel.getBundleDescription();
    return _bundleDescription.getSymbolicName();
  }
  
  public void save() {
    try {
      ScopedPreferenceStore _store = this.store();
      _store.save();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isGenerateImagePreview() {
    ScopedPreferenceStore _store = this.store();
    boolean _boolean = _store.getBoolean(ICGConfiguration.GENERATE_IMAGE_PREVIEW);
    return _boolean;
  }
  
  public void setGenerateImagePreview(final boolean generatePreview) {
    ScopedPreferenceStore _store = this.store();
    _store.setValue(ICGConfiguration.GENERATE_IMAGE_PREVIEW, generatePreview);
  }
  
  public IFile getSaveFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".settings/");
    Activator _default = Activator.getDefault();
    Bundle _bundle = _default.getBundle();
    String _symbolicName = _bundle.getSymbolicName();
    _builder.append(_symbolicName, "");
    _builder.append(".icg.prefs");
    Path _path = new Path(_builder.toString());
    IFile _file = this.project.getFile(_path);
    return _file;
  }
}

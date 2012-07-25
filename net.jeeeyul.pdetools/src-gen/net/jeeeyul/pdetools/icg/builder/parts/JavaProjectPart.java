package net.jeeeyul.pdetools.icg.builder.parts;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.shared.ResourceExtensions;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.pde.core.IEditableModel;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class JavaProjectPart {
  @Inject
  private ResourceExtensions _resourceExtensions;
  
  @Inject
  private ICGConfiguration config;
  
  @Inject
  private IJavaProject javaProject;
  
  @Inject
  private IProject project;
  
  /**
   * 결과 자바 소스가 생성될 소스폴더를 만들고, 자바 소스 폴더로 빌드 패스에 등록한다.
   * 이미 존재하고, 이미 등록되어 있으면 아무일도 하지 않는다.
   */
  public void ensureJavaSourceFolder() {
    try {
      IFolder _generateSrcFolder = this.config.getGenerateSrcFolder();
      this._resourceExtensions.ensureExist(_generateSrcFolder);
      IClasspathEntry[] _rawClasspath = this.javaProject.getRawClasspath();
      final Function1<IClasspathEntry,Boolean> _function = new Function1<IClasspathEntry,Boolean>() {
          public Boolean apply(final IClasspathEntry it) {
            IPath _path = it.getPath();
            IFolder _generateSrcFolder = JavaProjectPart.this.config.getGenerateSrcFolder();
            IPath _fullPath = _generateSrcFolder.getFullPath();
            boolean _equals = Objects.equal(_path, _fullPath);
            return Boolean.valueOf(_equals);
          }
        };
      boolean isAlreadJavaSoruceFolder = IterableExtensions.<IClasspathEntry>exists(((Iterable<IClasspathEntry>)Conversions.doWrapArray(_rawClasspath)), _function);
      boolean _not = (!isAlreadJavaSoruceFolder);
      if (_not) {
        IClasspathEntry[] _rawClasspath_1 = this.javaProject.getRawClasspath();
        ArrayList<IClasspathEntry> rawClasspathes = CollectionLiterals.<IClasspathEntry>newArrayList(_rawClasspath_1);
        IFolder _generateSrcFolder_1 = this.config.getGenerateSrcFolder();
        IPath _fullPath = _generateSrcFolder_1.getFullPath();
        IClasspathEntry _newSourceEntry = JavaCore.newSourceEntry(_fullPath);
        rawClasspathes.add(_newSourceEntry);
        final ArrayList<IClasspathEntry> _converted_rawClasspathes = (ArrayList<IClasspathEntry>)rawClasspathes;
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        this.javaProject.setRawClasspath(((IClasspathEntry[])Conversions.unwrapArray(_converted_rawClasspathes, IClasspathEntry.class)), _nullProgressMonitor);
      }
      IPluginModelBase model = PluginRegistry.findModel(this.project);
      IBuildModel _createBuildModel = PluginRegistry.createBuildModel(model);
      WorkspaceBuildModel buildModel = ((WorkspaceBuildModel) _createBuildModel);
      IBuild _build = buildModel.getBuild();
      IBuildEntry[] _buildEntries = _build.getBuildEntries();
      final Function1<IBuildEntry,Boolean> _function_1 = new Function1<IBuildEntry,Boolean>() {
          public Boolean apply(final IBuildEntry it) {
            String _name = it.getName();
            boolean _equals = Objects.equal(_name, "source..");
            return Boolean.valueOf(_equals);
          }
        };
      IBuildEntry entry = IterableExtensions.<IBuildEntry>findFirst(((Iterable<IBuildEntry>)Conversions.doWrapArray(_buildEntries)), _function_1);
      IFolder _generateSrcFolder_2 = this.config.getGenerateSrcFolder();
      IPath _projectRelativePath = _generateSrcFolder_2.getProjectRelativePath();
      String _portableString = _projectRelativePath.toPortableString();
      String srcPath = (_portableString + "/");
      boolean _contains = entry.contains(srcPath);
      boolean _not_1 = (!_contains);
      if (_not_1) {
        entry.addToken(srcPath);
        ((IEditableModel) buildModel).save();
      }
      buildModel.dispose();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

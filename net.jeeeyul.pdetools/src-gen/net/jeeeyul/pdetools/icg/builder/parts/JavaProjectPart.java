package net.jeeeyul.pdetools.icg.builder.parts;

import com.google.inject.Inject;
import java.util.ArrayList;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.shared.ResourceExtensions;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class JavaProjectPart {
  @Inject
  private ResourceExtensions _resourceExtensions;
  
  @Inject
  private ICGConfiguration config;
  
  @Inject
  private IJavaProject javaProject;
  
  /**
   * 결과 자바 소스가 생성될 소스폴더를 만들고, 자바 소스 폴더로 빌드 패스에 등록한다.
   * 이미 존재하고, 이미 등록되어 있으면 아무일도 하지 않는다.
   */
  public void ensureJavaSourceFolder() {
    try {
      IFolder _generateSrcFolder = this.config.getGenerateSrcFolder();
      this._resourceExtensions.ensureExist(_generateSrcFolder);
      IFolder _generateSrcFolder_1 = this.config.getGenerateSrcFolder();
      IPath _projectRelativePath = _generateSrcFolder_1.getProjectRelativePath();
      IJavaElement javaElement = this.javaProject.findElement(_projectRelativePath);
      boolean isAlreadJavaSoruceFolder = (javaElement instanceof IPackageFragmentRoot);
      boolean _not = (!isAlreadJavaSoruceFolder);
      if (_not) {
        IClasspathEntry[] _rawClasspath = this.javaProject.getRawClasspath();
        ArrayList<IClasspathEntry> rawClasspathes = CollectionLiterals.<IClasspathEntry>newArrayList(_rawClasspath);
        IFolder _generateSrcFolder_2 = this.config.getGenerateSrcFolder();
        IPath _fullPath = _generateSrcFolder_2.getFullPath();
        IClasspathEntry _newSourceEntry = JavaCore.newSourceEntry(_fullPath);
        rawClasspathes.add(_newSourceEntry);
        final ArrayList<IClasspathEntry> _converted_rawClasspathes = (ArrayList<IClasspathEntry>)rawClasspathes;
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        this.javaProject.setRawClasspath(((IClasspathEntry[])Conversions.unwrapArray(_converted_rawClasspathes, IClasspathEntry.class)), _nullProgressMonitor);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

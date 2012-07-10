package net.jeeeyul.pdetools.icg.builder;

import com.google.common.base.Objects;
import java.io.ByteArrayInputStream;
import net.jeeeyul.pdetools.icg.builder.ImageCosntantGenerator;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import net.jeeeyul.pdetools.shared.ResourceExtensions;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class Building {
  private int kind;
  
  private ResourceExtensions _resourceExtensions = new Function0<ResourceExtensions>() {
    public ResourceExtensions apply() {
      ResourceExtensions _resourceExtensions = new ResourceExtensions();
      return _resourceExtensions;
    }
  }.apply();
  
  private IncrementalProjectBuilder builder;
  
  private ICGConfiguration _config;
  
  public Building(final IncrementalProjectBuilder builder, final int kind) {
    this.builder = builder;
    this.kind = kind;
  }
  
  public IProject[] build(final IProgressMonitor monitor) {
    try {
      boolean _hasToBuild = this.hasToBuild();
      boolean _not = (!_hasToBuild);
      if (_not) {
        return ((IProject[])Conversions.unwrapArray(CollectionLiterals.<IProject>emptyList(), IProject.class));
      }
      ICGConfiguration _config = this.getConfig();
      IFile _ouputFile = _config.getOuputFile();
      IContainer _parent = _ouputFile.getParent();
      this._resourceExtensions.ensureExist(_parent);
      ICGConfiguration _config_1 = this.getConfig();
      PaletteModelGenerator _paletteModelGenerator = new PaletteModelGenerator(_config_1);
      PaletteModelGenerator pmg = _paletteModelGenerator;
      ICGConfiguration _config_2 = this.getConfig();
      IFolder _monitoringFolder = _config_2.getMonitoringFolder();
      Palette paletteModel = pmg.generatePalette(_monitoringFolder);
      ImageCosntantGenerator _imageCosntantGenerator = new ImageCosntantGenerator();
      ImageCosntantGenerator generator = _imageCosntantGenerator;
      ICGConfiguration _config_3 = this.getConfig();
      generator.setConfig(_config_3);
      generator.setRootPalette(paletteModel);
      ICGConfiguration _config_4 = this.getConfig();
      IFile _ouputFile_1 = _config_4.getOuputFile();
      boolean _exists = _ouputFile_1.exists();
      if (_exists) {
        ICGConfiguration _config_5 = this.getConfig();
        IFile _ouputFile_2 = _config_5.getOuputFile();
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _ouputFile_2.delete(true, _nullProgressMonitor);
      }
      CharSequence _generate = generator.generate();
      String _string = _generate.toString();
      byte[] _bytes = _string.getBytes();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
      ByteArrayInputStream stream = _byteArrayInputStream;
      ICGConfiguration _config_6 = this.getConfig();
      IFile _ouputFile_3 = _config_6.getOuputFile();
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      _ouputFile_3.create(stream, true, _nullProgressMonitor_1);
      stream.close();
      IProject _project = this.builder.getProject();
      return ((IProject[])Conversions.unwrapArray(CollectionLiterals.<IProject>newArrayList(_project), IProject.class));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ICGConfiguration getConfig() {
    boolean _equals = Objects.equal(this._config, null);
    if (_equals) {
      IProject _project = this.builder.getProject();
      ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
      this._config = _iCGConfiguration;
    }
    return this._config;
  }
  
  public boolean hasToBuild() {
    boolean _or = false;
    boolean _equals = (this.kind == IncrementalProjectBuilder.CLEAN_BUILD);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = (this.kind == IncrementalProjectBuilder.FULL_BUILD);
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
    ICGConfiguration _config = this.getConfig();
    IFolder monitoringFolder = _config.getMonitoringFolder();
    boolean _equals_3 = Objects.equal(monitoringFolder, null);
    if (_equals_3) {
      return false;
    }
    boolean _exists = monitoringFolder.exists();
    boolean _not = (!_exists);
    if (_not) {
      return false;
    }
    ICGConfiguration _config_1 = this.getConfig();
    IFolder _monitoringFolder = _config_1.getMonitoringFolder();
    IPath _projectRelativePath = _monitoringFolder.getProjectRelativePath();
    IResourceDelta monitoredDelta = projectDelta.findMember(_projectRelativePath);
    boolean _equals_4 = Objects.equal(monitoredDelta, null);
    if (_equals_4) {
      return false;
    }
    return true;
  }
}

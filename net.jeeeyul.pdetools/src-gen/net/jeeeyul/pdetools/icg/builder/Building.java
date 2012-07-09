package net.jeeeyul.pdetools.icg.builder;

import com.google.common.base.Objects;
import net.jeeeyul.pdetools.icg.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.ImageCosntantGenerator;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Building {
  private int kind;
  
  private IncrementalProjectBuilder builder;
  
  private ICGConfiguration _config;
  
  public Building(final IncrementalProjectBuilder builder, final int kind) {
    this.builder = builder;
    this.kind = kind;
  }
  
  public IProject[] build(final IProgressMonitor monitor) {
    ICGConfiguration _config = this.getConfig();
    PaletteModelGenerator _paletteModelGenerator = new PaletteModelGenerator(_config);
    PaletteModelGenerator pmg = _paletteModelGenerator;
    ICGConfiguration _config_1 = this.getConfig();
    IFolder _monitoringFolder = _config_1.getMonitoringFolder();
    Palette paletteModel = pmg.generatePalette(_monitoringFolder);
    ImageCosntantGenerator _imageCosntantGenerator = new ImageCosntantGenerator();
    ImageCosntantGenerator generator = _imageCosntantGenerator;
    ICGConfiguration _config_2 = this.getConfig();
    generator.setConfig(_config_2);
    generator.setRootPalette(paletteModel);
    CharSequence _generate = generator.generate();
    InputOutput.<CharSequence>println(_generate);
    return ((IProject[])Conversions.unwrapArray(CollectionLiterals.<IProject>emptyList(), IProject.class));
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
    boolean _exists = monitoringFolder.exists();
    boolean _not = (!_exists);
    if (_not) {
      return false;
    }
    ICGConfiguration _config_1 = this.getConfig();
    IFolder _monitoringFolder = _config_1.getMonitoringFolder();
    IPath _fullPath = _monitoringFolder.getFullPath();
    IResourceDelta monitoredDelta = projectDelta.findMember(_fullPath);
    boolean _equals_3 = Objects.equal(monitoredDelta, null);
    if (_equals_3) {
      return false;
    }
    return true;
  }
}

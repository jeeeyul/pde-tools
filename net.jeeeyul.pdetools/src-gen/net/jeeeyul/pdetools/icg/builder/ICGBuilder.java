package net.jeeeyul.pdetools.icg.builder;

import java.util.ArrayList;
import java.util.Map;
import net.jeeeyul.pdetools.icg.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.ImageCosntantGenerator;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator;
import net.jeeeyul.pdetools.icg.model.imageResource.Palette;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class ICGBuilder extends IncrementalProjectBuilder {
  public ICGBuilder() {
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
    ICGConfiguration cfg = _iCGConfiguration;
    IFolder _monitoringFolder = cfg.getMonitoringFolder();
    boolean _exists = _monitoringFolder.exists();
    if (_exists) {
      PaletteModelGenerator _paletteModelGenerator = new PaletteModelGenerator(cfg);
      PaletteModelGenerator mg = _paletteModelGenerator;
      IFolder _monitoringFolder_1 = cfg.getMonitoringFolder();
      Palette palette = mg.generatePalette(_monitoringFolder_1);
      ImageCosntantGenerator _imageCosntantGenerator = new ImageCosntantGenerator();
      ImageCosntantGenerator generator = _imageCosntantGenerator;
      generator.setRootPalette(palette);
      generator.setConfig(cfg);
      CharSequence _generate = generator.generate();
      InputOutput.<CharSequence>println(_generate);
    }
    ArrayList<IProject> _arrayList = new ArrayList<IProject>();
    return ((IProject[])Conversions.unwrapArray(_arrayList, IProject.class));
  }
  
  public Object hasToBuild() {
    return null;
  }
}

package net.jeeeyul.pdetools.icg.builder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import net.jeeeyul.pdetools.icg.builder.parts.ErrorPart;
import net.jeeeyul.pdetools.icg.builder.parts.ImageCosntantGenerator;
import net.jeeeyul.pdetools.icg.builder.parts.JavaProjectPart;
import net.jeeeyul.pdetools.icg.builder.parts.ResourceDeltaPart;
import net.jeeeyul.pdetools.icg.builder.parts.ValidationPart;
import net.jeeeyul.pdetools.shared.ResourceExtensions;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class Building {
  private ResourceExtensions _resourceExtensions = new Function0<ResourceExtensions>() {
    public ResourceExtensions apply() {
      ResourceExtensions _resourceExtensions = new ResourceExtensions();
      return _resourceExtensions;
    }
  }.apply();
  
  @Inject
  private ValidationPart _validationPart;
  
  @Inject
  private IncrementalProjectBuilder builder;
  
  @Inject
  private ErrorPart _errorPart;
  
  @Inject
  private ResourceDeltaPart _resourceDeltaPart;
  
  @Inject
  private ImageCosntantGenerator _imageCosntantGenerator;
  
  @Inject
  private ICGConfiguration config;
  
  @Inject
  private JavaProjectPart _javaProjectPart;
  
  public IProject[] build(final IProgressMonitor monitor) {
    try {
      this._validationPart.validate();
      this._errorPart.cleanMarkers();
      this._errorPart.generateMarkers();
      boolean _or = false;
      boolean _canBuild = this._errorPart.canBuild();
      boolean _not = (!_canBuild);
      if (_not) {
        _or = true;
      } else {
        boolean _hasResourceDelta = this._resourceDeltaPart.hasResourceDelta();
        boolean _not_1 = (!_hasResourceDelta);
        _or = (_not || _not_1);
      }
      if (_or) {
        return ((IProject[])Conversions.unwrapArray(CollectionLiterals.<IProject>emptyList(), IProject.class));
      }
      this._javaProjectPart.ensureJavaSourceFolder();
      PaletteModelGenerator _paletteModelGenerator = new PaletteModelGenerator(this.config);
      PaletteModelGenerator pmg = _paletteModelGenerator;
      IFolder _monitoringFolder = this.config.getMonitoringFolder();
      Palette paletteModel = pmg.generatePalette(_monitoringFolder);
      IFile _ouputFile = this.config.getOuputFile();
      boolean _exists = _ouputFile.exists();
      if (_exists) {
        IFile _ouputFile_1 = this.config.getOuputFile();
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _ouputFile_1.delete(true, _nullProgressMonitor);
      }
      XMLResourceImpl _xMLResourceImpl = new XMLResourceImpl();
      XMLResourceImpl serializer = _xMLResourceImpl;
      EList<EObject> _contents = serializer.getContents();
      Palette _copy = EcoreUtil.<Palette>copy(paletteModel);
      _contents.add(_copy);
      HashMap<Object,Object> _hashMap = new HashMap<Object,Object>();
      serializer.save(System.out, _hashMap);
      CharSequence _generateJavaSource = this._imageCosntantGenerator.generateJavaSource(paletteModel);
      String _string = _generateJavaSource.toString();
      byte[] _bytes = _string.getBytes();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
      ByteArrayInputStream stream = _byteArrayInputStream;
      IFile _ouputFile_2 = this.config.getOuputFile();
      IContainer _parent = _ouputFile_2.getParent();
      this._resourceExtensions.ensureExist(_parent);
      IFile _ouputFile_3 = this.config.getOuputFile();
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      _ouputFile_3.create(stream, true, _nullProgressMonitor_1);
      stream.close();
      IFile _ouputFile_4 = this.config.getOuputFile();
      boolean _isMarkDerived = this.config.isMarkDerived();
      _ouputFile_4.setDerived(_isMarkDerived);
      IProject _project = this.builder.getProject();
      return ((IProject[])Conversions.unwrapArray(CollectionLiterals.<IProject>newArrayList(_project), IProject.class));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isNullOrBlank(final String src) {
    boolean _equals = Objects.equal(src, null);
    if (_equals) {
      return true;
    } else {
      String _trim = src.trim();
      return _trim.isEmpty();
    }
  }
}

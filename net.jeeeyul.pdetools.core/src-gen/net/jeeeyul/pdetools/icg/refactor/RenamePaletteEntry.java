package net.jeeeyul.pdetools.icg.refactor;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.model.PaletteDelta;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelDeltaGenerator;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator;
import net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner;
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import net.jeeeyul.pdetools.icg.refactor.JavaRefactor;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.jdt.core.refactoring.descriptors.RenameJavaElementDescriptor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.osgi.framework.Bundle;

@SuppressWarnings("all")
public class RenamePaletteEntry extends RenameParticipant {
  private ICGConfiguration config;
  
  private IResource resource;
  
  private List<Change> result;
  
  public RenamePaletteEntry() {
  }
  
  public RefactoringStatus checkConditions(final IProgressMonitor pm, final CheckConditionsContext context) throws OperationCanceledException {
    return null;
  }
  
  public Change createChange(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    int workAmount = 10000;
    pm.beginTask("Update Shared Image References", workAmount);
    ArrayList<Change> _newArrayList = CollectionLiterals.<Change>newArrayList();
    this.result = _newArrayList;
    Palette palette = this.loadPreviousPaletteModel();
    Palette newPalette = this.createNewPaletteModel();
    PaletteModelDeltaGenerator _paletteModelDeltaGenerator = new PaletteModelDeltaGenerator();
    PaletteModelDeltaGenerator deltaGenerator = _paletteModelDeltaGenerator;
    List<PaletteDelta> diffs = deltaGenerator.compare(palette, newPalette);
    int _xifexpression = (int) 0;
    int _size = diffs.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      int _size_1 = diffs.size();
      int _divide = (workAmount / _size_1);
      _xifexpression = _divide;
    } else {
      _xifexpression = 1;
    }
    int eachWork = _xifexpression;
    for (final PaletteDelta eachDelta : diffs) {
      boolean _isRefactorTarget = eachDelta.isRefactorTarget();
      if (_isRefactorTarget) {
        try {
          FieldNameOwner _before = eachDelta.getBefore();
          IResource _resource = this.getResource(_before);
          IProject _project = _resource.getProject();
          JavaRefactor _javaRefactor = new JavaRefactor(_project);
          JavaRefactor javaRefactor = _javaRefactor;
          RenameJavaElementDescriptor desc = javaRefactor.createDescriptor(eachDelta);
          RefactoringStatus _createFatalErrorStatus = RefactoringStatus.createFatalErrorStatus("Error");
          Refactoring refactor = desc.createRefactoring(_createFatalErrorStatus);
          int _divide_1 = (eachWork / 2);
          SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(pm, _divide_1);
          RefactoringStatus status = refactor.checkAllConditions(_subProgressMonitor);
          boolean _hasFatalError = status.hasFatalError();
          boolean _not = (!_hasFatalError);
          if (_not) {
            int _divide_2 = (eachWork / 2);
            SubProgressMonitor _subProgressMonitor_1 = new SubProgressMonitor(pm, _divide_2);
            Change change = refactor.createChange(_subProgressMonitor_1);
            this.result.add(change);
          } else {
            int _divide_3 = (eachWork / 2);
            pm.worked(_divide_3);
          }
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            e.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    pm.done();
    boolean _isEmpty = this.result.isEmpty();
    boolean _not_1 = (!_isEmpty);
    if (_not_1) {
      CompositeChange _compositeChange = new CompositeChange("Update Shared Image Java Referernces", ((Change[])Conversions.unwrapArray(this.result, Change.class)));
      return _compositeChange;
    }
    return null;
  }
  
  public String getName() {
    return "Update Shared Image References";
  }
  
  protected boolean initialize(final Object element) {
    IAdapterManager _adapterManager = Platform.getAdapterManager();
    Object _adapter = _adapterManager.getAdapter(element, IResource.class);
    this.resource = ((IResource) _adapter);
    IProject _project = this.resource.getProject();
    ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
    this.config = _iCGConfiguration;
    IFolder _monitoringFolder = this.config.getMonitoringFolder();
    IPath _fullPath = _monitoringFolder.getFullPath();
    IPath _fullPath_1 = this.resource.getFullPath();
    boolean _isPrefixOf = _fullPath.isPrefixOf(_fullPath_1);
    boolean _not = (!_isPrefixOf);
    if (_not) {
      return false;
    }
    return true;
  }
  
  public Palette loadPreviousPaletteModel() {
    Palette _xtrycatchfinallyexpression = null;
    try {
      Palette _xblockexpression = null;
      {
        IProject _project = this.resource.getProject();
        IPath _fullPath = _project.getFullPath();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(".settings/");
        PDEToolsCore _default = PDEToolsCore.getDefault();
        Bundle _bundle = _default.getBundle();
        String _symbolicName = _bundle.getSymbolicName();
        _builder.append(_symbolicName, "");
        _builder.append(".palette.xml");
        IPath _append = _fullPath.append(_builder.toString());
        String _portableString = _append.toPortableString();
        URI uri = URI.createPlatformResourceURI(_portableString, true);
        XMLResourceImpl _xMLResourceImpl = new XMLResourceImpl(uri);
        XMLResourceImpl resource = _xMLResourceImpl;
        HashMap<Object,Object> _hashMap = new HashMap<Object,Object>();
        resource.load(_hashMap);
        EList<EObject> _contents = resource.getContents();
        EObject _get = _contents.get(0);
        _xblockexpression = (((Palette) _get));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        e.printStackTrace();
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public Palette createNewPaletteModel() {
    Palette _xblockexpression = null;
    {
      PaletteModelGenerator _paletteModelGenerator = new PaletteModelGenerator(this.config);
      PaletteModelGenerator generator = _paletteModelGenerator;
      final Function1<IResource,String> _function = new Function1<IResource,String>() {
          public String apply(final IResource it) {
            String _xifexpression = null;
            boolean _equals = Objects.equal(it, RenamePaletteEntry.this.resource);
            if (_equals) {
              RenameArguments _arguments = RenamePaletteEntry.this.getArguments();
              String _newName = _arguments.getNewName();
              Path _path = new Path(_newName);
              IPath _removeFileExtension = _path.removeFileExtension();
              String _lastSegment = _removeFileExtension.lastSegment();
              _xifexpression = _lastSegment;
            }
            return _xifexpression;
          }
        };
      generator.setNameProvider(_function);
      Palette _generate = generator.generate();
      _xblockexpression = (_generate);
    }
    return _xblockexpression;
  }
  
  protected IResource _getResource(final FieldNameOwner obj) {
    return null;
  }
  
  protected IResource _getResource(final Palette palette) {
    IFolder _folder = palette.getFolder();
    return _folder;
  }
  
  protected IResource _getResource(final ImageFile file) {
    IFile _file = file.getFile();
    return _file;
  }
  
  public IResource getResource(final FieldNameOwner file) {
    if (file instanceof ImageFile) {
      return _getResource((ImageFile)file);
    } else if (file instanceof Palette) {
      return _getResource((Palette)file);
    } else if (file != null) {
      return _getResource(file);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(file).toString());
    }
  }
}

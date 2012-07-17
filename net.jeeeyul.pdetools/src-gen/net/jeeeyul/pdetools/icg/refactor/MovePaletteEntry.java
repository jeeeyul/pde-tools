package net.jeeeyul.pdetools.icg.refactor;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import net.jeeeyul.pdetools.Activator;
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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
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
import org.eclipse.ltk.core.refactoring.participants.MoveArguments;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osgi.framework.Bundle;

@SuppressWarnings("all")
public class MovePaletteEntry extends MoveParticipant {
  private ICGConfiguration config;
  
  private IResource resource;
  
  private List<Change> result;
  
  public RefactoringStatus checkConditions(final IProgressMonitor pm, final CheckConditionsContext context) throws OperationCanceledException {
    return null;
  }
  
  public Change createChange(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    ArrayList<Change> _newArrayList = CollectionLiterals.<Change>newArrayList();
    this.result = _newArrayList;
    Palette palette = this.loadPreviousPaletteModel();
    Palette newPalette = this.createNewPaletteModel();
    PaletteModelDeltaGenerator _paletteModelDeltaGenerator = new PaletteModelDeltaGenerator();
    PaletteModelDeltaGenerator deltaGenerator = _paletteModelDeltaGenerator;
    List<PaletteDelta> diffs = deltaGenerator.compare(palette, newPalette);
    int _size = diffs.size();
    InputOutput.<Integer>println(Integer.valueOf(_size));
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
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          RefactoringStatus status = refactor.checkAllConditions(_nullProgressMonitor);
          boolean _hasFatalError = status.hasFatalError();
          boolean _not = (!_hasFatalError);
          if (_not) {
            NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
            Change change = refactor.createChange(_nullProgressMonitor_1);
            this.result.add(change);
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
    boolean _isEmpty = this.result.isEmpty();
    boolean _not_1 = (!_isEmpty);
    if (_not_1) {
      CompositeChange _compositeChange = new CompositeChange("Update Shared Image Java Referernces", ((Change[])Conversions.unwrapArray(this.result, Change.class)));
      return _compositeChange;
    }
    return null;
  }
  
  public String getName() {
    return null;
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
        Activator _default = Activator.getDefault();
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
      MoveArguments _arguments = this.getArguments();
      Object _destination = _arguments.getDestination();
      String _string = _destination.toString();
      Path _path = new Path(_string);
      final IPath destination = _path.removeFirstSegments(1);
      InputOutput.<IPath>println(destination);
      final Function1<IFolder,IResource[]> _function = new Function1<IFolder,IResource[]>() {
          public IResource[] apply(final IFolder it) {
            try {
              IPath _fullPath = it.getFullPath();
              InputOutput.<IPath>println(_fullPath);
              IResource[] _members = it.members();
              boolean _contains = ((List<IResource>)Conversions.doWrapArray(_members)).contains(MovePaletteEntry.this.resource);
              if (_contains) {
                IResource[] _members_1 = it.members();
                List<IResource> _list = IterableExtensions.<IResource>toList(((Iterable<? extends IResource>)Conversions.doWrapArray(_members_1)));
                ArrayList<IResource> _arrayList = new ArrayList<IResource>(_list);
                ArrayList<IResource> result = _arrayList;
                result.remove(MovePaletteEntry.this.resource);
                return ((IResource[])Conversions.unwrapArray(result, IResource.class));
              } else {
                IPath _fullPath_1 = it.getFullPath();
                boolean _equals = Objects.equal(_fullPath_1, destination);
                if (_equals) {
                  IResource[] _members_2 = it.members();
                  List<IResource> _list_1 = IterableExtensions.<IResource>toList(((Iterable<? extends IResource>)Conversions.doWrapArray(_members_2)));
                  ArrayList<IResource> _arrayList_1 = new ArrayList<IResource>(_list_1);
                  ArrayList<IResource> result_1 = _arrayList_1;
                  result_1.add(MovePaletteEntry.this.resource);
                  return ((IResource[])Conversions.unwrapArray(result_1, IResource.class));
                } else {
                  try {
                    return it.members();
                  } catch (Exception _e) {
                    throw Exceptions.sneakyThrow(_e);
                  }
                }
              }
            } catch (Exception _e_1) {
              throw Exceptions.sneakyThrow(_e_1);
            }
          }
        };
      generator.setContentProvider(_function);
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

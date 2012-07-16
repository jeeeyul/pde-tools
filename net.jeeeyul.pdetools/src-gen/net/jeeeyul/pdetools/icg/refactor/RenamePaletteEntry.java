package net.jeeeyul.pdetools.icg.refactor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.jeeeyul.pdetools.Activator;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.model.PaletteDelta;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelDeltaGenerator;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator;
import net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner;
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import net.jeeeyul.pdetools.icg.refactor.JavaVisitor;
import net.jeeeyul.pdetools.icg.refactor.SearchMatcher;
import net.jeeeyul.pdetools.icg.refactor.TargetFieldFinder;
import net.jeeeyul.pdetools.icg.refactor.TargetInterfaceFinder;
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
    ArrayList<Change> _newArrayList = CollectionLiterals.<Change>newArrayList();
    this.result = _newArrayList;
    Palette palette = this.loadPreviousPaletteModel();
    Palette newPalette = this.createNewPaletteModel();
    PaletteModelDeltaGenerator _paletteModelDeltaGenerator = new PaletteModelDeltaGenerator();
    PaletteModelDeltaGenerator deltaGenerator = _paletteModelDeltaGenerator;
    List<PaletteDelta> diffs = deltaGenerator.compare(palette, newPalette);
    for (final PaletteDelta eachDelta : diffs) {
      {
        TreeIterator<EObject> _eAllContents = palette.eAllContents();
        Iterator<FieldNameOwner> _filter = Iterators.<FieldNameOwner>filter(_eAllContents, FieldNameOwner.class);
        final Function1<FieldNameOwner,Boolean> _function = new Function1<FieldNameOwner,Boolean>() {
            public Boolean apply(final FieldNameOwner it) {
              IResource _resource = RenamePaletteEntry.this.getResource(it);
              FieldNameOwner _before = eachDelta.getBefore();
              IResource _resource_1 = RenamePaletteEntry.this.getResource(_before);
              boolean _equals = Objects.equal(_resource, _resource_1);
              return Boolean.valueOf(_equals);
            }
          };
        FieldNameOwner target = IteratorExtensions.<FieldNameOwner>findFirst(_filter, _function);
        IFile _ouputFile = this.config.getOuputFile();
        IJavaElement _create = JavaCore.create(_ouputFile);
        final ICompilationUnit cu = ((ICompilationUnit) _create);
        JavaVisitor<IJavaElement> visitor = null;
        FieldNameOwner _before = eachDelta.getBefore();
        IResource _resource = this.getResource(_before);
        if ((_resource instanceof IFile)) {
          IResource _resource_1 = this.getResource(target);
          IPath _projectRelativePath = _resource_1.getProjectRelativePath();
          String _portableString = _projectRelativePath.toPortableString();
          TargetFieldFinder _targetFieldFinder = new TargetFieldFinder(_portableString);
          visitor = _targetFieldFinder;
        } else {
          FieldNameOwner _before_1 = eachDelta.getBefore();
          String _qualifiedName = this.qualifiedName(((Palette) _before_1));
          TargetInterfaceFinder _targetInterfaceFinder = new TargetInterfaceFinder(_qualifiedName);
          visitor = _targetInterfaceFinder;
        }
        visitor.visit(cu);
        IJavaElement _result = visitor.getResult();
        boolean _notEquals = (!Objects.equal(_result, null));
        if (_notEquals) {
          IJavaElement _result_1 = visitor.getResult();
          SearchPattern pattern = SearchPattern.createPattern(_result_1, IJavaSearchConstants.READ_ACCESSES);
          IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
          SearchParticipant _defaultSearchParticipant = SearchEngine.getDefaultSearchParticipant();
          List<SearchParticipant> participants = CollectionLiterals.<SearchParticipant>newArrayList(_defaultSearchParticipant);
          SearchMatcher _searchMatcher = new SearchMatcher();
          SearchMatcher mather = _searchMatcher;
          final Procedure1<SearchMatch> _function_1 = new Procedure1<SearchMatch>() {
              public void apply(final SearchMatch it) {
                final SearchMatch match = it;
                IResource _resource = it.getResource();
                IFile file = ((IFile) _resource);
                TextFileChange change = RenamePaletteEntry.this.newTextFilecChange(file);
                int _offset = match.getOffset();
                int _length = match.getLength();
                FieldNameOwner _after = eachDelta.getAfter();
                IJavaElement _create = JavaCore.create(file);
                String _updatedReference = RenamePaletteEntry.this.getUpdatedReference(_after, ((ICompilationUnit) _create));
                ReplaceEdit _replaceEdit = new ReplaceEdit(_offset, _length, _updatedReference);
                change.addEdit(_replaceEdit);
              }
            };
          mather.handler = _function_1;
          SearchEngine _searchEngine = new SearchEngine();
          final List<SearchParticipant> _converted_participants = (List<SearchParticipant>)participants;
          _searchEngine.search(pattern, ((SearchParticipant[])Conversions.unwrapArray(_converted_participants, SearchParticipant.class)), scope, mather, pm);
        }
      }
    }
    boolean _isEmpty = this.result.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      CompositeChange _compositeChange = new CompositeChange("\uC544\uC624 \uC528\uBC14", ((Change[])Conversions.unwrapArray(this.result, Change.class)));
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
  
  public TextFileChange newTextFilecChange(final IFile file) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(file);
    final TextFileChange _result;
    synchronized (_createCache_newTextFilecChange) {
      if (_createCache_newTextFilecChange.containsKey(_cacheKey)) {
        return _createCache_newTextFilecChange.get(_cacheKey);
      }
      TextFileChange _textFileChange = new TextFileChange("\uC54C\uAC70 \uC5C6\uB2E4", file);
      _result = _textFileChange;
      _createCache_newTextFilecChange.put(_cacheKey, _result);
    }
    _init_newTextFilecChange(_result, file);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,TextFileChange> _createCache_newTextFilecChange = CollectionLiterals.newHashMap();
  
  private void _init_newTextFilecChange(final TextFileChange it, final IFile file) {
    MultiTextEdit _multiTextEdit = new MultiTextEdit();
    it.setEdit(_multiTextEdit);
    this.result.add(it);
  }
  
  public String qualifiedName(final Palette owner) {
    List<String> segments = CollectionLiterals.<String>newArrayList();
    String _fieldName = owner.getFieldName();
    segments.add(_fieldName);
    Palette parent = owner.getParent();
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(parent, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      String _fieldName_1 = parent.getFieldName();
      boolean _notEquals_1 = (!Objects.equal(_fieldName_1, null));
      _and_1 = (_notEquals && _notEquals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      Palette _parent = parent.getParent();
      boolean _notEquals_2 = (!Objects.equal(_parent, null));
      _and = (_and_1 && _notEquals_2);
    }
    boolean _while = _and;
    while (_while) {
      {
        String _fieldName_2 = parent.getFieldName();
        segments.add(_fieldName_2);
        Palette _parent_1 = parent.getParent();
        parent = _parent_1;
      }
      boolean _and_2 = false;
      boolean _and_3 = false;
      boolean _notEquals_3 = (!Objects.equal(parent, null));
      if (!_notEquals_3) {
        _and_3 = false;
      } else {
        String _fieldName_2 = parent.getFieldName();
        boolean _notEquals_4 = (!Objects.equal(_fieldName_2, null));
        _and_3 = (_notEquals_3 && _notEquals_4);
      }
      if (!_and_3) {
        _and_2 = false;
      } else {
        Palette _parent_1 = parent.getParent();
        boolean _notEquals_5 = (!Objects.equal(_parent_1, null));
        _and_2 = (_and_3 && _notEquals_5);
      }
      _while = _and_2;
    }
    StringConcatenation _builder = new StringConcatenation();
    String _generatePackageName = this.config.getGeneratePackageName();
    _builder.append(_generatePackageName, "");
    _builder.append(".");
    String _generateClassName = this.config.getGenerateClassName();
    _builder.append(_generateClassName, "");
    _builder.append("$");
    List<String> _reverse = ListExtensions.<String>reverse(segments);
    String _join = IterableExtensions.join(_reverse, "$");
    _builder.append(_join, "");
    return _builder.toString();
  }
  
  public String qualifiedNameForUpdate(final Palette owner) {
    List<String> segments = CollectionLiterals.<String>newArrayList();
    String _fieldName = owner.getFieldName();
    segments.add(_fieldName);
    Palette parent = owner.getParent();
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(parent, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      String _fieldName_1 = parent.getFieldName();
      boolean _notEquals_1 = (!Objects.equal(_fieldName_1, null));
      _and_1 = (_notEquals && _notEquals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      Palette _parent = parent.getParent();
      boolean _notEquals_2 = (!Objects.equal(_parent, null));
      _and = (_and_1 && _notEquals_2);
    }
    boolean _while = _and;
    while (_while) {
      {
        String _fieldName_2 = parent.getFieldName();
        segments.add(_fieldName_2);
        Palette _parent_1 = parent.getParent();
        parent = _parent_1;
      }
      boolean _and_2 = false;
      boolean _and_3 = false;
      boolean _notEquals_3 = (!Objects.equal(parent, null));
      if (!_notEquals_3) {
        _and_3 = false;
      } else {
        String _fieldName_2 = parent.getFieldName();
        boolean _notEquals_4 = (!Objects.equal(_fieldName_2, null));
        _and_3 = (_notEquals_3 && _notEquals_4);
      }
      if (!_and_3) {
        _and_2 = false;
      } else {
        Palette _parent_1 = parent.getParent();
        boolean _notEquals_5 = (!Objects.equal(_parent_1, null));
        _and_2 = (_and_3 && _notEquals_5);
      }
      _while = _and_2;
    }
    StringConcatenation _builder = new StringConcatenation();
    String _generateClassName = this.config.getGenerateClassName();
    _builder.append(_generateClassName, "");
    _builder.append(".");
    List<String> _reverse = ListExtensions.<String>reverse(segments);
    String _join = IterableExtensions.join(_reverse, ".");
    _builder.append(_join, "");
    return _builder.toString();
  }
  
  public Palette parent(final FieldNameOwner owner) {
    Palette _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (owner instanceof Palette) {
        final Palette _palette = (Palette)owner;
        _matched=true;
        return _palette.getParent();
      }
    }
    if (!_matched) {
      if (owner instanceof ImageFile) {
        final ImageFile _imageFile = (ImageFile)owner;
        _matched=true;
        return _imageFile.getParent();
      }
    }
    return _switchResult;
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
  
  protected String _getUpdatedReference(final FieldNameOwner obj, final ICompilationUnit cu) {
    return null;
  }
  
  protected String _getUpdatedReference(final Palette palette, final ICompilationUnit cu) {
    try {
      String result = this.qualifiedNameForUpdate(palette);
      StringConcatenation _builder = new StringConcatenation();
      String _generatePackageName = this.config.getGeneratePackageName();
      _builder.append(_generatePackageName, "");
      _builder.append(".");
      String _generateClassName = this.config.getGenerateClassName();
      _builder.append(_generateClassName, "");
      final String fullyQualifiedName = _builder.toString();
      IImportDeclaration[] _imports = cu.getImports();
      final Function1<IImportDeclaration,Boolean> _function = new Function1<IImportDeclaration,Boolean>() {
          public Boolean apply(final IImportDeclaration it) {
            boolean _or = false;
            String _elementName = it.getElementName();
            boolean _equals = Objects.equal(_elementName, fullyQualifiedName);
            if (_equals) {
              _or = true;
            } else {
              String _elementName_1 = it.getElementName();
              String _generatePackageName = RenamePaletteEntry.this.config.getGeneratePackageName();
              String _plus = (_generatePackageName + ".*");
              boolean _equals_1 = Objects.equal(_elementName_1, _plus);
              _or = (_equals || _equals_1);
            }
            return Boolean.valueOf(_or);
          }
        };
      boolean imported = IterableExtensions.<IImportDeclaration>exists(((Iterable<IImportDeclaration>)Conversions.doWrapArray(_imports)), _function);
      IImportDeclaration[] _imports_1 = cu.getImports();
      final Procedure1<IImportDeclaration> _function_1 = new Procedure1<IImportDeclaration>() {
          public void apply(final IImportDeclaration it) {
            String _elementName = it.getElementName();
            InputOutput.<String>println(_elementName);
          }
        };
      IterableExtensions.<IImportDeclaration>forEach(((Iterable<IImportDeclaration>)Conversions.doWrapArray(_imports_1)), _function_1);
      boolean _not = (!imported);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _generatePackageName_1 = this.config.getGeneratePackageName();
        _builder_1.append(_generatePackageName_1, "");
        _builder_1.append(".");
        _builder_1.append(result, "");
        result = _builder_1.toString();
      }
      return result;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String _getUpdatedReference(final ImageFile file, final ICompilationUnit cu) {
    String _fieldName = file.getFieldName();
    return _fieldName;
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
  
  public String getUpdatedReference(final FieldNameOwner file, final ICompilationUnit cu) {
    if (file instanceof ImageFile) {
      return _getUpdatedReference((ImageFile)file, cu);
    } else if (file instanceof Palette) {
      return _getUpdatedReference((Palette)file, cu);
    } else if (file != null) {
      return _getUpdatedReference(file, cu);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(file, cu).toString());
    }
  }
}

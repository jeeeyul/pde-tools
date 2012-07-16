package net.jeeeyul.pdetools.icg.refactor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.jeeeyul.pdetools.Activator;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.model.PaletteDelta;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelDeltaGenerator;
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator;
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import net.jeeeyul.pdetools.icg.refactor.SearchMatcher;
import net.jeeeyul.pdetools.icg.refactor.TargetFieldFinder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
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
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osgi.framework.Bundle;

@SuppressWarnings("all")
public class RenamePaletteEntry extends RenameParticipant {
  private ICGConfiguration config;
  
  private IFile file;
  
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
        Iterator<ImageFile> _filter = Iterators.<ImageFile>filter(_eAllContents, ImageFile.class);
        final Function1<ImageFile,Boolean> _function = new Function1<ImageFile,Boolean>() {
            public Boolean apply(final ImageFile it) {
              IFile _file = it.getFile();
              ImageFile _before = eachDelta.getBefore();
              IFile _file_1 = _before.getFile();
              boolean _equals = Objects.equal(_file, _file_1);
              return Boolean.valueOf(_equals);
            }
          };
        ImageFile target = IteratorExtensions.<ImageFile>findFirst(_filter, _function);
        IFile _ouputFile = this.config.getOuputFile();
        IJavaElement _create = JavaCore.create(_ouputFile);
        ICompilationUnit cu = ((ICompilationUnit) _create);
        IFile _file = target.getFile();
        IPath _projectRelativePath = _file.getProjectRelativePath();
        String _portableString = _projectRelativePath.toPortableString();
        TargetFieldFinder _targetFieldFinder = new TargetFieldFinder(_portableString);
        TargetFieldFinder visitor = _targetFieldFinder;
        visitor.visit(cu);
        IField _result = visitor.getResult();
        boolean _notEquals = (!Objects.equal(_result, null));
        if (_notEquals) {
          InputOutput.<String>println("\uD544\uB4DC \uCC3E\uC74C");
          IField _result_1 = visitor.getResult();
          SearchPattern pattern = SearchPattern.createPattern(_result_1, IJavaSearchConstants.REFERENCES);
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
                ImageFile _after = eachDelta.getAfter();
                String _fieldName = _after.getFieldName();
                ReplaceEdit _replaceEdit = new ReplaceEdit(_offset, _length, _fieldName);
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
    this.file = ((IFile) element);
    IProject _project = this.file.getProject();
    ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
    this.config = _iCGConfiguration;
    IFolder _monitoringFolder = this.config.getMonitoringFolder();
    IPath _fullPath = _monitoringFolder.getFullPath();
    IPath _fullPath_1 = this.file.getFullPath();
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
        IProject _project = this.file.getProject();
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
            boolean _equals = Objects.equal(it, RenamePaletteEntry.this.file);
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
}

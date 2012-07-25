package net.jeeeyul.pdetools.icg.refactor;

import java.util.ArrayList;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.MoveArguments;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.DocumentProviderRegistry;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class MoveMonitorFolder extends MoveParticipant {
  private IPath after;
  
  private IPath before;
  
  private ICGConfiguration config;
  
  public RefactoringStatus checkConditions(final IProgressMonitor pm, final CheckConditionsContext context) throws OperationCanceledException {
    RefactoringStatus _refactoringStatus = new RefactoringStatus();
    return _refactoringStatus;
  }
  
  public Change createChange(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    try {
      TextFileChange change = null;
      IFile _saveFile = this.config.getSaveFile();
      FileEditorInput _fileEditorInput = new FileEditorInput(_saveFile);
      FileEditorInput editorInput = _fileEditorInput;
      DocumentProviderRegistry _default = DocumentProviderRegistry.getDefault();
      IDocumentProvider documentProvider = _default.getDocumentProvider(editorInput);
      try {
        documentProvider.connect(editorInput);
        IDocument doc = documentProvider.getDocument(editorInput);
        FindReplaceDocumentAdapter _findReplaceDocumentAdapter = new FindReplaceDocumentAdapter(doc);
        FindReplaceDocumentAdapter finder = _findReplaceDocumentAdapter;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("monitoring-folder=");
        String _portableString = this.before.toPortableString();
        String _asISO_8859_1 = this.asISO_8859_1(_portableString);
        _builder.append(_asISO_8859_1, "");
        IRegion region = finder.find(0, _builder.toString(), true, true, false, false);
        IFile _saveFile_1 = this.config.getSaveFile();
        TextFileChange _textFileChange = new TextFileChange("Update Image Constant Generator settings", _saveFile_1);
        change = _textFileChange;
        int _offset = region.getOffset();
        int _length = region.getLength();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("monitoring-folder=");
        String _portableString_1 = this.after.toPortableString();
        String _asISO_8859_1_1 = this.asISO_8859_1(_portableString_1);
        _builder_1.append(_asISO_8859_1_1, "");
        ReplaceEdit _replaceEdit = new ReplaceEdit(_offset, _length, _builder_1.toString());
        change.setEdit(_replaceEdit);
      } finally {
        documentProvider.disconnect(editorInput);
      }
      ArrayList<TextFileChange> _newArrayList = CollectionLiterals.<TextFileChange>newArrayList(change);
      CompositeChange _compositeChange = new CompositeChange("Update Shared Image Generator settings", ((Change[])Conversions.unwrapArray(_newArrayList, Change.class)));
      return _compositeChange;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getName() {
    return "Change Monitoring Folder name in ICG Configuration";
  }
  
  protected boolean initialize(final Object element) {
    IResource movingResource = this.<IResource>getAdapter(element, IResource.class);
    boolean _not = (!(movingResource instanceof IFolder));
    if (_not) {
      return false;
    }
    IProject _project = movingResource.getProject();
    ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
    this.config = _iCGConfiguration;
    IPath _fullPath = movingResource.getFullPath();
    IFolder _monitoringFolder = this.config.getMonitoringFolder();
    IPath _fullPath_1 = _monitoringFolder.getFullPath();
    boolean _isPrefixOf = _fullPath.isPrefixOf(_fullPath_1);
    boolean _not_1 = (!_isPrefixOf);
    if (_not_1) {
      return false;
    }
    IFolder _monitoringFolder_1 = this.config.getMonitoringFolder();
    IPath _projectRelativePath = _monitoringFolder_1.getProjectRelativePath();
    this.before = _projectRelativePath;
    IFolder _monitoringFolder_2 = this.config.getMonitoringFolder();
    IPath _fullPath_2 = _monitoringFolder_2.getFullPath();
    IPath _fullPath_3 = movingResource.getFullPath();
    IPath relPath = _fullPath_2.makeRelativeTo(_fullPath_3);
    MoveArguments _arguments = this.getArguments();
    Object _destination = _arguments.getDestination();
    String _string = _destination.toString();
    Path _path = new Path(_string);
    String _name = movingResource.getName();
    IPath _append = _path.append(_name);
    IPath _append_1 = _append.append(relPath);
    IPath _removeFirstSegments = _append_1.removeFirstSegments(2);
    this.after = _removeFirstSegments;
    return true;
  }
  
  public <T extends Object> T getAdapter(final Object target, final Class<T> service) {
    Assert.isNotNull(target);
    IAdapterManager _adapterManager = Platform.getAdapterManager();
    Object _adapter = _adapterManager.getAdapter(target, service);
    return ((T) _adapter);
  }
  
  public String asISO_8859_1(final String string) {
    StringBuffer _stringBuffer = new StringBuffer();
    StringBuffer result = _stringBuffer;
    char[] _charArray = string.toCharArray();
    for (final char c : _charArray) {
      boolean _greaterThan = (c > 255);
      if (_greaterThan) {
        String _format = String.format("\\u%2x", Integer.valueOf(((int) c)));
        result.append(_format);
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }
}

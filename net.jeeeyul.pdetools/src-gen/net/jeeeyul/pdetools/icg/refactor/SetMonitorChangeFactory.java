package net.jeeeyul.pdetools.icg.refactor;

import java.util.ArrayList;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.DocumentProviderRegistry;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class SetMonitorChangeFactory {
  private IProject project;
  
  private IFolder newFolder;
  
  public SetMonitorChangeFactory(final IProject project, final IFolder newMonitorFolder) {
    this.project = project;
    this.newFolder = newMonitorFolder;
    InputOutput.<IFolder>println(this.newFolder);
  }
  
  public CompositeChange createChange() {
    ICGConfiguration _iCGConfiguration = new ICGConfiguration(this.project);
    ICGConfiguration cfg = _iCGConfiguration;
    IFile _saveFile = cfg.getSaveFile();
    InputOutput.<IFile>println(_saveFile);
    TextFileChange change = null;
    IFile _saveFile_1 = cfg.getSaveFile();
    FileEditorInput _fileEditorInput = new FileEditorInput(_saveFile_1);
    FileEditorInput editorInput = _fileEditorInput;
    DocumentProviderRegistry _default = DocumentProviderRegistry.getDefault();
    IDocumentProvider provider = _default.getDocumentProvider(editorInput);
    try {
      provider.connect(editorInput);
      IDocument doc = provider.getDocument(editorInput);
      FindReplaceDocumentAdapter _findReplaceDocumentAdapter = new FindReplaceDocumentAdapter(doc);
      FindReplaceDocumentAdapter finder = _findReplaceDocumentAdapter;
      IFolder _monitoringFolder = cfg.getMonitoringFolder();
      IPath _projectRelativePath = _monitoringFolder.getProjectRelativePath();
      String _portableString = _projectRelativePath.toPortableString();
      InputOutput.<String>println(_portableString);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("monitoring-folder=");
      IFolder _monitoringFolder_1 = cfg.getMonitoringFolder();
      IPath _projectRelativePath_1 = _monitoringFolder_1.getProjectRelativePath();
      String _portableString_1 = _projectRelativePath_1.toPortableString();
      String _asISO_8859_1 = this.asISO_8859_1(_portableString_1);
      _builder.append(_asISO_8859_1, "");
      IRegion region = finder.find(0, _builder.toString(), true, true, false, false);
      IFile _saveFile_2 = cfg.getSaveFile();
      TextFileChange _textFileChange = new TextFileChange("Update Image Constant Generator settings", _saveFile_2);
      change = _textFileChange;
      int _offset = region.getOffset();
      int _length = region.getLength();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("monitoring-folder=");
      IPath _projectRelativePath_2 = this.newFolder.getProjectRelativePath();
      String _portableString_2 = _projectRelativePath_2.toPortableString();
      String _asISO_8859_1_1 = this.asISO_8859_1(_portableString_2);
      _builder_1.append(_asISO_8859_1_1, "");
      ReplaceEdit _replaceEdit = new ReplaceEdit(_offset, _length, _builder_1.toString());
      change.setEdit(_replaceEdit);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        e.printStackTrace();
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      IFile _saveFile_3 = cfg.getSaveFile();
      provider.disconnect(_saveFile_3);
    }
    ArrayList<TextFileChange> _newArrayList = CollectionLiterals.<TextFileChange>newArrayList(change);
    CompositeChange _compositeChange = new CompositeChange("Shared Image Generator", ((Change[])Conversions.unwrapArray(_newArrayList, Change.class)));
    return _compositeChange;
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

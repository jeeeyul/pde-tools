package net.jeeeyul.pdetools.icg.builder.parts;

import java.util.List;
import net.jeeeyul.pdetools.shared.Base64Coder;
import net.jeeeyul.pdetools.shared.ResourceExtensions;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class ImagePreviewGenerator {
  private ResourceExtensions _resourceExtensions = new Function0<ResourceExtensions>() {
    public ResourceExtensions apply() {
      ResourceExtensions _resourceExtensions = new ResourceExtensions();
      return _resourceExtensions;
    }
  }.apply();
  
  private final long DATA_URI_SIZE_LIMIT = 32768L;
  
  public String generate(final IFile file) {
    String _xblockexpression = null;
    {
      byte[] content = this._resourceExtensions.getContentAsBytes(file);
      String _xifexpression = null;
      final byte[] _converted_content = (byte[])content;
      int _size = ((List<Byte>)Conversions.doWrapArray(_converted_content)).size();
      boolean _greaterThan = (_size > this.DATA_URI_SIZE_LIMIT);
      if (_greaterThan) {
        return "[Image file is too big or not valid]";
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<img src=\"data:image/");
        IPath _projectRelativePath = file.getProjectRelativePath();
        String _fileExtension = _projectRelativePath.getFileExtension();
        _builder.append(_fileExtension, "");
        _builder.append(";base64,");
        char[] _encode = Base64Coder.encode(content);
        String _string = new String(_encode);
        _builder.append(_string, "");
        _builder.append("\">");
        String _string_1 = _builder.toString();
        _xifexpression = _string_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}

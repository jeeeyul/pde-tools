package net.jeeeyul.pdetools.decorator;

import org.eclipse.core.resources.IFile;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class ImageDataEntry {
  private final IFile _file;
  
  public IFile getFile() {
    return this._file;
  }
  
  private final ImageData _imageData;
  
  public ImageData getImageData() {
    return this._imageData;
  }
  
  public ImageDataEntry(final IFile file, final ImageData imageData) {
    super();
    this._file = file;
    this._imageData = imageData;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_file== null) ? 0 : _file.hashCode());
    result = prime * result + ((_imageData== null) ? 0 : _imageData.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ImageDataEntry other = (ImageDataEntry) obj;
    if (_file == null) {
      if (other._file != null)
        return false;
    } else if (!_file.equals(other._file))
      return false;
    if (_imageData == null) {
      if (other._imageData != null)
        return false;
    } else if (!_imageData.equals(other._imageData))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}

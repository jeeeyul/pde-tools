package net.jeeeyul.pdetools.snapshot;

import com.google.common.base.Objects;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Date;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class SnapshotLabelProvider extends LabelProvider {
  private ImageRegistry registry = new Function0<ImageRegistry>() {
    public ImageRegistry apply() {
      ImageRegistry _imageRegistry = new ImageRegistry();
      return _imageRegistry;
    }
  }.apply();
  
  protected String _getText(final Object element) {
    return null;
  }
  
  protected String _getText(final SnapshotGroup group) {
    Date _date = group.getDate();
    String _string = _date.toString();
    return _string;
  }
  
  protected String _getText(final SnapshotEntry entry) {
    return null;
  }
  
  protected Image _getImage(final Object element) {
    return null;
  }
  
  protected Image _getImage(final SnapshotEntry entry) {
    try {
      Image _xblockexpression = null;
      {
        SnapshotGroup _parent = entry.getParent();
        SnapshotRepository _parent_1 = _parent.getParent();
        String _repositoryLocation = _parent_1.getRepositoryLocation();
        Path _path = new Path(_repositoryLocation);
        IPath basePath = _path;
        IPath _setDevice = basePath.setDevice(null);
        IPath _removeLastSegments = _setDevice.removeLastSegments(1);
        String _fileName = entry.getFileName();
        IPath _append = _removeLastSegments.append(_fileName);
        basePath = _append;
        File file = basePath.toFile();
        String _absolutePath = file.getAbsolutePath();
        Image _get = this.registry.get(_absolutePath);
        Image result = ((Image) _get);
        boolean _equals = Objects.equal(result, null);
        if (_equals) {
          Display _default = Display.getDefault();
          FileInputStream _fileInputStream = new FileInputStream(file);
          Image _image = new Image(_default, _fileInputStream);
          result = _image;
          String _absolutePath_1 = file.getAbsolutePath();
          this.registry.put(_absolutePath_1, result);
        }
        _xblockexpression = (result);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void dispose() {
    this.registry.dispose();
  }
  
  public String getText(final Object entry) {
    if (entry instanceof SnapshotEntry) {
      return _getText((SnapshotEntry)entry);
    } else if (entry instanceof SnapshotGroup) {
      return _getText((SnapshotGroup)entry);
    } else if (entry != null) {
      return _getText(entry);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entry).toString());
    }
  }
  
  public Image getImage(final Object entry) {
    if (entry instanceof SnapshotEntry) {
      return _getImage((SnapshotEntry)entry);
    } else if (entry != null) {
      return _getImage(entry);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entry).toString());
    }
  }
}

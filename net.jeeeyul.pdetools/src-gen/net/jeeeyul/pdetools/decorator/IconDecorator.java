package net.jeeeyul.pdetools.decorator;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class IconDecorator extends BaseLabelProvider implements ILightweightLabelDecorator {
  private final static ArrayList<String> IMAGE_FILES = new Function0<ArrayList<String>>() {
    public ArrayList<String> apply() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("jpg", "gif", "png", "bmp");
      return _newArrayList;
    }
  }.apply();
  
  public void decorate(final Object element, final IDecoration decoration) {
    if ((element instanceof IFile)) {
      IFile file = ((IFile) element);
      boolean _isImageFile = this.isImageFile(file);
      if (_isImageFile) {
        this.doDecorateImageFile(file, decoration);
      }
    }
  }
  
  public void doDecorateImageFile(final IFile file, final IDecoration decoration) {
    try {
      URI _rawLocationURI = file.getRawLocationURI();
      URL url = _rawLocationURI.toURL();
      ImageDescriptor _createFromURL = ImageDescriptor.createFromURL(url);
      decoration.addOverlay(_createFromURL, IDecoration.REPLACE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isImageFile(final IFile file) {
    boolean _exists = file.exists();
    boolean _not = (!_exists);
    if (_not) {
      return false;
    }
    IPath _projectRelativePath = file.getProjectRelativePath();
    String _fileExtension = _projectRelativePath.getFileExtension();
    String _lowerCase = _fileExtension.toLowerCase();
    return IconDecorator.IMAGE_FILES.contains(_lowerCase);
  }
}

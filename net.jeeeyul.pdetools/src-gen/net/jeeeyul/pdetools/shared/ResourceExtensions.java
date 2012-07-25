package net.jeeeyul.pdetools.shared;

import java.util.Arrays;
import net.jeeeyul.pdetools.shared.ResourceExtensionHelper;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ResourceExtensions {
  protected void _ensureExist(final IFolder folder) {
    try {
      boolean _exists = folder.exists();
      if (_exists) {
        return;
      }
      IContainer _parent = folder.getParent();
      boolean _exists_1 = _parent.exists();
      boolean _not = (!_exists_1);
      if (_not) {
        IContainer _parent_1 = folder.getParent();
        this.ensureExist(_parent_1);
      }
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      folder.create(true, true, _nullProgressMonitor);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _ensureExist(final IContainer container) {
  }
  
  protected void _ensureExist(final IProject project) {
    try {
      boolean _exists = project.exists();
      boolean _not = (!_exists);
      if (_not) {
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        project.create(_nullProgressMonitor);
      } else {
        boolean _isOpen = project.isOpen();
        boolean _not_1 = (!_isOpen);
        if (_not_1) {
          NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
          project.open(_nullProgressMonitor_1);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public byte[] getContentAsBytes(final IFile file) {
    try {
      return ResourceExtensionHelper.load(file);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void ensureExist(final IContainer folder) {
    if (folder instanceof IFolder) {
      _ensureExist((IFolder)folder);
      return;
    } else if (folder instanceof IProject) {
      _ensureExist((IProject)folder);
      return;
    } else if (folder != null) {
      _ensureExist(folder);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(folder).toString());
    }
  }
}

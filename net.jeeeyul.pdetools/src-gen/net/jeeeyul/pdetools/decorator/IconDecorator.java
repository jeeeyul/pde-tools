package net.jeeeyul.pdetools.decorator;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import net.jeeeyul.pdetools.decorator.ImageDataEntry;
import net.jeeeyul.pdetools.decorator.ImageLoadingQueue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class IconDecorator extends BaseLabelProvider implements ILightweightLabelDecorator, IResourceChangeListener {
  private final static ArrayList<String> IMAGE_FILES = new Function0<ArrayList<String>>() {
    public ArrayList<String> apply() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("jpg", "gif", "png", "bmp");
      return _newArrayList;
    }
  }.apply();
  
  private HashMap<IFile,ImageData> decoratedFiles = new Function0<HashMap<IFile,ImageData>>() {
    public HashMap<IFile,ImageData> apply() {
      HashMap<IFile,ImageData> _hashMap = new HashMap<IFile,ImageData>();
      return _hashMap;
    }
  }.apply();
  
  private ImageLoadingQueue queue;
  
  public IconDecorator() {
    ImageLoadingQueue _imageLoadingQueue = new ImageLoadingQueue();
    this.queue = _imageLoadingQueue;
    final Procedure1<List<ImageDataEntry>> _function = new Procedure1<List<ImageDataEntry>>() {
        public void apply(final List<ImageDataEntry> it) {
          IconDecorator.this.loaded(((ImageDataEntry[])Conversions.unwrapArray(it, ImageDataEntry.class)));
        }
      };
    this.queue.setLoadHandler(_function);
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    _workspace.addResourceChangeListener(this);
  }
  
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
    boolean _containsKey = this.decoratedFiles.containsKey(file);
    if (_containsKey) {
      ImageData data = this.decoratedFiles.get(file);
      boolean _notEquals = (!Objects.equal(data, null));
      if (_notEquals) {
        ImageDescriptor _createFromImageData = ImageDescriptor.createFromImageData(data);
        decoration.addOverlay(_createFromImageData);
      }
    } else {
      this.queue.add(file);
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
  
  public void resourceChanged(final IResourceChangeEvent event) {
    IResourceDelta delta = event.getDelta();
    boolean _equals = Objects.equal(delta, null);
    if (_equals) {
      return;
    }
    Set<IFile> _keySet = this.decoratedFiles.keySet();
    ArrayList<IFile> _arrayList = new ArrayList<IFile>(_keySet);
    for (final IFile eachFile : _arrayList) {
      {
        IPath _fullPath = eachFile.getFullPath();
        IResourceDelta eachDelta = delta.findMember(_fullPath);
        boolean _notEquals = (!Objects.equal(eachDelta, null));
        if (_notEquals) {
          int _kind = eachDelta.getKind();
          final int _switchValue = _kind;
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(_switchValue,IResourceDelta.REMOVED)) {
              _matched=true;
              this.decoratedFiles.remove(eachFile);
            }
          }
          if (!_matched) {
            this.queue.add(eachFile);
          }
        }
      }
    }
  }
  
  public void dispose() {
    this.decoratedFiles.clear();
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    _workspace.removeResourceChangeListener(this);
    super.dispose();
  }
  
  public void loaded(final ImageDataEntry[] datas) {
    final Procedure1<ImageDataEntry> _function = new Procedure1<ImageDataEntry>() {
        public void apply(final ImageDataEntry it) {
          IFile _file = it.getFile();
          ImageData _imageData = it.getImageData();
          IconDecorator.this.decoratedFiles.put(_file, _imageData);
        }
      };
    IterableExtensions.<ImageDataEntry>forEach(((Iterable<ImageDataEntry>)Conversions.doWrapArray(datas)), _function);
    final IconDecorator me = this;
    Display _default = Display.getDefault();
    final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          LabelProviderChangedEvent _labelProviderChangedEvent = new LabelProviderChangedEvent(me);
          IconDecorator.this.fireLabelProviderChanged(_labelProviderChangedEvent);
        }
      };
    _default.asyncExec(new Runnable() {
        public void run() {
          _function_1.apply();
        }
    });
  }
}

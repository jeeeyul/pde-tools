package net.jeeeyul.pdetools.icg.model;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import net.jeeeyul.pdetools.icg.ICGConfiguration;
import net.jeeeyul.pdetools.icg.model.GenerationContext;
import net.jeeeyul.pdetools.icg.model.imageResource.FieldNameOwner;
import net.jeeeyul.pdetools.icg.model.imageResource.ImageFile;
import net.jeeeyul.pdetools.icg.model.imageResource.ImageResourceFactory;
import net.jeeeyul.pdetools.icg.model.imageResource.Palette;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ResourceMappingModelGenerator {
  private Stack<GenerationContext> stack;
  
  private ICGConfiguration config;
  
  public ResourceMappingModelGenerator(final ICGConfiguration config) {
    this.config = config;
    Stack<GenerationContext> _stack = new Stack<GenerationContext>();
    this.stack = _stack;
    this.pushContext(null);
  }
  
  public Palette generatePalette(final IFolder folder) {
    Palette palette = ImageResourceFactory.eINSTANCE.createPalette();
    palette.setFolder(folder);
    String _name = folder.getName();
    String _safeFieldName = this.safeFieldName(_name);
    this.assigneFieldName(palette, _safeFieldName);
    GenerationContext _currentContext = this.currentContext();
    Palette _palette = _currentContext.getPalette();
    boolean _notEquals = (!Objects.equal(_palette, null));
    if (_notEquals) {
      GenerationContext _currentContext_1 = this.currentContext();
      Palette _palette_1 = _currentContext_1.getPalette();
      EList<Palette> _subPalettes = _palette_1.getSubPalettes();
      _subPalettes.add(palette);
    }
    this.pushContext(palette);
    {
      IResource[] _validMembers = this.validMembers(folder);
      Iterable<IFolder> _filter = Iterables.<IFolder>filter(((Iterable<? extends Object>)Conversions.doWrapArray(_validMembers)), IFolder.class);
      final Procedure1<IFolder> _function = new Procedure1<IFolder>() {
          public void apply(final IFolder it) {
            ResourceMappingModelGenerator.this.generatePalette(it);
          }
        };
      IterableExtensions.<IFolder>forEach(_filter, _function);
      IResource[] _validMembers_1 = this.validMembers(folder);
      Iterable<IFile> _filter_1 = Iterables.<IFile>filter(((Iterable<? extends Object>)Conversions.doWrapArray(_validMembers_1)), IFile.class);
      for (final IFile eachFile : _filter_1) {
        EList<ImageFile> _imageFiles = palette.getImageFiles();
        ImageFile _generateImageFile = this.generateImageFile(eachFile);
        _imageFiles.add(_generateImageFile);
      }
    }
    this.popContext();
    return palette;
  }
  
  public ImageFile generateImageFile(final IFile file) {
    ImageFile _createImageFile = ImageResourceFactory.eINSTANCE.createImageFile();
    final Procedure1<ImageFile> _function = new Procedure1<ImageFile>() {
        public void apply(final ImageFile it) {
          it.setFile(file);
          IPath _fullPath = file.getFullPath();
          IPath _removeFileExtension = _fullPath.removeFileExtension();
          String _lastSegment = _removeFileExtension.lastSegment();
          String _safeFieldName = ResourceMappingModelGenerator.this.safeFieldName(_lastSegment);
          ResourceMappingModelGenerator.this.assigneFieldName(it, _safeFieldName);
        }
      };
    return ObjectExtensions.<ImageFile>operator_doubleArrow(_createImageFile, _function);
  }
  
  private GenerationContext popContext() {
    GenerationContext _pop = this.stack.pop();
    return _pop;
  }
  
  private boolean assigneFieldName(final FieldNameOwner fieldNameOwner, final String preferName) {
    boolean _xifexpression = false;
    GenerationContext _currentContext = this.currentContext();
    boolean _isRegisterdFieldName = _currentContext.isRegisterdFieldName(preferName);
    boolean _not = (!_isRegisterdFieldName);
    if (_not) {
      boolean _xblockexpression = false;
      {
        fieldNameOwner.setFieldName(preferName);
        GenerationContext _currentContext_1 = this.currentContext();
        boolean _registerFieldName = _currentContext_1.registerFieldName(preferName);
        _xblockexpression = (_registerFieldName);
      }
      _xifexpression = _xblockexpression;
    } else {
      boolean _xblockexpression_1 = false;
      {
        int step = 2;
        String _plus = (preferName + "_");
        String newName = (_plus + Integer.valueOf(step));
        GenerationContext _currentContext_1 = this.currentContext();
        boolean _isRegisterdFieldName_1 = _currentContext_1.isRegisterdFieldName(newName);
        boolean _while = _isRegisterdFieldName_1;
        while (_while) {
          {
            int _plus_1 = (step + 1);
            step = _plus_1;
            String _plus_2 = (preferName + "_");
            String _plus_3 = (_plus_2 + Integer.valueOf(step));
            newName = _plus_3;
          }
          GenerationContext _currentContext_2 = this.currentContext();
          boolean _isRegisterdFieldName_2 = _currentContext_2.isRegisterdFieldName(newName);
          _while = _isRegisterdFieldName_2;
        }
        fieldNameOwner.setFieldName(newName);
        GenerationContext _currentContext_2 = this.currentContext();
        boolean _registerFieldName = _currentContext_2.registerFieldName(newName);
        _xblockexpression_1 = (_registerFieldName);
      }
      _xifexpression = _xblockexpression_1;
    }
    return _xifexpression;
  }
  
  private GenerationContext currentContext() {
    GenerationContext _peek = this.stack.peek();
    return _peek;
  }
  
  private GenerationContext pushContext(final Palette palette) {
    GenerationContext _generationContext = new GenerationContext(palette);
    GenerationContext _push = this.stack.push(_generationContext);
    return _push;
  }
  
  private String safeFieldName(final String preferName) {
    String _replaceAll = preferName.replaceAll("[^a-zA-Z0-9_]", "_");
    String result = _replaceAll.toUpperCase();
    boolean _matches = result.matches("[0-9].*");
    if (_matches) {
      String _plus = ("_" + result);
      result = _plus;
    }
    return result;
  }
  
  private IResource[] validMembers(final IFolder folder) {
    try {
      List<IResource> _xblockexpression = null;
      {
        IResource[] _members = folder.members();
        final Function1<IResource,Boolean> _function = new Function1<IResource,Boolean>() {
            public Boolean apply(final IResource it) {
              boolean _xifexpression = false;
              if ((it instanceof IFolder)) {
                _xifexpression = true;
              } else {
                String[] _imageFileExtensions = ResourceMappingModelGenerator.this.config.getImageFileExtensions();
                final Function1<String,String> _function = new Function1<String,String>() {
                    public String apply(final String it) {
                      String _lowerCase = it.toLowerCase();
                      return _lowerCase;
                    }
                  };
                List _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_imageFileExtensions)), _function);
                String _fileExtension = it.getFileExtension();
                String _lowerCase = _fileExtension.toLowerCase();
                boolean _contains = _map.contains(_lowerCase);
                _xifexpression = _contains;
              }
              return Boolean.valueOf(_xifexpression);
            }
          };
        Iterable<IResource> list = IterableExtensions.<IResource>filter(((Iterable<IResource>)Conversions.doWrapArray(_members)), _function);
        final Function2<IResource,IResource,Integer> _function_1 = new Function2<IResource,IResource,Integer>() {
            public Integer apply(final IResource a, final IResource b) {
              boolean _and = false;
              if (!(a instanceof IFolder)) {
                _and = false;
              } else {
                _and = ((a instanceof IFolder) && (b instanceof IFile));
              }
              if (_and) {
                return (-1);
              } else {
                boolean _and_1 = false;
                if (!(a instanceof IFile)) {
                  _and_1 = false;
                } else {
                  _and_1 = ((a instanceof IFile) && (b instanceof IFolder));
                }
                if (_and_1) {
                  return 1;
                } else {
                  String _name = a.getName();
                  String _name_1 = b.getName();
                  return _name.compareTo(_name_1);
                }
              }
            }
          };
        List<IResource> _sort = IterableExtensions.<IResource>sort(list, new Comparator<IResource>() {
            public int compare(IResource o1,IResource o2) {
              return _function_1.apply(o1,o2);
            }
        });
        _xblockexpression = (_sort);
      }
      return ((IResource[])Conversions.unwrapArray(_xblockexpression, IResource.class));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

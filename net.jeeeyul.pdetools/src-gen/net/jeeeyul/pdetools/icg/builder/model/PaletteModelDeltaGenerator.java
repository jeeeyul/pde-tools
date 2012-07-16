package net.jeeeyul.pdetools.icg.builder.model;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.jeeeyul.pdetools.icg.builder.model.PaletteDelta;
import net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner;
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PaletteModelDeltaGenerator {
  public List<PaletteDelta> compare(final Palette a, final Palette b) {
    final List<PaletteDelta> deltas = CollectionLiterals.<PaletteDelta>newArrayList();
    HashMap<IResource,FieldNameOwner> _hashMap = new HashMap<IResource,FieldNameOwner>();
    final Map<IResource,FieldNameOwner> original = _hashMap;
    TreeIterator<EObject> _eAllContents = a.eAllContents();
    Iterator<FieldNameOwner> _filter = Iterators.<FieldNameOwner>filter(_eAllContents, FieldNameOwner.class);
    final Procedure1<FieldNameOwner> _function = new Procedure1<FieldNameOwner>() {
        public void apply(final FieldNameOwner it) {
          IResource _resource = PaletteModelDeltaGenerator.this.getResource(it);
          original.put(_resource, it);
        }
      };
    IteratorExtensions.<FieldNameOwner>forEach(_filter, _function);
    TreeIterator<EObject> _eAllContents_1 = b.eAllContents();
    Iterator<FieldNameOwner> _filter_1 = Iterators.<FieldNameOwner>filter(_eAllContents_1, FieldNameOwner.class);
    Iterable<FieldNameOwner> _iterable = IteratorExtensions.<FieldNameOwner>toIterable(_filter_1);
    for (final FieldNameOwner each : _iterable) {
      {
        IResource _resource = this.getResource(each);
        final FieldNameOwner eachOriginal = original.get(_resource);
        String _fieldName = eachOriginal.getFieldName();
        String _fieldName_1 = each.getFieldName();
        boolean _notEquals = (!Objects.equal(_fieldName, _fieldName_1));
        if (_notEquals) {
          PaletteDelta _paletteDelta = new PaletteDelta();
          final Procedure1<PaletteDelta> _function_1 = new Procedure1<PaletteDelta>() {
              public void apply(final PaletteDelta it) {
                it.setBefore(eachOriginal);
                it.setAfter(each);
              }
            };
          PaletteDelta _doubleArrow = ObjectExtensions.<PaletteDelta>operator_doubleArrow(_paletteDelta, _function_1);
          deltas.add(_doubleArrow);
        }
      }
    }
    return deltas;
  }
  
  protected IResource _getResource(final FieldNameOwner obj) {
    return null;
  }
  
  protected IResource _getResource(final Palette palette) {
    IFolder _folder = palette.getFolder();
    return _folder;
  }
  
  protected IResource _getResource(final ImageFile file) {
    IFile _file = file.getFile();
    return _file;
  }
  
  public IResource getResource(final FieldNameOwner file) {
    if (file instanceof ImageFile) {
      return _getResource((ImageFile)file);
    } else if (file instanceof Palette) {
      return _getResource((Palette)file);
    } else if (file != null) {
      return _getResource(file);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(file).toString());
    }
  }
}

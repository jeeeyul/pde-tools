package net.jeeeyul.pdetools.icg.builder.model;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.jeeeyul.pdetools.icg.builder.model.PaletteDelta;
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PaletteModelDeltaGenerator {
  public String quallifiedIdentifier(final ImageFile imageFile) {
    ArrayList<String> _arrayList = new ArrayList<String>();
    ArrayList<String> result = _arrayList;
    String _fieldName = imageFile.getFieldName();
    result.add(_fieldName);
    Palette parent = imageFile.getParent();
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(parent, null));
    if (!_notEquals) {
      _and = false;
    } else {
      String _fieldName_1 = parent.getFieldName();
      boolean _notEquals_1 = (!Objects.equal(_fieldName_1, null));
      _and = (_notEquals && _notEquals_1);
    }
    boolean _while = _and;
    while (_while) {
      {
        String _fieldName_2 = parent.getFieldName();
        result.add(_fieldName_2);
        Palette _parent = parent.getParent();
        parent = _parent;
      }
      boolean _and_1 = false;
      boolean _notEquals_2 = (!Objects.equal(parent, null));
      if (!_notEquals_2) {
        _and_1 = false;
      } else {
        String _fieldName_2 = parent.getFieldName();
        boolean _notEquals_3 = (!Objects.equal(_fieldName_2, null));
        _and_1 = (_notEquals_2 && _notEquals_3);
      }
      _while = _and_1;
    }
    List<String> _reverse = ListExtensions.<String>reverse(result);
    return IterableExtensions.join(_reverse, ".");
  }
  
  public List<PaletteDelta> compare(final Palette a, final Palette b) {
    final List<PaletteDelta> deltas = CollectionLiterals.<PaletteDelta>newArrayList();
    HashMap<IFile,ImageFile> _hashMap = new HashMap<IFile,ImageFile>();
    final Map<IFile,ImageFile> original = _hashMap;
    TreeIterator<EObject> _eAllContents = a.eAllContents();
    Iterator<ImageFile> _filter = Iterators.<ImageFile>filter(_eAllContents, ImageFile.class);
    final Procedure1<ImageFile> _function = new Procedure1<ImageFile>() {
        public void apply(final ImageFile it) {
          IFile _file = it.getFile();
          original.put(_file, it);
        }
      };
    IteratorExtensions.<ImageFile>forEach(_filter, _function);
    TreeIterator<EObject> _eAllContents_1 = b.eAllContents();
    Iterator<ImageFile> _filter_1 = Iterators.<ImageFile>filter(_eAllContents_1, ImageFile.class);
    Iterable<ImageFile> _iterable = IteratorExtensions.<ImageFile>toIterable(_filter_1);
    for (final ImageFile each : _iterable) {
      {
        IFile _file = each.getFile();
        final ImageFile eachOriginal = original.get(_file);
        String _quallifiedIdentifier = this.quallifiedIdentifier(eachOriginal);
        String _quallifiedIdentifier_1 = this.quallifiedIdentifier(each);
        boolean _notEquals = (!Objects.equal(_quallifiedIdentifier, _quallifiedIdentifier_1));
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
}

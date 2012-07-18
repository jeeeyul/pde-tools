package net.jeeeyul.pdetools.clipboard;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import net.jeeeyul.pdetools.clipboard.StyleAndText;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StyleAndTextFactory {
  public StyleAndText createFromRTFString(final String rtfString) {
    try {
      StyleAndText _styleAndText = new StyleAndText();
      StyleAndText result = _styleAndText;
      RTFEditorKit _rTFEditorKit = new RTFEditorKit();
      RTFEditorKit kit = _rTFEditorKit;
      Document _createDefaultDocument = kit.createDefaultDocument();
      final StyledDocument doc = ((StyledDocument) _createDefaultDocument);
      StringReader _stringReader = new StringReader(rtfString);
      kit.read(_stringReader, doc, 0);
      ArrayList<Element> _arrayList = new ArrayList<Element>();
      final List<Element> leafs = _arrayList;
      final Procedure1<Element> _function = new Procedure1<Element>() {
          public void apply(final Element it) {
          }
        };
      final Procedure1<? super Element> leafCollector = _function;
      Element[] _rootElements = doc.getRootElements();
      final Procedure1<Element> _function_1 = new Procedure1<Element>() {
          public void apply(final Element it) {
            StyleAndTextFactory.this.accept(it, leafCollector);
          }
        };
      IterableExtensions.<Element>forEach(((Iterable<Element>)Conversions.doWrapArray(_rootElements)), _function_1);
      return result;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void accept(final Element element, final Procedure1<? super Element> visitor) {
    visitor.apply(element);
    boolean _isLeaf = element.isLeaf();
    boolean _not = (!_isLeaf);
    if (_not) {
      int _elementCount = element.getElementCount();
      int _minus = (_elementCount - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        Element _element = element.getElement((i).intValue());
        this.accept(_element, visitor);
      }
    }
  }
}

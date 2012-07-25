package net.jeeeyul.pdetools.clipboard;

import com.google.common.base.Objects;
import java.awt.Color;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import net.jeeeyul.pdetools.clipboard.IColorProvider;
import net.jeeeyul.pdetools.clipboard.StyleAndText;
import net.jeeeyul.pdetools.shared.BitExtensions;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StyleAndTextFactory {
  private BitExtensions _bitExtensions = new Function0<BitExtensions>() {
    public BitExtensions apply() {
      BitExtensions _bitExtensions = new BitExtensions();
      return _bitExtensions;
    }
  }.apply();
  
  private IColorProvider colorProvider;
  
  public StyleAndTextFactory(final IColorProvider colorProvider) {
    this.colorProvider = colorProvider;
  }
  
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
            boolean _and = false;
            boolean _isLeaf = it.isLeaf();
            if (!_isLeaf) {
              _and = false;
            } else {
              String _name = it.getName();
              boolean _equals = Objects.equal(_name, "content");
              _and = (_isLeaf && _equals);
            }
            if (_and) {
              leafs.add(it);
            }
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
      final Function1<Element,String> _function_2 = new Function1<Element,String>() {
          public String apply(final Element it) {
            try {
              int _startOffset = it.getStartOffset();
              int _endOffset = it.getEndOffset();
              int _startOffset_1 = it.getStartOffset();
              int _minus = (_endOffset - _startOffset_1);
              String _text = doc.getText(_startOffset, _minus);
              return _text;
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      String _join = IterableExtensions.<Element>join(leafs, "", _function_2);
      result.setText(_join);
      ArrayList<StyleRange> _arrayList_1 = new ArrayList<StyleRange>();
      final List<StyleRange> ranges = _arrayList_1;
      final Procedure1<Element> _function_3 = new Procedure1<Element>() {
          public void apply(final Element it) {
            StyleRange _styleRange = new StyleRange();
            StyleRange each = _styleRange;
            int _startOffset = it.getStartOffset();
            each.start = _startOffset;
            int _endOffset = it.getEndOffset();
            int _startOffset_1 = it.getStartOffset();
            int _minus = (_endOffset - _startOffset_1);
            each.length = _minus;
            AttributeSet _attributes = it.getAttributes();
            Object _attribute = _attributes.getAttribute(StyleConstants.Foreground);
            Color foreground = ((Color) _attribute);
            boolean _notEquals = (!Objects.equal(foreground, null));
            if (_notEquals) {
              RGB _asRGB = StyleAndTextFactory.this.asRGB(foreground);
              org.eclipse.swt.graphics.Color _color = StyleAndTextFactory.this.colorProvider.getColor(_asRGB);
              each.foreground = _color;
            }
            int fontStyle = SWT.NORMAL;
            AttributeSet _attributes_1 = it.getAttributes();
            boolean _isBold = StyleConstants.isBold(_attributes_1);
            if (_isBold) {
              int _or = StyleAndTextFactory.this._bitExtensions.operator_or(fontStyle, SWT.BOLD);
              fontStyle = _or;
            }
            AttributeSet _attributes_2 = it.getAttributes();
            boolean _isItalic = StyleConstants.isItalic(_attributes_2);
            if (_isItalic) {
              int _or_1 = StyleAndTextFactory.this._bitExtensions.operator_or(fontStyle, SWT.ITALIC);
              fontStyle = _or_1;
            }
            each.fontStyle = fontStyle;
            ranges.add(each);
          }
        };
      IterableExtensions.<Element>forEach(leafs, _function_3);
      result.setStyleRanges(((StyleRange[])Conversions.unwrapArray(ranges, StyleRange.class)));
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
  
  public RGB asRGB(final Color awtColor) {
    int _red = awtColor.getRed();
    int _green = awtColor.getGreen();
    int _blue = awtColor.getBlue();
    RGB _rGB = new RGB(_red, _green, _blue);
    return _rGB;
  }
}

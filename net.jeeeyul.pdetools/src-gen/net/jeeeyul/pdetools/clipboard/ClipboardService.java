package net.jeeeyul.pdetools.clipboard;

import com.google.common.base.Objects;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import net.jeeeyul.pdetools.clipboard.AbstractClipboardService;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ClipboardService extends AbstractClipboardService {
  private static ClipboardService INSTANCE;
  
  public static ClipboardService initailze() {
    ClipboardService _xifexpression = null;
    boolean _equals = Objects.equal(ClipboardService.INSTANCE, null);
    if (_equals) {
      ClipboardService _clipboardService = new ClipboardService();
      ClipboardService _INSTANCE = ClipboardService.INSTANCE = _clipboardService;
      _xifexpression = _INSTANCE;
    }
    return _xifexpression;
  }
  
  public static ClipboardService getInstance() {
    boolean _equals = Objects.equal(ClipboardService.INSTANCE, null);
    if (_equals) {
      IllegalStateException _illegalStateException = new IllegalStateException("\uCD08\uAE30\uD654 \uB418\uC9C0 \uC54A\uC558\uC2B5\uB2C8\uB2E4.");
      throw _illegalStateException;
    }
    return ClipboardService.INSTANCE;
  }
  
  private ClipboardService() {
  }
  
  protected void handleCopy() {
    try {
      Clipboard _nativeClipboard = this.getNativeClipboard();
      TransferData[] _availableTypes = _nativeClipboard.getAvailableTypes();
      final Function1<TransferData,Boolean> _function = new Function1<TransferData,Boolean>() {
          public Boolean apply(final TransferData it) {
            TextTransfer _textTransfer = ClipboardService.this.getTextTransfer();
            boolean _isSupportedType = _textTransfer.isSupportedType(it);
            return Boolean.valueOf(_isSupportedType);
          }
        };
      boolean hasTextContents = IterableExtensions.<TransferData>exists(((Iterable<TransferData>)Conversions.doWrapArray(_availableTypes)), _function);
      boolean _not = (!hasTextContents);
      if (_not) {
        return;
      }
      Clipboard _nativeClipboard_1 = this.getNativeClipboard();
      RTFTransfer _rTFTransfer = this.getRTFTransfer();
      Object _contents = _nativeClipboard_1.getContents(_rTFTransfer);
      String rtfText = ((String) _contents);
      RTFEditorKit _rTFEditorKit = new RTFEditorKit();
      RTFEditorKit kit = _rTFEditorKit;
      Document _createDefaultDocument = kit.createDefaultDocument();
      final StyledDocument doc = ((StyledDocument) _createDefaultDocument);
      StringReader _stringReader = new StringReader(rtfText);
      kit.read(_stringReader, doc, 0);
      ArrayList<Element> _arrayList = new ArrayList<Element>();
      final List<Element> leafs = _arrayList;
      final Procedure1<Element> _function_1 = new Procedure1<Element>() {
          public void apply(final Element it) {
            boolean _and = false;
            boolean _and_1 = false;
            int _elementCount = it.getElementCount();
            boolean _equals = (_elementCount == 0);
            if (!_equals) {
              _and_1 = false;
            } else {
              String _name = it.getName();
              boolean _equals_1 = Objects.equal(_name, "content");
              _and_1 = (_equals && _equals_1);
            }
            if (!_and_1) {
              _and = false;
            } else {
              int _startOffset = it.getStartOffset();
              int _endOffset = it.getEndOffset();
              boolean _notEquals = (_startOffset != _endOffset);
              _and = (_and_1 && _notEquals);
            }
            if (_and) {
              leafs.add(it);
            }
          }
        };
      final Procedure1<? super Element> visitor = _function_1;
      Element[] _rootElements = doc.getRootElements();
      final Procedure1<Element> _function_2 = new Procedure1<Element>() {
          public void apply(final Element it) {
            ClipboardService.this.accept(it, visitor);
          }
        };
      IterableExtensions.<Element>forEach(((Iterable<Element>)Conversions.doWrapArray(_rootElements)), _function_2);
      final Procedure1<Element> _function_3 = new Procedure1<Element>() {
          public void apply(final Element it) {
            try {
              int _startOffset = it.getStartOffset();
              int _endOffset = it.getEndOffset();
              int _startOffset_1 = it.getStartOffset();
              int _minus = (_endOffset - _startOffset_1);
              String text = doc.getText(_startOffset, _minus);
              AttributeSet _attributes = it.getAttributes();
              Enumeration<? extends Object> enum_ = _attributes.getAttributeNames();
              boolean _hasMoreElements = enum_.hasMoreElements();
              boolean _while = _hasMoreElements;
              while (_while) {
                Object _nextElement = enum_.nextElement();
                InputOutput.<Object>println(_nextElement);
                boolean _hasMoreElements_1 = enum_.hasMoreElements();
                _while = _hasMoreElements_1;
              }
              AttributeSet _attributes_1 = it.getAttributes();
              Object _attribute = _attributes_1.getAttribute(StyleConstants.Foreground);
              InputOutput.<Object>println(_attribute);
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      IterableExtensions.<Element>forEach(leafs, _function_3);
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

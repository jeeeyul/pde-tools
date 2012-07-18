package net.jeeeyul.pdetools.clipboard;

import com.google.common.base.Objects;
import net.jeeeyul.pdetools.clipboard.AbstractClipboardService;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ClipboardService extends AbstractClipboardService {
  private ClipboardFactory _clipboardFactory = ClipboardFactory.eINSTANCE;
  
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
      ClipboardService.initailze();
    }
    return ClipboardService.INSTANCE;
  }
  
  private ClipboardService() {
  }
  
  protected void handleCopy() {
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
    ClipboardEntry _createClipboardEntry = this._clipboardFactory.createClipboardEntry();
    final Procedure1<ClipboardEntry> _function_1 = new Procedure1<ClipboardEntry>() {
        public void apply(final ClipboardEntry it) {
          Clipboard _nativeClipboard = ClipboardService.this.getNativeClipboard();
          TextTransfer _textTransfer = ClipboardService.this.getTextTransfer();
          Object _contents = _nativeClipboard.getContents(_textTransfer);
          it.setTextContent(((String) _contents));
          Clipboard _nativeClipboard_1 = ClipboardService.this.getNativeClipboard();
          TransferData[] _availableTypes = _nativeClipboard_1.getAvailableTypes();
          final Function1<TransferData,Boolean> _function = new Function1<TransferData,Boolean>() {
              public Boolean apply(final TransferData it) {
                RTFTransfer _rTFTransfer = ClipboardService.this.getRTFTransfer();
                boolean _isSupportedType = _rTFTransfer.isSupportedType(it);
                return Boolean.valueOf(_isSupportedType);
              }
            };
          boolean _exists = IterableExtensions.<TransferData>exists(((Iterable<TransferData>)Conversions.doWrapArray(_availableTypes)), _function);
          if (_exists) {
            Clipboard _nativeClipboard_2 = ClipboardService.this.getNativeClipboard();
            RTFTransfer _rTFTransfer = ClipboardService.this.getRTFTransfer();
            Object _contents_1 = _nativeClipboard_2.getContents(_rTFTransfer);
            it.setRtfContent(((String) _contents_1));
          }
        }
      };
    ClipboardEntry entry = ObjectExtensions.<ClipboardEntry>operator_doubleArrow(_createClipboardEntry, _function_1);
    ClipHistory _history = this.getHistory();
    EList<ClipboardEntry> _entries = _history.getEntries();
    _entries.add(0, entry);
  }
}

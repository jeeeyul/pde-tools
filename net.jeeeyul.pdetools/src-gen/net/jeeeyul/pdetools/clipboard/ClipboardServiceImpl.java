package net.jeeeyul.pdetools.clipboard;

import com.google.common.base.Objects;
import java.util.Date;
import net.jeeeyul.pdetools.clipboard.AbstractClipboardService;
import net.jeeeyul.pdetools.clipboard.IClipboardService;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ClipboardServiceImpl extends AbstractClipboardService {
  private ClipboardFactory _clipboardFactory = ClipboardFactory.eINSTANCE;
  
  private static IClipboardService INSTANCE;
  
  private static ILock lock = new Function0<ILock>() {
    public ILock apply() {
      IJobManager _jobManager = Job.getJobManager();
      ILock _newLock = _jobManager.newLock();
      return _newLock;
    }
  }.apply();
  
  public static IClipboardService initailze() {
    IClipboardService _xblockexpression = null;
    {
      ClipboardServiceImpl.lock.acquire();
      IClipboardService _xtrycatchfinallyexpression = null;
      try {
        IClipboardService _xifexpression = null;
        boolean _equals = Objects.equal(ClipboardServiceImpl.INSTANCE, null);
        if (_equals) {
          ClipboardServiceImpl _clipboardServiceImpl = new ClipboardServiceImpl();
          IClipboardService _INSTANCE = ClipboardServiceImpl.INSTANCE = _clipboardServiceImpl;
          _xifexpression = _INSTANCE;
        }
        _xtrycatchfinallyexpression = _xifexpression;
      } finally {
        ClipboardServiceImpl.lock.release();
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  public static IClipboardService getInstance() {
    ClipboardServiceImpl.lock.acquire();
    try {
      boolean _equals = Objects.equal(ClipboardServiceImpl.INSTANCE, null);
      if (_equals) {
        ClipboardServiceImpl.initailze();
      }
    } finally {
      ClipboardServiceImpl.lock.release();
    }
    return ClipboardServiceImpl.INSTANCE;
  }
  
  private ClipboardServiceImpl() {
  }
  
  public ClipboardEntry createClipEntry() {
    ClipboardEntry _createClipboardEntry = this._clipboardFactory.createClipboardEntry();
    final Procedure1<ClipboardEntry> _function = new Procedure1<ClipboardEntry>() {
        public void apply(final ClipboardEntry it) {
          Clipboard _nativeClipboard = ClipboardServiceImpl.this.getNativeClipboard();
          TextTransfer _textTransfer = ClipboardServiceImpl.this.getTextTransfer();
          Object _contents = _nativeClipboard.getContents(_textTransfer);
          it.setTextContent(((String) _contents));
          Clipboard _nativeClipboard_1 = ClipboardServiceImpl.this.getNativeClipboard();
          TransferData[] _availableTypes = _nativeClipboard_1.getAvailableTypes();
          final Function1<TransferData,Boolean> _function = new Function1<TransferData,Boolean>() {
              public Boolean apply(final TransferData it) {
                RTFTransfer _rTFTransfer = ClipboardServiceImpl.this.getRTFTransfer();
                boolean _isSupportedType = _rTFTransfer.isSupportedType(it);
                return Boolean.valueOf(_isSupportedType);
              }
            };
          boolean _exists = IterableExtensions.<TransferData>exists(((Iterable<TransferData>)Conversions.doWrapArray(_availableTypes)), _function);
          if (_exists) {
            Clipboard _nativeClipboard_2 = ClipboardServiceImpl.this.getNativeClipboard();
            RTFTransfer _rTFTransfer = ClipboardServiceImpl.this.getRTFTransfer();
            Object _contents_1 = _nativeClipboard_2.getContents(_rTFTransfer);
            it.setRtfContent(((String) _contents_1));
          }
        }
      };
    ClipboardEntry entry = ObjectExtensions.<ClipboardEntry>operator_doubleArrow(_createClipboardEntry, _function);
    return entry;
  }
  
  protected void handleCopy(final ExecutionEvent event) {
    Clipboard _nativeClipboard = this.getNativeClipboard();
    TransferData[] _availableTypes = _nativeClipboard.getAvailableTypes();
    final Function1<TransferData,Boolean> _function = new Function1<TransferData,Boolean>() {
        public Boolean apply(final TransferData it) {
          TextTransfer _textTransfer = ClipboardServiceImpl.this.getTextTransfer();
          boolean _isSupportedType = _textTransfer.isSupportedType(it);
          return Boolean.valueOf(_isSupportedType);
        }
      };
    boolean hasTextContents = IterableExtensions.<TransferData>exists(((Iterable<TransferData>)Conversions.doWrapArray(_availableTypes)), _function);
    boolean _not = (!hasTextContents);
    if (_not) {
      return;
    }
    ClipHistory _history = this.getHistory();
    EList<ClipboardEntry> _entries = _history.getEntries();
    boolean _isEmpty = _entries.isEmpty();
    boolean _not_1 = (!_isEmpty);
    if (_not_1) {
      ClipHistory _history_1 = this.getHistory();
      EList<ClipboardEntry> _entries_1 = _history_1.getEntries();
      ClipboardEntry _head = IterableExtensions.<ClipboardEntry>head(_entries_1);
      String _textContent = _head.getTextContent();
      Clipboard _nativeClipboard_1 = this.getNativeClipboard();
      TextTransfer _textTransfer = this.getTextTransfer();
      Object _contents = _nativeClipboard_1.getContents(_textTransfer);
      boolean _equals = Objects.equal(_textContent, ((String) _contents));
      if (_equals) {
        return;
      }
    }
    ClipboardEntry entry = this.createClipEntry();
    IWorkbenchPart part = HandlerUtil.getActivePart(event);
    boolean _notEquals = (!Objects.equal(part, null));
    if (_notEquals) {
      Image _titleImage = part.getTitleImage();
      ImageData _imageData = _titleImage.getImageData();
      entry.setImageData(_imageData);
      IWorkbenchPartSite _site = part.getSite();
      String _id = _site.getId();
      entry.setPartId(_id);
    }
    Date _date = new Date();
    entry.setTakenTime(_date);
    ClipHistory _history_2 = this.getHistory();
    EList<ClipboardEntry> _entries_2 = _history_2.getEntries();
    _entries_2.add(0, entry);
  }
}

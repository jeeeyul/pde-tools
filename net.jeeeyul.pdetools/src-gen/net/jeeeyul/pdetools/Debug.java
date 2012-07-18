package net.jeeeyul.pdetools;

import net.jeeeyul.pdetools.clipboard.ClipboardView;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Debug extends AbstractHandler {
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    try {
      Object _xblockexpression = null;
      {
        IWorkbenchWindow _activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindow(event);
        IWorkbenchPage _activePage = _activeWorkbenchWindow.getActivePage();
        IViewPart _showView = _activePage.showView(ClipboardView.ID);
        ClipboardView view = ((ClipboardView) _showView);
        Display _default = Display.getDefault();
        Clipboard _clipboard = new Clipboard(_default);
        Clipboard clip = _clipboard;
        RTFTransfer _instance = RTFTransfer.getInstance();
        Object _contents = clip.getContents(_instance);
        String rtfString = ((String) _contents);
        view.showRTF(rtfString);
        _xblockexpression = (null);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

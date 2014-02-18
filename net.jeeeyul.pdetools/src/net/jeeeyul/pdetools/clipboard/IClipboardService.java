package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.clipboard.internal.ClipboardServiceImpl;
import net.jeeeyul.pdetools.model.pdetools.ClipHistory;
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.ui.services.IServiceLocator;

/**
 * @see IServiceLocator#getService(Class)
 * @author Jeeeyul
 * 
 */
public interface IClipboardService {
	public static final IClipboardService INSTANCE = ClipboardServiceImpl.getInstance();
	ClipHistory getHistory();

	Clipboard getNativeClipboard();

	ClipboardEntry createClipEntry();

	void doSave();
}
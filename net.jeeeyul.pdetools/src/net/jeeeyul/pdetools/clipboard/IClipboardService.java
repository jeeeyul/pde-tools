package net.jeeeyul.pdetools.clipboard;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.ui.services.IServiceLocator;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;

/**
 * @see IServiceLocator#getService(Class)
 * @author Jeeeyul
 * 
 */
public interface IClipboardService {
	ClipHistory getHistory();

	Clipboard getNativeClipboard();

	ClipboardEntry createClipEntry();

	void doSave();
}
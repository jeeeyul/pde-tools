package net.jeeeyul.pdetools.clipboard;

import org.eclipse.swt.dnd.Clipboard;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;

public interface IClipboardService {
	ClipHistory getHistory();

	Clipboard getNativeClipboard();

	ClipboardEntry createClipEntry();
	
	void doSave();
}
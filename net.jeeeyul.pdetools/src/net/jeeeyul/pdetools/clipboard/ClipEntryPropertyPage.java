package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.clipboard.internal.OpenJavaElementFunction;
import net.jeeeyul.pdetools.clipboard.internal.OpenResourceFunction;
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;

public class ClipEntryPropertyPage extends PropertyPage{

	@Override
	protected Control createContents(Composite parent) {
		Browser browser = new Browser(parent, SWT.FLAT | SWT.BORDER);
		
		new OpenResourceFunction(browser);
		new OpenJavaElementFunction(browser);
		
		ClipboardEntry entry = (ClipboardEntry) getElement().getAdapter(ClipboardEntry.class);
		ClipEntryInformationGenerator generator = new ClipEntryInformationGenerator();
		String content = generator.generate(entry).toString();
		browser.setText(content);
		return browser;
	}
}

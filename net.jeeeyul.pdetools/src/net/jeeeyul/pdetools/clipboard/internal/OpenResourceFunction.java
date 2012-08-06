package net.jeeeyul.pdetools.clipboard.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class OpenResourceFunction extends BrowserFunction {

	public OpenResourceFunction(Browser browser) {
		super(browser, "openResource");
	}

	@Override
	public Object function(Object[] arguments) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path((String) arguments[0]));
		System.out.println(file);
		try {
			IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

}

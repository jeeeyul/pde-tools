package net.jeeeyul.pdetools.clipboard.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;

public class OpenResourceFunction extends BrowserFunction {

	public OpenResourceFunction(Browser browser) {
		super(browser, "openResource");
	}

	@Override
	public Object function(Object[] arguments) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path((String) arguments[0]));

		try {
			IEditorPart editor = IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
					file);

			if (arguments.length == 3 && editor instanceof ITextEditor) {
				int offset = (int) Double.parseDouble(arguments[1].toString());
				int length = (int) Double.parseDouble(arguments[2].toString());
				ITextEditor textEditor = (ITextEditor) editor;
				textEditor.selectAndReveal(offset, length);
			}

		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

}

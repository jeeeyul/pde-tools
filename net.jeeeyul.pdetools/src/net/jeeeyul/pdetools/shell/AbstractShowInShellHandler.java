package net.jeeeyul.pdetools.shell;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

public abstract class AbstractShowInShellHandler extends AbstractHandler implements IElementUpdater {

	@Override
	public final Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		IResource resource = (IResource) Platform.getAdapterManager().getAdapter(selection.getFirstElement(),
				IResource.class);

		URI uri = resource.getLocationURI();
		if (resource.isLinked()) {
			uri = resource.getRawLocationURI();
		}

		try {
			File file = EFS.getStore(uri).toLocalFile(0, new NullProgressMonitor());
			List<String> command = new ArrayList<String>();

			fillCommand(command, file);

			Runtime.getRuntime().exec(command.toArray(new String[command.size()]));

		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	protected abstract void fillCommand(List<String> command, File file);

	@Override
	public final void updateElement(UIElement element, @SuppressWarnings("rawtypes") Map parameters) {
		element.setText(getLabel());
		ImageDescriptor iconDescriptor = getImageDescriptor();
		if (iconDescriptor != null) {
			element.setIcon(iconDescriptor);
		}
	}

	protected abstract String getLabel();

	protected ImageDescriptor getImageDescriptor() {
		return null;
	}

}
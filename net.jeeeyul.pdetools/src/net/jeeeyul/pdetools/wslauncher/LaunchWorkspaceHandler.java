package net.jeeeyul.pdetools.wslauncher;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.internal.ide.ChooseWorkspaceData;
import org.eclipse.ui.internal.ide.ChooseWorkspaceDialog;
import org.eclipse.ui.menus.UIElement;

@SuppressWarnings("restriction")
public class LaunchWorkspaceHandler extends AbstractHandler implements IHandler, IElementUpdater {
	public static final String COMMNAD_ID = "net.jeeeyul.pdetools.wslauncher.launchworkspace";
	public static final String PARAM_WORKSPACE = "workspace";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String workspace = event.getParameter(PARAM_WORKSPACE);
		if (workspace == null) {
			ChooseWorkspaceData data = new ChooseWorkspaceData(Platform.getInstanceLocation().getURL());
			ChooseWorkspaceDialog dialog = new ChooseWorkspaceDialog(Display.getDefault().getActiveShell(), data, true,
					true);
			if (dialog.open() == IDialogConstants.OK_ID) {
				workspace = data.getSelection();
			} else {
				return null;
			}
		}

		LaunchCommandFactory factory = new LaunchCommandFactory();
		try {
			String[] command = factory.createCommand(workspace);
			Runtime.getRuntime().exec(command);
		} catch (UnsupportedOperationException uoe) {

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateElement(UIElement element, @SuppressWarnings("rawtypes") Map parameters) {
		String workspace = (String) parameters.get(PARAM_WORKSPACE);
		if (workspace != null) {
			element.setText(workspace);
		} else {
			element.setText("Other...");
		}
	}

}

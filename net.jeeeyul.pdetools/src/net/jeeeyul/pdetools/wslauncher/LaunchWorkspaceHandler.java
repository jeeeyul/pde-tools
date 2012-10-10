package net.jeeeyul.pdetools.wslauncher;

import java.io.File;
import java.text.MessageFormat;
import java.util.Map;

import net.jeeeyul.pdetools.PDEToolsCore;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
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
		String dirStr = Platform.getInstallLocation().getURL().toExternalForm();
		if (dirStr.startsWith("file:/")) {
			dirStr = dirStr.substring(6);
			if (Platform.getOS().equals(Platform.OS_LINUX)) {
				dirStr = "/" + dirStr;
			}
		}
		File dir = new File(dirStr);
		System.out.println(dir.exists());

		try {
			LaunchCommand command = factory.createCommand(workspace);
			try {
				command.execute();
			} catch (Exception e) {
				IStatus error =  new Status(IStatus.ERROR, PDEToolsCore.PLUGIN_ID, e.getLocalizedMessage() , e);
				ErrorDialog.openError(Display.getDefault().getActiveShell(), "Error", MessageFormat.format("Could not execute \"{0}\"", command), error);
			}
		} catch (UnsupportedOperationException uoe) {
			IStatus error =  new Status(IStatus.ERROR, PDEToolsCore.PLUGIN_ID, uoe.getLocalizedMessage() , uoe);
			ErrorDialog.openError(Display.getDefault().getActiveShell(), "Error", MessageFormat.format("{0} is not supported.", Platform.getOS()), error);
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

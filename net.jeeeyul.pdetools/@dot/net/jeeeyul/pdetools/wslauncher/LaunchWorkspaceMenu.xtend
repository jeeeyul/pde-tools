package net.jeeeyul.pdetools.wslauncher

import java.util.ArrayList
import java.util.HashMap
import org.eclipse.core.filesystem.EFS
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Platform
import org.eclipse.jface.action.IContributionItem
import org.eclipse.jface.action.Separator
import org.eclipse.swt.SWT
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.actions.CompoundContributionItem
import org.eclipse.ui.internal.ide.ChooseWorkspaceData
import org.eclipse.ui.menus.CommandContributionItem
import org.eclipse.ui.menus.CommandContributionItemParameter

class LaunchWorkspaceMenu extends CompoundContributionItem {
	new() {
	}

	override protected getContributionItems() {
		var result = new ArrayList<IContributionItem>

		var data = new ChooseWorkspaceData(Platform::instanceLocation.URL);

		var root = ResourcesPlugin::workspace.root
		var file = EFS::getStore(root.locationURI).toLocalFile(0, new NullProgressMonitor());
		var currentWorkspace = file.absolutePath

		for (each : data.recentWorkspaces) {
			if (each != null && each != currentWorkspace) {
				var param = new CommandContributionItemParameter(PlatformUI::workbench, each,
					LaunchWorkspaceHandler::COMMNAD_ID, SWT::PUSH)
				param.parameters = new HashMap<String, String> => [
					put(LaunchWorkspaceHandler::PARAM_WORKSPACE, each)
				]
				result += new CommandContributionItem(param)
			}
		}

		if (!result.empty) {
			result += new Separator()
		}

		return result
	}

}

package net.jeeeyul.pdetools.wslauncher

import org.eclipse.ui.actions.CompoundContributionItem
import org.eclipse.core.runtime.Platform
import org.eclipse.ui.internal.ide.ChooseWorkspaceData
import java.util.ArrayList
import org.eclipse.jface.action.IContributionItem
import org.eclipse.ui.menus.CommandContributionItemParameter
import org.eclipse.ui.PlatformUI
import org.eclipse.swt.SWT
import java.util.HashMap
import org.eclipse.ui.menus.CommandContributionItem
import org.eclipse.jface.action.Separator

class LaunchWorkspaceMenu extends CompoundContributionItem {
	new(){
	}

	override protected getContributionItems() {
		var result = new ArrayList<IContributionItem>
		
		var data = new ChooseWorkspaceData(Platform::instanceLocation.URL);
		
		for(each : data.recentWorkspaces){
			if(each != null){
				var param = new CommandContributionItemParameter(PlatformUI::workbench, each, LaunchWorkspaceHandler::COMMNAD_ID, SWT::PUSH)
				param.parameters = new HashMap<String, String> => [
					put(LaunchWorkspaceHandler::PARAM_WORKSPACE, each)
				]
				result += new CommandContributionItem(param)
			}
		}
		
		if(!result.empty){
			result += new Separator()
		}
		
		return result
	}
	
}
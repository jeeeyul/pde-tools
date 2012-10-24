package net.jeeeyul.pdetools.shell

import java.io.File
import net.jeeeyul.pdetools.shared.LaunchCommand
import net.jeeeyul.pdetools.shared.SharedImages

class ShowInShellWin32Handler extends AbstractShowInShellHandler{
	override protected getLabel() {
		"Show in Explorer"
	}
	
	override protected getImageDescriptor() {
		SharedImages::getImageDescriptor(SharedImages::EXPLORER)
	}

	override public createLaunchCommand(File targetFile) {
		new LaunchCommand() => [
			envMap.put("pde_tools_target_file", '''/select,"«targetFile.absolutePath»"'''.toString)
			
			commands += "cmd"
			commands += "/c"
			commands += "C:/windows/explorer"
			commands += "%pde_tools_target_file%"
		]
	}
}
package net.jeeeyul.pdetools.shell

import java.io.File
import java.util.List
import net.jeeeyul.pdetools.shared.SharedImages

class ShowInShellWin32Handler extends AbstractShowInShellHandler{
	override protected fillCommand(List<String> command, File file) {
		command += "explorer"
		command += '''/select,"«file.absolutePath»"'''.toString
	}

	override protected getLabel() {
		"Show in Explorer"
	}
	
	override protected getImageDescriptor() {
		SharedImages::getImageDescriptor(SharedImages::EXPLORER)
	}
	
}
package net.jeeeyul.pdetools.shell

import java.io.File
import java.util.List

class ShowInShellWin32Handler extends AbstractShowInShellHandler{
	override protected fillCommand(List<String> command, File file) {
		command += "explorer"
		command += "/select"
		command += file.absolutePath
	}
	
}
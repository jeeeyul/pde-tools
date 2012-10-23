package net.jeeeyul.pdetools.shell

import java.io.File
import java.util.List
import org.eclipse.ui.commands.IElementUpdater
import net.jeeeyul.pdetools.shared.SharedImages

class ShowInShellOSXHandler extends AbstractShowInShellHandler implements IElementUpdater {
	override protected fillCommand(List<String> command, File file) {
		command += "osascript"
		command += "-e"
		command += '''tell app "Finder" to activate reveal Posix file "«file.absolutePath»"'''.toString
		
	}

	override protected getLabel() {
		"Reveal in Finder"
	}
	
	override protected getImageDescriptor() {
		SharedImages::getImageDescriptor(SharedImages::FINDER)
	}
}
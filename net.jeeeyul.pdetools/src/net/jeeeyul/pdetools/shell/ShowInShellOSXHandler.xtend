package net.jeeeyul.pdetools.shell

import java.io.File
import net.jeeeyul.pdetools.shared.LaunchCommand
import net.jeeeyul.pdetools.shared.SharedImages
import org.eclipse.ui.commands.IElementUpdater

class ShowInShellOSXHandler extends AbstractShowInShellHandler implements IElementUpdater {
	override protected getLabel() {
		"Reveal in Finder"
	}
	
	override protected getImageDescriptor() {
		SharedImages::getImageDescriptor(SharedImages::FINDER)
	}

	override public createLaunchCommand(File targetFile) {
		new LaunchCommand() => [
			commands += "osascript"
			commands += "-e"
			commands += '''tell app "Finder" to activate reveal Posix file "«targetFile.absolutePath»"'''.toString
		]
	}
	
}
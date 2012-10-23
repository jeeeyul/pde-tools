package net.jeeeyul.pdetools.shell

import java.io.File
import java.util.List
import org.eclipse.ui.commands.IElementUpdater
import java.util.Map
import org.eclipse.ui.menus.UIElement

class ShowInShellOSXHandler extends AbstractShowInShellHandler implements IElementUpdater {
	override protected fillCommand(List<String> command, File file) {
		command += "osascript"
		command += "-e"
		command += '''tell app "Finder" to activate reveal Posix file "«file.absolutePath»"'''.toString
		
	}

	override updateElement(UIElement element, Map parameters) {
		element.setText("Reveal in Finder")
	}
	
}
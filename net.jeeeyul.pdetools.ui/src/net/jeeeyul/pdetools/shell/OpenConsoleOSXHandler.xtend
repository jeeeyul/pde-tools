package net.jeeeyul.pdetools.shell

import net.jeeeyul.pdetools.shell.AbstractFileBasedExecHandler
import java.io.File
import net.jeeeyul.pdetools.shared.LaunchCommand

class OpenConsoleOSXHandler extends AbstractFileBasedExecHandler {
	override createLaunchCommand(File targetFile) {
		new LaunchCommand() => [
			commands += "open"
			commands += "-a"
			commands += "/Applications/Utilities/Terminal.app"
			commands += targetFile.ensureDirectory.absolutePath
		]
	}
	
	override protected getLabel() {
		"Open Terminal Here"
	}
}
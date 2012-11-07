package net.jeeeyul.pdetools.shell

import net.jeeeyul.pdetools.shell.AbstractFileBasedExecHandler
import java.io.File
import net.jeeeyul.pdetools.shared.LaunchCommand

class OpenConsoleLinuxHandler extends AbstractFileBasedExecHandler {
	override createLaunchCommand(File targetFile) {
		new LaunchCommand() => [
			commands += "open"
			commands += "-n"
			commands += "/Applications/Utilities/Terminal.app"
			commands += "--args"
			commands += targetFile.ensureDirectory.absolutePath
		]
	}
	
	override protected getLabel() {
		"Open Terminal Here"
	}
}
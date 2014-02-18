package net.jeeeyul.pdetools.shell

import net.jeeeyul.pdetools.shell.AbstractFileBasedExecHandler
import java.io.File
import net.jeeeyul.pdetools.shared.LaunchCommand

class OpenConsoleLinuxHandler extends AbstractFileBasedExecHandler {
	override createLaunchCommand(File targetFile) {
		new LaunchCommand() => [
			commands += "/bin/bash"
			commands += "-c"
			commands += '''gnome-terminal --working-directory="«targetFile.ensureDirectory.absolutePath»"'''.toString
			
		]
	}
	
	override protected getLabel() {
		"Open Terminal Here"
	}
}
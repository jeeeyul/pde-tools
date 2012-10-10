package net.jeeeyul.pdetools.wslauncher

import java.util.List
import java.util.ArrayList
import java.io.File
import java.io.IOException

class LaunchCommand {
	@Property List<String> commands = new ArrayList()
	@Property File launchDir
	
	def void execute() throws IOException{
		Runtime::runtime.exec(commands, null, launchDir)
	}
	
	override String toString(){
		commands.join(" ")
	}
}
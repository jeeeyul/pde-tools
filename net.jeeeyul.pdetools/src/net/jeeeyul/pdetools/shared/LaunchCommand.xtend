package net.jeeeyul.pdetools.shared

import java.util.List
import java.util.ArrayList
import java.io.File
import java.io.IOException
import java.util.Map
import java.util.HashMap

class LaunchCommand {
	@Property List<String> commands = new ArrayList()
	@Property File launchDir
	@Property Map<String, String> envMap = new HashMap()
	
	def void execute() throws IOException{
		var builder = new ProcessBuilder(commands)
		builder.directory(launchDir)
		builder.environment.putAll(envMap)
		builder.start()
	}
	
	override String toString(){
		commands.map[
			if(it.matches("%.+%")){
				var key = it.subSequence(1, it.length - 1)
				if(envMap.containsKey(key)){
					return envMap.get(key)	
				}
			}
			
			return it
		].join(" ")
	}
}
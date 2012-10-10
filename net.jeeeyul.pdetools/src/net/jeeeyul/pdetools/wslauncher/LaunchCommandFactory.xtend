package net.jeeeyul.pdetools.wslauncher

import java.util.ArrayList
import org.eclipse.core.runtime.Platform

class LaunchCommandFactory {
	def String[] createCommand(String workspace){
		var result = new ArrayList<String>
		
		switch(Platform::OS){
			case Platform::OS_WIN32:{
				var command = Platform::installLocation.URL.toExternalForm + "eclipse.exe"
				if(command.startsWith("file:/")){
					command = command.substring(6)
				}
				
				result += command
			}
			
			
			case Platform::OS_MACOSX:{
				result += "open"
				result += "-n"
				result += Platform::installLocation.URL.toString + "Eclipse.app"
				result += "--args"
			}
			
			default:
				throw new UnsupportedOperationException()
		}
		
		result += "-data"
		result += workspace
		
		println(result.join(" "))
				
		return result
	}
	
}
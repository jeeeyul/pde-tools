package net.jeeeyul.pdetools.wslauncher

import java.util.ArrayList
import org.eclipse.core.runtime.Platform

class LaunchCommandFactory {
	def String[] createCommand(String workspace){
		var result = new ArrayList<String>
		
		switch(Platform::OS){
			case Platform::OS_WIN32:{
				result += "eclipse.exe"
				result += "-data"
				result += workspace
			}
			
			case Platform::OS_MACOSX:{
				result += "open"
				result += "-n"
				result += "Eclipse.app"
				result += "--args"
				result += "-data"
				result += workspace
			}
			
			case Platform::OS_LINUX:{
				result +="/bin/bash"
				result +="-c"
				result += '''./eclipse -data «workspace»'''.toString
			}

			default:
				throw new UnsupportedOperationException()
		}
		
		
		
		println(result.join(" "))
				
		return result
	}
	
}
package net.jeeeyul.pdetools.wslauncher

import java.util.ArrayList
import org.eclipse.core.runtime.Platform

class LaunchCommandFactory {
	def String[] createCommand(String workspace){
		var result = new ArrayList<String>
		
		switch(Platform::OS){
			case Platform::OS_WIN32:{
				result += "eclipse.exe"
			}
			
			case Platform::OS_MACOSX:{
				result += "open"
				result += "-n"
				result += "Eclipse.app"
				result += "--args"
			}
			
			case Platform::OS_LINUX:{
				result +="./eclipse"
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
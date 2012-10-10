package net.jeeeyul.pdetools.wslauncher

import static org.eclipse.core.runtime.Platform.*
import java.io.File

class LaunchCommandFactory {
	def LaunchCommand createCommand(String workspace) throws UnsupportedOperationException{
		var result = new LaunchCommand() =>[
			var dirStr = installLocation.URL.toExternalForm
			
			if(dirStr.startsWith("file:/")){
				dirStr = dirStr.substring(6);
			}

			switch(OS){
				case OS_WIN32:{
					commands += "eclipse.exe"
					commands += "-data"
					commands += workspace
				}
				
				case OS_MACOSX:{
					dirStr = "/" + dirStr
					
					commands += "open"
					commands += "-n"
					commands += "Eclipse.app"
					commands += "--args"
					commands += "-data"
					commands += workspace
				}
				
				case OS_LINUX:{
					dirStr = "/" + dirStr
					
					commands +="/bin/bash"
					commands +="-c"
					commands += '''./eclipse -data «workspace»'''.toString
				}
	
				default:
					throw new UnsupportedOperationException()
			}
			
			launchDir = new File(dirStr)	
		]

		println(result)
				
		return result
	}
	
}
package net.jeeeyul.pdetools.wslauncher

import static org.eclipse.core.runtime.Platform.*
import java.io.File

class LaunchCommandFactory {
	def LaunchCommand createCommand(String workspace) throws UnsupportedOperationException{
		var result = new LaunchCommand() =>[
			launchDir = new File(installLocation.URL.file)
						
			switch(OS){
				case OS_WIN32:{
					commands += "eclipse.exe"
					commands += "-data"
					commands += workspace
				}
				
				case OS_MACOSX:{
					commands += "open"
					commands += "-n"
					commands += "Eclipse.app"
					commands += "--args"
					commands += "-data"
					commands += workspace
				}
				
				case OS_LINUX:{
					commands +="/bin/bash"
					commands +="-c"
					commands += '''./eclipse -data «workspace»'''.toString
				}
	
				default:
					throw new UnsupportedOperationException()
			}
		]

		println(result)
				
		return result
	}
	
}
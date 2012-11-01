package net.jeeeyul.pdetools.wslauncher

import java.io.File

import static org.eclipse.core.runtime.Platform.*
import net.jeeeyul.pdetools.shared.LaunchCommand
import net.jeeeyul.pdetools.Debug

class LaunchCommandFactory {
	def LaunchCommand createCommand(String workspace) throws UnsupportedOperationException{
		var result = new LaunchCommand() =>[
			launchDir = new File(installLocation.URL.file)
			envMap.putAll(System::getenv())
			switch(OS){
				case OS_WIN32:{
					envMap.put("PDE_TOOLS_WORKSPACE", '''"«workspace»"''')
					commands += "cmd"
					commands += "/c"
					commands += launcher.name
					commands += "-data"
					commands += "%PDE_TOOLS_WORKSPACE%"
				}
				
				case OS_MACOSX:{
					commands += "open"
					commands += "-n"
					commands += launcher.name
					commands += "--args"
					commands += "-data"
					commands += workspace
				}
				
				case OS_LINUX:{
					commands += "/bin/bash"
					commands += "-c"
					commands += '''./«launcher.name» -data "«workspace»"'''.toString
				}
	
				default:
					throw new UnsupportedOperationException()
			}
		]

		Debug::println(result)
		return result
	}
	
	def File getLauncher(){
		var result = new File(System::getProperty("eclipse.launcher"))
		if(OS == OS_MACOSX){
			result = result.parentFile.parentFile.parentFile
		}
		return result
	}
	
}
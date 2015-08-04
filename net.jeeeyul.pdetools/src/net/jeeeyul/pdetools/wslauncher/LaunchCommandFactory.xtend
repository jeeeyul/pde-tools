package net.jeeeyul.pdetools.wslauncher

import java.io.File

import static org.eclipse.core.runtime.Platform.*
import net.jeeeyul.pdetools.shared.LaunchCommand
import net.jeeeyul.pdetools.Debug
import net.jeeeyul.pdetools.PDEToolsCore

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
					
					if(hasToClearPersistedState){
						commands += "-clearPersistedState"
					}
				}
				
				case OS_MACOSX:{
					commands += "open"
					commands += "-n"
					commands += launcher.absolutePath
					commands += "--args"
					commands += "-data"
					commands += workspace
					
					if(hasToClearPersistedState){
						commands += "-clearPersistedState"
					}
				}
				
				case OS_LINUX:{
					commands += "/bin/bash"
					commands += "-c"
					commands += '''./«launcher.name» -data "«workspace»"«IF hasToClearPersistedState» -clearPersistedState«ENDIF»'''.toString
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
			while(!result.name.endsWith(".app")){
				result = result.parentFile;
			}
		}
		return result
	}
	
	def boolean hasToClearPersistedState(){
		PDEToolsCore::^default.preferenceStore.getBoolean(IWSLauncherPreferernceConstants::CLEAR_PERSISTED_STATE)
	}
}
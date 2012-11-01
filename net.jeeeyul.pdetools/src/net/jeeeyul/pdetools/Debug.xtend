 package net.jeeeyul.pdetools

import org.eclipse.core.runtime.Platform
import net.jeeeyul.pdetools.shared.DebugStream

class Debug {
	private static val debugStream = new DebugStream()

	def static void println(Object o){
		if(hasToShowDebug){
			debugStream.println(o)
		}
	}
	
	def static void println(int o){
		if(hasToShowDebug){
			debugStream.println(o)
		}
	}
	
	def static void println(String o){
		if(hasToShowDebug){
			debugStream.println(o)
		}
	}
	
	def static void println(boolean o){
		if(hasToShowDebug){
			debugStream.println(o)
		}
	}
	
	def static boolean hasToShowDebug(){
		if(!PDEToolsCore::^default.debugging){
			return false
		}
		return "true".equalsIgnoreCase(Platform::getDebugOption("net.jeeeyul.pdetools/debug"))
	}
}
 package net.jeeeyul.pdetools

import net.jeeeyul.pdetools.shared.DebugStream

import static net.jeeeyul.pdetools.Debug.*

class Debug {
	private static val DEBUG_STREAM = new DebugStream()
	private static boolean DEBUG = PDEToolsCore::^default.debugging
	def static void println(Object o){
		if(DEBUG){
			DEBUG_STREAM.println(o)
		}
	}
	
	def static void println(int o){
		if(DEBUG){
			DEBUG_STREAM.println(o)
		}
	}
	
	def static void println(String o){
		if(DEBUG){
			DEBUG_STREAM.println(o)
		}
	}
	
	def static void println(boolean o){
		if(DEBUG){
			DEBUG_STREAM.println(o)
		}
	}
	
}
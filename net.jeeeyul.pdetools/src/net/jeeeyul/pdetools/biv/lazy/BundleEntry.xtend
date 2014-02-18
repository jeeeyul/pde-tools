package net.jeeeyul.pdetools.biv.lazy

import java.util.List
import org.eclipse.xtend.lib.Property
import org.osgi.framework.Bundle

class BundleEntry {
	public static val int UNRESOLVED = 0
	public static val int RESOLVING = 1
	public static val int RESOLVED = 2
	
	@Property Bundle bundle
	@Property List<URLImageEntry> entries
	@Property int state		
	
	def boolean isResolved(){
		this.state == RESOLVED
	}
}
package net.jeeeyul.pdetools.biv.lazy

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.osgi.framework.Bundle

class BundleEntry {
	public static val int UNRESOLVED = 0
	public static val int RESOLVING = 1
	public static val int RESOLVED = 2
	
	@Accessors Bundle bundle
	@Accessors List<URLImageEntry> entries
	@Accessors int state		
	
	def boolean isResolved(){
		this.state == RESOLVED
	}
}
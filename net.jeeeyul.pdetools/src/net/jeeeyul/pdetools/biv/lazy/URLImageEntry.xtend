package net.jeeeyul.pdetools.biv.lazy

import java.net.URL
import org.eclipse.xtend.lib.Property

class URLImageEntry {
	@Property BundleEntry parent
	@Property URL url
	@Property int width = -1
	@Property int height = -1
	
	new(BundleEntry parent, URL url){
		this.parent = parent
		this.url = url
	}
}
package net.jeeeyul.pdetools.biv.lazy

import java.net.URL
import org.eclipse.xtend.lib.annotations.Accessors

class URLImageEntry {
	@Accessors BundleEntry parent
	@Accessors URL url
	@Accessors int width = -1
	@Accessors int height = -1
	
	new(BundleEntry parent, URL url){
		this.parent = parent
		this.url = url
	}
}
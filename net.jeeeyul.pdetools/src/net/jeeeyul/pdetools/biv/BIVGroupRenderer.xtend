package net.jeeeyul.pdetools.biv

import org.eclipse.nebula.widgets.gallery.DefaultGalleryGroupRenderer
import org.eclipse.nebula.widgets.gallery.GalleryItem
import org.eclipse.swt.graphics.GC
import org.osgi.framework.Bundle

class BIVGroupRenderer extends DefaultGalleryGroupRenderer {
	override protected getGroupTitle(GalleryItem group) {
		return group.text
	}

	override layout(GC gc, GalleryItem group) {
		super.layout(gc, group)
		var Bundle bundle = group.data as Bundle
		if(bundle != null){
			group.setText(1, bundle.symbolicName)
		}
	}
		
}
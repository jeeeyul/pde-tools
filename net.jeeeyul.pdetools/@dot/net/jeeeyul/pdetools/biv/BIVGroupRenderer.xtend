package net.jeeeyul.pdetools.biv

import net.jeeeyul.pdetools.biv.lazy.BundleEntry
import org.eclipse.nebula.widgets.gallery.DefaultGalleryGroupRenderer
import org.eclipse.nebula.widgets.gallery.GalleryItem
import org.eclipse.swt.graphics.GC

class BIVGroupRenderer extends DefaultGalleryGroupRenderer {
	override protected getGroupTitle(GalleryItem group) {
		return group.text
	}

	override layout(GC gc, GalleryItem group) {
		super.layout(gc, group)
		var BundleEntry bundle = group.data as BundleEntry
		if(bundle != null){
			group.setText(1, bundle.bundle.symbolicName)
		}
	}
		
}
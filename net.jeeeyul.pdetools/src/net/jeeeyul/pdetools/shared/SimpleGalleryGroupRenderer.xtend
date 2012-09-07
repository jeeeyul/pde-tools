package net.jeeeyul.pdetools.shared

import org.eclipse.nebula.widgets.gallery.DefaultGalleryGroupRenderer
import org.eclipse.nebula.widgets.gallery.GalleryItem

class SimpleGalleryGroupRenderer extends DefaultGalleryGroupRenderer {
	override protected getGroupTitle(GalleryItem group) {
		return group.text
	}
	
	override protected getGroupHeight(GalleryItem group) {
		super.getGroupHeight(group)
	}
	
}
package net.jeeeyul.pdetools.snapshot;

import org.eclipse.nebula.widgets.gallery.DefaultGalleryItemRenderer;
import org.eclipse.nebula.widgets.gallery.GalleryItem;
import org.eclipse.swt.graphics.GC;

public class SafeItemRenderer extends DefaultGalleryItemRenderer{
	@Override
	public void draw(GC gc, GalleryItem item, int index, int x, int y, int width, int height) {
		if(item.isDisposed() || item.getImage() == null || item.getImage().isDisposed()){
			return;
		}
		super.draw(gc, item, index, x, y, width, height);
	}
}

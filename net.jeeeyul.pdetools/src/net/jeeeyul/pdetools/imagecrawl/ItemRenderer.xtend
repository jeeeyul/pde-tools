package net.jeeeyul.pdetools.imagecrawl

import org.eclipse.nebula.widgets.gallery.AbstractGalleryItemRenderer
import org.eclipse.nebula.widgets.gallery.GalleryItem
import org.eclipse.swt.graphics.GC
import org.eclipse.swt.graphics.Rectangle
import net.jeeeyul.pdetools.shared.SWTExtensions
import org.eclipse.swt.graphics.Point
import org.eclipse.nebula.widgets.gallery.RendererHelper
import org.eclipse.swt.SWT

class ItemRenderer extends AbstractGalleryItemRenderer {
	extension SWTExtensions = SWTExtensions::INSTANCE

	@Property int margin = 4;
	@Property int selectionMargin = 2;

	override dispose() {
	}
	
	override draw(GC gc, GalleryItem item, int index, int x, int y, int width, int height) {
		if(item.image == null){
			return;
		}
		
		val clientArea = new Rectangle(x, y, width, height);
		
		if(isSelected){
			gc.background = item.display.getSystemColor(SWT::COLOR_LIST_SELECTION)
			var selectionBounds = clientArea.copy.translate(selectionMargin, selectionMargin).expand(-selectionMargin * 2, -selectionMargin * 2)
			gc.fillRoundRectangle(selectionBounds, 14)
		}
		
		val bounds = clientArea.getTranslated(margin, margin).expand(-margin*2, -margin*2)
		val size = getBestSize(item.image.bounds.size, bounds.size)
		val sizeDelta = size.getDiference(bounds.size).getScaled(0.5)
		
		var targetArea = new Rectangle(0, 0, 0, 0) => [
			it.location = bounds.location.getTranslated(sizeDelta)
			it.size = size
		]
		
		gc.drawImage(item.image, item.image.bounds, targetArea)			
	}
	
	def Point getBestSize(Point imageSize, Point maxSize){
		if(imageSize.x <= maxSize.x && imageSize.y <= maxSize.y){
			return imageSize.getCopy()
		}
		RendererHelper::getBestSize(imageSize.x, imageSize.y, maxSize.x, maxSize.y)		
	}
	
	
}
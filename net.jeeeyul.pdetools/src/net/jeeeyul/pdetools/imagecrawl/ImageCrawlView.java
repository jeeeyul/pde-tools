package net.jeeeyul.pdetools.imagecrawl;

import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.nebula.widgets.gallery.DefaultGalleryGroupRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ImageCrawlView extends ViewPart {
	public static final String ID = "net.jeeeyul.pdetools.imagecrawl.ImageCrawlView";
	private GalleryTreeViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		viewer = new GalleryTreeViewer(parent, SWT.MULTI | SWT.V_SCROLL);
		viewer.getGallery().setItemRenderer(new ItemRenderer());
		DefaultGalleryGroupRenderer groupRenderer = (DefaultGalleryGroupRenderer) viewer.getGallery().getGroupRenderer();
		groupRenderer.setItemSize(64, 64);
		viewer.setContentProvider(new ImageCrawlContentProvider());
		viewer.setLabelProvider(new ImageCrawlLabelProvider());
		viewer.setInput(Object.class);

		new DragImageSupport(viewer);
	}

	@Override
	public void setFocus() {

	}

}

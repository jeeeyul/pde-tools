package net.jeeeyul.pdetools.biv.lazy;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;

import net.jeeeyul.pdetools.shared.ImageLoadingEntry;
import net.jeeeyul.pdetools.shared.ImageLoadingQueue;
import net.jeeeyul.pdetools.shared.SWTExtensions;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.nebula.widgets.gallery.RendererHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osgi.framework.Constants;

public class BundleImageLabelProvider extends LabelProvider {
	private ImageLoadingQueue<URLImageEntry> queue;
	private ImageRegistry registry;
	private HashSet<URLImageEntry> invalidURLs;

	public BundleImageLabelProvider() {
		invalidURLs = new HashSet<URLImageEntry>();

		queue = new ImageLoadingQueue<URLImageEntry>();
		queue.setImageLoader(new Function1<URLImageEntry, ImageData>() {
			@Override
			public ImageData apply(URLImageEntry p) {
				ImageData imageData = ImageDescriptor.createFromURL(p.getUrl()).getImageData();
				Point imageSize = SWTExtensions.INSTANCE.getSize(imageData);
				Point maxSize = new Point(32, 32);
				if (!SWTExtensions.INSTANCE.contains(maxSize, imageSize)) {
					Point bestSize = getBestSize(imageSize, maxSize);
					return imageData.scaledTo(bestSize.x, bestSize.y);
				} else {
					return imageData;
				}
			}
		});

		queue.setLoadHandler(new Procedure1<List<ImageLoadingEntry<URLImageEntry>>>() {
			@Override
			public void apply(List<ImageLoadingEntry<URLImageEntry>> p) {
				handleLoad(p);
			}
		});

		registry = new ImageRegistry();
	}

	private Point getBestSize(Point imageSize, Point maxSize) {
		if (imageSize.x <= maxSize.x && imageSize.y <= maxSize.y) {
			return imageSize;
		}
		return RendererHelper.getBestSize(imageSize.x, imageSize.y, maxSize.x, maxSize.y);
	}

	protected void handleLoad(List<ImageLoadingEntry<URLImageEntry>> p) {
		for (ImageLoadingEntry<URLImageEntry> each : p) {
			try {
				if (each.image != null) {
					registry.put(each.key.toString(), ImageDescriptor.createFromImageData(each.image));
					each.key.setWidth(each.image.width);
					each.key.setHeight(each.image.height);
				} else {
					invalidURLs.add(each.key);
				}
			} catch (Exception e) {

			}
		}

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				fireLabelProviderChanged(new LabelProviderChangedEvent(BundleImageLabelProvider.this));
			}
		});

	}

	@Override
	public void dispose() {
		queue.cancel();
		invalidURLs.clear();
		registry.dispose();
		super.dispose();
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof URLImageEntry) {
			URLImageEntry imageURLEntry = (URLImageEntry) element;

			if (invalidURLs.contains(imageURLEntry)) {
				return SharedImages.getImage(SharedImages.INVAILD);
			}

			Image result = registry.get(imageURLEntry.toString());
			if (result == null) {
				queue.add(imageURLEntry);
				return SharedImages.getImage(SharedImages.REFRESH);
			} else {
				return result;
			}
		} else {
			return null;
		}
	}

	@Override
	public String getText(Object element) {
		if (element instanceof BundleEntry) {
			BundleEntry be = (BundleEntry) element;
			String label = be.getBundle().getHeaders().get(Constants.BUNDLE_NAME);
			if (be.getState() == BundleEntry.RESOLVING) {
				label += " (Expanding)";
			}
			return label;
		}

		else if (element instanceof URLImageEntry) {
			URLImageEntry urlImageEntry = (URLImageEntry) element;
			String result = new Path(urlImageEntry.getUrl().toString()).lastSegment();

			if (urlImageEntry.getWidth() >= 0 && urlImageEntry.getHeight() >= 0) {
				result += MessageFormat.format(" - {0}x{1}", urlImageEntry.getWidth(), urlImageEntry.getHeight());
			}
			return result;
		}

		else {
			return "Unknown";
		}
	}

}

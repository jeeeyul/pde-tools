package net.jeeeyul.pdetools.biv;

import java.net.URL;
import java.util.HashSet;
import java.util.List;

import net.jeeeyul.pdetools.shared.ImageLoadingEntry;
import net.jeeeyul.pdetools.shared.ImageLoadingQueue;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

public class BundleImageLabelProvider extends LabelProvider {
	private ImageLoadingQueue<URL> queue;
	private ImageRegistry registry;
	private HashSet<URL> invalidURLs;

	public BundleImageLabelProvider() {
		invalidURLs = new HashSet<URL>();

		queue = new ImageLoadingQueue<URL>();
		queue.setImageLoader(new Function1<URL, ImageData>() {
			@Override
			public ImageData apply(URL p) {
				return ImageDescriptor.createFromURL(p).getImageData();
			}
		});

		queue.setLoadHandler(new Procedure1<List<ImageLoadingEntry<URL>>>() {
			@Override
			public void apply(List<ImageLoadingEntry<URL>> p) {
				handleLoad(p);
			}
		});

		registry = new ImageRegistry();
	}

	protected void handleLoad(List<ImageLoadingEntry<URL>> p) {
		for (ImageLoadingEntry<URL> each : p) {
			try {
				if (each.image != null) {
					registry.put(each.key.toString(), ImageDescriptor.createFromImageData(each.image));
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
		if (element instanceof URL) {
			URL url = (URL) element;

			if (invalidURLs.contains(url)) {
				return SharedImages.getImage(SharedImages.INVAILD);
			}

			Image result = registry.get(url.toString());
			if (result == null) {
				queue.add(url);
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
		if (element instanceof Bundle) {
			Bundle bundle = (Bundle) element;
			return bundle.getHeaders().get(Constants.BUNDLE_NAME);
		} else if (element instanceof URL) {
			URL url = (URL) element;
			String fileName = new Path(url.toString()).lastSegment();
			return fileName;
		} else {
			return "Unkown";
		}
	}

}

package net.jeeeyul.pdetools.imagecrawl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

import net.jeeeyul.pdetools.PDEToolsCore;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.osgi.framework.Bundle;

public class ImageCrawlContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public Object[] getElements(Object inputElement) {
		return PDEToolsCore.getDefault().getBundle().getBundleContext().getBundles();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		ArrayList<Object> result = new ArrayList<Object>();
		if (parentElement instanceof Bundle) {
			Bundle bundle = (Bundle) parentElement;
			Enumeration<URL> iter = bundle.findEntries("/", "*.gif", true);
			while (iter != null && iter.hasMoreElements()) {
				result.add(iter.nextElement());
			}
			
			iter = bundle.findEntries("/", "*.png", true);
			while (iter != null && iter.hasMoreElements()) {
				result.add(iter.nextElement());
			}
			
			iter = bundle.findEntries("/", "*.bmp", true);
			while (iter != null && iter.hasMoreElements()) {
				result.add(iter.nextElement());
			}
			
			iter = bundle.findEntries("/", "*.jpg", true);
			while (iter != null && iter.hasMoreElements()) {
				result.add(iter.nextElement());
			}
		}
		return result.toArray();
	}

	@Override
	public Object getParent(Object element) {
		if(element instanceof URL){
			URL url = (URL) element;

			// bundleentry://423.fwk1652180105/icons/obj16/int_obj.gif
			IPath path = new Path(url.toExternalForm());
			long bundleId = Long.parseLong(path.segment(0).split("\\.")[0]);
			
			return PDEToolsCore.getDefault().getBundle().getBundleContext().getBundle(bundleId);
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

}

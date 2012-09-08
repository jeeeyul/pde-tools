package net.jeeeyul.pdetools.biv;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

import net.jeeeyul.pdetools.PDEToolsCore;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.osgi.framework.Bundle;

public class BundleImageContentProvider implements ITreeContentProvider {

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
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

}

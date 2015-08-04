package net.jeeeyul.pdetools.clipboard.internal;

import net.jeeeyul.pdetools.clipboard.ClipboardWorkbecnAdapter;
import net.jeeeyul.pdetools.model.pdetools.ClipboardElement;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class ClipboardWorkbenchAdapterFactory implements IAdapterFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if (adaptableObject instanceof ClipboardElement && adapterType == IWorkbenchAdapter.class) {
			return ClipboardWorkbecnAdapter.INSTANCE;
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IWorkbenchAdapter.class };
	}

}

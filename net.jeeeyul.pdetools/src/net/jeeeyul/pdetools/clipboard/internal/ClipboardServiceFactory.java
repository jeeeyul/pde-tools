package net.jeeeyul.pdetools.clipboard.internal;

import net.jeeeyul.pdetools.clipboard.IClipboardService;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

public class ClipboardServiceFactory extends AbstractServiceFactory {

	public ClipboardServiceFactory() {
	}

	@Override
	public Object create(@SuppressWarnings("rawtypes") Class serviceInterface, IServiceLocator parentLocator,
			IServiceLocator locator) {
		if (serviceInterface == IClipboardService.class) {
			return ClipboardServiceImpl.getInstance();
		}
		return null;
	}

}

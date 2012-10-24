package net.jeeeyul.pdetools.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.PlatformUI;

public class WorkbenchProvider extends AbstractSourceProvider {

	public WorkbenchProvider() {
	}

	@Override
	public void dispose() {

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getCurrentState() {
		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put("net.jeeeyul.pdetools.workbench", PlatformUI.getWorkbench());
		return result;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] { "net.jeeeyul.pdetools.workbench" };
	}

}

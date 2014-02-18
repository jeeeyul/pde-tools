package net.jeeeyul.pdetools.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.PlatformUI;

public class CoreExpressionSourceProvider extends AbstractSourceProvider {

	public CoreExpressionSourceProvider() {
	}

	@Override
	public void dispose() {

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getCurrentState() {
		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put("net.jeeeyul.pdetools.workbench", PlatformUI.getWorkbench());
		result.put("net.jeeeyul.pdetools.platform", Platform.class);
		return result;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] { "net.jeeeyul.pdetools.workbench", "net.jeeeyul.pdetools.platform" };
	}

}

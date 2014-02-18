package net.jeeeyul.pdetools.commandspy;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;

public class ToggleGlobalCommandSpyHandler extends AbstractHandler implements IElementUpdater {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		GlobalCommandSpy spy = GlobalCommandSpy.getInstance();
		if (spy.isSpying()) {
			spy.stop();
		} else {
			spy.start();
		}
		return null;
	}

	@Override
	public void updateElement(UIElement element, @SuppressWarnings("rawtypes") Map parameters) {
		element.setChecked(GlobalCommandSpy.getInstance().isSpying());
	}

}

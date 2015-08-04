package net.jeeeyul.pdetools.snapshot;

import net.jeeeyul.pdetools.snapshot.capture.SnapshotHook;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

public class TakeScreenShotHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		new SnapshotHook(Display.getDefault()).start();
		return null;
	}

}

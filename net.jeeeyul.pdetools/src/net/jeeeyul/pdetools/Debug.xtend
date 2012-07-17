package net.jeeeyul.pdetools

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import net.jeeeyul.pdetools.snapshot.SnapshotHook

class Debug extends AbstractHandler {
	override execute(ExecutionEvent event) throws ExecutionException {
		new SnapshotHook().start();
		null
	}
}
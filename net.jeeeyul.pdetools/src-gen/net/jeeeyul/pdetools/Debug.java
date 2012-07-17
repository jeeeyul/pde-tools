package net.jeeeyul.pdetools;

import net.jeeeyul.pdetools.snapshot.SnapshotHook;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

@SuppressWarnings("all")
public class Debug extends AbstractHandler {
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    Object _xblockexpression = null;
    {
      SnapshotHook _snapshotHook = new SnapshotHook();
      _snapshotHook.start();
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
}

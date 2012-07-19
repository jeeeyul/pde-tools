package net.jeeeyul.pdetools;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Debug extends AbstractHandler {
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    Object _xblockexpression = null;
    {
      InputOutput.<String>println("test");
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
}

package net.jeeeyul.pdetools.clipboard;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * 
 * @author Jeeeyul
 * 
 */
public class CopyActionDetector {
	private class CommandHook implements IExecutionListener {
		@Override
		public void notHandled(String commandId, NotHandledException exception) {
		}

		@Override
		public void postExecuteFailure(String commandId, ExecutionException exception) {
		}

		@Override
		public void postExecuteSuccess(String commandId, Object returnValue) {
			if (ActionFactory.COPY.getCommandId().equals(commandId)) {
				handleCopyPerformed();
			}
		}

		@Override
		public void preExecute(String commandId, ExecutionEvent event) {
		}
	}

	private CommandHook commandHook;
	private Procedure0 copyHandler;

	public CopyActionDetector() {
		getCommandService().addExecutionListener(getCommandHook());
	}

	public void dispose() {
		getCommandService().removeExecutionListener(getCommandHook());
		copyHandler = null;
	}

	private CommandHook getCommandHook() {
		if (commandHook == null) {
			commandHook = new CommandHook();
		}
		return commandHook;
	}

	private ICommandService getCommandService() {
		return (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
	}

	public Procedure0 getCopyHandler() {
		return copyHandler;
	}

	public void handleCopyPerformed() {
		if (copyHandler != null) {
			copyHandler.apply();
		}
	}

	public void setCopyHandler(Procedure0 copyHandler) {
		this.copyHandler = copyHandler;
	}
}

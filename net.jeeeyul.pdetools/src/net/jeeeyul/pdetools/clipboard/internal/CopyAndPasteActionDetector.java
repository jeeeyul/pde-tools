package net.jeeeyul.pdetools.clipboard.internal;

import java.util.Arrays;
import java.util.List;

import net.jeeeyul.pdetools.Debug;
import net.jeeeyul.pdetools.shell.CopyResourcePathHandler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.IActivity;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.progress.WorkbenchJob;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * 
 * @author Jeeeyul
 * 
 */
public class CopyAndPasteActionDetector {
	private class CommandHook implements IExecutionListener {

		@Override
		public void notHandled(String commandId, NotHandledException exception) {
			event = null;
		}

		@Override
		public void postExecuteFailure(String commandId, ExecutionException exception) {
			event = null;
		}

		@Override
		public void postExecuteSuccess(String commandId, Object returnValue) {
			if (COPY_COMMAND_LIST.contains(commandId)) {
				handleCopyPerformed();
			} else if (commandId.equals(PASTE_COMMAND)) {
				handlePastePerformed();
			}
			event = null;
		}

		@Override
		public void preExecute(String commandId, ExecutionEvent event) {
			CopyAndPasteActionDetector.this.event = event;
		}
	}

	private static final String[] COPY_COMMANDS = new String[] {
			"org.eclipse.jdt.ui.edit.text.java.copy.qualified.name", "org.eclipse.ui.edit.copy",
			"org.eclipse.ui.edit.cut", CopyResourcePathHandler.COMMAND_ID };
	private static final String PASTE_COMMAND = "org.eclipse.ui.edit.paste";

	private static final List<String> COPY_COMMAND_LIST = Arrays.asList(COPY_COMMANDS);

	private ExecutionEvent event;

	private CommandHook commandHook;
	private Procedure1<ExecutionEvent> copyHandler;
	private Procedure1<ExecutionEvent> pasteHandler;

	public CopyAndPasteActionDetector() {
		hook();
	}

	private void handlePastePerformed() {
		if (pasteHandler != null) {
			pasteHandler.apply(event);
		}
	}

	public void dispose() {
		unhook();
		copyHandler = null;
	}

	private IActivity getClipboardActivity() {
		IActivity activity = PlatformUI.getWorkbench().getActivitySupport().getActivityManager()
				.getActivity("net.jeeeyul.pdetools.capability.clipboard");
		return activity;
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

	public Procedure1<ExecutionEvent> getCopyHandler() {
		return copyHandler;
	}

	public Procedure1<ExecutionEvent> getPasteHandler() {
		return pasteHandler;
	}

	public void handleCopyPerformed() {
		IActivity activity = getClipboardActivity();
		if (activity == null || !activity.isEnabled()) {
			Debug.println("Copy action was ignored due to activity disablement.");
			return;
		}
		if (copyHandler != null) {
			copyHandler.apply(event);
		}
	}

	private void hook() {
		Job job = new WorkbenchJob("hook command service") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				getCommandService().addExecutionListener(getCommandHook());
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	public void setCopyHandler(Procedure1<ExecutionEvent> copyHandler) {
		this.copyHandler = copyHandler;
	}

	public void setPasteHandler(Procedure1<ExecutionEvent> pasteHandler) {
		this.pasteHandler = pasteHandler;
	}

	private void unhook() {
		Job job = new WorkbenchJob("hook command service") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				getCommandService().removeExecutionListener(getCommandHook());
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}
}

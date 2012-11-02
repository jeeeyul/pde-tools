package net.jeeeyul.pdetools.commandspy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import net.jeeeyul.pdetools.Debug;
import net.jeeeyul.pdetools.model.pdetools.CommandEvent;
import net.jeeeyul.pdetools.model.pdetools.CommandExecutionType;
import net.jeeeyul.pdetools.model.pdetools.CommandHistory;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandImageService;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class GlobalCommandSpy {
	private static GlobalCommandSpy INSTANCE;

	public static final synchronized GlobalCommandSpy getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GlobalCommandSpy();
		}
		return INSTANCE;
	}

	private boolean isSpying;
	private CommandHistory commandHistory = PdetoolsFactory.eINSTANCE.createCommandHistory();
	private Stack<CommandEvent> stack = new Stack<CommandEvent>();

	private List<Procedure1<CommandEvent>> listeners = new ArrayList<Procedure1<CommandEvent>>();

	private IExecutionListener executionListener = new IExecutionListener() {
		@Override
		public void notHandled(String commandId, NotHandledException exception) {
			handleNotHandled(commandId, exception);
		}

		@Override
		public void postExecuteFailure(String commandId, ExecutionException exception) {
			handleFailed(commandId, exception);
		}

		@Override
		public void postExecuteSuccess(String commandId, Object returnValue) {
			handleSuccess(commandId, returnValue);
		}

		@Override
		public void preExecute(String commandId, ExecutionEvent event) {
			handleStart(commandId);
		}
	};

	private GlobalCommandSpy() {
	}

	public boolean addListener(Procedure1<CommandEvent> e) {
		return listeners.add(e);
	}

	private CommandEvent createEvent(String commandId) {
		Command command = getService(ICommandService.class).getCommand(commandId);
		CommandEvent event = PdetoolsFactory.eINSTANCE.createCommandEvent();
		event.setType(CommandExecutionType.EXECUTING);
		event.setTime(System.currentTimeMillis());
		event.setCommandId(commandId);
		if (command.isDefined()) {
			try {
				event.setName(command.getName());
			} catch (NotDefinedException e) {
				e.printStackTrace();
			}
		}

		ImageDescriptor imageDescriptor = getService(ICommandImageService.class).getImageDescriptor(commandId);
		event.setImageDescriptor(imageDescriptor);

		return event;
	}

	public CommandHistory getCommandHistory() {
		return commandHistory;
	}

	private <T> T getService(Class<T> serviceType) {
		@SuppressWarnings("unchecked")
		T service = (T) PlatformUI.getWorkbench().getService(serviceType);
		return service;
	}

	private void handleFailed(String commandId, ExecutionException exception) {
		if (stack.empty() || !stack.peek().getCommandId().equals(commandId)) {
			return;
		}
		CommandEvent event = stack.pop();
		event.setType(CommandExecutionType.FAILED);
		event.setException(exception);
	}

	private void handleNotHandled(String commandId, NotHandledException exception) {
		if (stack.empty() || !stack.peek().getCommandId().equals(commandId)) {
			return;
		}
		CommandEvent event = stack.pop();
		event.setType(CommandExecutionType.NOT_HANDLED);
		event.setException(exception);
	}

	private void handleStart(String commandId) {
		Command command = getService(ICommandService.class).getCommand(commandId);
		if (command.getHandler() != null && !command.getHandler().isEnabled()) {
			return;
		}
		CommandEvent event = createEvent(commandId);

		if (stack.size() > 0) {
			stack.peek().getChildren().add(event);
		} else {
			commandHistory.getEvents().add(0, event);
		}
		stack.push(event);
		pushEvent(event);
	}

	private void handleSuccess(String commandId, Object returnValue) {
		if (stack.empty() || !stack.peek().getCommandId().equals(commandId)) {
			return;
		}
		CommandEvent event = stack.pop();
		event.setType(CommandExecutionType.SUCCEED);
	}

	public boolean isSpying() {
		return isSpying;
	}

	private void pushEvent(CommandEvent ce) {
		List<Procedure1<CommandEvent>> copy = new ArrayList<Procedure1<CommandEvent>>();
		copy.addAll(listeners);

		for (Procedure1<CommandEvent> each : copy) {
			try {
				each.apply(ce);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean removeListener(Procedure1<CommandEvent> o) {
		return listeners.remove(o);
	}

	public synchronized void start() {
		if (isSpying) {
			return;
		}
		getService(ICommandService.class).addExecutionListener(executionListener);
		isSpying = true;
		Debug.println("Global Command Spy on");
		stack.clear();
	}

	public synchronized void stop() {
		if (!isSpying) {
			return;
		}

		getService(ICommandService.class).removeExecutionListener(executionListener);
		isSpying = false;
		Debug.println("Global Command Spy off");
		stack.clear();
	}
}

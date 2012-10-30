package net.jeeeyul.pdetools.commandspy;

import java.util.ArrayList;
import java.util.List;

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

		}
	};

	private GlobalCommandSpy() {
	}

	public boolean addListener(Procedure1<CommandEvent> e) {
		return listeners.add(e);
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
		CommandEvent event = createEvent(commandId);
		event.setType(CommandExecutionType.FAILED);
		event.setException(exception);
		pushEvent(event);
	}

	private CommandEvent createEvent(String commandId) {
		Command command = getService(ICommandService.class).getCommand(commandId);
		CommandEvent event = PdetoolsFactory.eINSTANCE.createCommandEvent();
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

	private void handleNotHandled(String commandId, NotHandledException exception) {
		CommandEvent event = createEvent(commandId);
		event.setType(CommandExecutionType.NOT_HANDLED);
		event.setException(exception);
		pushEvent(event);
	}

	private void handleSuccess(String commandId, Object returnValue) {
		CommandEvent event = createEvent(commandId);
		event.setType(CommandExecutionType.SUCCEED);

		pushEvent(event);
	}

	public boolean isSpying() {
		return isSpying;
	}

	private void pushEvent(CommandEvent ce) {
		commandHistory.getEvents().add(0, ce);

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
		System.out.println("Spy on");
	}

	public synchronized void stop() {
		if (!isSpying) {
			return;
		}

		getService(ICommandService.class).removeExecutionListener(executionListener);
		isSpying = false;
		System.out.println("Spy off");
	}
}

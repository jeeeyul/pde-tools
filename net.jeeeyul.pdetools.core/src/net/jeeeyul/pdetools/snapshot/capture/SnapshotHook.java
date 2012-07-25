package net.jeeeyul.pdetools.snapshot.capture;

import java.util.HashSet;
import java.util.Set;

import net.jeeeyul.pdetools.snapshot.NewSnapshotEntryJob;
import net.jeeeyul.pdetools.snapshot.model.snapshot.ShellInfo;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotFactory;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class SnapshotHook {
	private Set<Integer> hookingTypes = new HashSet<Integer>();

	private HookingState state = HookingState.NONE;

	private Listener dispatcher = new Listener() {
		@Override
		public void handleEvent(Event event) {
			SnapshotHook.this.handleEvent(event);
		}
	};

	private Display display;

	private CaptureBoundsShell captureBoundsShell;

	private ControlCapture controlCapture;

	private Control controlUnderMouse;

	public SnapshotHook(Display display) {
		this.display = display;
	}

	private CaptureBoundsShell getCaptureBoundsShell() {
		if (captureBoundsShell == null) {
			captureBoundsShell = new CaptureBoundsShell(Display.getCurrent());
		}
		return captureBoundsShell;
	}

	private ControlCapture getControlCapture() {
		if (controlCapture == null) {
			controlCapture = new ControlCapture();
		}
		return controlCapture;
	}

	private void handleEvent(Event event) {
		switch (event.type) {
			case SWT.KeyDown:
			case 3005:
				onKeyDown(event);
				break;

			case SWT.KeyUp:
				onKeyUp(event);
				break;

			case SWT.MouseMove:
				onMouseMove(event);
				break;

			case SWT.MouseDown:
				onMouseDown(event);
				break;

			default:
				break;
		}

		event.doit = false;
	}

	private void onMouseDown(Event event) {
		switch (state) {
			case TRACK_CONTROL:
			case TRACK_SHELL:
				capture();
				break;

			default:
				break;
		}
	}

	private void capture() {
		if (state == HookingState.TRACK_CONTROL) {
			transite(HookingState.CAPTURING_CONTROL);
		} else {
			transite(HookingState.CAPTURING_SHELL);
		}

		Image image = null;
		if (state == HookingState.CAPTURING_SHELL) {
			image = getControlCapture().capture(controlUnderMouse.getShell());
		} else {
			image = getControlCapture().capture(controlUnderMouse);
		}

		ImageData imageData = image.getImageData();
		image.dispose();

		NewSnapshotEntryJob job = new NewSnapshotEntryJob(imageData);
		if (state == HookingState.CAPTURING_SHELL) {
			Shell shell = controlUnderMouse.getShell();
			ShellInfo shellInfo = SnapshotFactory.eINSTANCE.createShellInfo();
			if (shell.getImage() != null) {
				shellInfo.setIcon(shell.getImage().getImageData());
			}
			shellInfo.setShellStyle(shell.getStyle());
			shellInfo.setShellTitle(shell.getText());
			job.setShellInfo(shellInfo);
		}
		job.schedule();

		transite(HookingState.NONE);

	}

	private void onMouseMove(Event event) {
		switch (state) {
			case TRACK_CONTROL:
				updateControlUnderMouse(event);
				getCaptureBoundsShell().setTarget(controlUnderMouse);
				break;

			case TRACK_SHELL:
				updateControlUnderMouse(event);
				getCaptureBoundsShell().setTarget(controlUnderMouse.getShell());
				break;

			default:
				break;
		}

	}

	private void onKeyUp(Event event) {
		switch (state) {
			case TRACK_SHELL:
				if (event.keyCode == SWT.MOD1) {
					transite(HookingState.TRACK_CONTROL);
				}
				break;

			default:
				break;
		}
	}

	private void onKeyDown(Event event) {
		switch (state) {
			case TRACK_CONTROL:
				if (event.keyCode == SWT.MOD1) {
					transite(HookingState.TRACK_SHELL);
				}
				break;

			default:
				break;
		}

	}

	private void hook(int... eventTypes) {
		for (int each : eventTypes) {
			if (hookingTypes.contains(each)) {
				continue;
			}
			hookingTypes.add(each);
			display.addFilter(each, dispatcher);
		}
	}

	private void updateControlUnderMouse(Event event) {
		Control control = null;
		if (event.widget instanceof Control) {
			control = (Control) event.widget;
		}

		if (this.controlUnderMouse == control) {
			return;
		}
		this.controlUnderMouse = control;
	}

	/**
	 * 
	 * 3005 is used for comparability to support under version of 3.8,
	 * {@link ST#VerifyKey}
	 */
	public void start() {
		if (state != HookingState.NONE) {
			return;
		}

		hook(SWT.MouseMove, SWT.MouseDown, SWT.MouseUp, SWT.KeyDown, SWT.KeyUp, 3005);
		controlUnderMouse = display.getCursorControl();

		transite(HookingState.TRACK_CONTROL);
	}

	public void transite(HookingState nextState) {
		if (this.state == nextState) {
			return;
		}
		this.state = nextState;
		switch (state) {
			case TRACK_CONTROL:
				getCaptureBoundsShell().setTarget(controlUnderMouse);
				getCaptureBoundsShell().show();
				break;

			case TRACK_SHELL:
				getCaptureBoundsShell().setTarget(controlUnderMouse.getShell());
				getCaptureBoundsShell().show();
				break;

			case CAPTURING_CONTROL:
			case CAPTURING_SHELL:
				getCaptureBoundsShell().hide();
				break;

			case NONE:
				unhookAll();
				controlUnderMouse = null;
				getCaptureBoundsShell().hide();
				break;
		}
	}

	private void unhookAll() {
		for (Integer each : hookingTypes) {
			display.removeFilter(each, dispatcher);
		}
		hookingTypes.clear();
	}
}

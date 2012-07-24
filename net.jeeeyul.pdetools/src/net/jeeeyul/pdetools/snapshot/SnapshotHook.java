package net.jeeeyul.pdetools.snapshot;

import net.jeeeyul.pdetools.snapshot.model.snapshot.ShellInfo;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotFactory;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class SnapshotHook {
	private boolean isCapturing = false;
	private boolean isStarted = false;
	private Control targetControl;
	private Listener mouseHandler = new Listener() {
		@Override
		public void handleEvent(Event event) {
			handleMouseMove(event);
		}
	};

	private Listener disposeHandler = new Listener() {
		@Override
		public void handleEvent(Event event) {
			handleDispose(event);
		}
	};

	private Listener paintHandler = new Listener() {
		@Override
		public void handleEvent(Event event) {
			handlePaint(event);
		}
	};

	private Listener clickListener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			handleClick(event);
		}
	};

	private Listener keyHandler = new Listener() {
		@Override
		public void handleEvent(Event event) {
			handleKeyPressed(event);
		}
	};

	public Control getTargetControl() {
		return targetControl;
	}

	protected void handleKeyPressed(Event event) {
		switch (event.keyCode) {
		case SWT.ARROW_UP:
			if (targetControl != null) {
				setTargetControl(targetControl.getParent());
				event.doit = false;
			}
			break;
		}

		switch (event.character) {
		case SWT.CR:
			capture(true);
			stop();
			event.doit = false;

			break;

		case SWT.ESC:
			stop();
			event.doit = false;
			break;
		}
	}

	protected void handleClick(Event event) {
		event.doit = false;
		capture();
		stop();
	}

	protected void handleDispose(Event event) {
		setTargetControl(null);
	}

	protected void handleMouseMove(Event event) {
		if (event.widget instanceof Control) {
			setTargetControl((Control) event.widget);
		}
	}

	public synchronized void capture() {
		capture(false);
	}

	public synchronized void capture(boolean captureShell) {
		if (targetControl == null || targetControl.isDisposed() || isCapturing) {
			return;
		}
		isCapturing = true;

		Control captureTarget = targetControl;
		if (captureShell) {
			captureTarget = captureTarget.getShell();
		}

		targetControl.redraw();
		targetControl.update();

		Point size = captureTarget.getSize();
		if (captureTarget instanceof Shell) {
			Rectangle clientArea = ((Shell) captureTarget).getClientArea();
			size = new Point(clientArea.width, clientArea.height);
		}

		Image image = new Image(captureTarget.getDisplay(), size.x, size.y);
		GC gc = new GC(captureTarget);

		if (captureShell) {
			Rectangle clientArea = ((Shell) captureTarget).getClientArea();
			gc.copyArea(image, clientArea.x, clientArea.y);
		} else {
			gc.copyArea(image, 0, 0);
		}

		gc.dispose();

		ImageData imageData = image.getImageData();
		NewSnapshotEntryJob job = new NewSnapshotEntryJob(imageData);
		job.setControlType(captureTarget.getClass().getCanonicalName());

		if (captureShell) {
			Shell shell = (Shell) captureTarget;
			ShellInfo shellInfo = SnapshotFactory.eINSTANCE.createShellInfo();
			if (shell.getImage() != null) {
				shellInfo.setIcon(shell.getImage().getImageData());
			}
			shellInfo.setShellStyle(shell.getStyle());
			shellInfo.setShellTitle(shell.getText());
			job.setShellInfo(shellInfo);
		}
		job.schedule();
		image.dispose();

		isCapturing = false;
	}

	protected void handlePaint(Event event) {
		if (isCapturing) {
			return;
		}
		GC gc = event.gc;
		gc.setForeground(getTargetControl().getDisplay().getSystemColor(SWT.COLOR_RED));
		gc.setLineStyle(SWT.LINE_DASH);
		gc.setLineDash(new int[] { 4, 2 });
		gc.setLineWidth(2);
		Rectangle bounds = getTargetControl().getBounds();
		gc.drawRectangle(1, 1, bounds.width - 2, bounds.height - 2);

		gc.setBackground(getTargetControl().getDisplay().getSystemColor(SWT.COLOR_RED));
		gc.setAlpha(100);
		gc.fillRectangle(0, 0, bounds.width, bounds.height);
	}

	public void setTargetControl(Control targetControl) {
		if (this.targetControl == targetControl) {
			if (targetControl != null && !targetControl.isDisposed()) {
				targetControl.redraw();
			}
			return;
		}

		if (this.targetControl != null) {
			this.targetControl.removeListener(SWT.Paint, paintHandler);
			this.targetControl.removeListener(SWT.Dispose, disposeHandler);
			this.targetControl.redraw();
		}
		this.targetControl = targetControl;
		if (this.targetControl != null && !this.targetControl.isDisposed()) {
			targetControl.addListener(SWT.Dispose, disposeHandler);
			targetControl.addListener(SWT.Paint, paintHandler);
			targetControl.redraw();
		}
	}

	public synchronized void start() {
		if (isStarted) {
			return;
		}
		isStarted = true;
		Display.getDefault().addFilter(SWT.MouseMove, mouseHandler);
		Display.getDefault().addFilter(SWT.KeyDown, keyHandler);
		Display.getDefault().addFilter(SWT.Traverse, keyHandler);
		Display.getDefault().addFilter(SWT.MouseDown, clickListener);
	}

	public synchronized void stop() {
		if (!isStarted) {
			return;
		}
		setTargetControl(null);
		isStarted = false;
		Display.getDefault().removeFilter(SWT.MouseMove, mouseHandler);
		Display.getDefault().removeFilter(SWT.KeyDown, keyHandler);
		Display.getDefault().removeFilter(SWT.Traverse, keyHandler);
		Display.getDefault().removeFilter(SWT.MouseDown, clickListener);
	}
}

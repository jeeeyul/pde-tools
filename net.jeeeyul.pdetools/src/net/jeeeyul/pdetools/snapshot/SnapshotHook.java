package net.jeeeyul.pdetools.snapshot;

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
		if (event.keyCode == SWT.ARROW_UP) {
			if (targetControl != null) {
				setTargetControl(targetControl.getParent());
				event.doit = false;
			}
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
		if (targetControl == null || targetControl.isDisposed() || isCapturing) {
			return;
		}
		isCapturing = true;

		targetControl.redraw();
		targetControl.update();

		Point size = targetControl.getSize();
		Image image = new Image(targetControl.getDisplay(), size.x, size.y);
		GC gc = new GC(targetControl);
		gc.copyArea(image, 0, 0);
		gc.dispose();

		ImageData imageData = image.getImageData();
		new NewSnapshotEntryJob(imageData).schedule();
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
		Display.getDefault().removeFilter(SWT.MouseDown, clickListener);
	}
}

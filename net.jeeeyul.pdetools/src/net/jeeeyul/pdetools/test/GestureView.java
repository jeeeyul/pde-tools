package net.jeeeyul.pdetools.test;

import net.jeeeyul.pdetools.shared.KPoint;
import net.jeeeyul.pdetools.shared.KRectangle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class GestureView extends Canvas {
	private double rotation = 0d;
	private double rotationAmp = 0d;
	private double zoom = 1d;
	private double zoomAmp = 1d;
	private double x = 0d;
	private double y = 0d;
	private double xAmp = 0d;
	private double yAmp = 0d;

	public GestureView(Composite parent, int style) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		addListener(SWT.Paint, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onPaint(event);
			}
		});

		addListener(SWT.Gesture, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onGesture(event);
			}
		});
	}

	protected void onGesture(Event event) {
		if (event.detail == SWT.GESTURE_MAGNIFY) {
			zoomAmp = event.magnification;
		}

		else if (event.detail == SWT.GESTURE_ROTATE) {
			rotationAmp = -event.rotation * 2d;
		}

		else if (event.detail == SWT.GESTURE_PAN) {
			xAmp -= event.xDirection * 2d;
			yAmp -= event.yDirection * 2d;
		}

		else if (event.detail == SWT.GESTURE_END) {
			zoom = zoom * zoomAmp;
			rotation += rotationAmp;
			zoomAmp = 1d;
			rotationAmp = 0;
			x += xAmp;
			y += yAmp;
			xAmp = yAmp = 0;
		}

		redraw();
	}

	protected void onPaint(Event event) {
		GC gc = event.gc;
		KRectangle bounds = new KRectangle(getClientArea());
		KPoint center = bounds.getCenter();
		Transform transform = new Transform(getDisplay());
		transform.identity();

		transform.translate((float) (center.x + x + xAmp), (float) (center.y + y + yAmp));

		transform.rotate((float) (rotation + rotationAmp));
		transform.scale((float) (zoom * zoomAmp), (float) (zoom * zoomAmp));
		gc.setTransform(transform);

		gc.drawRectangle(-40, -20, 80, 40);

		transform.dispose();

	}

	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setLayout(new FillLayout());

		new GestureView(shell, SWT.DOUBLE_BUFFERED);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}

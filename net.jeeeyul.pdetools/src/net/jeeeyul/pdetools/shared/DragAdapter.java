package net.jeeeyul.pdetools.shared;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DragAdapter {
	private static final int STATE_NONE = 0;
	private static final int STATE_DRAGGING = 1;

	private int state = STATE_NONE;
	private Point lastPosition;
	private Procedure1<Point> deltaHandler;

	private Cursor handCursor;
	private Cursor dragCursor;

	private Listener dispatcher = new Listener() {
		@Override
		public void handleEvent(Event event) {
			handleTargetEvent(event);
		}
	};
	private Control target;

	public DragAdapter(Control target) {
		this.target = target;
		target.addListener(SWT.MouseDown, dispatcher);
		target.addListener(SWT.MouseMove, dispatcher);
		target.addListener(SWT.MouseUp, dispatcher);

		handCursor = new Cursor(target.getDisplay(), SharedImages.getImageDescriptor(SharedImages.HAND).getImageData(),
				8, 8);
		dragCursor = new Cursor(target.getDisplay(), SharedImages.getImageDescriptor(SharedImages.GRAB).getImageData(),
				8, 8);

		target.addListener(SWT.Dispose, new Listener() {
			@Override
			public void handleEvent(Event event) {
				handCursor.dispose();
				dragCursor.dispose();
			}
		});

		target.setCursor(handCursor);
	}

	public Procedure1<Point> getDeltaHandler() {
		return deltaHandler;
	}

	private void handleDelta(Point delta) {
		if (deltaHandler != null) {
			deltaHandler.apply(delta);
		}
	}

	private void handleMouseDown(Event event) {
		switch (state) {
			case STATE_NONE:
				if (event.button == 1) {
					state = STATE_DRAGGING;
					lastPosition = new Point(event.x, event.y);
					target.setCursor(dragCursor);
				}

				break;

			default:
				break;
		}

	}

	private void handleMouseMove(Event event) {
		if (state == STATE_DRAGGING) {
			Point delta = new Point(event.x - lastPosition.x, event.y - lastPosition.y);
			lastPosition = new Point(event.x, event.y);
			handleDelta(delta);
		}
	}

	private void handleMouseUp(Event event) {
		switch (state) {
			case STATE_DRAGGING:
				if (event.button == 1) {
					state = STATE_NONE;
					lastPosition = null;
					target.setCursor(handCursor);
				}

				break;

			default:
				break;
		}
	}

	protected void handleTargetEvent(Event event) {
		switch (event.type) {
			case SWT.MouseDown:
				handleMouseDown(event);
				break;
			case SWT.MouseUp:
				handleMouseUp(event);
				break;

			case SWT.MouseMove:
				handleMouseMove(event);
				break;

		}
	}

	public void setDeltaHandler(Procedure1<Point> deltaHandler) {
		this.deltaHandler = deltaHandler;
	}
}

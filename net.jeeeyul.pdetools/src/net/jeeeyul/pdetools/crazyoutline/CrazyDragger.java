package net.jeeeyul.pdetools.crazyoutline;

import net.jeeeyul.pdetools.shared.SWTExtensions;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class CrazyDragger {
	private SWTExtensions swt = SWTExtensions.INSTANCE;

	private static final int STATE_NONE = 0;
	private static final int STATE_DRAGGING = 1;

	private int state = STATE_NONE;

	private CrazyCanvas canvas;
	private Rectangle offsetSelection;
	private Point offsetLocation;
	private Cursor handCursor;
	private Cursor grabCursor;

	public CrazyDragger(CrazyCanvas canvas) {
		this.canvas = canvas;
		canvas.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onMouseDown(event);
			}
		});
		canvas.addListener(SWT.MouseUp, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onMouseUp(event);
			}
		});

		canvas.addListener(SWT.MouseMove, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onMouseMove(event);
			}
		});
	}

	public Cursor getGrabCursor() {
		grabCursor = new Cursor(canvas.getDisplay(), SharedImages.getImageDescriptor(SharedImages.GRAB).getImageData(),
				8, 8);
		canvas.addListener(SWT.Dispose, new Listener() {
			@Override
			public void handleEvent(Event event) {
				grabCursor.dispose();
			}
		});
		return grabCursor;
	}

	public Cursor getHandCursor() {
		if (handCursor == null || handCursor.isDisposed()) {
			handCursor = new Cursor(canvas.getDisplay(), SharedImages.getImageDescriptor(SharedImages.HAND)
					.getImageData(), 8, 8);
			canvas.addListener(SWT.Dispose, new Listener() {
				@Override
				public void handleEvent(Event event) {
					handCursor.dispose();
				}
			});
		}
		return handCursor;
	}

	private void onMouseDown(Event event) {
		Point location = scaledPoint(event);
		if (state == STATE_NONE) {
			Rectangle selection = canvas.getSelection();
			if (swt.contains(selection, location)) {
				offsetSelection = swt.getCopy(selection);
				offsetLocation = location;
				state = STATE_DRAGGING;
				canvas.setCursor(getGrabCursor());
			} else {
				offsetSelection = swt.getCopy(selection);
				offsetSelection.x = location.x - offsetSelection.width / 2;
				offsetSelection.y = location.y - offsetSelection.height / 2;
				offsetLocation = location;
				state = STATE_DRAGGING;
				canvas.setSelection(offsetSelection, true);
				canvas.setCursor(getGrabCursor());
			}
		}
	}

	private void onMouseMove(Event event) {
		Point location = scaledPoint(event);
		Rectangle selection = canvas.getSelection();

		if (state == STATE_DRAGGING) {
			Point delta = swt.getDifference(offsetLocation, location);
			Rectangle newSelection = swt.getTranslated(offsetSelection, delta);
			canvas.setSelection(newSelection, true);
		}

		else {
			if (swt.contains(selection, location)) {
				canvas.setCursor(getHandCursor());
			} else {
				canvas.setCursor(null);
			}
		}
	}

	private void onMouseUp(Event event) {
		if (state == STATE_DRAGGING) {
			state = STATE_NONE;
		}
	}

	private Point scaledPoint(Event event) {
		float invertedScale = 1f / canvas.getScale();
		return swt.scale(new Point(event.x, event.y), invertedScale);
	}
}

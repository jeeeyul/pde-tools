package net.jeeeyul.pdetools.crazyoutline;

import net.jeeeyul.pdetools.shared.SWTExtensions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class CrazyDragger {
	private static final int STATE_NONE = 0;
	private static final int STATE_DRAGGING = 1;

	private int state = STATE_NONE;

	private CrazyCanvas canvas;
	private SWTExtensions swt = SWTExtensions.INSTANCE;

	private Rectangle offsetSelection;
	private Point offsetLocation;

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

	private void onMouseMove(Event event) {
		Point location = scaledPoint(event);

		if (state == STATE_DRAGGING) {
			Point delta = swt.getDifference(offsetLocation, location);
			Rectangle newSelection = swt.getTranslated(offsetSelection, delta);
			
			canvas.setSelection(newSelection, true);
		}
	}

	private void onMouseUp(Event event) {
		if (state == STATE_DRAGGING) {
			state = STATE_NONE;
		}
	}

	private void onMouseDown(Event event) {
		Point location = scaledPoint(event);
		if (state == STATE_NONE) {
			Rectangle selection = canvas.getSelection();
			if (swt.contains(selection, location)) {
				offsetSelection = swt.getCopy(selection);
				offsetLocation = location;
				state = STATE_DRAGGING;
			}
		}
	}

	private Point scaledPoint(Event event) {
		float invertedScale = 1f / canvas.getScale();
		return swt.scale(new Point(event.x, event.y), invertedScale);
	}
}

package net.jeeeyul.pdetools.snapshot.capture;

import net.jeeeyul.pdetools.shared.SWTExtensions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CaptureBoundsIndicator {
	private Control target;
	private Shell shell;
	private Region region;
	private Display display;

	public Control getTarget() {
		return target;
	}

	public void setTarget(Control target) {
		if (this.target == target) {
			return;
		}
		this.target = target;

		if (target == null) {
			shell.setVisible(false);
			return;
		}
		shell.setVisible(true);

		Point size = null;
		if (target instanceof Shell) {
			Rectangle clientArea = ((Shell) target).getClientArea();
			size = new Point(clientArea.width, clientArea.height);
		} else {
			size = target.getSize();
		}

		shell.setSize(size);
		Point location = target.toDisplay(0, 0);

		shell.setLocation(location);

		Rectangle rectangle = new Rectangle(0, 0, size.x, size.y);

		if (region != null && !region.isDisposed()) {
			region.dispose();
		}
		region = new Region(display);
		region.add(rectangle);
		SWTExtensions.expand(rectangle, -6, -6);
		SWTExtensions.translate(rectangle, 3, 3);
		if (rectangle.width > 0 && rectangle.height > 0)
			region.subtract(rectangle);

		shell.setRegion(region);

	}

	protected void doFlashing() {
		while (!shell.isDisposed()) {
			shell.getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					if (shell.isDisposed()) {
						return;
					}
					long time = System.currentTimeMillis() % 1000L;
					double theta = (time / 1000d) * Math.PI * 2d;
					int addition = (int) ((Math.sin(theta) + 1d) * 96);
					shell.setAlpha(64 + addition);
				}
			});

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public CaptureBoundsIndicator(Display display) {
		this.display = display;
		create(display);
	}

	private void create(Display display) {
		shell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
		shell.setBackground(display.getSystemColor(SWT.COLOR_RED));
		region = new Region(display);

		GC gc = new GC(shell);
		gc.setAdvanced(true);
		gc.dispose();
	}

	public void dispose() {
		if (shell != null && !shell.isDisposed())
			shell.dispose();

		if (region != null && !region.isDisposed())
			region.dispose();
	}

	public void hide() {
		shell.setVisible(false);
	}

	public void show() {
		shell.setVisible(true);
	}

}

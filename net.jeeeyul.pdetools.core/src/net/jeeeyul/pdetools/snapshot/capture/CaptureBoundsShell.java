package net.jeeeyul.pdetools.snapshot.capture;

import net.jeeeyul.pdetools.shared.SWTExtensions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CaptureBoundsShell {
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
		SWTExtensions.expand(rectangle, -4, -4);
		SWTExtensions.translate(rectangle, 2, 2);
		if (rectangle.width > 0 && rectangle.height > 0)
			region.subtract(rectangle);

		shell.setRegion(region);
	}

	public CaptureBoundsShell(Display display) {
		this.display = display;
		create(display);
	}

	private void create(Display display) {
		shell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
		shell.setBackground(display.getSystemColor(SWT.COLOR_RED));
		region = new Region(display);
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

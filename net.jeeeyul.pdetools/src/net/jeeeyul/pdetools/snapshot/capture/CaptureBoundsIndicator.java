package net.jeeeyul.pdetools.snapshot.capture;

import net.jeeeyul.swtend.SWTExtensions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class CaptureBoundsIndicator {
	private static final SWTExtensions toolkit = SWTExtensions.INSTANCE;
	private Control target;
	private Shell shell;
	private Shell helpShell;
	private Region region;
	private Display display;
	private CaptureBoundsComputer boundsComputer = new CaptureBoundsComputer();
	private Label helpLabel;

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

		Rectangle bounds = boundsComputer.compute(target);
		Rectangle shellBounds = toolkit.getExpanded(bounds, 3);
		shell.setBounds(shellBounds);
		toolkit.safeDispose(region);

		region = new Region(display);
		Rectangle regionBounds = toolkit.getCopy(shellBounds);
		regionBounds.x = regionBounds.y = 0;

		region.add(regionBounds);
		if (bounds.width > 0 && bounds.height > 0)
			region.subtract(toolkit.getShrinked(regionBounds, 3));
		
		shell.setRegion(region);
		shell.setVisible(true);

		helpLabel.setText(target.getClass().getSimpleName() + " " + bounds.width + "x" + bounds.height);
		helpShell.layout(true, true);
		helpShell.pack(true);
		Rectangle helpBounds = helpLabel.getBounds();
		toolkit.relocateTopRightWith(helpBounds, shellBounds);
		toolkit.translate(helpBounds, 0, -helpBounds.height);
		helpShell.setBounds(helpBounds);
		helpShell.setVisible(true);

	}

	public CaptureBoundsIndicator(Display display) {
		this.display = display;
		create(display);
	}

	private void create(Display display) {
		shell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
		shell.setBackground(display.getSystemColor(SWT.COLOR_RED));
		shell.setSize(0, 0);
		shell.setVisible(false);
		shell.update();

		helpShell = new Shell(shell, SWT.NO_TRIM | SWT.ON_TOP);
		helpShell.setLayout(new FillLayout());
		helpShell.setBackground(display.getSystemColor(SWT.COLOR_RED));
		helpShell.setBackgroundMode(SWT.INHERIT_FORCE);
		helpLabel = new Label(helpShell, SWT.NORMAL);
		helpLabel.setForeground(display.getSystemColor(SWT.COLOR_WHITE));

		region = new Region(display);

		GC gc = new GC(shell);
		gc.setAdvanced(true);
		gc.dispose();
	}

	public void dispose() {
		toolkit.safeDispose(helpShell, shell);
		toolkit.safeDispose(region);
	}

	public void hide() {
		shell.setVisible(false);
		helpShell.setVisible(false);
		shell.update();
		helpShell.update();
	}

	public void show() {
		shell.setVisible(true);
		helpShell.setVisible(true);
		shell.update();
		helpShell.update();
	}

}

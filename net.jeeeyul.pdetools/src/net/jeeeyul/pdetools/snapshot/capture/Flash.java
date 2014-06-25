package net.jeeeyul.pdetools.snapshot.capture;

import java.io.InputStream;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.shared.AnimateJob;
import net.jeeeyul.pdetools.shared.PlayThread;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Flash {
	private Control target;
	private Shell shell;
	private AnimateJob job;
	private CaptureBoundsComputer boundsComputer = new CaptureBoundsComputer();

	public AnimateJob getJob() {
		if (job == null) {
			job = new AnimateJob() {
				@Override
				protected void doAnimate(double p) {
					if (shell != null && !shell.isDisposed()) {
						int alpha = (int) (255 - (255 * p));
						shell.setAlpha(alpha);
					}
				}

				@Override
				protected void onEnd() {
					shell.dispose();
				}
			};

			job.setLength(600);
		}
		return job;
	}

	public Flash(Control target) {
		create(target.getDisplay());
		setTarget(target);
	}

	private void setTarget(Control target) {
		if (this.target == target) {
			return;
		}
		this.target = target;

		if (target == null) {
			shell.setVisible(false);
			return;
		}

		Rectangle bounds = boundsComputer.compute(target);
		shell.setBounds(bounds);
		shell.setVisible(true);

	}

	private void create(Display display) {
		shell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP | SWT.TOOL);
		shell.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		shell.setSize(0, 0);
		shell.setVisible(false);
		shell.update();
	}

	public void start() {
		try {
			InputStream sound = PDEToolsCore.getDefault().getBundle().getResource("sounds/camera.wav").openStream();
			new PlayThread(sound).schedule();
		} catch (Exception e) {
			e.printStackTrace();
		}
		getJob().schedule();
	}
}

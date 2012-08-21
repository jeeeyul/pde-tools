package net.jeeeyul.pdetools.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class TableTest {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setLayout(new FillLayout());

		shell.addListener(SWT.Gesture, new Listener() {
			@Override
			public void handleEvent(Event event) {
				System.out.println(event.magnification);
			}
		});

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}

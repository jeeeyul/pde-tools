package net.jeeeyul.pdetools.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TableTest {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setLayout(new FillLayout());

		StyledText text = new StyledText(shell, SWT.MULTI);
		text.setLayoutData(new GridData(GridData.FILL_BOTH));

		Image image = new Image(display, 20, text.getLineHeight());
		GC gc = new GC(image);
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
		gc.setAlpha(10);
		gc.setLineStyle(SWT.LINE_DASH);
		gc.setLineDash(new int[] { 2, 2 });
		gc.drawLine(0, 0, 20, 0);
		gc.dispose();
		text.setBackgroundImage(image);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}

package net.jeeeyul.pdetools.shared;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class BilinearTest {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		
		Label label = new Label(shell, SWT.NORMAL);
		
		ImageData data = SharedImages.getImageDescriptor(SharedImages.SAMPLE_TEST).getImageData();
		BilinearInterpolation resize = new BilinearInterpolation(data, 1024, 1024);
		ImageData resized = resize.run();
		Image image = new Image(display, resized);
		label.setImage(image);
		
		
		shell.open();
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
	}
}

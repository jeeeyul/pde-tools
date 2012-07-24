package net.jeeeyul.pdetools.snapshot.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ShellFrame {
	public static PaletteData PALETTE = new PaletteData(0xff0000, 0xff00, 0xff);
	private ImageData frame;
	private Rectangle clientArea;

	public ShellFrame(ImageData image, Rectangle clientArea) {
		super();
		this.frame = upmix(image);
		this.clientArea = clientArea;
	}

	public ImageData decorate(ImageData content) {
		content = upmix(content);

		int width = frame.width - clientArea.width + content.width;
		int height = frame.height - clientArea.height + content.height;

		ImageData result = new ImageData(width, height, content.depth, PALETTE);
		ImageData leftTop = crop(frame, new Rectangle(0, 0, clientArea.x, clientArea.y));

		result = drawImage(leftTop, result, 0, 0);
		result = drawImage(content, result, clientArea.x, clientArea.y);

		ImageData top = crop(frame, new Rectangle(clientArea.x, 0, clientArea.width, clientArea.y));
		result = drawImage(top, result, new Rectangle(clientArea.x, 0, content.width, clientArea.y));

		ImageData rightTop = crop(frame, new Rectangle(clientArea.x + clientArea.width, 0, frame.width
				- (clientArea.x + clientArea.width), clientArea.y));
		result = drawImage(rightTop, result, clientArea.x + content.width, 0);

		ImageData left = crop(frame, new Rectangle(0, clientArea.y, clientArea.x, clientArea.height));
		result = drawImage(left, result, new Rectangle(0, clientArea.y, clientArea.x, content.height));

		ImageData right = crop(frame, new Rectangle(clientArea.x + clientArea.width, clientArea.y, frame.width
				- clientArea.width - clientArea.x, clientArea.height));
		result = drawImage(right, result, new Rectangle(clientArea.x + content.width, clientArea.y, right.width,
				content.height));

		ImageData leftBottom = crop(frame, new Rectangle(0, clientArea.y + clientArea.height, clientArea.x,
				frame.height - clientArea.y - clientArea.height));
		result = drawImage(leftBottom, result, new Rectangle(0, clientArea.y + content.height, clientArea.x,
				frame.height - clientArea.y - clientArea.height));

		ImageData bottom = crop(frame, new Rectangle(clientArea.x, clientArea.y + clientArea.height, clientArea.width,
				frame.height - clientArea.y - clientArea.height));
		result = drawImage(bottom, result, new Rectangle(clientArea.x, height - bottom.height, content.width,
				bottom.height));

		ImageData rightBottom = crop(frame, new Rectangle(clientArea.x + clientArea.width, clientArea.y
				+ clientArea.height, frame.width - clientArea.x - clientArea.width, frame.height - clientArea.y
				- clientArea.height));

		result = drawImage(rightBottom, result, clientArea.x + content.width, clientArea.y + content.height);

		return result;
	}

	private ImageData drawImage(ImageData source, ImageData target, int x, int y) {
		target = upmix(target);

		int scanlineLength = source.width;
		int[] buffer = new int[scanlineLength];
		byte[] alphas = new byte[scanlineLength];
		for (int r = 0; r < source.height; r++) {
			source.getPixels(0, r, scanlineLength, buffer, 0);
			target.setPixels(x, y + r, scanlineLength, buffer, 0);

			source.getAlphas(0, r, scanlineLength, alphas, 0);
			target.setAlphas(x, y + r, scanlineLength, alphas, 0);
		}

		return target;
	}

	private ImageData drawImage(ImageData source, ImageData target, Rectangle targetArea) {
		return drawImage(source, new Rectangle(0, 0, source.width, source.height), target, targetArea);
	}

	private ImageData drawImage(ImageData source, Rectangle sourceArea, ImageData target, Rectangle targetArea) {
		source = upmix(source);
		target = upmix(target);

		ImageData sourceBox = crop(source, sourceArea);
		if (sourceBox.width != targetArea.width || sourceBox.height != targetArea.height) {
			sourceBox = sourceBox.scaledTo(targetArea.width, targetArea.height);
		}

		int[] pixels = new int[sourceBox.width];
		byte[] alphas = new byte[sourceBox.width];

		for (int y = 0; y < sourceBox.height; y++) {
			sourceBox.getPixels(0, y, sourceBox.width, pixels, 0);
			target.setPixels(targetArea.x, targetArea.y + y, targetArea.width, pixels, 0);

			sourceBox.getAlphas(0, y, sourceBox.width, alphas, 0);
			target.setAlphas(targetArea.x, targetArea.y + y, targetArea.width, alphas, 0);
		}

		return target;
	}

	private ImageData crop(ImageData source, Rectangle sourceArea) {
		source = upmix(source);
		ImageData crop = new ImageData(sourceArea.width, sourceArea.height, 32, PALETTE);

		int[] buffer = new int[crop.width];
		byte[] alphaBuffer = new byte[crop.width];
		for (int y = 0; y < crop.height; y++) {
			source.getPixels(sourceArea.x, sourceArea.y + y, sourceArea.width, buffer, 0);
			crop.setPixels(0, y, crop.width, buffer, 0);

			source.getAlphas(sourceArea.x, sourceArea.y + y, crop.width, alphaBuffer, 0);
			crop.setAlphas(0, y, crop.width, alphaBuffer, 0);
		}
		return crop;
	}

	private ImageData upmix(ImageData imageData) {
		if (imageData.palette.redMask == 0xff0000 && imageData.palette.greenMask == 0xff00) {
			return imageData;
		}

		ImageData result = new ImageData(imageData.width, imageData.height, 32, PALETTE);
		for (int x = 0; x < imageData.width; x++) {
			for (int y = 0; y < imageData.height; y++) {
				RGB rgb = imageData.palette.getRGB(imageData.getPixel(x, y));
				result.setPixel(x, y, PALETTE.getPixel(rgb));
				result.setAlpha(x, y, imageData.getAlpha(x, y));
			}
		}
		System.out.println("¾÷¹Í½º");
		return result;
	}

	public static void main(String[] args) {
		Display display = Display.getDefault();

		Rectangle area = new Rectangle(9, 31, 118, 82);
		ImageData data = new ImageData(ShellFrame.class.getResourceAsStream("win7-basic.png"));
		ShellFrame frame = new ShellFrame(data, area);

		ImageData source = new ImageData(ShellFrame.class.getResourceAsStream("test.jpg"));

		ImageData decorate = frame.decorate(source);
		Image image = new Image(display, decorate);

		Shell shell = new Shell();
		shell.setLayout(new FillLayout());
		Label label = new Label(shell, SWT.NORMAL);
		label.setImage(image);
		label.setBackground(display.getSystemColor(SWT.COLOR_RED));
		shell.pack();

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}
}

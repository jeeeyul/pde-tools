package net.jeeeyul.pdetools.shared;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;

public class ThumbnailGenerator {
	public ImageData generate(ImageData original, int width, int height) {
		PaletteData paletteData = new PaletteData(0xff0000, 0xff00, 0xff);
		ImageData result = new ImageData(width, height, 32, paletteData);

		double xRatio = original.width / (double) width;
		double yRatio = original.height / (double) height;

		AverageComputer redComputer = new AverageComputer();
		AverageComputer greenComputer = new AverageComputer();
		AverageComputer blueComputer = new AverageComputer();
		AverageComputer alphaComputer = new AverageComputer();

		for (int x = 0; x < result.width; x++) {
			for (int y = 0; y < result.height; y++) {
				redComputer.reset();
				greenComputer.reset();
				blueComputer.reset();
				alphaComputer.reset();
				
				double d = 0.2d;

				for (int dx = (int) ((x - d) * xRatio); dx <= (int) ((x + d) * xRatio); dx += 1.0d) {
					for (int dy = (int) ((y -d) * yRatio); dy <= (int) ((y + d) * yRatio); dy += 1.0d) {
						int ax = Math.min(Math.max(0, dx), original.width - 1);
						int ay = Math.min(Math.max(0, dy), original.height - 1);

						int pixel = original.getPixel(ax, ay);
						RGB rgb = original.palette.getRGB(pixel);

						redComputer.push(rgb.red);
						greenComputer.push(rgb.green);
						blueComputer.push(rgb.blue);

						int alpha = 255;
						
						switch (original.getTransparencyType()) {
							case SWT.TRANSPARENCY_ALPHA: {
								alpha = original.getAlpha(ax, ay);
								break;
							}

							case SWT.TRANSPARENCY_PIXEL: {
								alpha = (pixel == original.transparentPixel) ? 0 : 255;
								break;
							}

							default: {
								alpha = 255;
								break;
							}
						}
						
						alphaComputer.push(alpha);
					}
				}

				RGB rgb = new RGB((int) redComputer.getAverage(), (int) greenComputer.getAverage(),
						(int) blueComputer.getAverage());
				
				int alpha = (int) alphaComputer.getAverage();
				result.setPixel(x, y, result.palette.getPixel(rgb));
				result.setAlpha(x, y, alpha);
			}
		}

		return result;
	}
}

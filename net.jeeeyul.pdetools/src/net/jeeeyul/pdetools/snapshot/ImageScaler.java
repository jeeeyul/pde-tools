package net.jeeeyul.pdetools.snapshot;

import org.eclipse.swt.graphics.ImageData;

public class ImageScaler {
	public static ImageData scale(ImageData original, int maxLength) {
		if (original.width > original.height && original.width > 200) {
			return original.scaledTo(200, (int) (200 * original.height / (double) original.width));
		} else if (original.height > original.width && original.height > 200) {
			return original.scaledTo((int) (200 * original.width / (double) original.height), 200);
		}
		return original;
	}
}

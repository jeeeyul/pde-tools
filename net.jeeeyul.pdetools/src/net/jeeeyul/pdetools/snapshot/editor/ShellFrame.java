package net.jeeeyul.pdetools.snapshot.editor;

import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;

public class ShellFrame {
	private ImageData image;
	private Rectangle clientArea;

	public ShellFrame(ImageData image, Rectangle clientArea) {
		super();
		this.image = image;
		this.clientArea = clientArea;
	}

	public ImageData decorate(ImageData content) {
		int width = image.width - clientArea.width + content.width;
		int height = image.height - clientArea.height + content.height;

		return null;
	}

}

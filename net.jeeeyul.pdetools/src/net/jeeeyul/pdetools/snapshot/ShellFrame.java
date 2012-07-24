package net.jeeeyul.pdetools.snapshot;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

public class ShellFrame {
	private Image image;
	private Rectangle clientArea;

	public ShellFrame(Image image, Rectangle clientArea) {
		super();
		this.image = image;
		this.clientArea = clientArea;
	}

	public Image decorate(Image content) {
		return null;
	}

}

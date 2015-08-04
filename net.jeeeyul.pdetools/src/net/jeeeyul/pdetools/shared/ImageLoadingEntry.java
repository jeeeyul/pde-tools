package net.jeeeyul.pdetools.shared;

import org.eclipse.swt.graphics.ImageData;

public class ImageLoadingEntry<KeyType> {
	public KeyType key;
	public ImageData image;

	public ImageLoadingEntry(KeyType key, ImageData image) {
		this.key = key;
		this.image = image;
	}

}

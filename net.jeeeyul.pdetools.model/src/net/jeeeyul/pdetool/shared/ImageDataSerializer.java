package net.jeeeyul.pdetool.shared;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

public class ImageDataSerializer {
	private static final ImageLoader imageLoader = new ImageLoader();

	public static final String serialize(ImageData imageData) {
		imageLoader.data = new ImageData[] { imageData };
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		imageLoader.save(baos, SWT.IMAGE_PNG);
		try {
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new String(Base64Coder.encode(baos.toByteArray()));
	}

	public static final ImageData deserialize(String code) {
		ByteArrayInputStream is = new ByteArrayInputStream(Base64Coder.decode(code));
		imageLoader.load(is);
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (imageLoader.data.length > 0) {
			return imageLoader.data[0];
		} else {
			return null;
		}
	}
}

package net.jeeeyul.pdetools.shared;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

public class ResourceExtensionHelper {
	public static byte[] load(IFile file) throws CoreException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int len = -1;
		InputStream is = file.getContents();
		while ((len = is.read(buf)) != -1) {
			baos.write(buf, 0, len);
		}
		is.close();
		byte[] bytes = baos.toByteArray();
		return bytes;
	}
}

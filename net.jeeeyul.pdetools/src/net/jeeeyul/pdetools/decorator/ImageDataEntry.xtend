package net.jeeeyul.pdetools.decorator

import org.eclipse.core.resources.IFile
import org.eclipse.swt.graphics.ImageData

@Data class ImageDataEntry {
	IFile file
	ImageData imageData
}
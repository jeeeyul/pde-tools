package net.jeeeyul.pdetools.decorator

import org.eclipse.core.resources.IFile
import org.eclipse.jface.viewers.BaseLabelProvider
import org.eclipse.jface.viewers.IDecoration
import org.eclipse.jface.viewers.ILightweightLabelDecorator

import static net.jeeeyul.pdetools.decorator.IconDecorator.*
import org.eclipse.jface.resource.ImageDescriptor

class IconDecorator extends BaseLabelProvider implements ILightweightLabelDecorator {
	static val IMAGE_FILES = newArrayList("jpg", "gif", "png", "bmp")

	override decorate(Object element, IDecoration decoration) {
		if(element instanceof IFile) {
			var file = element as IFile
			if(file.isImageFile()) {
				doDecorateImageFile(file, decoration)
			}
		}
	}

	def doDecorateImageFile(IFile file, IDecoration decoration) {
		var url = file.rawLocationURI.toURL
		decoration.addOverlay(ImageDescriptor::createFromURL(url), IDecoration::REPLACE)
	}

	def boolean isImageFile(IFile file) {
		if(!file.exists) {
			return false
		}
		return IMAGE_FILES.contains(file.projectRelativePath.fileExtension.toLowerCase)
	}
}
package net.jeeeyul.pdetools.icg.builder

import net.jeeeyul.pdetools.shared.Base64Coder
import net.jeeeyul.pdetools.shared.ResourceExtensions
import org.eclipse.core.resources.IFile

class ImagePreviewGenerator {
	extension ResourceExtensions = new ResourceExtensions()
	val DATA_URI_SIZE_LIMIT = 32768L ;

	def generate(IFile file) {
		var content = file.contentAsBytes
		if(content.size>DATA_URI_SIZE_LIMIT) {
			return "[Image file is too big or not valid]"
		} else {
			'''<img src="data:image/« file.projectRelativePath.fileExtension »;base64,« new String(Base64Coder::encode(content)) »">'''.toString
		}
	}
}
package net.jeeeyul.pdetools.clipboard

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.SWT
import org.eclipse.ui.PlatformUI
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.swt.graphics.ImageLoader
import java.io.ByteArrayOutputStream
import net.jeeeyul.pdetools.shared.Base64Coder

class ClipEntryInformationGenerator {
	def generate(ClipboardEntry entry)'''
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title></title>
		</head>
		<style>
			html, body{
				background-color: «Display::^default.getSystemColor(SWT::COLOR_INFO_BACKGROUND).RGB.toHtmlColor»;
				margin: 0px;
				padding: 0px;
			}
			
			*{
				font-family: Helvetica, "Segoe UI";
				font-size: 13px;
			}
			h1, h2, h3{
				font-size: 15px;
				margin: 5px;
			}
			
			ul{
				margin-top: 5px;
			}
		</style>
		<script type="text/javascript">
			
		</script>
		<body>
			«IF entry.partId != null»
				<h2>
					«entry.partId.asPartIcon» Captured from «entry.partId.asPartName»
				</h2>
			«ELSE»
				<h2>Capture Information</h2>
			«ENDIF»
			<ul>
				«IF entry.releatedFile != null»
					<li>
						Resource: 
						<a href="#" onclick="openResource('«entry.releatedFile.fullPath.toPortableString»')">
							«entry.releatedFile.name»
						</a>
					</li>
				«ENDIF»
				«IF entry.takenTime != null»
					<li>
						Time: «entry.takenTime.toLocaleString»
					</li>
				«ENDIF»
			</ul>
			
			<h2>Stats</h2>
			<ul>
				<li>«entry.usingCount.times» used.</li>
			</ul>
		</body>
		</html>
	'''

	def private String toHtmlColor(RGB rgb){
		return String::format("#%02x%02x%02x", rgb.red, rgb.green, rgb.blue)
	}

	def asPartName(String partId){
		if(PlatformUI::workbench.editorRegistry.findEditor(partId) != null) {
			PlatformUI::workbench.editorRegistry.findEditor(partId)?.label
		} else {
			PlatformUI::workbench.viewRegistry.find(partId)?.label
		}
	}

	def asPartIcon(String partId){
		var ImageDescriptor descriptor = if(PlatformUI::workbench.editorRegistry.findEditor(partId) != null) {
			PlatformUI::workbench.editorRegistry.findEditor(partId)?.imageDescriptor
		} else {
			PlatformUI::workbench.viewRegistry.find(partId)?.imageDescriptor
		}
		if(descriptor != null) {
			var io = new ImageLoader()
			io.data = newArrayList(descriptor.imageData)
			var baos = new ByteArrayOutputStream()
			io.save(baos, SWT::IMAGE_PNG);
			var result = '''<img src="data:image/png;base64,«new String(Base64Coder::encode(baos.toByteArray))»">'''
			return result
		}
		return ""
	}

	def times(int times){
		if(times == 0) {
			return "Never"
		} else
			if(times == 1) {
				return "1 time"
			} else {
				return times + " times"
			}
	}
}
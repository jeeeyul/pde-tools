package net.jeeeyul.pdetools.clipboard

import java.io.ByteArrayOutputStream
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry
import net.jeeeyul.pdetools.shared.Base64Coder
import net.jeeeyul.pdetools.shared.ElapsedTimeLabelProvider
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.ImageLoader
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.widgets.Display
import org.eclipse.ui.PlatformUI
import java.text.DateFormat

class ClipEntryInformationGenerator {
	ElapsedTimeLabelProvider elapsedTimeLabelProvider = new ElapsedTimeLabelProvider

	def generate(ClipboardEntry entry) '''
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title></title>
		</head>
		<style>
			html, body{
				background-color: «Display::getDefault().getSystemColor(SWT::COLOR_INFO_BACKGROUND).RGB.toHtmlColor»;
				margin: 0px;
				padding: 5px;
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
			
			.line-wrap{
				word-wrap:break-word;
			}
			
			pre{
				margin: 5px;
				margin-left: 10px;
			}
			
			span.tab{
				width: 1em;
				height: 1em;
				display:inline-block;
				overflow: hidden;
			}
		</style>
		<script type="text/javascript">
			
		</script>
		<body>
			«IF entry.partId !== null»
				<h2>
					«entry.partId.asPartIcon» Captured from «entry.partId.asPartName»
				</h2>
			«ELSE»
				<h2>Capture Information</h2>
			«ENDIF»
			<ul>
				«IF entry.javaInfo !== null && entry.releatedFile !== null && entry.textRange !== null»
					<li>Java Element: 
						<a href="#" class="line-wrap" onclick="openResource('«entry.releatedFile.fullPath.toPortableString»', «entry.textRange.offset», «entry.textRange.length»)">
							«IF entry.javaInfo.enclosingElementName !== null»
								«entry.javaInfo.enclosingElementName» (Line: «entry.textRange.startLine + 1»)
							«ELSE»
								«entry.javaInfo.qualifiedTypeName» (Line: «entry.textRange.startLine + 1»)
							«ENDIF»
						</a>
					</li>
				«ELSEIF entry.javaInfo !== null && entry.releatedFile === null && entry.textRange !== null»
					<li>Java Element: 
						<a href="#" class="line-wrap" onclick="openJavaElement('«entry.javaInfo.qualifiedTypeName»', «entry.textRange.offset», «entry.textRange.length»)">
							«IF entry.javaInfo.enclosingElementName !== null»
								«entry.javaInfo.enclosingElementName» (Line: «entry.textRange.startLine + 1»)
							«ELSE»
								«entry.javaInfo.qualifiedTypeName» (Line: «entry.textRange.startLine + 1»)
							«ENDIF»
						</a>
					</li>
				«ELSEIF entry.javaInfo !== null && entry.releatedFile === null && entry.textRange === null»
					<li>Java Element: 
						<a href="#" class="line-wrap" onclick="openJavaElement('«entry.javaInfo.qualifiedTypeName»')">
							«IF entry.javaInfo.enclosingElementName !== null»
								«entry.javaInfo.enclosingElementName»
							«ELSE»
								«entry.javaInfo.qualifiedTypeName»
							«ENDIF»
						</a>
					</li>
				«ELSEIF entry.releatedFile !== null && entry.textRange === null»
					<li>
						Resource: 
						<a href="#" onclick="openResource('«entry.releatedFile.fullPath.toPortableString»')">
							«entry.releatedFile.name»
						</a>
					</li>
				«ELSEIF entry.releatedFile !== null && entry.textRange !== null»
					<li>
						Resource: 
						<a href="#" onclick="openResource('«entry.releatedFile.fullPath.toPortableString»', «entry.textRange.offset», «entry.textRange.length»)">
							«entry.releatedFile.name» (Line: «entry.textRange.startLine + 1»)
						</a>
					</li>
				«ELSEIF entry.partId === null»
					<li>
						Unknown location, Captured from outside of Workbench.
					</li>
				«ENDIF»
				
				«IF entry.takenTime !== null»
					<li>
						Time: «DateFormat.dateTimeInstance.format(entry.takenTime)»
					</li>
				«ENDIF»
			</ul>
			
			<h2>Stats</h2>
			<ul>
				<li>«entry.usingCount.times» used.</li>
				«IF entry.lastUsedTime !== null»
					<li>Recent using: «elapsedTimeLabelProvider.getText(entry.lastUsedTime)»</li>
				«ENDIF»
			</ul>
			
			<h2>Full Content</h2>
			<pre>
		«entry.textContent.replace("<", "&lt;").replace(">", "&gt;").replace("\t", '''<span class="tab">«"\t"»</span>''')»
			</pre>
		</body>
		</html>
	'''

	def private String toHtmlColor(RGB rgb) {
		return String::format("#%02x%02x%02x", rgb.red, rgb.green, rgb.blue)
	}

	def asPartName(String partId) {
		if (PlatformUI::workbench.editorRegistry.findEditor(partId) !== null) {
			PlatformUI::workbench.editorRegistry.findEditor(partId)?.label
		} else {
			PlatformUI::workbench.viewRegistry.find(partId)?.label
		}
	}

	def asPartIcon(String partId) {
		var ImageDescriptor descriptor = if (PlatformUI::workbench.editorRegistry.findEditor(partId) !== null) {
				PlatformUI::workbench.editorRegistry.findEditor(partId)?.imageDescriptor
			} else {
				PlatformUI::workbench.viewRegistry.find(partId)?.imageDescriptor
			}
		if (descriptor !== null) {
			var io = new ImageLoader()
			io.data = newArrayList(descriptor.imageData)
			var baos = new ByteArrayOutputStream()
			io.save(baos, SWT::IMAGE_PNG);
			var result = '''<img src="data:image/png;base64,«new String(Base64Coder::encode(baos.toByteArray))»">'''
			return result
		}
		return ""
	}

	def times(int times) {
		if (times == 0) {
			return "Never"
		} else if (times == 1) {
			return "1 time"
		} else {
			return times + " times"
		}
	}

	def String lastSegment(String source) {
		if (source === null) {
			return ""
		}

		source.split("\\.").last
	}

	def String lineWrapable(String source) {
		if (source === null) {
			return ""
		}

		source.split("\\.").join(".")['''<span class="line-wrap">«it»</span>'''].toString
	}
}

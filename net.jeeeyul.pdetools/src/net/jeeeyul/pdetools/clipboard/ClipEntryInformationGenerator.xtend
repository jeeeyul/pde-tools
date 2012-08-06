package net.jeeeyul.pdetools.clipboard

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.SWT

class ClipEntryInformationGenerator {
	def generate(ClipboardEntry entry)'''
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title></title>
		</head>
		<style>
			body{
				background-color: «Display::^default.getSystemColor(SWT::COLOR_INFO_BACKGROUND).RGB.toHtmlColor»;
			}
			
			*{
				font-size: 13px;
			}
			h1, h2, h3{
				margin: 5px;
			}
			
			ul{
				margin-top: 5px;
			}
		</style>
		<script type="text/javascript">
			
		</script>
		<body>
			<h2>Captured From</h2>
			<ul>
				«IF entry.partId != null»
					<li>
						Part ID: «entry.partId»
					</li>
				«ENDIF»
				«IF entry.releatedFile != null»
					<li>
						Resource: <a href="#" onclick="openResource('«entry.releatedFile.fullPath.toPortableString»')">«entry.releatedFile.fullPath.toPortableString»</a>
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
				<li>«entry.usingCount» time(s) used.</li>
			</ul>
		</body>
		</html>
	'''
	
	def private String toHtmlColor(RGB rgb){
		return String::format("#%02x%02x%02x", rgb.red, rgb.green, rgb.blue)
	}
}
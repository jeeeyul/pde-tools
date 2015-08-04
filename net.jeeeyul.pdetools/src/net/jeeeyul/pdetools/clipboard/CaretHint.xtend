package net.jeeeyul.pdetools.clipboard

import org.eclipse.swt.custom.StyledText
import org.eclipse.swt.widgets.Text

class CaretHint {
	@Property int x
	@Property int y
	@Property int height

	def static capture(StyledText styledText){
		new CaretHint() => [
			var location = styledText.caret.location
			location = styledText.toDisplay(location)
			x = location.x
			y = location.y
			height = styledText.caret.bounds.height
		]
	}

	def static capture(Text text){
		new CaretHint() => [
			var location = text.caretLocation
			location = text.toDisplay(location)
			x = location.x
			y = location.y
			height = text.lineHeight
		]
	}
}
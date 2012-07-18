package net.jeeeyul.pdetools.clipboard

import org.eclipse.swt.custom.StyleRange
import org.eclipse.xtend.lib.Property

class StyleAndText {
	@Property StyleRange[] styleRanges
	@Property String text

	override String toString(){
		text
	}
}
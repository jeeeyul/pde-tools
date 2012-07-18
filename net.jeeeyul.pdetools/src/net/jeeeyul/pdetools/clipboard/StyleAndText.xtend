package net.jeeeyul.pdetools.clipboard

import org.eclipse.swt.custom.StyleRange
import org.eclipse.xtend.lib.Property

/**
 * SWT RTF
 */
class StyleAndText {
	@Property StyleRange[] styleRanges
	@Property String text

	override String toString(){
		text
	}
}
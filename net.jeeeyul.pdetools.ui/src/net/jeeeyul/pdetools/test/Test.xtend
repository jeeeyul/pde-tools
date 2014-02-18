package net.jeeeyul.pdetools.test

import net.jeeeyul.swtend.SWTExtensions
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite

class Test {
	extension SWTExtensions = SWTExtensions::INSTANCE
	
	def test(){
		new Composite(null, SWT::NORMAL)=>[
			newComposite[
				newComposite[
					
				]
			]
		];
	}
}
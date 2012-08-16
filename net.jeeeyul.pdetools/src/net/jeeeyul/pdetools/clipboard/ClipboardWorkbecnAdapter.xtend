package net.jeeeyul.pdetools.clipboard

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry
import net.jeeeyul.pdetools.shared.SharedImages
import org.eclipse.ui.model.IWorkbenchAdapter

class ClipboardWorkbecnAdapter implements IWorkbenchAdapter {
	public static val INSTANCE = new ClipboardWorkbecnAdapter

	override getChildren(Object o) {
		switch o {
			ClipHistory:
				o.entries
				
			default:
				emptyList
		}
	}
	
	override getImageDescriptor(Object object) {
		switch(object){
			ClipHistory:
				SharedImages::getImageDescriptor(SharedImages::CLIPBOARD)
			
			ClipboardEntry:
				SharedImages::getImageDescriptor(SharedImages::CLIPBOARD)
			
			default: null
		}
	}
	
	override getLabel(Object o) {
		switch(o){
			ClipHistory:
				"Clipboard"
			
			ClipboardEntry:
				"Clip Entry"				
			
			default:
				if(o != null){
					o.^class.name
				}else{
					null
				}
		}
	}
	
	override getParent(Object o) {
		switch(o){
			ClipboardEntry:
				o.parent
			
			default: null
		}
	}
}
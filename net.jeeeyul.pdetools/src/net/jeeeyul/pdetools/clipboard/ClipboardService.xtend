package net.jeeeyul.pdetools.clipboard

import java.util.Date
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.runtime.jobs.ILock
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.ui.handlers.HandlerUtil

import static extension net.jeeeyul.pdetools.clipboard.ClipboardService.*

class ClipboardService extends AbstractClipboardService {
	extension ClipboardFactory = ClipboardFactory::eINSTANCE
	static ClipboardService INSTANCE;
	static ILock lock = Job::jobManager.newLock()

	def static initailze(){
		lock.acquire()
		try{
			if(INSTANCE == null) {
				INSTANCE = new ClipboardService()
			}
		}finally{
			lock.release()
		}
	}

	def static getInstance(){
		lock.acquire()
		try{
			if(INSTANCE == null) {
				initailze()
			}
		}finally{
			lock.release()
		}
		return INSTANCE
	}

	private new(){
	}
	
	def createClipEntry(){
		var entry = createClipboardEntry() => [
			it.textContent = nativeClipboard.getContents(textTransfer) as String
			if(nativeClipboard.availableTypes.exists[RTFTransfer.isSupportedType(it)]) {
				it.rtfContent = nativeClipboard.getContents(RTFTransfer) as String
			}
		]
		return entry;
	}

	override protected handleCopy(ExecutionEvent event) {
		var hasTextContents = nativeClipboard.availableTypes.exists[ textTransfer.isSupportedType(it) ]
		if(!hasTextContents) {
			return;
		}
		
		if(!history.entries.empty){
			if(history.entries.head.textContent == nativeClipboard.getContents(textTransfer) as String){
				return;
			}
		}
		
		var entry = createClipEntry()
		
		var part = HandlerUtil::getActivePart(event)
		
		
		if(part != null){
			entry.imageData = part.titleImage.imageData
			entry.partId = part.site.id
		}
		
		entry.takenTime = new Date()
		
		history.entries.add(0, entry)
	}
}
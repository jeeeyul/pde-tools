package net.jeeeyul.pdetools.snapshot

import org.eclipse.jface.viewers.LabelProvider
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry

class SnapshotLabelProvider extends LabelProvider {
	
	def dispatch String getText(Object element) {
		"Unknown"
	}
	
	def dispatch String getText(SnapshotGroup group){
		group.date.toString
	}
	
	def dispatch String getText(SnapshotEntry entry){
		entry.fileName
	}
	
}
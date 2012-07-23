package net.jeeeyul.pdetools.snapshot

import org.eclipse.jface.viewers.LabelProvider
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.IPath
import org.eclipse.jface.resource.ImageRegistry
import org.eclipse.swt.graphics.Image
import java.io.FileInputStream
import org.eclipse.swt.widgets.Display

class SnapshotLabelProvider extends LabelProvider {
	ImageRegistry registry = new ImageRegistry()

	def dispatch String getText(Object element) {
		null
	}

	def dispatch String getText(SnapshotGroup group){
		group.date.toString
	}

	def dispatch String getText(SnapshotEntry entry){
		null
	}

	def dispatch getImage(Object element) {
		null
	}

	def dispatch getImage(SnapshotEntry entry){
		var IPath basePath = new Path(entry.parent.parent.repositoryLocation)
		basePath = basePath.setDevice(null).removeLastSegments(1).append(entry.fileName)
		var file = basePath.toFile;
		var result = registry.get(file.absolutePath) as Image
		if(result == null) {
			result = new Image(Display::^default, new FileInputStream(file));
			registry.put(file.absolutePath, result)
		}
		result
	}

	override dispose() {
		registry.dispose()
	}
}
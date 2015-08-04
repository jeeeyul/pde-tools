package net.jeeeyul.pdetools.snapshot

import net.jeeeyul.pdetools.model.pdetools.SnapshotGroup
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.Viewer

class SnapshotContentProvider implements ITreeContentProvider{
	override getChildren(Object parentElement) {
		(parentElement as SnapshotGroup).entries.toArray
	}
	
	override getElements(Object inputElement) {
		(inputElement as SnapshotRepository).groups.toArray
	}
	
	override getParent(Object element) {
		return (element as EObject).eContainer
	}
	
	override hasChildren(Object element) {
		element instanceof SnapshotGroup
	}
	
	override dispose() {
	}
	
	override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
	
}
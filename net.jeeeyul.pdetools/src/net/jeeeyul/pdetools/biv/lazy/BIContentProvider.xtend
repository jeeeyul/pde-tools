package net.jeeeyul.pdetools.biv.lazy

import java.util.ArrayList
import java.util.List
import net.jeeeyul.pdetools.PDEToolsCore
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.Viewer
import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer
import net.jeeeyul.pdetools.biv.lazy.BundleResolver
import net.jeeeyul.pdetools.shared.SWTExtensions

class BIContentProvider implements ITreeContentProvider {
	extension SWTExtensions = SWTExtensions::INSTANCE
	
	private List<BundleEntry> model
	private GalleryTreeViewer viewer;
	private BundleResolver resolver = new BundleResolver()
	
	new(){
		resolver.resolvingHandler = [BundleEntry bundleEntry|
			schedule[
				viewer?.refresh(bundleEntry)
			]
		]
	}
	
	override getChildren(Object parentElement) {
		switch(parentElement){
			BundleEntry:{
				switch(parentElement.state){
					case BundleEntry::RESOLVED:{
						return parentElement.entries.toArray()
					}
					
					case BundleEntry::UNRESOLVED:{
						parentElement.state = BundleEntry::RESOLVING
						resolver.add(parentElement)
						schedule[viewer?.update(parentElement, null)]
						return emptyList.toArray()
					}
					
					default:{
						return emptyList.toArray()
					}	
				}
			}
			
			default:{
				emptyList.toArray()
			}
		}
	}
	
	override getElements(Object inputElement) {
		if(model == null){
			model = new ArrayList<BundleEntry>
			
			for(each : PDEToolsCore::^default.bundle.bundleContext.bundles){
				model += new BundleEntry() => [
					it.bundle = each
				]
			}
		}

		return model.toArray()
	}
	
	override getParent(Object element) {
		switch(element){
			URLImageEntry:{
				element.parent
			}
			
			default:{
				null
			}
		}
	}
	
	override hasChildren(Object element) {
		switch(element){
			BundleEntry case element.resolved: {
				element.entries.size > 0	
			}
			
			BundleEntry case !element.resolved: {
				false
			}
			
			default:{
				false
			}
		}
	}
	
	override dispose() {
		this.viewer = null
		model.clear()
		model = null
	}
	
	override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(!(viewer instanceof GalleryTreeViewer)){
			this.viewer = null
			throw new IllegalArgumentException("Gallery Tree Viewer Only!")
		}
		
		this.viewer = viewer as GalleryTreeViewer
	}
	
}
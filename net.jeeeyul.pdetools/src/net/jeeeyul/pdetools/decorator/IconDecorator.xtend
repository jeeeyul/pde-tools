package net.jeeeyul.pdetools.decorator

import java.util.HashMap
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.viewers.BaseLabelProvider
import org.eclipse.jface.viewers.IDecoration
import org.eclipse.jface.viewers.ILightweightLabelDecorator
import org.eclipse.jface.viewers.LabelProviderChangedEvent
import org.eclipse.swt.graphics.ImageData
import org.eclipse.swt.widgets.Display
import java.util.ArrayList
import org.eclipse.jface.viewers.DecorationContext
import static net.jeeeyul.pdetools.decorator.IconDecorator.*

class IconDecorator extends BaseLabelProvider implements ILightweightLabelDecorator, IResourceChangeListener {
	static val IMAGE_FILES = newArrayList("jpg", "gif", "png", "bmp")
	HashMap<IFile, ImageData> decoratedFiles = new HashMap()
	ImageLoadingQueue queue

	new(){
		queue = new ImageLoadingQueue()
		queue.loadHandler = [loaded]
		ResourcesPlugin::workspace.addResourceChangeListener(this)
	}

	override decorate(Object element, IDecoration decoration) {
		if(element instanceof IFile) {
			var file = element as IFile
			if(file.isImageFile()) {
				doDecorateImageFile(file, decoration)
			}
		}
	}

	def doDecorateImageFile(IFile file, IDecoration decoration) {
		if(decoratedFiles.containsKey(file)) {
			var data = decoratedFiles.get(file)
			if(data != null)
				decoration.replaceImage(ImageDescriptor::createFromImageData(data))
		} else {
			queue.add(file)
		}
	}

	def replaceImage(IDecoration decoration, ImageDescriptor descriptor){
		var ctx = decoration.decorationContext
		if(ctx instanceof DecorationContext) {
			var ctxImpl = ctx as DecorationContext
			ctxImpl.putProperty(IDecoration::ENABLE_REPLACE, Boolean::TRUE)
		}
		decoration.addOverlay(descriptor, IDecoration::REPLACE)
	}

	def boolean isImageFile(IFile file) {
		if(!file.exists) {
			return false
		}
		if(file.projectRelativePath.fileExtension == null){
			return false;
		}
		return IMAGE_FILES.contains(file.projectRelativePath.fileExtension.toLowerCase)
	}

	override resourceChanged(IResourceChangeEvent event) {
		var delta = event.delta
		if(delta == null) {
			return
		}
		for(eachFile : new ArrayList(decoratedFiles.keySet)){
			var eachDelta = delta.findMember(eachFile.fullPath)
			if(eachDelta != null) {
				switch(eachDelta.kind) {
					case IResourceDelta::REMOVED: {
						decoratedFiles.remove(eachFile)
					}
				default:{
						queue.add(eachFile)
					}
				}
			}
		}
	}

	override dispose() {
		decoratedFiles.clear()
		ResourcesPlugin::workspace.removeResourceChangeListener(this)
		super.dispose()
	}

	def void loaded(ImageDataEntry[] datas) {
		datas.forEach[ decoratedFiles.put(file, imageData) ]
		val me = this
		Display::getDefault().asyncExec([|
			fireLabelProviderChanged(new LabelProviderChangedEvent(me))
		]);
	}
}
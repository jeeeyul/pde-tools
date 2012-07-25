package net.jeeeyul.pdetools.decorator;

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.DecorationContext;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.widgets.Display;

public class MonitorFolderDecorator extends BaseLabelProvider implements ILightweightLabelDecorator,
		IResourceChangeListener {
	public MonitorFolderDecorator() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	@Override
	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof IFolder) {
			IFolder folder = (IFolder) element;
			ICGConfiguration config = new ICGConfiguration(folder.getProject());
			if (folder.equals(config.getMonitoringFolder())) {
				replaceImage(decoration, SharedImages.getImageDescriptor(SharedImages.IMAGE_FOLDER));
				decoration.addSuffix(" (Shared Image Folder)");
			}
		}
	}

	private void replaceImage(IDecoration decoration, ImageDescriptor descriptor) {
		IDecorationContext ctx = decoration.getDecorationContext();
		if (ctx instanceof DecorationContext) {
			DecorationContext ctxImpl = (DecorationContext) ctx;
			ctxImpl.putProperty(IDecoration.ENABLE_REPLACE, Boolean.TRUE);
		}
		decoration.addOverlay(descriptor, IDecoration.REPLACE);
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return super.isLabelProperty(element, property);
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		IPath path = new Path(".settings/net.jeeeyul.pdetools.icg.prefs");
		IResourceDelta delta = event.getDelta();
		if (delta == null) {
			return;
		}
		for (IProject each : projects) {
			if (delta.findMember(each.getFile(path).getFullPath()) != null) {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						fireLabelProviderChanged(new LabelProviderChangedEvent(MonitorFolderDecorator.this));
					}
				});
				return;
			}
		}
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
}

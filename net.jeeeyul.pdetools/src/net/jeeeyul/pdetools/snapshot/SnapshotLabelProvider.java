package net.jeeeyul.pdetools.snapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry;
import net.jeeeyul.pdetools.model.pdetools.SnapshotGroup;
import net.jeeeyul.pdetools.shared.ImageLoadingEntry;
import net.jeeeyul.pdetools.shared.ImageLoadingQueue;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SnapshotLabelProvider extends LabelProvider {
	private ImageRegistry registry = new ImageRegistry();
	private ImageLoadingQueue<SnapshotEntry> loadingQueue = new ImageLoadingQueue<SnapshotEntry>();
	private EContentAdapter listener = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			int eventType = notification.getEventType();
			if (eventType == Notification.REMOVE || eventType == Notification.REMOVE_MANY) {
				handleRemovedItem(notification.getOldValue());
			}
			super.notifyChanged(notification);
		};
	};

	public SnapshotLabelProvider() {
		loadingQueue.setImageLoader(new Function1<SnapshotEntry, ImageData>() {
			@Override
			public ImageData apply(SnapshotEntry p) {
				ImageData imageData = new ImageData(p.getAbsoulteVisibleFilePath());
				return ImageScaler.scale(imageData, 200);
			}
		});

		loadingQueue.setLoadHandler(new Procedure1<List<ImageLoadingEntry<SnapshotEntry>>>() {
			@Override
			public void apply(List<ImageLoadingEntry<SnapshotEntry>> result) {
				handleLoad(result);
			}
		});

		SnapshotCore.getRepository().eAdapters().add(listener);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof SnapshotEntry) {
			SnapshotEntry entry = (SnapshotEntry) element;
			Image image = registry.get(entry.getAbsoulteVisibleFilePath());
			if (image == null) {
				loadingQueue.add(entry);
				return SharedImages.getImage(SharedImages.REFRESH);
			} else {
				return image;
			}

		} else {
			return null;
		}
	}

	@Override
	public String getText(Object element) {
		if (element instanceof SnapshotGroup) {
			return ((SnapshotGroup) element).getDate().toString();
		} else {
			return null;
		}
	}

	public void dispose() {
		SnapshotCore.getRepository().eAdapters().remove(listener);
		this.registry.dispose();
	}

	public void handleLoad(final List<ImageLoadingEntry<SnapshotEntry>> result) {
		final List<SnapshotEntry> changedElements = new ArrayList<SnapshotEntry>();
		for (ImageLoadingEntry<SnapshotEntry> each : result) {
			registry.put(each.key.getAbsoulteVisibleFilePath(), ImageDescriptor.createFromImageData(each.image));
			changedElements.add(each.key);
		}

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				fireLabelProviderChanged(new LabelProviderChangedEvent(SnapshotLabelProvider.this, changedElements
						.toArray()));
			}
		});
	}

	protected void handleRemovedItem(Object oldValue) {
		List<SnapshotEntry> entries = resoveEntries(oldValue);

		IPath path = new Path(SnapshotCore.getRepository().getRepositoryLocation()).removeLastSegments(1).setDevice(
				null);

		for (SnapshotEntry each : entries) {
			IPath filePath = path.append(each.getOriginalFile());
			registry.remove(filePath.toFile().getAbsolutePath());
		}

		System.out.println(entries.size() + "개의 이미지가 정리 됨");
	}

	private List<SnapshotEntry> resoveEntries(Object obj) {
		ArrayList<SnapshotEntry> result = new ArrayList<SnapshotEntry>();
		if (obj instanceof Collection<?>) {
			for (Object each : (Collection<?>) obj) {
				result.addAll(resoveEntries(each));
			}
		} else if (obj instanceof SnapshotEntry) {
			result.add((SnapshotEntry) obj);
		}

		else if (obj instanceof SnapshotGroup) {
			result.addAll(((SnapshotGroup) obj).getEntries());

		}
		return result;
	}
}

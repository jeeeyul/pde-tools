package net.jeeeyul.pdetools.snapshot;

import net.jeeeyul.pdetools.shared.DeferredViewerUpdate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class SnapshotView extends ViewPart {
	public static final String ID = "net.jeeeyul.pdetools.snapshot.SnapshotView";
	private GalleryTreeViewer viewer;
	private EContentAdapter refresher = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			if (!notification.isTouch()) {
				getUpdate().schedule();
			}
			super.notifyChanged(notification);
		};
	};

	private DeferredViewerUpdate<GalleryTreeViewer> update;

	@Override
	public void createPartControl(Composite parent) {
		viewer = new GalleryTreeViewer(parent, SWT.V_SCROLL);
		viewer.setContentProvider(new SnapshotContentProvider());
		viewer.setLabelProvider(new SnapshotLabelProvider());
		viewer.setInput(SnapshotCore.getRepository());

		SnapshotCore.getRepository().eAdapters().add(refresher);
	}

	@Override
	public void dispose() {
		SnapshotCore.getRepository().eAdapters().remove(refresher);
		super.dispose();
	}

	public DeferredViewerUpdate<GalleryTreeViewer> getUpdate() {
		if (update == null) {
			update = new DeferredViewerUpdate<GalleryTreeViewer>(viewer) {
				@Override
				protected void update(GalleryTreeViewer viewer) {
					viewer.refresh();
				}
			};
		}
		return update;
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}

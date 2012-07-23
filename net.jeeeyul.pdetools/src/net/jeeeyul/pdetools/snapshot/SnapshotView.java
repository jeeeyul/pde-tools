package net.jeeeyul.pdetools.snapshot;

import java.util.ArrayList;
import java.util.List;

import net.jeeeyul.pdetools.shared.DeferredViewerUpdate;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.nebula.widgets.gallery.DefaultGalleryGroupRenderer;
import org.eclipse.nebula.widgets.gallery.DefaultGalleryItemRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.part.ViewPart;

public class SnapshotView extends ViewPart {
	public static final String ID = "net.jeeeyul.pdetools.snapshot.SnapshotView";
	private GalleryTreeViewer viewer;
	private EContentAdapter refresher = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			if (!notification.isTouch()) {
				handleModelChange();
			}
			super.notifyChanged(notification);
		};
	};

	private List<SnapshotAction> snapshotActions = new ArrayList<SnapshotAction>();

	private DeferredViewerUpdate<GalleryTreeViewer> update;

	@Override
	public void createPartControl(Composite parent) {
		viewer = new GalleryTreeViewer(parent, SWT.V_SCROLL | SWT.MULTI);
		viewer.setContentProvider(new SnapshotContentProvider());
		viewer.setLabelProvider(new SnapshotLabelProvider());
		viewer.setInput(SnapshotCore.getRepository());

		DefaultGalleryGroupRenderer rederer = (DefaultGalleryGroupRenderer) viewer.getGallery().getGroupRenderer();
		rederer.setAutoMargin(true);

		DefaultGalleryItemRenderer itemRenderer = (DefaultGalleryItemRenderer) viewer.getGallery().getItemRenderer();
		itemRenderer.setDropShadows(true);
		itemRenderer.setDropShadowsSize(5);

		SnapshotCore.getRepository().eAdapters().add(refresher);

		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuManager, viewer);

		getSite().setSelectionProvider(viewer);

		RemoveAllAction removeAllAction = new RemoveAllAction(SnapshotCore.getRepository());
		snapshotActions.add(removeAllAction);
		getViewSite().getActionBars().getToolBarManager().add(removeAllAction);

		configureDragSource();
	}

	private void configureDragSource() {
		DragSource dragSource = new DragSource(viewer.getControl(), DND.DROP_COPY);
		dragSource.setTransfer(new Transfer[] { FileTransfer.getInstance() });
		dragSource.addDragListener(new DragSourceListener() {
			@Override
			public void dragStart(DragSourceEvent event) {
				event.doit = !getSelection().isEmpty();
				if (event.doit) {
					event.detail = DND.DROP_COPY;
				}
			}

			@Override
			public void dragSetData(DragSourceEvent event) {
				List<SnapshotEntry> selection = getSelection();
				List<String> result = new ArrayList<String>();
				for (SnapshotEntry each : selection) {
					result.add(each.getAbsoulteFilePath());
				}
				event.data = result.toArray(new String[result.size()]);
			}

			@Override
			public void dragFinished(DragSourceEvent event) {

			}
		});
	}

	@SuppressWarnings("unchecked")
	private List<SnapshotEntry> getSelection() {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		return new ArrayList<SnapshotEntry>(selection.toList());
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

	private void handleModelChange() {
		getUpdate().schedule();

		for (SnapshotAction eachAction : snapshotActions) {
			eachAction.update();
		}
	}
}

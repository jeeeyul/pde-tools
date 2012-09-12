package net.jeeeyul.pdetools.snapshot;

import java.util.ArrayList;
import java.util.List;

import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry;
import net.jeeeyul.pdetools.model.pdetools.provider.PdetoolsItemProviderAdapterFactory;
import net.jeeeyul.pdetools.shared.DeferredViewerUpdate;
import net.jeeeyul.pdetools.shared.SimpleGalleryItemRenderer;
import net.jeeeyul.pdetools.snapshot.editor.SnapshotEditor;
import net.jeeeyul.pdetools.snapshot.handlers.RemoveAllAction;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.nebula.widgets.gallery.DefaultGalleryGroupRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

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

	private void configureDragSource() {
		DragSource dragSource = new DragSource(viewer.getControl(), DND.DROP_COPY);
		dragSource.setTransfer(new Transfer[] { FileTransfer.getInstance() });
		dragSource.addDragListener(new DragSourceListener() {
			@Override
			public void dragFinished(DragSourceEvent event) {

			}

			@Override
			public void dragSetData(DragSourceEvent event) {
				List<SnapshotEntry> selection = getSelection();
				List<String> result = new ArrayList<String>();
				for (SnapshotEntry each : selection) {
					result.add(each.getAbsoulteVisibleFilePath());
				}
				event.data = result.toArray(new String[result.size()]);
			}

			@Override
			public void dragStart(DragSourceEvent event) {
				event.doit = !getSelection().isEmpty();
				if (event.doit) {
					event.detail = DND.DROP_COPY;
				}
			}
		});
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new GalleryTreeViewer(parent, SWT.V_SCROLL | SWT.MULTI);
		viewer.setContentProvider(new SnapshotContentProvider());
		viewer.setLabelProvider(new SnapshotLabelProvider());
		viewer.setInput(SnapshotCore.getRepository());

		DefaultGalleryGroupRenderer rederer = (DefaultGalleryGroupRenderer) viewer.getGallery().getGroupRenderer();
		rederer.setAutoMargin(true);

		SimpleGalleryItemRenderer itemRenderer = new SimpleGalleryItemRenderer();
		viewer.getGallery().setItemRenderer(itemRenderer);

		SnapshotCore.getRepository().eAdapters().add(refresher);

		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuManager, viewer);

		getSite().setSelectionProvider(viewer);

		RemoveAllAction removeAllAction = new RemoveAllAction(SnapshotCore.getRepository());
		snapshotActions.add(removeAllAction);
		getViewSite().getActionBars().getToolBarManager().add(removeAllAction);

		viewer.addOpenListener(new IOpenListener() {
			@Override
			public void open(OpenEvent event) {
				List<SnapshotEntry> selection = getSelection();
				if (selection.size() == 1) {
					doOpen(selection.get(0));
				}
			}
		});

		configureDragSource();
		updateActions();
	}

	@Override
	public void dispose() {
		SnapshotCore.getRepository().eAdapters().remove(refresher);
		super.dispose();
	}

	protected void doOpen(SnapshotEntry snapshotEntry) {
		try {
			getViewSite().getPage().openEditor(new SnapshotEditorInput(snapshotEntry), SnapshotEditor.ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private List<SnapshotEntry> getSelection() {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		return new ArrayList<SnapshotEntry>(selection.toList());
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

	private void handleModelChange() {
		getUpdate().schedule();
		updateActions();
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private void updateActions() {
		for (SnapshotAction eachAction : snapshotActions) {
			eachAction.update();
		}
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IPropertySheetPage.class) {
			PropertySheetPage page = new PropertySheetPage();
			page.setPropertySourceProvider(new AdapterFactoryContentProvider(new PdetoolsItemProviderAdapterFactory()));
			return page;
		}
		return super.getAdapter(adapter);
	}
}

package net.jeeeyul.pdetools.imagecrawl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ImageCrawlView extends ViewPart {
	public static final String ID = "net.jeeeyul.pdetools.imagecrawl.ImageCrawlView";
	private GalleryTreeViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		viewer = new GalleryTreeViewer(parent, SWT.MULTI | SWT.V_SCROLL);
		viewer.setContentProvider(new ICProvider());
		viewer.setLabelProvider(new ICLabelProvider());
		viewer.setInput(Object.class);

		configureDragSource();
	}

	@SuppressWarnings("unchecked")
	private List<URL> getSelection() {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		return new ArrayList<URL>(selection.toList());
	}

	private void configureDragSource() {
		DragSource dragSource = new DragSource(viewer.getControl(), DND.DROP_COPY);
		dragSource.setTransfer(new Transfer[] { FileTransfer.getInstance() });
		dragSource.addDragListener(new DragSourceListener() {
			@Override
			public void dragFinished(DragSourceEvent event) {

			}

			@Override
			public void dragSetData(DragSourceEvent event) {
				List<URL> selection = getSelection();
				List<String> result = new ArrayList<String>();
				for (URL each : selection) {
					result.add(each.toString());
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
	public void setFocus() {

	}

}

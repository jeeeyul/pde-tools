package net.jeeeyul.pdetools.snapshot;

import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class SnapshotView extends ViewPart {
	public static final String ID = "net.jeeeyul.pdetools.snapshot.SnapshotView";
	private GalleryTreeViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		viewer = new GalleryTreeViewer(parent, SWT.V_SCROLL);
		viewer.setContentProvider(new SnapshotContentProvider());
		viewer.setLabelProvider(new SnapshotLabelProvider());
		viewer.setInput(SnapshotCore.getRepository());
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

}

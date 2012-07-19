package net.jeeeyul.pdetools.clipboard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ClipboardView extends ViewPart {
	public static final String ID = "net.jeeeyul.pdetools.clipboard.ClipboardView";
	private ClipboardViewer viewer;

	public ClipboardViewer getViewer() {
		return viewer;
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new ClipboardViewer(parent, SWT.NORMAL);

	}

	@Override
	public void setFocus() {
		viewer.getTableViewer().getTable().setFocus();
	}

}

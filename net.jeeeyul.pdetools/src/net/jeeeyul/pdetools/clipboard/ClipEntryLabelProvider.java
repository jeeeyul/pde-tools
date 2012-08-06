package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class ClipEntryLabelProvider extends OwnerDrawLabelProvider {
	private StyleAndTextFactory factory;
	private TextLayout sharedLayout;

	private ColumnViewer viewer;

	public ClipEntryLabelProvider(IColorProvider colorProvider) {
		super();
		factory = new StyleAndTextFactory(colorProvider);
	}

	@Override
	public void dispose() {
		if (sharedLayout != null) {
			sharedLayout.dispose();
			sharedLayout = null;
		}
		super.dispose();
	}

	private void drawBadge(Event event, ClipboardEntry entry) {

	}

	@Override
	protected void erase(Event event, Object element) {
		event.detail &= ~SWT.FOREGROUND;
	}

	public TextLayout getSharedLayout() {
		if (sharedLayout == null) {
			sharedLayout = new TextLayout(getViewer().getControl().getDisplay());
			sharedLayout.setFont(getViewer().getControl().getFont());
			sharedLayout.setText(" ");
			int spaceWidth = sharedLayout.getBounds().width;
			sharedLayout.setTabs(new int[] { spaceWidth * 2 });
			sharedLayout.setSpacing(0);
		}
		return sharedLayout;
	}

	public ColumnViewer getViewer() {
		return viewer;
	}

	@Override
	protected void initialize(ColumnViewer viewer, ViewerColumn column) {
		this.viewer = viewer;
		super.initialize(viewer, column);
	}

	@Override
	protected void measure(Event event, Object element) {
		getSharedLayout().setFont(getViewer().getControl().getFont());
		getSharedLayout().setText("\r\n\r\n\r\n\r\n");
		event.height = getSharedLayout().getBounds().height;
	}

	@Override
	protected void paint(Event event, Object element) {
		TableItem item = (TableItem) event.item;
		Table table = item.getParent();
		table.setToolTipText("");
		boolean isLastItem = table.indexOf(item) == table.getItemCount() - 1;

		Rectangle bounds = item.getBounds();

		ClipboardEntry entry = (ClipboardEntry) element;
		getSharedLayout().setText(entry.getTextContent());

		if (entry.getRtfContent() != null && (event.detail & SWT.SELECTED) == 0) {
			StyleAndText data = factory.createFromRTFString(entry.getRtfContent());
			getSharedLayout().setText(data.getText());
			for (StyleRange each : data.getStyleRanges()) {
				getSharedLayout().setStyle(each, each.start, each.start + each.length);
			}
		} else {
			if ((event.detail & SWT.SELECTED) != 0) {
				getViewer().getControl().getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT);
			}
		}
		getSharedLayout().draw(event.gc, bounds.x, bounds.y);

		if (!isLastItem) {
			event.gc.setForeground(item.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			event.gc.setAlpha(40);
			event.gc.drawLine(0, bounds.y + bounds.height - 1, item.getParent().getSize().x, bounds.y + bounds.height
					- 1);
		}

		drawBadge(event, entry);
	}
}

package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;
import net.jeeeyul.pdetools.shared.ElapsedTimeLabelProvider;
import net.jeeeyul.swtend.SWTExtensions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.IViewDescriptor;

public class ClipEntryLabelProvider extends OwnerDrawLabelProvider {
	private SWTExtensions $ = SWTExtensions.INSTANCE;
	private StyleAndTextFactory factory;
	private TextLayout sharedLayout;
	private ElapsedTimeLabelProvider elapsedTimeLabelProvider = new ElapsedTimeLabelProvider();
	private int numberOfLineForRow = 5;
	private ColumnViewer viewer;
	private boolean colorizeTextOnSelection = false;

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

	@SuppressWarnings("deprecation")
	private void drawBadge(Event event, ClipboardEntry entry) {
		Table table = (Table) event.widget;
		TableItem item = (TableItem) event.item;
		Rectangle itemBounds = $.newRectangle(event);
		itemBounds.width = table.getClientArea().width;

		ImageDescriptor iconDescriptor = getImageDescriptor(entry);

		String text = elapsedTimeLabelProvider.getText(entry.getTakenTime());
		if (entry.isActive()) {
			text += " (Active)";
		}

		int r = 5;

		getSharedLayout().setText(text);

		Rectangle textBounds = $.resize(getSharedLayout().getBounds(), r, 0);
		if (iconDescriptor != null) {
			textBounds.width += iconDescriptor.getImageData().width;
		}

		Point textOffset = new Point(itemBounds.x + itemBounds.width - textBounds.width, itemBounds.y
				+ itemBounds.height - textBounds.height);

		Point boxOffset = $.getCopy(textOffset);

		$.translate(textOffset, -1, -1);
		$.translate(boxOffset, 0, -1);

		if (iconDescriptor != null) {
			$.translate(textOffset, 16, 0);
		}

		Path path = new Path(table.getDisplay());
		path.addArc(boxOffset.x - r, boxOffset.y - r, r * 2, r * 2, 90, 90);
		path.lineTo(boxOffset.x - r, boxOffset.y + textBounds.height);
		path.lineTo(boxOffset.x + textBounds.width, boxOffset.y + textBounds.height);
		path.lineTo(boxOffset.x + textBounds.width, boxOffset.y - r);
		path.lineTo(boxOffset.x, boxOffset.y - r);

		// badge background
		event.gc.setAlpha(255);
		event.gc.setBackground(table.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		event.gc.fillPath(path);

		// badge text
		event.gc.setForeground(item.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		getSharedLayout().draw(event.gc, textOffset.x, textOffset.y - r / 2 + 1);
		
		event.gc.setForeground(item.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		getSharedLayout().draw(event.gc, textOffset.x, textOffset.y - r / 2);
		path.dispose();

		// badge border
		event.gc.setForeground(item.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		event.gc.setAlpha(40);

		$.translate(boxOffset, -1, -1);
		path = new Path(table.getDisplay());
		path.addArc(boxOffset.x - r, boxOffset.y - r, r * 2, r * 2, 90, 90);
		path.lineTo(boxOffset.x - r, boxOffset.y + textBounds.height);
		path.lineTo(boxOffset.x + textBounds.width, boxOffset.y + textBounds.height);
		path.lineTo(boxOffset.x + textBounds.width, boxOffset.y - r);
		path.lineTo(boxOffset.x, boxOffset.y - r);
		event.gc.drawPath(path);
		path.dispose();

		// badge icon
		if (iconDescriptor != null) {
			event.gc.setAlpha(255);
			Image image = iconDescriptor.createImage();
			event.gc.drawImage(image, boxOffset.x - 2, boxOffset.y - r / 2 + 1);
			image.dispose();
		}
	}

	@Override
	protected void erase(Event event, Object element) {
		event.detail &= ~SWT.FOREGROUND;
	}

	private ImageDescriptor getImageDescriptor(ClipboardEntry entry) {
		IFile file = entry.getReleatedFile();
		if (file == null) {
			return getPartImage(entry.getPartId());
		}

		try {
			if (!file.isSynchronized(IResource.DEPTH_ONE)) {
				file.refreshLocal(IResource.DEPTH_ONE, null);
			}
			if (file.exists() && file.getContentDescription() != null) {
				IContentType contentType = file.getContentDescription().getContentType();
				return PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor(file.getName(), contentType);
			} else {
				return PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor(file.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getNumberOfLineForRow() {
		return numberOfLineForRow;
	}

	private ImageDescriptor getPartImage(String partId) {
		if (partId == null) {
			return null;
		}

		IEditorDescriptor editor = PlatformUI.getWorkbench().getEditorRegistry().findEditor(partId);
		if (editor != null) {
			return editor.getImageDescriptor();
		}

		IViewDescriptor view = PlatformUI.getWorkbench().getViewRegistry().find(partId);
		if (view != null) {
			return view.getImageDescriptor();
		}

		return null;
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

	public boolean isColorizeTextOnSelection() {
		return colorizeTextOnSelection;
	}

	@Override
	protected void measure(Event event, Object element) {
		Table table = (Table) event.widget;

		getSharedLayout().setFont(getViewer().getControl().getFont());
		String evaluate = "";
		for (int i = 0; i < numberOfLineForRow - 1; i++) {
			evaluate += "\r\n";
		}
		getSharedLayout().setText(evaluate);
		event.height = getSharedLayout().getBounds().height;
		event.width = table.getClientArea().width;
	}

	@Override
	protected void paint(Event event, Object element) {
		TableItem item = (TableItem) event.item;
		Table table = item.getParent();
		table.setToolTipText("");

		Rectangle bounds = $.newRectangle(event);
		bounds.width = table.getClientArea().width;

		ClipboardEntry entry = (ClipboardEntry) element;
		getSharedLayout().setText(entry.getTextContent());

		boolean hasToStyle = entry.getRtfContent() != null
				&& (colorizeTextOnSelection || (event.detail & SWT.SELECTED) == 0);

		if (hasToStyle) {
			try {
				StyleAndText data = factory.createFromRTFString(entry.getRtfContent());
				getSharedLayout().setText(data.getText());
				for (StyleRange each : data.getStyleRanges()) {
					getSharedLayout().setStyle(each, each.start, each.start + each.length);
				}
			} catch (Exception ie) {

			}
		}
		getSharedLayout().draw(event.gc, bounds.x, bounds.y);

		event.gc.setForeground(item.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		event.gc.setAlpha(40);
		event.gc.drawLine(0, bounds.y + bounds.height - 1, item.getParent().getSize().x, bounds.y + bounds.height - 1);

		drawBadge(event, entry);
	}

	public void setColorizeTextOnSelection(boolean colorizeTextOnSelection) {
		this.colorizeTextOnSelection = colorizeTextOnSelection;
	}

	public void setNumberOfLineForRow(int numberOfLineForRow) {
		this.numberOfLineForRow = numberOfLineForRow;
	}
}

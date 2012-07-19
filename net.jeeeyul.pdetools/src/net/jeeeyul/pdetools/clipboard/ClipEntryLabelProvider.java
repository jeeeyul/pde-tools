package net.jeeeyul.pdetools.clipboard;

import java.text.SimpleDateFormat;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class ClipEntryLabelProvider extends StyledCellLabelProvider {
	private StyleAndTextFactory factory;

	private SimpleDateFormat format = new SimpleDateFormat("MM/dd kk:mm:ss");

	// reused text layout
	private TextLayout sharedLayout;

	public TextLayout getSharedLayout() {
		if (sharedLayout == null) {
			sharedLayout = new TextLayout(getViewer().getControl().getDisplay());
		}
		return sharedLayout;
	}

	public ClipEntryLabelProvider(IColorProvider colorProvider) {
		super();
		factory = new StyleAndTextFactory(colorProvider);
	}

	@Override
	protected void measure(Event event, Object element) {
		super.measure(event, element);
		getSharedLayout().setFont(getViewer().getControl().getFont());
		getSharedLayout().setText("\r\n\r\n\r\n\r\n");
		event.height = getSharedLayout().getBounds().height;
	}

	@Override
	public void update(ViewerCell cell) {
		ClipboardEntry model = (ClipboardEntry) cell.getElement();
		if (model.getRtfContent() == null) {
			cell.setText(model.getTextContent());
			cell.setStyleRanges(null);
		} else {
			StyleAndText data = factory.createFromRTFString(model.getRtfContent());
			cell.setText(data.getText());
			cell.setStyleRanges(data.getStyleRanges());
		}

		super.update(cell);
	}

	@Override
	protected void erase(Event event, Object element) {
		super.erase(event, element);
	}

	@Override
	protected void paint(Event event, Object element) {
		if ((event.detail & SWT.FOCUSED) != 0) {
			event.detail = event.detail ^ SWT.FOCUSED;
		}

		super.paint(event, element);

		ClipboardEntry entry = (ClipboardEntry) element;

		TableItem item = (TableItem) event.item;
		Table table = item.getParent();
		table.setToolTipText("");
		boolean isLastItem = table.indexOf(item) == table.getItemCount() - 1;

		Rectangle bounds = item.getBounds();

		if (!isLastItem) {
			event.gc.setForeground(item.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			event.gc.setAlpha(40);
			event.gc.drawLine(0, bounds.y + bounds.height - 1, item.getParent().getSize().x, bounds.y + bounds.height
					- 1);
		}

		if (entry.getTakenTime() != null) {
			getSharedLayout().setFont(getViewer().getControl().getFont());
			getSharedLayout().setText(format.format(entry.getTakenTime()));
			Rectangle textBounds = getSharedLayout().getBounds();
			Rectangle area = new Rectangle(table.getClientArea().width - textBounds.width, bounds.y, textBounds.width,
					textBounds.height);

			Path path = new Path(getViewer().getControl().getDisplay());
			int radius = 5;
			int box = radius * 2;
			path.moveTo(area.x - radius, area.y);
			path.lineTo(area.x - radius, area.y + area.height);
			path.addArc(area.x - radius, area.y + area.height - radius, box, box, 180, 90);
			path.lineTo(area.x + area.width, area.y + radius + area.height);
			path.lineTo(area.x + area.width, area.y);

			event.gc.setAlpha(255);
			event.gc.setBackground(item.getDisplay().getSystemColor(SWT.COLOR_WHITE));
			event.gc.fillPath(path);

			event.gc.setAlpha(40);
			event.gc.drawPath(path);

			event.gc.setAlpha(255);
			event.gc.drawText(format.format(entry.getTakenTime()), area.x - 2, area.y + 2, true);

			path.dispose();
		}

		ImageData imageData = entry.getImageData();
		if (imageData != null) {
			Image image = new Image(item.getDisplay(), imageData);
			event.gc.drawImage(image, bounds.width - imageData.width - 2 + bounds.x, bounds.height + bounds.y
					- imageData.height - 2);
			image.dispose();
		}
	}

	@Override
	public void dispose() {
		if (sharedLayout != null) {
			sharedLayout.dispose();
			sharedLayout = null;
		}
		super.dispose();
	}
}

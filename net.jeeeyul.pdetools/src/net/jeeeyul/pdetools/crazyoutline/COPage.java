package net.jeeeyul.pdetools.crazyoutline;

import java.util.HashSet;

import net.jeeeyul.pdetools.shared.HSB;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.part.Page;

public class COPage extends Page {
	private HashSet<Resource> resources;

	StyledText styledText;
	Canvas canvas;
	Transform transform;
	TextLayout textLayout;
	Rectangle cursor;
	EmptyTabReplacer emptyTabReplacer = new EmptyTabReplacer();
	Rectangle textBounds;
	float scale;

	public COPage(StyledText client) {
		this.styledText = client;
	}

	public void addResource(Resource r) {
		getResources().add(r);
	}

	@Override
	public void createControl(Composite parent) {
		canvas = new Canvas(parent, SWT.DOUBLE_BUFFERED);
		canvas.addListener(SWT.Paint, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onPaint(event);
			}
		});
		canvas.setFont(styledText.getFont());

		styledText.addListener(SWT.Paint, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (!styledText.isDisposed())
					canvas.redraw();
			}
		});

		new CursorDragger(this);
	}

	@Override
	public void dispose() {
		for (Resource eachResource : getResources()) {
			if (eachResource != null && !eachResource.isDisposed()) {
				eachResource.dispose();
			}
		}
		super.dispose();
	}

	@Override
	public Control getControl() {
		return canvas;
	}

	public HashSet<Resource> getResources() {
		if (resources == null) {
			resources = new HashSet<Resource>();
		}
		return resources;
	}

	public TextLayout getTextLayout() {
		if (textLayout == null || textLayout.isDisposed()) {
			textLayout = new TextLayout(getControl().getDisplay());
		}
		return textLayout;
	}

	public Transform getTransform() {
		if (transform == null || transform.isDisposed()) {
			transform = new Transform(getControl().getDisplay());
		}
		return transform;
	}

	private void onPaint(Event event) {
		HSB hsb = new HSB(styledText.getBackground().getRGB());
		hsb = hsb.ampBrightness(0.9f);

		Color background = new Color(getControl().getDisplay(), hsb.toRGB());
		event.gc.setBackground(background);
		event.gc.fillRectangle(canvas.getClientArea());
		background.dispose();

		TextLayout layout = getTextLayout();
		layout.setFont(styledText.getFont());
		layout.setSpacing(styledText.getLineSpacing());

		String text = styledText.getText();
		text = emptyTabReplacer.replace(text);
		layout.setText(text);
		for (StyleRange each : styledText.getStyleRanges()) {
			TextStyle style = new TextStyle();
			style.foreground = each.foreground;
			style.background = each.background;
			style.font = each.font;
			layout.setStyle(style, each.start, each.start + each.length);
		}

		layout.setTabs(new int[] { event.gc.stringExtent(" ").x * 4 });

		textBounds = layout.getBounds();
		Rectangle clientArea = canvas.getClientArea();
		scale = 1f;

		if (textBounds.width > clientArea.width) {
			scale = clientArea.width / (float) textBounds.width;
		}

		if (textBounds.height * scale > clientArea.height) {
			scale = clientArea.height / (float) textBounds.height;
		}

		Transform transform = getTransform();
		transform.identity();
		transform.scale(scale, scale);
		event.gc.setTransform(transform);

		// Computes cursor
		int x = styledText.getHorizontalPixel();
		int hThumb = styledText.getHorizontalBar().getThumb();
		int width = hThumb != 1 ? hThumb - 5 : textBounds.width - 2;

		int y = styledText.getTopPixel();
		int vThumb = styledText.getVerticalBar().getThumb();
		int height = vThumb != 1 ? vThumb - 5 : textBounds.height - 2;

		cursor = new Rectangle(x, y, width, height);

		event.gc.setForeground(event.display.getSystemColor(SWT.COLOR_LIST_SELECTION));
		event.gc.setBackground(styledText.getBackground());
		event.gc.fillRectangle(cursor);
		event.gc.drawRectangle(cursor);

		layout.draw(event.gc, 0, 0, -1, -1, null, null, SWT.DELIMITER_SELECTION);
	}

	@Override
	public void setFocus() {

	}

}

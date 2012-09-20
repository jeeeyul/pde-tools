package net.jeeeyul.pdetools.crazyoutline;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.shared.HSB;
import net.jeeeyul.pdetools.shared.SWTExtensions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.progress.UIJob;

public class CrazyCanvas extends Canvas implements IDocumentListener, IAnnotationModelListener, IPropertyChangeListener {
	private SWTExtensions swt = SWTExtensions.INSTANCE;

	private StyledText textWidget;
	private Image buffer;
	private TextLayout textLayout;
	private Transform transform;
	private float scale = 1f;
	private Rectangle selection = new Rectangle(0, 0, 0, 0);
	private IDocument document;
	private ProjectionAnnotationModel pam;
	private UIJob invalidateJob;

	public UIJob getInvalidateJob() {
		if (invalidateJob == null) {
			invalidateJob = new UIJob("invalidate crazy canvas") {
				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {
					doInvalidate();
					return Status.OK_STATUS;
				}
			};
			invalidateJob.setDisplay(getDisplay());
			invalidateJob.setSystem(true);
		}
		return invalidateJob;
	}

	public CrazyCanvas(Composite parent, StyledText textWidget, IDocument document) {
		this(parent, textWidget, document, null);
	}

	public CrazyCanvas(Composite parent, StyledText textWidget, IDocument document, ProjectionAnnotationModel pam) {
		super(parent, SWT.DOUBLE_BUFFERED);

		this.textWidget = textWidget;
		this.document = document;
		this.pam = pam;

		hook();

		addListener(SWT.Dispose, new Listener() {
			@Override
			public void handleEvent(Event event) {
				handleDispose();
			}
		});

		new CrazyDragger(this);

	}

	private float computeScale(Rectangle viewBounds, Rectangle textBounds) {
		float scale = 1f;

		if (textBounds.width > viewBounds.width) {
			scale = viewBounds.width / (float) textBounds.width;
		}

		if (textBounds.height * scale > viewBounds.height) {
			scale = viewBounds.height / (float) textBounds.height;
		}

		return scale;
	}

	private void computeSelection(boolean updateTextWidget) {
		Rectangle newSelection = new Rectangle(0, 0, 0, 0);
		newSelection.x = textWidget.getHorizontalPixel();
		newSelection.y = textWidget.getTopPixel();

		int hThumb = textWidget.getHorizontalBar().getThumb();
		if (hThumb == 1) {
			newSelection.width = textWidget.getClientArea().width;
		} else {
			newSelection.width = hThumb;
		}

		int vThumb = textWidget.getVerticalBar().getThumb();
		if (vThumb == 1) {
			newSelection.height = textWidget.getClientArea().height;
		} else {
			newSelection.height = vThumb;
		}

		setSelection(newSelection, updateTextWidget);
	}

	@Override
	public void documentAboutToBeChanged(DocumentEvent event) {
	}

	@Override
	public void documentChanged(DocumentEvent event) {
		invalidate();
	}

	private void drawSelection(GC gc) {
		if (selection == null) {
			computeSelection(false);
		}

		Rectangle clientArea = getClientArea();
		Rectangle box = swt.getScaled(selection, scale);

		if (box.x + box.width >= clientArea.width) {
			box.width = clientArea.width - box.x - 1;
		}

		if (box.y + box.height >= clientArea.height) {
			box.height = clientArea.height - box.y - 1;
		}

		Region region = new Region(getDisplay());
		region.add(clientArea);
		region.subtract(box);

		gc.setClipping(region);

		IPreferenceStore store = PDEToolsCore.getDefault().getPreferenceStore();
		HSB fogHSB = HSB.createFromString(store.getString(CrazyOutlineConstants.FOG_COLOR));
		Color fogColor = new Color(getDisplay(), fogHSB.toRGB());
		gc.setBackground(fogColor);

		gc.setAlpha(store.getInt(CrazyOutlineConstants.FOG_TRANSPARENCY));
		gc.fillRectangle(clientArea.x, clientArea.y, clientArea.width, clientArea.height);
		fogColor.dispose();

		gc.setClipping(clientArea);
		region.dispose();

		gc.setAlpha(255);
		gc.setForeground(getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION));
		gc.drawRectangle(box);
	}

	private void drawText(GC gc) {
		if (!isBufferReady()) {
			prepareBuffer();
		}
		gc.drawImage(buffer, 0, 0);
	}

	public float getScale() {
		return scale;
	}

	public Rectangle getSelection() {
		return selection;
	}

	private TextLayout getSharedTextLayout() {
		if (textLayout == null) {
			textLayout = new TextLayout(getDisplay());
			addListener(SWT.Dispose, new Listener() {
				@Override
				public void handleEvent(Event event) {
					textLayout.dispose();
				}
			});
		}
		return textLayout;
	}

	private Transform getSharedTransform() {
		if (transform == null || transform.isDisposed()) {
			transform = new Transform(getDisplay());
			addListener(SWT.Dispose, new Listener() {
				@Override
				public void handleEvent(Event event) {
					transform.dispose();
				}
			});
		}
		return transform;
	}

	public StyledText getTextWidget() {
		return textWidget;
	}

	private void handleDispose() {
		document.removeDocumentListener(this);
		if (pam != null) {
			pam.removeAnnotationModelListener(this);
		}
		PDEToolsCore.getDefault().getPreferenceStore().removePropertyChangeListener(this);
	}

	private void hook() {
		addListener(SWT.Resize, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onResize(event);
			}
		});

		addListener(SWT.Paint, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onPaint(event);
			}
		});

		document.addDocumentListener(this);

		textWidget.getVerticalBar().addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				invalidateSelection();
			}
		});

		textWidget.getHorizontalBar().addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				invalidateSelection();
			}
		});

		if (pam != null)
			pam.addAnnotationModelListener(this);

		PDEToolsCore.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	public void invalidate() {
		if (textWidget.isDisposed() || isDisposed()) {
			return;
		}

		getInvalidateJob().schedule(2000);
	}

	private void doInvalidate() {
		if (textWidget.isDisposed() || isDisposed()) {
			return;
		}

		swt.safeDispose(buffer);
		invalidateSelection();
		redraw();
	}

	private void invalidateSelection() {
		if (textWidget.isDisposed() || isDisposed()) {
			return;
		}

		selection = null;
		redraw();
	}

	private boolean isBufferReady() {
		return buffer != null && !buffer.isDisposed();
	}

	private void onPaint(Event event) {
		drawText(event.gc);
		drawSelection(event.gc);
	}

	private void onResize(Event event) {
		invalidate();
	}

	private void prepareBuffer() {
		swt.safeDispose(buffer);
		Rectangle bounds = getClientArea();

		buffer = new Image(getDisplay(), bounds.width, bounds.height);

		Rectangle textBounds = null;
		if (textWidget.getCharCount() > 0) {
			textBounds = textWidget.getTextBounds(0, textWidget.getCharCount() - 1);
		} else {
			textBounds = new Rectangle(1, 1, 1, 1);
		}

		this.scale = computeScale(bounds, textBounds);

		Transform transform = getSharedTransform();
		transform.identity();
		transform.scale(scale, scale);

		GC gc = new GC(buffer);
		gc.setBackground(textWidget.getBackground());
		gc.fillRectangle(bounds);

		gc.setTransform(transform);

		TextLayout layout = getSharedTextLayout();
		layout.setFont(textWidget.getFont());
		layout.setSpacing(textWidget.getLineSpacing());
		layout.setTabs(textWidget.getTabStops());

		int lineCount = textWidget.getLineCount();
		for (int l = 0; l < lineCount; l++) {
			int start = textWidget.getOffsetAtLine(l);
			int end = start;
			boolean isEndLine = l == lineCount - 1;
			if (!isEndLine) {
				end = textWidget.getOffsetAtLine(l + 1) - 1;
			} else {
				end = textWidget.getCharCount() - 1;
			}
			if (start > end) {
				continue;
			}
			String lineText = textWidget.getText(start, end);
			if (lineText.trim().isEmpty()) {
				continue;
			}
			StyleRange[] ranges = textWidget.getStyleRanges(start, end - start);
			layout.setText(lineText);
			for (StyleRange each : ranges) {
				layout.setStyle(each, each.start - start, each.start + each.length);
			}
			layout.draw(gc, 0, textWidget.getLineHeight() * l);
		}

		gc.dispose();
	}

	public void setSelection(Rectangle rectangle, boolean updateTextWidget) {
		if (updateTextWidget) {
			textWidget.setTopPixel(rectangle.y);

			textWidget.setHorizontalPixel(rectangle.x);
			invalidateSelection();
			return;
		}

		this.selection = rectangle;
		redraw();
	}

	@Override
	public void modelChanged(IAnnotationModel model) {
		invalidate();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty() == null) {
			return;
		}

		if (event.getProperty().startsWith("crazy-")) {
			invalidate();
		}
	}
}

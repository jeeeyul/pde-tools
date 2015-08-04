package net.jeeeyul.pdetools.shared;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ImageCanvas extends Canvas {
	private Image backgroundImage;
	private Pattern backgroundPattern;

	private Image image;
	private Procedure1<Point> deltaHandler = new Procedure1<Point>() {
		@Override
		public void apply(Point delta) {
			handleDelta(delta);
		}
	};

	public Image getImage() {
		return image;
	}

	protected void handleDelta(Point delta) {
		int newX = getHorizontalBar().getSelection() - delta.x;
		int newY = getVerticalBar().getSelection() - delta.y;
		getHorizontalBar().setSelection(newX);
		getVerticalBar().setSelection(newY);
		redraw();
	}

	public ImageCanvas(Composite parent) {
		super(parent, SWT.V_SCROLL | SWT.H_SCROLL | SWT.DOUBLE_BUFFERED);

		DragAdapter dragAdapter = new DragAdapter(this);
		dragAdapter.setDeltaHandler(deltaHandler);

		addListener(SWT.Paint, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onPaint(event.gc);
			}
		});

		// 이미지 캔버스의 크기가 변경되면 스크롤바를 업데이트
		addListener(SWT.Resize, new Listener() {
			@Override
			public void handleEvent(Event event) {
				updateScrollBars();
			}
		});

		// 스크롤바가 이동되면 다시 그리기
		getHorizontalBar().addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				redraw();
			}
		});

		getVerticalBar().addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				redraw();
			}
		});

		backgroundImage = new Image(getDisplay(), new ImageData(getClass().getResourceAsStream(
				"image-canvas-background.gif")));
		backgroundPattern = new Pattern(getDisplay(), backgroundImage);

		addListener(SWT.Dispose, new Listener() {
			@Override
			public void handleEvent(Event event) {
				backgroundPattern.dispose();
				backgroundImage.dispose();
			}
		});

	}

	private void onPaint(GC gc) {
		Rectangle clientArea = getClientArea();
		gc.setClipping(clientArea);

		gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
		int boxSize = 10;
		int maxCol = clientArea.width / boxSize + 1;
		int maxRow = clientArea.height / boxSize + 1;

		for (int r = 0; r < maxRow; r++) {
			for (int c = 0; c < maxCol; c++) {
				if (r % 2 == c % 2) {
					gc.fillRectangle(c * boxSize, r * boxSize, boxSize, boxSize);
				}
			}
		}

		if (image == null || image.isDisposed()) {
			return;
		}
		Rectangle imageBounds = image.getBounds();

		int x = -getHorizontalBar().getSelection();
		int y = -getVerticalBar().getSelection();

		if (clientArea.width > imageBounds.width) {
			x += (clientArea.width - imageBounds.width) / 2;
		}

		if (clientArea.height > imageBounds.height) {
			y += (clientArea.height - imageBounds.height) / 2;
		}

		gc.drawImage(image, x, y);
	}

	private void updateScrollBars() {
		ScrollBar hBar = getHorizontalBar();
		ScrollBar vBar = getVerticalBar();

		if (image == null || image.isDisposed()) {
			hBar.setVisible(false);
			vBar.setVisible(false);
			return;
		}

		// 표시해야할 이미지의 크기
		Rectangle imageBounds = image != null ? image.getBounds() : new Rectangle(0, 0, 0, 0);

		// 표시에 사용할 수 있는 클라이언트 영역
		Rectangle clientArea = getClientArea();

		// 스크롤바 표시 여부 계산, 표시해야할 그림이 클라이언트 영역보다 넓으면 표시
		hBar.setVisible(imageBounds.width > clientArea.width);
		vBar.setVisible(imageBounds.height > clientArea.height);

		hBar.setMaximum(imageBounds.width);
		vBar.setMaximum(imageBounds.height);

		clientArea = getClientArea();

		// 현재 표시중인 영역이 표시해야할 전체 영역에 대한 비율을 계산
		double hRatio = clientArea.width / (double) imageBounds.width;
		double vRatio = clientArea.height / (double) imageBounds.height;

		// 스크롤바의 썸 크기 업데이트
		hBar.setThumb((int) (hRatio * imageBounds.width));
		vBar.setThumb((int) (vRatio * imageBounds.height));

		// 스크롤바 빈영역 클릭시 10% 정도씩 이동하도록 지정
		hBar.setPageIncrement((int) (imageBounds.width * 0.1));
		vBar.setPageIncrement((int) (imageBounds.height * 0.1));
	}

	public void setImage(Image image) {
		if (this.image == image) {
			return;
		}
		this.image = image;
		updateScrollBars();
		redraw();
	}
}
package net.jeeeyul.pdetools.crazyoutline;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.texteditor.AbstractTextEditor;

public class MultiPageCrazyPage extends Page implements IPageChangedListener {
	private PageBook pageBook;
	private MultiPageEditorPart multiPageEditor;
	private Map<Object, Control> canvasMap = new HashMap<Object, Control>();
	private Label fallBack;

	public MultiPageCrazyPage(MultiPageEditorPart multiPageEditor) {
		this.multiPageEditor = multiPageEditor;
		multiPageEditor.addPageChangedListener(this);
	}

	@Override
	public void createControl(Composite parent) {
		pageBook = new PageBook(parent, SWT.NORMAL);
		fallBack = new Label(pageBook, SWT.NORMAL);
		fallBack.setText("Unsupported Context");
		pageChanged(null);
	}

	@Override
	public Control getControl() {
		return pageBook;
	}

	@Override
	public void setFocus() {

	}

	@Override
	public void pageChanged(PageChangedEvent event) {
		Object page = multiPageEditor.getSelectedPage();

		Control cache = canvasMap.get(page);
		if (cache != null) {
			pageBook.showPage(cache);
			return;
		}

		if (page instanceof AbstractTextEditor) {
			AbstractTextEditor textEditor = (AbstractTextEditor) page;
			IDocument document = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());
			StyledText textWidget = (StyledText) textEditor.getAdapter(Control.class);
			CrazyCanvas canvas = new CrazyCanvas(pageBook, textWidget, document);
			canvasMap.put(page, canvas);
			pageBook.showPage(canvas);
		} else {
			canvasMap.put(page, fallBack);
			pageBook.showPage(fallBack);
		}
	}

}

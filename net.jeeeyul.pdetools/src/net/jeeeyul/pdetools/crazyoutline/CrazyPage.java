package net.jeeeyul.pdetools.crazyoutline;

import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class CrazyPage extends Page {

	private CrazyCanvas crazyView;
	private AbstractTextEditor textEditor;
	private StyledText widget;

	public CrazyPage(AbstractTextEditor textEditor) {
		this.textEditor = textEditor;
		widget = (StyledText) textEditor.getAdapter(Control.class);
	}

	@Override
	public void createControl(Composite parent) {
		ProjectionAnnotationModel am = computePAM();

		IDocumentProvider documentProvider = textEditor.getDocumentProvider();
		IEditorInput editorInput = textEditor.getEditorInput();
		crazyView = new CrazyCanvas(parent, widget, documentProvider.getDocument(editorInput), am);

	}

	protected ProjectionAnnotationModel computePAM() {
		ProjectionAnnotationModel am = null;

		Object target = textEditor.getAdapter(ITextOperationTarget.class);
		if (target instanceof ProjectionViewer) {
			am = ((ProjectionViewer) target).getProjectionAnnotationModel();
		}
		return am;
	}

	@Override
	public Control getControl() {
		return crazyView;
	}

	@Override
	public void setFocus() {
		crazyView.setFocus();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}

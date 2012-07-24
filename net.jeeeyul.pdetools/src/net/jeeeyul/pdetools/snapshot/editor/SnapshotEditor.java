package net.jeeeyul.pdetools.snapshot.editor;

import net.jeeeyul.pdetools.snapshot.SnapshotEditorInput;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class SnapshotEditor extends EditorPart {
	public static final String ID = "net.jeeeyul.pdetools.snapshot.editor.SnapshotEditor";

	@Override
	public void doSave(IProgressMonitor monitor) {

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
	}
	
	@Override
	public SnapshotEditorInput getEditorInput() {
		return (SnapshotEditorInput) super.getEditorInput();
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NORMAL);
	}

	@Override
	public void setFocus() {

	}

}

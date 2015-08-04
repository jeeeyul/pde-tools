package net.jeeeyul.pdetools.icg.ui;

import net.jeeeyul.pdetools.shared.SimpleViewerFilter;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class FolderSelectionDialog extends ElementTreeSelectionDialog {

	private IProject targetProject;
	private Button makeNewFolderButton;

	public FolderSelectionDialog(Shell parent) {
		super(parent, WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
		setInput(ResourcesPlugin.getWorkspace().getRoot());

		SimpleViewerFilter filter = new SimpleViewerFilter(new Function1<Object, Boolean>() {
			@Override
			public Boolean apply(Object p) {
				if (p instanceof IProject && targetProject != null) {
					return p == targetProject;
				} else if (p instanceof IFile) {
					return false;
				}
				return true;
			}
		});

		addFilter(filter);

		setAllowMultiple(false);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		makeNewFolderButton = new Button(container, SWT.PUSH);
		makeNewFolderButton.setText("Make new Folder");
		makeNewFolderButton.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false));
		makeNewFolderButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				makeNewFolder();
			}
		});

		getTreeViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateMakeFolderButton();
			}
		});
		updateMakeFolderButton();

		return container;
	}

	protected void makeNewFolder() {
		InputDialog dialog = new InputDialog(getShell(), "Make new folder", "Enter a name for new folder",
				"new-folder", new IInputValidator() {
					@Override
					public String isValid(String newText) {
						return validateNewFolderName(newText);
					}
				});
		if (dialog.open() == IDialogConstants.OK_ID) {
			try {
				IFolder targetFolder = getCurrentSelection().getFolder(new Path(dialog.getValue()));
				targetFolder.create(true, true, new NullProgressMonitor());
				getTreeViewer().refresh();
				getTreeViewer().setSelection(new StructuredSelection(targetFolder), true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	protected String validateNewFolderName(String newText) {
		newText = newText.trim();
		if (newText.isEmpty()) {
			return "Folder name must be setted";
		} else if (newText.contains("/") || newText.contains("\\")) {
			return "Invalid folder name";
		} else if (getCurrentSelection().getFolder(new Path(newText)).exists()) {
			return "Folder already exists";
		} else if (getCurrentSelection().getFile(new Path(newText)).exists()) {
			return "File which has given name already exists";
		}
		return null;
	}

	private void updateMakeFolderButton() {
		IContainer container = getCurrentSelection();
		makeNewFolderButton.setEnabled(container != null);
	}

	private IContainer getCurrentSelection() {
		IStructuredSelection selection = (IStructuredSelection) getTreeViewer().getSelection();
		IContainer container = (IContainer) selection.getFirstElement();
		return container;
	}

	public IProject getTargetProject() {
		return targetProject;
	}

	public void setTargetProject(IProject targetProject) {
		this.targetProject = targetProject;
	}

}

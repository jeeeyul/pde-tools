package net.jeeeyul.pdetools.icg.refactor;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class CreateFolderOperation extends WorkspaceModifyOperation {
	private IFolder folder;

	public CreateFolderOperation(IFolder folder) {
		super();
		this.folder = folder;
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {
		folder.create(true, true, monitor);
	}

}

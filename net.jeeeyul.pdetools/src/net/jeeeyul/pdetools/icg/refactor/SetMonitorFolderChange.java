package net.jeeeyul.pdetools.icg.refactor;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

public class SetMonitorFolderChange extends Change {
	private IProject project;
	private IFolder newFolder;

	public SetMonitorFolderChange(IProject project, IFolder newFolder) {
		super();
		this.project = project;
		this.newFolder = newFolder;
	}

	@Override
	public String getName() {
		return "Change Monitor Folder setting from Image Constants Generator";
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {

	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return new RefactoringStatus();
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		ICGConfiguration config = new ICGConfiguration(project);
		IFolder oldFolder = config.getMonitoringFolder();
		config.setMonitoringFolder(newFolder);
		config.save();
		return new SetMonitorFolderChange(project, oldFolder);
	}

	@Override
	public Object getModifiedElement() {
		return null;
	}

}

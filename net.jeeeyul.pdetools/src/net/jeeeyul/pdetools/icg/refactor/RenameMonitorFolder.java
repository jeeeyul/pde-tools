package net.jeeeyul.pdetools.icg.refactor;

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;

public class RenameMonitorFolder extends RenameParticipant {

	private IFolder currentMonitorFolder;

	public RenameMonitorFolder() {
	}

	@Override
	protected boolean initialize(Object element) {
		if (!(element instanceof IFolder)) {
			return false;
		}
		IFolder folder = (IFolder) element;
		if (!folder.equals(new ICGConfiguration(folder.getProject()).getMonitoringFolder())) {
			return false;
		}
		this.currentMonitorFolder = folder;
		return true;
	}

	@Override
	public String getName() {
		return "Change Monitoring Folder name in ICG Configuration";
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
		return new RefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		IFolder newMonitorFolder = currentMonitorFolder.getParent().getFolder(new Path(getArguments().getNewName()));
		SetMonitorChangeFactory changeFactory = new SetMonitorChangeFactory(currentMonitorFolder.getProject(),
				newMonitorFolder);
		return changeFactory.createChange();

	}

}

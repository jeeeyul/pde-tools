package net.jeeeyul.pdetools.icg.refactor;

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.refactor.SetMonitorChangeFactory;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.MoveArguments;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;

@SuppressWarnings("all")
public class MoveMonitorFolder extends MoveParticipant {
  private IFolder currentMonitorFolder;
  
  public RefactoringStatus checkConditions(final IProgressMonitor pm, final CheckConditionsContext context) throws OperationCanceledException {
    RefactoringStatus _refactoringStatus = new RefactoringStatus();
    return _refactoringStatus;
  }
  
  public Change createChange(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    IProject project = this.currentMonitorFolder.getProject();
    MoveArguments _arguments = this.getArguments();
    Object _destination = _arguments.getDestination();
    String _string = _destination.toString();
    Path _path = new Path(_string);
    IFolder _folder = project.getFolder(_path);
    SetMonitorChangeFactory _setMonitorChangeFactory = new SetMonitorChangeFactory(project, _folder);
    return _setMonitorChangeFactory.createChange();
  }
  
  public String getName() {
    return "Change Monitoring Folder name in ICG Configuration";
  }
  
  protected boolean initialize(final Object element) {
    boolean _not = (!(element instanceof IFolder));
    if (_not) {
      return false;
    }
    IFolder folder = ((IFolder) element);
    IProject _project = folder.getProject();
    ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
    IFolder _monitoringFolder = _iCGConfiguration.getMonitoringFolder();
    boolean _equals = folder.equals(_monitoringFolder);
    boolean _not_1 = (!_equals);
    if (_not_1) {
      return false;
    }
    this.currentMonitorFolder = folder;
    return true;
  }
}

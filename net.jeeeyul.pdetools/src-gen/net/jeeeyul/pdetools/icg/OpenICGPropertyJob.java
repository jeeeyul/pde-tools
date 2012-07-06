package net.jeeeyul.pdetools.icg;

import net.jeeeyul.pdetools.icg.ICGPropertyPage;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.progress.WorkbenchJob;

@SuppressWarnings("all")
public class OpenICGPropertyJob extends WorkbenchJob {
  private IProject project;
  
  public OpenICGPropertyJob(final IProject project) {
    super("Open ICG Property");
    this.setSystem(true);
    this.project = project;
  }
  
  public IStatus runInUIThread(final IProgressMonitor monitor) {
    Display _display = this.getDisplay();
    Shell _activeShell = _display.getActiveShell();
    PreferenceDialog dialog = PreferencesUtil.createPropertyDialogOn(_activeShell, this.project, ICGPropertyPage.ID, null, null);
    dialog.open();
    return Status.OK_STATUS;
  }
}

package net.jeeeyul.pdetools.icg.builder;

import com.google.common.base.Objects;
import net.jeeeyul.pdetools.icg.ICGConstants;
import net.jeeeyul.pdetools.icg.builder.InstallNatureJob;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ICGNature implements IProjectNature {
  private IProject _project;
  
  public IProject getProject() {
    return this._project;
  }
  
  public void setProject(final IProject project) {
    this._project = project;
  }
  
  public void configure() throws CoreException {
    IProject _project = this.getProject();
    InstallNatureJob _installNatureJob = new InstallNatureJob(_project);
    _installNatureJob.schedule();
  }
  
  public void deconfigure() throws CoreException {
    IProject _project = this.getProject();
    IProjectDescription description = _project.getDescription();
    ICommand[] _buildSpec = description.getBuildSpec();
    final Function1<ICommand,Boolean> _function = new Function1<ICommand,Boolean>() {
        public Boolean apply(final ICommand it) {
          String _builderName = it.getBuilderName();
          boolean _notEquals = (!Objects.equal(_builderName, ICGConstants.BUILDER_ID));
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<ICommand> newBuildSpec = IterableExtensions.<ICommand>filter(((Iterable<ICommand>)Conversions.doWrapArray(_buildSpec)), _function);
    final Iterable<ICommand> _converted_newBuildSpec = (Iterable<ICommand>)newBuildSpec;
    description.setBuildSpec(((ICommand[])Conversions.unwrapArray(_converted_newBuildSpec, ICommand.class)));
    IProject _project_1 = this.getProject();
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    _project_1.setDescription(description, _nullProgressMonitor);
  }
}

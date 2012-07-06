package net.jeeeyul.pdetools.icg;

import com.google.common.base.Objects;
import java.util.List;
import net.jeeeyul.pdetools.icg.ICGConstants;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
    IProjectDescription description = _project.getDescription();
    ICommand[] _buildSpec = description.getBuildSpec();
    List<ICommand> buildCommands = CollectionLiterals.<ICommand>newArrayList(_buildSpec);
    ICommand _newCommand = description.newCommand();
    final Procedure1<ICommand> _function = new Procedure1<ICommand>() {
        public void apply(final ICommand it) {
          it.setBuilderName(ICGConstants.BUILDER_ID);
        }
      };
    ICommand _doubleArrow = ObjectExtensions.<ICommand>operator_doubleArrow(_newCommand, _function);
    buildCommands.add(_doubleArrow);
    final List<ICommand> _converted_buildCommands = (List<ICommand>)buildCommands;
    description.setBuildSpec(((ICommand[])Conversions.unwrapArray(_converted_buildCommands, ICommand.class)));
    IProject _project_1 = this.getProject();
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    _project_1.setDescription(description, _nullProgressMonitor);
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

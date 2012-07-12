package net.jeeeyul.pdetools.icg.builder;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import net.jeeeyul.pdetools.icg.ICGConstants;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.ui.OpenICGPropertyJob;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.ui.progress.WorkbenchJob;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class InstallNatureJob extends WorkbenchJob {
  private IProject project;
  
  public InstallNatureJob(final IProject project) {
    super("Install ICG Nature");
    this.project = project;
    this.setUser(true);
  }
  
  public IStatus runInUIThread(final IProgressMonitor monitor) {
    try {
      monitor.beginTask("Install ICG Nature", 100);
      SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(monitor, 50);
      this.project.refreshLocal(IResource.DEPTH_INFINITE, _subProgressMonitor);
      IProjectDescription description = this.project.getDescription();
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
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      this.project.setDescription(description, _nullProgressMonitor);
      ICGConfiguration _iCGConfiguration = new ICGConfiguration(this.project);
      final Procedure1<ICGConfiguration> _function_1 = new Procedure1<ICGConfiguration>() {
          public void apply(final ICGConfiguration it) {
            IFolder _monitoringFolder = it.getMonitoringFolder();
            boolean _equals = Objects.equal(_monitoringFolder, null);
            if (_equals) {
              IFolder _folder = InstallNatureJob.this.project.getFolder("icons");
              it.setMonitoringFolder(_folder);
            }
            String[] _imageFileExtensions = it.getImageFileExtensions();
            boolean _equals_1 = Objects.equal(_imageFileExtensions, null);
            if (_equals_1) {
              ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("jpg", "gif", "png");
              it.setImageFileExtensions(((String[])Conversions.unwrapArray(_newArrayList, String.class)));
            }
            IFolder _generateSrcFolder = it.getGenerateSrcFolder();
            boolean _equals_2 = Objects.equal(_generateSrcFolder, null);
            if (_equals_2) {
              IFolder _folder_1 = InstallNatureJob.this.project.getFolder("src-gen");
              it.setGenerateSrcFolder(_folder_1);
            }
            String _generatePackageName = it.getGeneratePackageName();
            boolean _equals_3 = Objects.equal(_generatePackageName, null);
            if (_equals_3) {
              it.setGeneratePackageName("shared");
            }
            String _generateClassName = it.getGenerateClassName();
            boolean _equals_4 = Objects.equal(_generateClassName, null);
            if (_equals_4) {
              it.setGenerateClassName("SharedImages");
            }
          }
        };
      ICGConfiguration config = ObjectExtensions.<ICGConfiguration>operator_doubleArrow(_iCGConfiguration, _function_1);
      config.save();
      monitor.done();
      OpenICGPropertyJob _openICGPropertyJob = new OpenICGPropertyJob(this.project);
      _openICGPropertyJob.schedule();
      return Status.OK_STATUS;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

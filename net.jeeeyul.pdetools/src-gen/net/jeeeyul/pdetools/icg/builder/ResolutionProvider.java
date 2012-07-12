package net.jeeeyul.pdetools.icg.builder;

import com.google.common.base.Objects;
import java.util.ArrayList;
import net.jeeeyul.pdetools.icg.ICGConstants;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.model.Resolution;
import net.jeeeyul.pdetools.icg.ui.OpenICGPropertyJob;
import net.jeeeyul.pdetools.shared.SharedImages;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.pde.core.IEditableModel;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.undo.CreateFolderOperation;
import org.eclipse.ui.operations.IWorkbenchOperationSupport;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ResolutionProvider implements IMarkerResolutionGenerator {
  public IMarkerResolution[] getResolutions(final IMarker marker) {
    ArrayList<IMarkerResolution> _arrayList = new ArrayList<IMarkerResolution>();
    ArrayList<IMarkerResolution> result = _arrayList;
    Object _errorType = this.errorType(marker);
    final Object _switchValue = _errorType;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"missing-build-entry")) {
        _matched=true;
        Resolution _resolution = new Resolution();
        final Procedure1<Resolution> _function = new Procedure1<Resolution>() {
            public void apply(final Resolution it) {
              it.setLabel("Add image monitoring folder to Binary Build Entry");
              it.setDescription("Image folder is not included as binary build entry.");
              final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
                  public void apply(final IMarker it) {
                    try {
                      IResource _resource = it.getResource();
                      IProject _project = _resource.getProject();
                      ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
                      ICGConfiguration cfg = _iCGConfiguration;
                      IResource _resource_1 = marker.getResource();
                      IProject _project_1 = _resource_1.getProject();
                      IPluginModelBase plugin = PluginRegistry.findModel(_project_1);
                      IBuildModel buildModel = PluginRegistry.createBuildModel(plugin);
                      IBuild _build = buildModel.getBuild();
                      IBuildEntry _entry = _build.getEntry("bin.includes");
                      IFolder _monitoringFolder = cfg.getMonitoringFolder();
                      IPath _projectRelativePath = _monitoringFolder.getProjectRelativePath();
                      String _portableString = _projectRelativePath.toPortableString();
                      String _plus = (_portableString + "/");
                      _entry.addToken(_plus);
                      ((IEditableModel) buildModel).save();
                      buildModel.dispose();
                    } catch (Exception _e) {
                      throw Exceptions.sneakyThrow(_e);
                    }
                  }
                };
              it.setFixCode(_function);
              Image _image = SharedImages.getImage(SharedImages.ADD);
              it.setImage(_image);
            }
          };
        Resolution _doubleArrow = ObjectExtensions.<Resolution>operator_doubleArrow(_resolution, _function);
        result.add(_doubleArrow);
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"monitor-folder-not-exists")) {
        _matched=true;
        Resolution _resolution_1 = new Resolution();
        final Procedure1<Resolution> _function_1 = new Procedure1<Resolution>() {
            public void apply(final Resolution it) {
              it.setLabel("Creates monitoring folder");
              final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
                  public void apply(final IMarker it) {
                    try {
                      IResource _resource = it.getResource();
                      IProject _project = _resource.getProject();
                      ICGConfiguration _iCGConfiguration = new ICGConfiguration(_project);
                      ICGConfiguration cfg = _iCGConfiguration;
                      IFolder _monitoringFolder = cfg.getMonitoringFolder();
                      CreateFolderOperation _createFolderOperation = new CreateFolderOperation(_monitoringFolder, null, "Monitoring folder creation");
                      CreateFolderOperation op = _createFolderOperation;
                      IWorkbench _workbench = PlatformUI.getWorkbench();
                      IWorkbenchOperationSupport _operationSupport = _workbench.getOperationSupport();
                      IOperationHistory _operationHistory = _operationSupport.getOperationHistory();
                      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
                      _operationHistory.execute(op, _nullProgressMonitor, null);
                    } catch (Exception _e) {
                      throw Exceptions.sneakyThrow(_e);
                    }
                  }
                };
              it.setFixCode(_function);
            }
          };
        Resolution _doubleArrow_1 = ObjectExtensions.<Resolution>operator_doubleArrow(_resolution_1, _function_1);
        result.add(_doubleArrow_1);
        Resolution _resolution_2 = new Resolution();
        final Procedure1<Resolution> _function_2 = new Procedure1<Resolution>() {
            public void apply(final Resolution it) {
              it.setLabel("Reconfig Image Constant Generator");
              final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
                  public void apply(final IMarker it) {
                    IResource _resource = marker.getResource();
                    IProject _project = _resource.getProject();
                    OpenICGPropertyJob _openICGPropertyJob = new OpenICGPropertyJob(_project);
                    _openICGPropertyJob.schedule();
                  }
                };
              it.setFixCode(_function);
            }
          };
        Resolution _doubleArrow_2 = ObjectExtensions.<Resolution>operator_doubleArrow(_resolution_2, _function_2);
        result.add(_doubleArrow_2);
      }
    }
    if (!_matched) {
      Resolution _resolution_3 = new Resolution();
      final Procedure1<Resolution> _function_3 = new Procedure1<Resolution>() {
          public void apply(final Resolution it) {
            it.setLabel("Reconfig Image Constant Generator");
            final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
                public void apply(final IMarker it) {
                  IResource _resource = marker.getResource();
                  IProject _project = _resource.getProject();
                  OpenICGPropertyJob _openICGPropertyJob = new OpenICGPropertyJob(_project);
                  _openICGPropertyJob.schedule();
                }
              };
            it.setFixCode(_function);
          }
        };
      Resolution _doubleArrow_3 = ObjectExtensions.<Resolution>operator_doubleArrow(_resolution_3, _function_3);
      result.add(_doubleArrow_3);
    }
    return ((IMarkerResolution[])Conversions.unwrapArray(result, IMarkerResolution.class));
  }
  
  public Object errorType(final IMarker marker) {
    try {
      Object _attribute = marker.getAttribute(ICGConstants.BUILD_ERROR_TYPE_MARKER_ATTRIBUTE);
      return _attribute;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

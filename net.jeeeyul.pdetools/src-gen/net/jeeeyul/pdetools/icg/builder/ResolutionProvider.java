package net.jeeeyul.pdetools.icg.builder;

import com.google.common.base.Objects;
import java.util.ArrayList;
import net.jeeeyul.pdetools.icg.ICGConstants;
import net.jeeeyul.pdetools.icg.builder.Resolution;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.ui.OpenICGPropertyJob;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
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
      if (Objects.equal(_switchValue,"monitor-folder-not-exists")) {
        _matched=true;
        Resolution _resolution = new Resolution();
        final Procedure1<Resolution> _function = new Procedure1<Resolution>() {
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
        Resolution _doubleArrow = ObjectExtensions.<Resolution>operator_doubleArrow(_resolution, _function);
        result.add(_doubleArrow);
        Resolution _resolution_1 = new Resolution();
        final Procedure1<Resolution> _function_1 = new Procedure1<Resolution>() {
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
        Resolution _doubleArrow_1 = ObjectExtensions.<Resolution>operator_doubleArrow(_resolution_1, _function_1);
        result.add(_doubleArrow_1);
      }
    }
    if (!_matched) {
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

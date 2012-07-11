package net.jeeeyul.pdetools.icg.builder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import net.jeeeyul.pdetools.icg.ICGConstants;
import net.jeeeyul.pdetools.icg.builder.model.BuildError;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class BuildErrorAcceptor {
  @Inject
  private IProject project;
  
  private List<BuildError> errors = new Function0<List<BuildError>>() {
    public List<BuildError> apply() {
      ArrayList<BuildError> _newArrayList = CollectionLiterals.<BuildError>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public boolean error(final BuildError error) {
    boolean _add = this.errors.add(error);
    return _add;
  }
  
  public List<BuildError> getErrors() {
    return this.errors;
  }
  
  public boolean error(final Procedure1<? super BuildError> initializer) {
    boolean _xblockexpression = false;
    {
      BuildError _buildError = new BuildError();
      BuildError error = _buildError;
      initializer.apply(error);
      boolean _error = this.error(error);
      _xblockexpression = (_error);
    }
    return _xblockexpression;
  }
  
  public boolean canBuild() {
    final Function1<BuildError,Boolean> _function = new Function1<BuildError,Boolean>() {
        public Boolean apply(final BuildError it) {
          boolean _isFatal = it.isFatal();
          boolean _equals = (_isFatal == true);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<BuildError> _filter = IterableExtensions.<BuildError>filter(this.errors, _function);
    int _size = IterableExtensions.size(_filter);
    boolean _equals = (_size == 0);
    return _equals;
  }
  
  public void generateMarkers() {
    try {
      for (final BuildError e : this.errors) {
        IMarker _createMarker = this.project.createMarker(ICGConstants.PROBLEM_MARKER_TYPE);
        final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
            public void apply(final IMarker it) {
              try {
                String _message = e.getMessage();
                it.setAttribute(IMarker.MESSAGE, _message);
                int _markerSeverity = BuildErrorAcceptor.this.markerSeverity(e);
                it.setAttribute(IMarker.SEVERITY, _markerSeverity);
                it.setAttribute(IMarker.LOCATION, "ICG Configuration");
                String _type = it.getType();
                boolean _notEquals = (!Objects.equal(_type, null));
                if (_notEquals) {
                  String _type_1 = e.getType();
                  it.setAttribute(ICGConstants.BUILD_ERROR_TYPE_MARKER_ATTRIBUTE, _type_1);
                }
              } catch (Exception _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
        ObjectExtensions.<IMarker>operator_doubleArrow(_createMarker, _function);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void cleanMarkers() {
    try {
      IMarker[] markers = this.project.findMarkers(ICGConstants.PROBLEM_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
      final IMarker[] _converted_markers = (IMarker[])markers;
      final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
          public void apply(final IMarker it) {
            try {
              it.delete();
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      IterableExtensions.<IMarker>forEach(((Iterable<IMarker>)Conversions.doWrapArray(_converted_markers)), _function);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public int markerSeverity(final BuildError e) {
    int _xifexpression = (int) 0;
    boolean _isFatal = e.isFatal();
    if (_isFatal) {
      _xifexpression = IMarker.SEVERITY_ERROR;
    } else {
      _xifexpression = IMarker.SEVERITY_WARNING;
    }
    return _xifexpression;
  }
}

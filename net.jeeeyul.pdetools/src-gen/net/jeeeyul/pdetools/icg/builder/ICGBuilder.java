package net.jeeeyul.pdetools.icg.builder;

import java.util.Map;
import net.jeeeyul.pdetools.icg.builder.Building;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

@SuppressWarnings("all")
public class ICGBuilder extends IncrementalProjectBuilder {
  public ICGBuilder() {
  }
  
  private int _kind;
  
  public int getKind() {
    return this._kind;
  }
  
  public void setKind(final int kind) {
    this._kind = kind;
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    Building _building = new Building(this, kind);
    Building building = _building;
    return building.build(monitor);
  }
}

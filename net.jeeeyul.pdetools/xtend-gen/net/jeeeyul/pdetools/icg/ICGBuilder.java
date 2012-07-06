package net.jeeeyul.pdetools.icg;

import java.util.ArrayList;
import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class ICGBuilder extends IncrementalProjectBuilder {
  public ICGBuilder() {
    InputOutput.<String>println("\uBE4C\uB354 \uC0DD\uC131");
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    ArrayList<IProject> _arrayList = new ArrayList<IProject>();
    return ((IProject[])Conversions.unwrapArray(_arrayList, IProject.class));
  }
  
  public Object hasToBuild() {
    return null;
  }
}

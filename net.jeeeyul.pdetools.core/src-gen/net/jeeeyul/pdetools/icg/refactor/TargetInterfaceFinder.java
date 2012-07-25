package net.jeeeyul.pdetools.icg.refactor;

import java.util.Arrays;
import net.jeeeyul.pdetools.icg.refactor.JavaVisitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;

@SuppressWarnings("all")
public class TargetInterfaceFinder extends JavaVisitor<IJavaElement> {
  private String expectedQualifedName;
  
  public TargetInterfaceFinder(final String expectedQualifiedName) {
    this.expectedQualifedName = expectedQualifiedName;
  }
  
  protected boolean _doVisit(final IJavaElement element) {
    return true;
  }
  
  protected boolean _doVisit(final IType type) {
    boolean _xblockexpression = false;
    {
      String _fullyQualifiedName = type.getFullyQualifiedName();
      boolean _equals = this.expectedQualifedName.equals(_fullyQualifiedName);
      if (_equals) {
        this.setResult(type);
      }
      _xblockexpression = (true);
    }
    return _xblockexpression;
  }
  
  public boolean doVisit(final IJavaElement type) {
    if (type instanceof IType) {
      return _doVisit((IType)type);
    } else if (type != null) {
      return _doVisit(type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
}

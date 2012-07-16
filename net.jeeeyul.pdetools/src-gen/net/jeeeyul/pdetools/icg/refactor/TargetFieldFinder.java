package net.jeeeyul.pdetools.icg.refactor;

import java.util.Arrays;
import net.jeeeyul.pdetools.icg.refactor.JavaVisitor;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TargetFieldFinder extends JavaVisitor<IJavaElement> {
  private String expectedValue;
  
  public TargetFieldFinder(final String expectedValue) {
    String _plus = ("\"" + expectedValue);
    String _plus_1 = (_plus + "\"");
    this.expectedValue = _plus_1;
  }
  
  protected boolean _doVisit(final IJavaElement element) {
    return true;
  }
  
  protected boolean _doVisit(final IField field) {
    try {
      boolean _xblockexpression = false;
      {
        Object _constant = field.getConstant();
        boolean _equals = this.expectedValue.equals(_constant);
        if (_equals) {
          this.setResult(field);
        }
        _xblockexpression = (false);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean doVisit(final IJavaElement field) {
    if (field instanceof IField) {
      return _doVisit((IField)field);
    } else if (field != null) {
      return _doVisit(field);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(field).toString());
    }
  }
}

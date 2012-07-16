package net.jeeeyul.pdetools.icg.refactor;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IParent;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public abstract class JavaVisitor<T extends Object> {
  private T result;
  
  private boolean isCanceled;
  
  public T setResult(final T result) {
    T _result = this.result = result;
    return _result;
  }
  
  public T getResult() {
    return this.result;
  }
  
  public void visit(final IJavaElement element) {
    try {
      this.isCanceled = false;
      boolean visitChild = this.doVisit(element);
      boolean _and = false;
      if (!visitChild) {
        _and = false;
      } else {
        _and = (visitChild && (element instanceof IParent));
      }
      if (_and) {
        IJavaElement[] _children = ((IParent) element).getChildren();
        final Procedure1<IJavaElement> _function = new Procedure1<IJavaElement>() {
            public void apply(final IJavaElement it) {
              JavaVisitor.this.visit(it);
            }
          };
        IterableExtensions.<IJavaElement>forEach(((Iterable<IJavaElement>)Conversions.doWrapArray(_children)), _function);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public abstract boolean doVisit(final IJavaElement element);
}

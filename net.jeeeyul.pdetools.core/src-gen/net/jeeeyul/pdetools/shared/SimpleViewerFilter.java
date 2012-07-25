package net.jeeeyul.pdetools.shared;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class SimpleViewerFilter extends ViewerFilter {
  private Function1<? super Object,? extends Boolean> selectRule;
  
  public SimpleViewerFilter(final Function1<? super Object,? extends Boolean> selectRule) {
    this.selectRule = selectRule;
  }
  
  public Function1<? super Object,? extends Boolean> getSelectRule() {
    return this.selectRule;
  }
  
  public void setSelectRule(final Function1<? super Object,? extends Boolean> selectRule) {
    this.selectRule = selectRule;
  }
  
  public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
    return (this.selectRule.apply(element)).booleanValue();
  }
}

package net.jeeeyul.pdetools.icg.builder.model;

import org.eclipse.core.resources.IncrementalProjectBuilder;

@SuppressWarnings("all")
public class BuildContext {
  private IncrementalProjectBuilder _builder;
  
  public IncrementalProjectBuilder getBuilder() {
    return this._builder;
  }
  
  public void setBuilder(final IncrementalProjectBuilder builder) {
    this._builder = builder;
  }
  
  private int _buildKind;
  
  public int getBuildKind() {
    return this._buildKind;
  }
  
  public void setBuildKind(final int buildKind) {
    this._buildKind = buildKind;
  }
}

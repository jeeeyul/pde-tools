package net.jeeeyul.pdetools.icg.model;

import java.util.HashSet;
import net.jeeeyul.pdetools.icg.model.imageResource.Palette;

@SuppressWarnings("all")
public class GenerationContext {
  private Palette palette;
  
  private HashSet<String> takenNames;
  
  public GenerationContext(final Palette palette) {
    HashSet<String> _hashSet = new HashSet<String>();
    this.takenNames = _hashSet;
    this.palette = palette;
  }
  
  public Palette getPalette() {
    return this.palette;
  }
  
  public boolean isRegisterdFieldName(final String fieldName) {
    return this.takenNames.contains(fieldName);
  }
  
  public boolean registerFieldName(final String fieldName) {
    boolean _add = this.takenNames.add(fieldName);
    return _add;
  }
}

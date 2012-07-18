package net.jeeeyul.pdetools.clipboard;

import org.eclipse.swt.custom.StyleRange;

/**
 * SWT RTF
 */
@SuppressWarnings("all")
public class StyleAndText {
  private StyleRange[] _styleRanges;
  
  public StyleRange[] getStyleRanges() {
    return this._styleRanges;
  }
  
  public void setStyleRanges(final StyleRange[] styleRanges) {
    this._styleRanges = styleRanges;
  }
  
  private String _text;
  
  public String getText() {
    return this._text;
  }
  
  public void setText(final String text) {
    this._text = text;
  }
  
  public String toString() {
    String _text = this.getText();
    return _text;
  }
}

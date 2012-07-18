package net.jeeeyul.pdetools.clipboard.internal;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class StyleRangeSerializer {
  public String serialize(final StyleRange range) {
    ArrayList<CharSequence> _arrayList = new ArrayList<CharSequence>();
    List<CharSequence> result = _arrayList;
    boolean _notEquals = (!Objects.equal(range.background, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("background=");
      RGB _rGB = range.background.getRGB();
      String _html = this.html(_rGB);
      _builder.append(_html, "");
      result.add(_builder);
    }
    boolean _notEquals_1 = (!Objects.equal(range.foreground, null));
    if (_notEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("background=");
      RGB _rGB_1 = range.foreground.getRGB();
      String _html_1 = this.html(_rGB_1);
      _builder_1.append(_html_1, "");
      result.add(_builder_1);
    }
    boolean _notEquals_2 = (range.fontStyle != SWT.NORMAL);
    if (_notEquals_2) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("fontStyle=");
      _builder_2.append(range.fontStyle, "");
      result.add(_builder_2);
    }
    return IterableExtensions.join(result, ";");
  }
  
  public String html(final RGB rgb) {
    String _format = String.format("#%02x%02x%02x", Integer.valueOf(rgb.red), Integer.valueOf(rgb.green), Integer.valueOf(rgb.blue));
    return _format;
  }
}

package net.jeeeyul.pdetools.clipboard.internal;

import com.google.common.base.Objects;
import java.util.List;
import net.jeeeyul.pdetools.clipboard.IColorProvider;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class StyleRangeDeserializer {
  private IColorProvider _colorProvider;
  
  public IColorProvider getColorProvider() {
    return this._colorProvider;
  }
  
  public void setColorProvider(final IColorProvider colorProvider) {
    this._colorProvider = colorProvider;
  }
  
  public StyleRangeDeserializer(final IColorProvider colorProvider) {
    this.setColorProvider(colorProvider);
  }
  
  public StyleRange createStyleRangeFromString(final String str) {
    StyleRange _styleRange = new StyleRange();
    StyleRange result = _styleRange;
    String[] pair = str.split(";");
    for (final String eachPair : pair) {
      {
        String[] keyAndValue = eachPair.split("=");
        final String[] _converted_keyAndValue = (String[])keyAndValue;
        String _get = ((List<String>)Conversions.doWrapArray(_converted_keyAndValue)).get(0);
        String key = _get.trim();
        final String[] _converted_keyAndValue_1 = (String[])keyAndValue;
        String _get_1 = ((List<String>)Conversions.doWrapArray(_converted_keyAndValue_1)).get(1);
        String value = _get_1.trim();
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(key,"foreground")) {
            _matched=true;
            IColorProvider _colorProvider = this.getColorProvider();
            RGB _asRGB = this.asRGB(value);
            Color _color = _colorProvider.getColor(_asRGB);
            result.foreground = _color;
          }
        }
        if (!_matched) {
          if (Objects.equal(key,"background")) {
            _matched=true;
            IColorProvider _colorProvider_1 = this.getColorProvider();
            RGB _asRGB_1 = this.asRGB(value);
            Color _color_1 = _colorProvider_1.getColor(_asRGB_1);
            result.background = _color_1;
          }
        }
        if (!_matched) {
          if (Objects.equal(key,"fontStyle")) {
            _matched=true;
            int _parseInt = Integer.parseInt(value);
            result.fontStyle = _parseInt;
          }
        }
      }
    }
    return result;
  }
  
  public RGB asRGB(final String string) {
    boolean _matches = string.matches("#[0-9a-fA-F]{6}");
    boolean _not = (!_matches);
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException();
      throw _illegalArgumentException;
    }
    RGB _rGB = new RGB(0, 0, 0);
    RGB result = _rGB;
    String _substring = string.substring(1, 2);
    int _parseInt = Integer.parseInt(_substring, 16);
    result.red = _parseInt;
    String _substring_1 = string.substring(3, 4);
    int _parseInt_1 = Integer.parseInt(_substring_1, 16);
    result.green = _parseInt_1;
    String _substring_2 = string.substring(5, 6);
    int _parseInt_2 = Integer.parseInt(_substring_2, 16);
    result.blue = _parseInt_2;
    return result;
  }
}

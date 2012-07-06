package net.jeeeyul.pdetools.icg;

import net.jeeeyul.pdetools.icg.ICGConfiguration;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ImageCosntantGenerator {
  private ICGConfiguration config;
  
  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _generatePackageName = this.config.getGeneratePackageName();
    _builder.append(_generatePackageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _generateClassName = this.config.getGenerateClassName();
    _builder.append(_generateClassName, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}

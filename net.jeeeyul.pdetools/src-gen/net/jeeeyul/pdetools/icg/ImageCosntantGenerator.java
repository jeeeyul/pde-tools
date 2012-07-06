package net.jeeeyul.pdetools.icg;

import net.jeeeyul.pdetools.icg.ICGConfiguration;
import net.jeeeyul.pdetools.icg.model.imageResource.ImageFile;
import net.jeeeyul.pdetools.icg.model.imageResource.Palette;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ImageCosntantGenerator {
  private ICGConfiguration _config;
  
  public ICGConfiguration getConfig() {
    return this._config;
  }
  
  public void setConfig(final ICGConfiguration config) {
    this._config = config;
  }
  
  private Palette _rootPalette;
  
  public Palette getRootPalette() {
    return this._rootPalette;
  }
  
  public void setRootPalette(final Palette rootPalette) {
    this._rootPalette = rootPalette;
  }
  
  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    ICGConfiguration _config = this.getConfig();
    String _generatePackageName = _config.getGeneratePackageName();
    _builder.append(_generatePackageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    ICGConfiguration _config_1 = this.getConfig();
    String _generateClassName = _config_1.getGenerateClassName();
    _builder.append(_generateClassName, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    {
      Palette _rootPalette = this.getRootPalette();
      EList<Palette> _subPalettes = _rootPalette.getSubPalettes();
      for(final Palette eachPalette : _subPalettes) {
        _builder.append("\t");
        CharSequence _generateSubPalette = this.generateSubPalette(eachPalette);
        _builder.append(_generateSubPalette, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Palette _rootPalette_1 = this.getRootPalette();
      EList<ImageFile> _imageFiles = _rootPalette_1.getImageFiles();
      for(final ImageFile eachFile : _imageFiles) {
        _builder.append("\t");
        CharSequence _generateField = this.generateField(eachFile);
        _builder.append(_generateField, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateSubPalette(final Palette palette) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public static interface ");
    String _fieldName = palette.getFieldName();
    _builder.append(_fieldName, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    {
      EList<ImageFile> _imageFiles = palette.getImageFiles();
      for(final ImageFile eachFile : _imageFiles) {
        _builder.append("\t");
        CharSequence _generateField = this.generateField(eachFile);
        _builder.append(_generateField, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateField(final ImageFile file) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public static final String ");
    String _fieldName = file.getFieldName();
    _builder.append(_fieldName, "");
    _builder.append(" = \"");
    IFile _file = file.getFile();
    IPath _projectRelativePath = _file.getProjectRelativePath();
    String _portableString = _projectRelativePath.toPortableString();
    _builder.append(_portableString, "");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}

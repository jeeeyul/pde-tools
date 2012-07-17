package net.jeeeyul.pdetools.icg.builder.model;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.model.PaletteDelta;
import net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner;
import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import net.jeeeyul.pdetools.icg.refactor.TargetFieldFinder;
import net.jeeeyul.pdetools.icg.refactor.TargetInterfaceFinder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.refactoring.IJavaRefactorings;
import org.eclipse.jdt.core.refactoring.descriptors.RenameJavaElementDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringContribution;
import org.eclipse.ltk.core.refactoring.RefactoringCore;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class JavaRefactor {
  private ICGConfiguration config;
  
  public JavaRefactor(final IProject project) {
    ICGConfiguration _iCGConfiguration = new ICGConfiguration(project);
    this.config = _iCGConfiguration;
  }
  
  public RenameJavaElementDescriptor createDescriptor(final PaletteDelta delta) {
    RefactoringContribution contribution = null;
    FieldNameOwner _before = delta.getBefore();
    if ((_before instanceof Palette)) {
      RefactoringContribution _refactoringContribution = RefactoringCore.getRefactoringContribution(IJavaRefactorings.RENAME_TYPE);
      contribution = _refactoringContribution;
    } else {
      RefactoringContribution _refactoringContribution_1 = RefactoringCore.getRefactoringContribution(IJavaRefactorings.RENAME_FIELD);
      contribution = _refactoringContribution_1;
    }
    RefactoringDescriptor _createDescriptor = contribution.createDescriptor();
    RenameJavaElementDescriptor desc = ((RenameJavaElementDescriptor) _createDescriptor);
    FieldNameOwner _before_1 = delta.getBefore();
    IJavaElement _asType = this.asType(_before_1);
    desc.setJavaElement(_asType);
    FieldNameOwner _after = delta.getAfter();
    String _fieldName = _after.getFieldName();
    desc.setNewName(_fieldName);
    return desc;
  }
  
  protected IJavaElement _asType(final FieldNameOwner owner) {
    return null;
  }
  
  protected IJavaElement _asType(final Palette palette) {
    IFile _ouputFile = this.config.getOuputFile();
    IJavaElement cu = JavaCore.create(_ouputFile);
    String _qualifiedName = this.qualifiedName(palette);
    TargetInterfaceFinder _targetInterfaceFinder = new TargetInterfaceFinder(_qualifiedName);
    TargetInterfaceFinder finder = _targetInterfaceFinder;
    finder.visit(cu);
    return finder.getResult();
  }
  
  protected IJavaElement _asType(final ImageFile file) {
    IFile _ouputFile = this.config.getOuputFile();
    IJavaElement cu = JavaCore.create(_ouputFile);
    IFile _file = file.getFile();
    IPath _projectRelativePath = _file.getProjectRelativePath();
    String _portableString = _projectRelativePath.toPortableString();
    TargetFieldFinder _targetFieldFinder = new TargetFieldFinder(_portableString);
    TargetFieldFinder finder = _targetFieldFinder;
    finder.visit(cu);
    return finder.getResult();
  }
  
  public Palette parent(final FieldNameOwner owner) {
    Palette _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (owner instanceof Palette) {
        final Palette _palette = (Palette)owner;
        _matched=true;
        Palette _parent = _palette.getParent();
        _switchResult = _parent;
      }
    }
    if (!_matched) {
      if (owner instanceof ImageFile) {
        final ImageFile _imageFile = (ImageFile)owner;
        _matched=true;
        Palette _parent = _imageFile.getParent();
        _switchResult = _parent;
      }
    }
    return _switchResult;
  }
  
  public String qualifiedName(final FieldNameOwner owner) {
    ArrayList<String> _arrayList = new ArrayList<String>();
    List<String> segments = _arrayList;
    String _fieldName = owner.getFieldName();
    segments.add(_fieldName);
    Palette parent = this.parent(owner);
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(parent, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      String _fieldName_1 = parent.getFieldName();
      boolean _notEquals_1 = (!Objects.equal(_fieldName_1, null));
      _and_1 = (_notEquals && _notEquals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isRoot = this.isRoot(parent);
      boolean _not = (!_isRoot);
      _and = (_and_1 && _not);
    }
    boolean _while = _and;
    while (_while) {
      {
        String _fieldName_2 = parent.getFieldName();
        segments.add(_fieldName_2);
        Palette _parent = parent.getParent();
        parent = _parent;
      }
      boolean _and_2 = false;
      boolean _and_3 = false;
      boolean _notEquals_2 = (!Objects.equal(parent, null));
      if (!_notEquals_2) {
        _and_3 = false;
      } else {
        String _fieldName_2 = parent.getFieldName();
        boolean _notEquals_3 = (!Objects.equal(_fieldName_2, null));
        _and_3 = (_notEquals_2 && _notEquals_3);
      }
      if (!_and_3) {
        _and_2 = false;
      } else {
        boolean _isRoot_1 = this.isRoot(parent);
        boolean _not_1 = (!_isRoot_1);
        _and_2 = (_and_3 && _not_1);
      }
      _while = _and_2;
    }
    StringConcatenation _builder = new StringConcatenation();
    String _generatePackageName = this.config.getGeneratePackageName();
    _builder.append(_generatePackageName, "");
    _builder.append(".");
    String _generateClassName = this.config.getGenerateClassName();
    _builder.append(_generateClassName, "");
    _builder.append(".");
    List<String> _reverse = ListExtensions.<String>reverse(segments);
    String _join = IterableExtensions.join(_reverse, ".");
    _builder.append(_join, "");
    return _builder.toString();
  }
  
  public boolean isRoot(final Palette palette) {
    Palette _parent = palette.getParent();
    return Objects.equal(_parent, null);
  }
  
  public IJavaElement asType(final FieldNameOwner file) {
    if (file instanceof ImageFile) {
      return _asType((ImageFile)file);
    } else if (file instanceof Palette) {
      return _asType((Palette)file);
    } else if (file != null) {
      return _asType(file);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(file).toString());
    }
  }
}

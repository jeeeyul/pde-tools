package net.jeeeyul.pdetools.jdt.template;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.corext.template.java.CompilationUnitContext;
import org.eclipse.jface.text.templates.TemplateContext;

@SuppressWarnings("restriction")
public class JDTHackExtensions {
	public static ICompilationUnit getCompilationUnit(TemplateContext context) {
		if (context instanceof CompilationUnitContext) {
			return ((CompilationUnitContext) context).getCompilationUnit();
		} else {
			return null;
		}
	}
	
	public static IProject getProject(TemplateContext context) {
		if (context instanceof CompilationUnitContext) {
			return ((CompilationUnitContext) context).getCompilationUnit().getJavaProject().getProject();
		} else {
			return null;
		}
	}
	
	public static IJavaProject getJavaProject(TemplateContext context) {
		if (context instanceof CompilationUnitContext) {
			return ((CompilationUnitContext) context).getCompilationUnit().getJavaProject();
		} else {
			return null;
		}
	}
}

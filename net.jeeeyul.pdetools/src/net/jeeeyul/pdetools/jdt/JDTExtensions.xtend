package net.jeeeyul.pdetools.jdt

import org.eclipse.jdt.core.ICompilationUnit

class JDTExtensions {
	def canImport(ICompilationUnit cu, String qualifiedTypeName){
		return !cu.imports.exists[
			it.elementName.simpleName == qualifiedTypeName.simpleName || 
			it.elementName == qualifiedTypeName.packageName + ".*"
		]
	}
	
	def private String getPackageName(String qualifiedTypeName){
		var segments = qualifiedTypeName.split("\\.").toList
		if(segments.size > 0){
			segments.remove(segments.size - 1)
		}
		return segments.join(".")
	}
	
	def private String getSimpleName(String qualifiedTypeName){
		return qualifiedTypeName.split("\\.").last
	}
}
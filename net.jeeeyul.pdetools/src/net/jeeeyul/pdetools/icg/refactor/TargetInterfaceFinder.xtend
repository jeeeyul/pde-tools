package net.jeeeyul.pdetools.icg.refactor

import org.eclipse.jdt.core.IType
import org.eclipse.jdt.core.IJavaElement

class TargetInterfaceFinder extends JavaVisitor<IJavaElement> {
	String expectedQualifedName
	
	new(String expectedQualifiedName){
		this.expectedQualifedName = expectedQualifiedName
	}

	def dispatch doVisit(IJavaElement element) {
		true
	}

	def dispatch doVisit(IType type){
		if(expectedQualifedName.equals(type.fullyQualifiedName)) {
			setResult(type)
		}
		true
	}
}
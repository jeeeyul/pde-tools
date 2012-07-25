package net.jeeeyul.pdetools.icg.refactor

import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IParent

abstract class JavaVisitor<T> {
	T result
	boolean isCanceled
	
	def setResult(T result){
		this.result = result;
	}
	
	def getResult(){
		result
	}
	
	def visit(IJavaElement element){
		isCanceled = false
		var visitChild = doVisit(element)
		
		if(visitChild && element instanceof IParent){
			(element as IParent).children.forEach[visit]
		}
	}
	
	def boolean doVisit(IJavaElement element)
}
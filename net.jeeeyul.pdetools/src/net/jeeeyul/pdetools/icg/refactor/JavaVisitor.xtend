package net.jeeeyul.pdetools.icg.refactor

import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IParent

abstract class JavaVisitor<T> {
	T result

	def setResult(T result) {
		this.result = result;
	}

	def getResult() {
		result
	}

	def void visit(IJavaElement element) {
		var visitChild = doVisit(element)

		if (visitChild && element instanceof IParent) {
			(element as IParent).children.forEach[visit]
		}
	}

	def boolean doVisit(IJavaElement element)
}

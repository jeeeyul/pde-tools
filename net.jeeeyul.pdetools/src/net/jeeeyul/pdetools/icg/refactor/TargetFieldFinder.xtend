package net.jeeeyul.pdetools.icg.refactor

import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IField

class TargetFieldFinder extends JavaVisitor<IField> {
	String expectedValue
	new(String expectedValue){
		this.expectedValue = "\"" + expectedValue + "\""
	}
	
	def dispatch doVisit(IJavaElement element) {
		true
	}

	def dispatch doVisit(IField field){
		if(expectedValue.equals(field.constant)){
			setResult(field)
		}
		false
	}
}
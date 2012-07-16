package net.jeeeyul.pdetools.icg.refactor

import org.eclipse.jdt.core.IField
import org.eclipse.jdt.core.IJavaElement

class TargetFieldFinder extends JavaVisitor<IJavaElement> {
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
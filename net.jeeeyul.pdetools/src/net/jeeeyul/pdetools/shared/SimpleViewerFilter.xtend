package net.jeeeyul.pdetools.shared

import org.eclipse.jface.viewers.ViewerFilter
import org.eclipse.jface.viewers.Viewer

class SimpleViewerFilter extends ViewerFilter{
	(Object)=>boolean selectRule;
	 
	new((Object)=>boolean selectRule){
		this.selectRule = selectRule
	}
	 
	def getSelectRule(){
		selectRule
	}
	
	def void setSelectRule((Object)=>boolean selectRule){
		this.selectRule = selectRule
	}
	 
	override select(Viewer viewer, Object parentElement, Object element) {
		return selectRule.apply(element)
	}
}
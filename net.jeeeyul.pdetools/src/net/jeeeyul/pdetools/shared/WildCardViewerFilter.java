package net.jeeeyul.pdetools.shared;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class WildCardViewerFilter<T> extends ViewerFilter {
	private String filterExpression;

	private Function1<T, String> textProvider;

	public String getFilterExpression() {
		return filterExpression;
	}

	public Function1<T, String> getTextProvider() {
		return textProvider;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return false;
	}

	public void setFilterExpression(String filterExpression) {
		this.filterExpression = filterExpression;
	}

	public void setTextProvider(Function1<T, String> textProvider) {
		this.textProvider = textProvider;
	}

}

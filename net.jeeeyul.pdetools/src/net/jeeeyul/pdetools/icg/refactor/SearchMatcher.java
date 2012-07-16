package net.jeeeyul.pdetools.icg.refactor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SearchMatcher extends SearchRequestor {
	Procedure1<SearchMatch> handler;
	
	public Procedure1<SearchMatch> getHandler() {
		return handler;
	}

	public void setHandler(Procedure1<SearchMatch> handler) {
		this.handler = handler;
	}

	@Override
	public void beginReporting() {
	}

	@Override
	public void acceptSearchMatch(SearchMatch match) throws CoreException {
		if(handler != null){
			handler.apply(match);
		}
	}

	@Override
	public void endReporting() {
	}

}

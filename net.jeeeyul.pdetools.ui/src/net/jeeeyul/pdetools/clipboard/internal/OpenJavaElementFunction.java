package net.jeeeyul.pdetools.clipboard.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;

public class OpenJavaElementFunction extends BrowserFunction {

	public OpenJavaElementFunction(Browser browser) {
		super(browser, "openJavaElement");
	}

	@Override
	public Object function(Object[] arguments) {
		final String qualifiedName = (String) arguments[0];

		try {

			final ArrayList<Object> result = new ArrayList<Object>();

			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						doSearch(qualifiedName, result, monitor);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			});

			if (result.size() > 0) {
				IType targetElement = (IType) result.get(0);
				IEditorPart editor = JavaUI.openInEditor(targetElement);

				if (arguments.length == 3 && editor instanceof ITextEditor) {
					int offset = (int) Double.parseDouble(arguments[1].toString());
					int length = (int) Double.parseDouble(arguments[2].toString());
					ITextEditor textEditor = (ITextEditor) editor;
					textEditor.selectAndReveal(offset, length);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void doSearch(String qualifiedName, final ArrayList<Object> result, IProgressMonitor monitor)
			throws CoreException {
		SearchPattern pattern = SearchPattern.createPattern(qualifiedName, IJavaSearchConstants.TYPE,
				IJavaSearchConstants.DECLARATIONS, SearchPattern.R_EXACT_MATCH | SearchPattern.R_EQUIVALENT_MATCH);

		SearchRequestor requestor = new SearchRequestor() {
			@Override
			public void acceptSearchMatch(SearchMatch match) throws CoreException {
				result.add(match.getElement());
			}
		};

		SearchEngine engine = new SearchEngine();
		engine.search(pattern, new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() },
				SearchEngine.createWorkspaceScope(), requestor, monitor);
	}

}

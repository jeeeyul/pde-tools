package net.jeeeyul.pdetools.jdt;

import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public abstract class AbstractJavaProposal implements ICompletionProposal, IJavaCompletionProposal {
	private JavaContentAssistInvocationContext context;

	public AbstractJavaProposal(JavaContentAssistInvocationContext context) {
		this.context = context;
	}

	protected JavaContentAssistInvocationContext getContext() {
		return context;
	}
	
	@Override
	public int getRelevance() {
		return 1000;
	}

}

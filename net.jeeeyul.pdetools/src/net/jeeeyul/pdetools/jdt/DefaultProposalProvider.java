package net.jeeeyul.pdetools.jdt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;

public class DefaultProposalProvider implements IJavaCompletionProposalComputer {

	@Override
	public void sessionStarted() {

	}

	@Override
	public List<ICompletionProposal> computeCompletionProposals(ContentAssistInvocationContext context,
			IProgressMonitor monitor) {
		ArrayList<ICompletionProposal> result = new ArrayList<ICompletionProposal>();

		if (context instanceof JavaContentAssistInvocationContext) {
			JavaContentAssistInvocationContext jContext = (JavaContentAssistInvocationContext) context;
			IType expectedType = jContext.getExpectedType();
			if (expectedType != null) {

				if (expectedType.getFullyQualifiedName().equals("org.eclipse.swt.graphics.Color")) {
					try {
						int prefix = jContext.computeIdentifierPrefix().length();
						result.add(new ColorProposal(jContext, prefix));
					} catch (BadLocationException e) {
						e.printStackTrace();
					}

				}

			}

		}

		return result;
	}

	@Override
	public List<IContextInformation> computeContextInformation(ContentAssistInvocationContext context,
			IProgressMonitor monitor) {
		return null;
	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	@Override
	public void sessionEnded() {

	}

}

package net.jeeeyul.pdetools.jdt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
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
		JavaContentAssistInvocationContext jCtx = (JavaContentAssistInvocationContext) context;
		ArrayList<ICompletionProposal> result = new ArrayList<ICompletionProposal>();

		if (jCtx.getExpectedType() != null) {
			if (jCtx.getExpectedType().getFullyQualifiedName().equals("org.eclipse.swt.graphics.Color")) {
				try {
					result.add(new ColorProposal(jCtx, jCtx.computeIdentifierPrefix().length()));
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public List<IContextInformation> computeContextInformation(ContentAssistInvocationContext context,
			IProgressMonitor monitor) {
		ArrayList<IContextInformation> result = new ArrayList<IContextInformation>();
		return result;
	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	@Override
	public void sessionEnded() {

	}

}

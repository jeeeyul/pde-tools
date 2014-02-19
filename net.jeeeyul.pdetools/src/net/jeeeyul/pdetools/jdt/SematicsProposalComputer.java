package net.jeeeyul.pdetools.jdt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;

public class SematicsProposalComputer implements IJavaCompletionProposalComputer {

	@Override
	public void sessionStarted() {

	}

	public CharSequence computeIdentifierPrefix(IDocument document, int offset) throws BadLocationException {
		int end = offset;
		int start = end;
		while (--start >= 0) {
			if (!Character.isJavaIdentifierPart(document.getChar(start)))
				break;
		}
		start++;
		return document.get(start, end - start);
	}

	@Override
	public List<ICompletionProposal> computeCompletionProposals(ContentAssistInvocationContext context,
			IProgressMonitor monitor) {
		JavaContentAssistInvocationContext jCtx = (JavaContentAssistInvocationContext) context;
		ArrayList<ICompletionProposal> result = new ArrayList<ICompletionProposal>();

		try {
			String prefix = jCtx.computeIdentifierPrefix().toString();

			if (jCtx.getExpectedType() != null
					&& jCtx.getExpectedType().getFullyQualifiedName().equals("org.eclipse.swt.graphics.Color")) {
				try {
					result.add(new ColorProposal(jCtx, jCtx.computeIdentifierPrefix().length()));
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}

			else if ("Color".startsWith(prefix)) {
				String previousToken = computeIdentifierPrefix(jCtx.getDocument(),
						jCtx.getInvocationOffset() - prefix.length() - 1).toString();
				if (previousToken.equals("new"))
					result.add(new ColorProposal(jCtx, jCtx.computeIdentifierPrefix().length()));
			}

		} catch (BadLocationException e1) {
			e1.printStackTrace();
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

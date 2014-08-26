package net.jeeeyul.pdetools.jdt;

import java.util.ArrayList;
import java.util.List;

import net.jeeeyul.pdetools.jdt.internal.PrefixUtil;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

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
			String previousToken = PrefixUtil.computeIdentifierPrefix(jCtx.getDocument(), jCtx.getInvocationOffset()
					- prefix.length() - 1);

			IType expectedType = jCtx.getExpectedType();
			if (expectedType != null) {

				String typeName = expectedType.getFullyQualifiedName();
				if (typeName.equals(Color.class.getCanonicalName())) {
					if ((prefix.length() > 0 && "new".startsWith(prefix))
							|| ("new".startsWith(previousToken) && "Color".startsWith(prefix))) {
						result.add(new ColorProposal(jCtx));
					}
				}

				else if (typeName.equals(RGB.class.getCanonicalName())) {
					if ((prefix.length() > 0 && "new".startsWith(prefix))
							|| ("new".startsWith(previousToken) && "RGB".startsWith(prefix))) {
						result.add(new RGBProposal(jCtx));
					}
				}
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

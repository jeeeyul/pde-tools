package net.jeeeyul.pdetools.jdt.internal;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public class PrefixUtil {
	public static String computeIdentifierPrefix(IDocument document, int offset) throws BadLocationException {
		int end = offset;
		int start = end;
		boolean acceptWhiteSpace = true;

		while (--start >= 0) {
			char current = document.getChar(start);
			if (!Character.isJavaIdentifierPart(current)
					&& !(acceptWhiteSpace == true && Character.isWhitespace(current)) && current != '.')
				break;

			if (!Character.isWhitespace(current)) {
				acceptWhiteSpace = false;
			}
		}
		start++;
		return document.get(start, end - start);
	}
}

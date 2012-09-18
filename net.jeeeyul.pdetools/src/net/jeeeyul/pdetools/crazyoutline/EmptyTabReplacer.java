package net.jeeeyul.pdetools.crazyoutline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmptyTabReplacer {
	public String replace(String content) {
		Pattern pattern = Pattern.compile("(\\r\\n|\\r|\\n)(\\t)+(\\r\\n|\\r|\\n)");

		String phase = content;
		Matcher matcher = pattern.matcher(phase);
		while (matcher.find()) {
			phase = matcher.replaceFirst(blank(matcher.group(2).length()) + matcher.group(3));
			matcher = pattern.matcher(phase);
		}

		return phase;
	}

	public static void main(String[] args) {
		EmptyTabReplacer r = new EmptyTabReplacer();
		System.out.println(r.replace("		\t\r\nasd"));
	}

	private String blank(int size) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < size; i++) {
			buffer.append(' ');
		}
		return buffer.toString();
	}
}

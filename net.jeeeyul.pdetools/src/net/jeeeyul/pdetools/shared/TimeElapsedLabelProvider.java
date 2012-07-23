package net.jeeeyul.pdetools.shared;

import java.text.MessageFormat;

public class TimeElapsedLabelProvider {
	public String getText(long timeElapsed) {
		long inSecond = timeElapsed / 1000;
		return MessageFormat.format("{0}ÃÊÀü", inSecond);
	}
}

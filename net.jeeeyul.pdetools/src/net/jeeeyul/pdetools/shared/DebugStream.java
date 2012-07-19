package net.jeeeyul.pdetools.shared;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DebugStream extends PrintStream {
	private static final Set<String> FILTER;
	static {
		String[] array = new String[] { "org.eclipse.xtext.xbase.lib.InputOutput",
				"net.jeeeyul.pdetools.shared.DebugStream", "java.lang.Thread" };
		FILTER = new HashSet<String>(Arrays.asList(array));
	}

	private static final DebugStream INSTANCE = new DebugStream();

	public static void activate() {
		System.setOut(INSTANCE);
		System.out.println("Debug Stream Activated");
	}

	private DebugStream() {
		super(System.out);
	}

	@Override
	public void println(Object x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(String x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(char x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(char[] x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(double x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(float x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(long x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(boolean x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println() {
		showLocation();
		super.println();
	}

	@Override
	public void println(int x) {
		showLocation();
		super.println(x);
	}

	private void showLocation() {
		StackTraceElement element = findUserFrame();
		super.print(MessageFormat.format("({0}:{1, number,#}) : ", element.getFileName(), element.getLineNumber()));
	}

	private StackTraceElement findUserFrame() {
		for (StackTraceElement each : Thread.currentThread().getStackTrace()) {
			if (!FILTER.contains(each.getClassName())) {
				return each;
			}
		}

		return null;
	}
}
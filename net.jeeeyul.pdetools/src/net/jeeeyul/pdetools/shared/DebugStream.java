package net.jeeeyul.pdetools.shared;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.HashSet;

import org.eclipse.core.runtime.Assert;
import org.eclipse.xtext.xbase.lib.InputOutput;

public class DebugStream extends PrintStream {

	private HashSet<String> filters = new HashSet<String>();

	public DebugStream() {
		super(System.out);
		addFilter(getClass());
		addFilter(InputOutput.class);
		addFilter(Thread.class);
	}

	public void addFilter(Class<?> type) {
		Assert.isNotNull(type);
		filters.add(type.getCanonicalName());
	}

	private StackTraceElement findUserFrame() {
		for (StackTraceElement each : Thread.currentThread().getStackTrace()) {
			if (!filters.contains(each.getClassName())) {
				return each;
			}
		}

		return null;
	}

	@Override
	public void println() {
		showLocation();
		super.println();
	}

	@Override
	public void println(boolean x) {
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
	public void println(int x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(long x) {
		showLocation();
		super.println(x);
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

	private void showLocation() {
		StackTraceElement element = findUserFrame();
		super.print(MessageFormat.format("({0}:{1, number,#}) : ", element.getFileName(), element.getLineNumber()));
	}
}
package net.jeeeyul.pdetools;

import net.jeeeyul.pdetools.shared.DebugStream;

public class Debug {
	private static boolean DEBUG = PDEToolsCore.getDefault().isDebugging();

	private static final DebugStream DEBUG_STREAM;

	public static void println() {
		if (DEBUG)
			DEBUG_STREAM.println();
	}

	public static void println(boolean x) {
		if (DEBUG)
			DEBUG_STREAM.println(x);
	}

	public static void println(char x) {
		if (DEBUG)
			DEBUG_STREAM.println(x);
	}

	public static void println(char[] x) {
		if (DEBUG)
			DEBUG_STREAM.println(x);
	}

	public static void println(double x) {
		if (DEBUG)
			DEBUG_STREAM.println(x);
	}

	public static void println(float x) {
		if (DEBUG)
			DEBUG_STREAM.println(x);
	}

	public static void println(int x) {
		if (DEBUG)
			DEBUG_STREAM.println(x);
	}

	public static void println(long x) {
		if (DEBUG)
			DEBUG_STREAM.println(x);
	}

	public static void println(Object x) {
		if (DEBUG)
			DEBUG_STREAM.println(x);
	}

	public static void println(String x) {
		if (DEBUG)
			DEBUG_STREAM.println(x);
	}

	public static void print(boolean b) {
		if (DEBUG)
			DEBUG_STREAM.print(b);
	}

	public static void print(char c) {
		if (DEBUG)
			DEBUG_STREAM.print(c);
	}

	public static void print(int i) {
		if (DEBUG)
			DEBUG_STREAM.print(i);
	}

	public static void print(long l) {
		if (DEBUG)
			DEBUG_STREAM.print(l);
	}

	public static void print(float f) {
		if (DEBUG)
			DEBUG_STREAM.print(f);
	}

	public static void print(double d) {
		if (DEBUG)
			DEBUG_STREAM.print(d);
	}

	public static void print(char[] s) {
		if (DEBUG)
			DEBUG_STREAM.print(s);
	}

	public static void print(String s) {
		if (DEBUG)
			DEBUG_STREAM.print(s);
	}

	public static void print(Object obj) {
		if (DEBUG)
			DEBUG_STREAM.print(obj);
	}

	static {
		DEBUG_STREAM = new DebugStream();
		DEBUG_STREAM.addFilter(Debug.class);
	}
}

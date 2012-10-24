package net.jeeeyul.pdetools.internal;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.Platform;

public class PlatformPropertyTester extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver == Platform.class) {
			if (property.equals("os")) {
				return Platform.getOS().equals((String) expectedValue);
			}
		}
		return false;
	}

}

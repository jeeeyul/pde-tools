package net.jeeeyul.pdetools.clipboard;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class SharedColor implements IColorProvider {
	private Display display;
	private Map<RGB, Color> cache;

	public SharedColor(Display display) {
		super();
		this.display = display;
		cache = new HashMap<RGB, Color>();
	}

	@Override
	public Color getColor(RGB rgb) {
		Color result = cache.get(rgb);
		if (result == null) {
			result = new Color(display, rgb);
			cache.put(rgb, result);
		}
		return result;
	}

	public void flush() {
		for (Color each : cache.values()) {
			each.dispose();
		}
		cache.clear();
	}

}

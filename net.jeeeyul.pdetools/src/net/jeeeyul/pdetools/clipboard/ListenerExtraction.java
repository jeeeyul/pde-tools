package net.jeeeyul.pdetools.clipboard;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;

public class ListenerExtraction {
	private Map<Integer, Listener[]> backup = new HashMap<Integer, Listener[]>();
	private Control control;

	public ListenerExtraction(Control control, int... types) {
		this.control = control;

		for (int each : types) {
			Listener[] listeners = control.getListeners(each);
			backup.put(each, listeners);

			for (Listener eachListener : listeners) {
				control.removeListener(each, eachListener);
			}
		}
	}

	public void restore() {
		for (int eachType : backup.keySet()) {
			Listener[] listeners = backup.get(eachType);
			for (Listener eachListener : listeners) {
				control.addListener(eachType, eachListener);
			}
		}
		backup.clear();
	}
}

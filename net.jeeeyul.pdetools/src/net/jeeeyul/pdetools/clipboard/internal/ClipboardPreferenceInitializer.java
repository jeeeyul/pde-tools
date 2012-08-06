package net.jeeeyul.pdetools.clipboard.internal;

import net.jeeeyul.pdetools.PDEToolsCore;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import static net.jeeeyul.pdetools.clipboard.internal.ClipboardPreferenceConstants.*;

public class ClipboardPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = PDEToolsCore.getDefault().getPreferenceStore();

		store.setDefault(CLIPBOARD_COLORLIZE_IN_SELECTION, false);
		store.setDefault(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES, false);
		store.setDefault(CLIPBOARD_MAXIMUM_HISTORY_SIZE, 50);
	}

}

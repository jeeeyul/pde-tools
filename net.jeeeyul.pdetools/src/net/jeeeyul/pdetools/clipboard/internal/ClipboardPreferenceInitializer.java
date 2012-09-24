package net.jeeeyul.pdetools.clipboard.internal;

import static net.jeeeyul.pdetools.clipboard.internal.ClipboardPreferenceConstants.CLIPBOARD_COLORLIZE_IN_SELECTION;
import static net.jeeeyul.pdetools.clipboard.internal.ClipboardPreferenceConstants.CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES;
import static net.jeeeyul.pdetools.clipboard.internal.ClipboardPreferenceConstants.CLIPBOARD_MAXIMUM_HISTORY_SIZE;
import net.jeeeyul.pdetools.PDEToolsCore;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class ClipboardPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = PDEToolsCore.getDefault().getPreferenceStore();

		store.setDefault(CLIPBOARD_COLORLIZE_IN_SELECTION, false);
		store.setDefault(CLIPBOARD_DONT_ASK_WHEN_REMOVE_ALL_CLIPBOARD_ENTRIES, false);
		store.setDefault(CLIPBOARD_MAXIMUM_HISTORY_SIZE, 50);
		store.setDefault(ClipboardPreferenceConstants.CLIPBOARD_NUMBER_OF_LINES_PER_EACH_ITEM, 5);
	}

}

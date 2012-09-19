package net.jeeeyul.pdetools.crazyoutline;

import net.jeeeyul.pdetools.PDEToolsCore;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class CrazyPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = PDEToolsCore.getDefault().getPreferenceStore();
		store.setDefault(CrazyOutlineConstants.INVERT_SWIPE_GESTURE, true);
	}

}

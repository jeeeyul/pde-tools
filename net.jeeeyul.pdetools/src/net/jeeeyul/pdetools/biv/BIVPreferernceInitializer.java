package net.jeeeyul.pdetools.biv;

import net.jeeeyul.pdetools.PDEToolsCore;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class BIVPreferernceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = PDEToolsCore.getDefault().getPreferenceStore();
		store.setDefault(BIVConfigConstants.BUNDLE_FILTER, "*.ui*");
	}

}

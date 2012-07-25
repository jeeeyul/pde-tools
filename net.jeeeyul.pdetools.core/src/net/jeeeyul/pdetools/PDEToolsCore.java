package net.jeeeyul.pdetools;

import net.jeeeyul.pdetools.clipboard.internal.ClipboardServiceImpl;
import net.jeeeyul.pdetools.shared.DebugStream;
import net.jeeeyul.pdetools.snapshot.SnapshotCore;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class PDEToolsCore extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "net.jeeeyul.pdetools"; //$NON-NLS-1$

	// The shared instance
	private static PDEToolsCore plugin;

	/**
	 * The constructor
	 */
	public PDEToolsCore() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		if (Platform.inDebugMode() || Platform.inDevelopmentMode()) {
			DebugStream.activate();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		ClipboardServiceImpl.getInstance().doSave();
		SnapshotCore.doSave();

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static PDEToolsCore getDefault() {
		return plugin;
	}

}

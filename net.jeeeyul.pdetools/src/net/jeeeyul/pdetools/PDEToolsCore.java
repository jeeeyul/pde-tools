package net.jeeeyul.pdetools;

import net.jeeeyul.pdetools.clipboard.IClipboardService;
import net.jeeeyul.pdetools.snapshot.SnapshotCore;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.ActivityManagerEvent;
import org.eclipse.ui.activities.IActivityManagerListener;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.services.IEvaluationService;
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

		hookActivity();
	}

	private void hookActivity() {
		PlatformUI.getWorkbench().getActivitySupport().getActivityManager()
				.addActivityManagerListener(new IActivityManagerListener() {
					@Override
					public void activityManagerChanged(ActivityManagerEvent activityManagerEvent) {
						handleActivityChanged();
					}
				});
	}

	private void handleActivityChanged() {
		IEvaluationService evalService = (IEvaluationService) PlatformUI.getWorkbench().getService(
				IEvaluationService.class);
		evalService.requestEvaluation("net.jeeeyul.pdetools.isActivityEnabled");
		evalService.requestEvaluation("net.jeeeyul.pdetools.isCategoryEnabled");
		Debug.println("request evaluation for activity property");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		IClipboardService.INSTANCE.doSave();

		SnapshotCore.save();
		SnapshotCore.clean();

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

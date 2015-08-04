package net.jeeeyul.pdetools.shared;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "net.jeeeyul.pdetools.shared.messages"; //$NON-NLS-1$
	public static String ElapsedTimeLabelProvider_DAYS_AGO;
	public static String ElapsedTimeLabelProvider_HALF_YEARS_AGO;
	public static String ElapsedTimeLabelProvider_HOURS_AGO;
	public static String ElapsedTimeLabelProvider_JUST_NOW;
	public static String ElapsedTimeLabelProvider_LAST_WEEK;
	public static String ElapsedTimeLabelProvider_MINITUES_AGO;
	public static String ElapsedTimeLabelProvider_MONTHS_AGO;
	public static String ElapsedTimeLabelProvider_SECONDS_AGO;
	public static String ElapsedTimeLabelProvider_WEEKS_AGO;
	public static String ElapsedTimeLabelProvider_YEARS_AGO;
	public static String ElapsedTimeLabelProvider_YESTERDAY;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}

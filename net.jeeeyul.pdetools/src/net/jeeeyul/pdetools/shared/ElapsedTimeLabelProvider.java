package net.jeeeyul.pdetools.shared;

import java.text.MessageFormat;

public class ElapsedTimeLabelProvider {
	public static final long MINITUE = 60 * 1000;
	public static final long HOUR = MINITUE * 60;
	public static final long DAY = HOUR * 24;
	public static final long MONTH = DAY * 30;
	public static final long YEAR = DAY * 365;

	public static String getText(long timeElapsed) {
		if (timeElapsed >= YEAR) {
			return MessageFormat.format(Messages.ElapsedTimeLabelProvider_YEARS_AGO, timeElapsed / YEAR);
		} else if (timeElapsed >= YEAR / 2) {
			return Messages.ElapsedTimeLabelProvider_HALF_YEARS_AGO;
		} else if (timeElapsed >= MONTH) {
			return MessageFormat.format(Messages.ElapsedTimeLabelProvider_MONTHS_AGO, timeElapsed / MONTH);
		} else if (timeElapsed >= DAY * 14) {
			return MessageFormat.format(Messages.ElapsedTimeLabelProvider_WEEKS_AGO, timeElapsed / (DAY * 7));
		} else if (timeElapsed >= DAY * 7) {
			return Messages.ElapsedTimeLabelProvider_LAST_WEEK;
		} else if (timeElapsed >= DAY * 2) {
			return MessageFormat.format(Messages.ElapsedTimeLabelProvider_DAYS_AGO, timeElapsed / DAY);
		} else if (timeElapsed >= DAY) {
			return Messages.ElapsedTimeLabelProvider_YESTERDAY;
		} else if (timeElapsed > HOUR) {
			return MessageFormat.format(Messages.ElapsedTimeLabelProvider_HOURS_AGO, timeElapsed / HOUR);
		} else if (timeElapsed >= MINITUE) {
			return MessageFormat.format(Messages.ElapsedTimeLabelProvider_MINITUES_AGO, timeElapsed / MINITUE);
		} else if (timeElapsed > 10000) {
			return MessageFormat.format(Messages.ElapsedTimeLabelProvider_SECONDS_AGO, timeElapsed / 1000);
		} else {
			return Messages.ElapsedTimeLabelProvider_JUST_NOW;
		}
	}
}

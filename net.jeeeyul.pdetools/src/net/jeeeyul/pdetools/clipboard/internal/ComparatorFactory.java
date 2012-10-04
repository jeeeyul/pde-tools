package net.jeeeyul.pdetools.clipboard.internal;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.jeeeyul.pdetools.model.pdetools.ClipItemSortOption;
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;

public class ComparatorFactory {
	private Map<ClipItemSortOption, Comparator<ClipboardEntry>> cache = new HashMap<ClipItemSortOption, Comparator<ClipboardEntry>>();

	public Comparator<ClipboardEntry> get(ClipItemSortOption option) {
		Comparator<ClipboardEntry> result = cache.get(option);
		if (result == null) {
			result = create(option);
			cache.put(option, result);
		}
		return result;
	}

	public Comparator<ClipboardEntry> getByLiteral(String literal) {
		ClipItemSortOption option = ClipItemSortOption.get(literal);
		return get(option);
	}

	private Comparator<ClipboardEntry> create(ClipItemSortOption option) {
		switch (option) {
			case CAPTURED_ORDER:
				return new Comparator<ClipboardEntry>() {
					@Override
					public int compare(ClipboardEntry o1, ClipboardEntry o2) {
						return o2.getTakenTime().compareTo(o1.getTakenTime());
					}
				};

			case LAST_USE:
				return new Comparator<ClipboardEntry>() {
					@Override
					public int compare(ClipboardEntry o1, ClipboardEntry o2) {
						Date o1Time = o1.getLastUsedTime();
						Date o2Time = o2.getLastUsedTime();
						if (o1Time == null && o2Time == null) {
							return 0;
						} else if (o1Time == null) {
							return 1;
						} else if (o2Time == null) {
							return -1;
						} else
							return o2Time.compareTo(o1Time);
					}

				};

			case USING_COUNT:
				return new Comparator<ClipboardEntry>() {
					@Override
					public int compare(ClipboardEntry o1, ClipboardEntry o2) {
						return o2.getUsingCount() - o1.getUsingCount();
					}
				};

			case ACTIVE:
				return new Comparator<ClipboardEntry>() {
					@Override
					public int compare(ClipboardEntry o1, ClipboardEntry o2) {
						if (o1.isActive()) {
							return -1;
						} else if (o2.isActive()) {
							return 1;
						} else {
							return 0;
						}
					}
				};

			default:
				return null;
		}
	}
}

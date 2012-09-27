package net.jeeeyul.pdetools.shared;

import java.util.ArrayList;
import java.util.Comparator;

public class ChaindComparator<T> implements Comparator<T> {
	private ArrayList<Comparator<? super T>> comparators = new ArrayList<Comparator<? super T>>();
	
	public boolean add(Comparator<? super T> e) {
		return comparators.add(e);
	}

	public void clear() {
		comparators.clear();
	}

	@Override
	public int compare(T o1, T o2) {
		for(Comparator<? super T> each : comparators){
			int eachResult = each.compare(o1, o2);
			if(eachResult != 0){
				return eachResult;
			}
		}
		return 0;
	}

	public Comparator<? super T> remove(int index) {
		return comparators.remove(index);
	}

	public boolean remove(Object o) {
		return comparators.remove(o);
	}

}

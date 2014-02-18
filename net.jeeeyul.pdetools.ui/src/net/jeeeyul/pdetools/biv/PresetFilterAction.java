package net.jeeeyul.pdetools.biv;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

public class PresetFilterAction extends Action {
	private BundleImageView view;
	private String filter;

	public PresetFilterAction(BundleImageView view, String name, String filter) {
		super(name, SWT.RADIO);
		this.view = view;
		this.filter = filter;
		update();
	}

	@Override
	public void run() {
		view.setFilterLiteral(filter);
	}

	public void update() {
		setChecked(this.filter.equals(view.getFilterLiteral()));
	}
}

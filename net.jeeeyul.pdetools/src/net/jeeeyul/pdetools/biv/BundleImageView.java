package net.jeeeyul.pdetools.biv;

import java.util.ArrayList;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.shared.SimpleGalleryGroupRenderer;
import net.jeeeyul.pdetools.shared.SimpleGalleryItemRenderer;
import net.jeeeyul.pdetools.shared.StringUtil;
import net.jeeeyul.pdetools.shared.UpdateJob;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.osgi.framework.Bundle;

public class BundleImageView extends ViewPart {
	private GalleryTreeViewer viewer;
	private String filterPattern;
	private boolean ignoreFilterEvent = false;
	private ArrayList<PresetFilterAction> presetActions = new ArrayList<PresetFilterAction>();

	private UpdateJob refreshFilter = new UpdateJob(new Procedure0() {
		@Override
		public void apply() {
			if (!viewer.getGallery().isDisposed()) {
				refreshFilter();
			}
		}
	});

	private Filter filter;
	private String filterLiteral;

	private void addPresetMenu(PresetFilterAction action) {
		final IMenuManager menu = getViewSite().getActionBars().getMenuManager();
		presetActions.add(action);
		menu.add(action);
	}

	private void configMenu() {
		addPresetMenu(new PresetFilterAction(this, "All UI Plugins", "*.ui*"));
		addPresetMenu(new PresetFilterAction(this, "Eclipse UI Plugins", "org.eclipse.ui*"));
		getViewSite().getActionBars().getMenuManager().add(new Separator());
		addPresetMenu(new PresetFilterAction(this, "Turn off filter", ""));

		getViewSite().getActionBars().getMenuManager().addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				manager.updateAll(true);
			}
		});
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NORMAL);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		layout.verticalSpacing = 0;

		container.setLayout(layout);

		filter = new Filter(container);
		filter.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		filter.getTextField().addListener(SWT.Modify, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (!ignoreFilterEvent)
					refreshFilter.schedule(1000);
			}
		});
		String initialFilter = PDEToolsCore.getDefault().getPreferenceStore()
				.getString(BIVConfigConstants.BUNDLE_FILTER);
		filter.getTextField().setText(initialFilter);

		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		viewer = new GalleryTreeViewer(container, SWT.MULTI | SWT.V_SCROLL | SWT.VIRTUAL);
		viewer.setUseHashlookup(true);
		viewer.getGallery().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.getGallery().setItemRenderer(new SimpleGalleryItemRenderer());

		SimpleGalleryGroupRenderer groupRenderer = new SimpleGalleryGroupRenderer();
		groupRenderer.setItemSize(48, 48);
		viewer.getGallery().setGroupRenderer(groupRenderer);

		viewer.setContentProvider(new BundleImageContentProvider());
		viewer.setLabelProvider(new BundleImageLabelProvider());
		viewer.setInput(Object.class);

		viewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof Bundle) {
					return doFilter((Bundle) element);
				} else
					return true;
			}
		});

		new DragImageSupport(viewer);

		refreshFilter();

		configMenu();
	}

	@Override
	public void dispose() {
		PDEToolsCore.getDefault().getPreferenceStore().putValue(BIVConfigConstants.BUNDLE_FILTER, filterLiteral);
		super.dispose();
	}

	private boolean doFilter(Bundle element) {
		if (filterPattern == null) {
			return true;
		}
		return element.getSymbolicName().matches(filterPattern);
	}

	public String getFilterLiteral() {
		return filterLiteral;
	}

	private void refreshFilter() {
		String literal = filter.getTextField().getText().trim();
		setFilterLiteral(literal, false);
	}

	public void setFilterLiteral(String wildCard) {
		setFilterLiteral(wildCard, true);
	}

	private void setFilterLiteral(String wildCard, boolean updateUI) {
		if (updateUI) {
			filter.getTextField().setText(wildCard);
			filter.getTextField().update();
			ignoreFilterEvent = true;
		}

		if (wildCard == null) {
			throw new IllegalArgumentException();
		}
		if (wildCard.equals(this.filterLiteral)) {
			return;
		}

		if (wildCard.isEmpty()) {
			setFilterPattern(null);
		} else if (!wildCard.contains("*")) {
			setFilterPattern(StringUtil.wildExpToRegExpSafeString("*" + wildCard + "*"));
		} else {
			setFilterPattern(StringUtil.wildExpToRegExpSafeString(wildCard));
		}

		filterLiteral = wildCard;

		for (PresetFilterAction each : presetActions) {
			each.update();
		}

		if (updateUI) {
			ignoreFilterEvent = false;
		}
	}

	private void setFilterPattern(String filterPattern) {
		if (this.filterPattern == filterPattern) {
			return;
		} else if (filterPattern != null && filterPattern.equals(this.filterPattern)) {
			return;
		} else if (this.filterPattern != null && this.filterPattern.equals(filterPattern)) {
			return;
		}
		this.filterPattern = filterPattern;
		viewer.refresh();
	}

	@Override
	public void setFocus() {

	}

}

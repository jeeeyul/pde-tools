package net.jeeeyul.pdetools.biv;

import java.util.ArrayList;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.biv.lazy.BIContentProvider;
import net.jeeeyul.pdetools.biv.lazy.BundleEntry;
import net.jeeeyul.pdetools.biv.lazy.BundleImageLabelProvider;
import net.jeeeyul.pdetools.biv.lazy.URLImageEntry;
import net.jeeeyul.pdetools.shared.SharedImages;
import net.jeeeyul.pdetools.shared.SimpleGalleryItemRenderer;
import net.jeeeyul.pdetools.shared.StringUtil;
import net.jeeeyul.pdetools.shared.UpdateJob;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

public class BundleImageView extends ViewPart {
	private GalleryTreeViewer viewer;
	private String filterPattern;
	private boolean ignoreFilterEvent = false;
	private ArrayList<PresetFilterAction> presetActions = new ArrayList<PresetFilterAction>();

	private Color gradinntColor1 = new Color(Display.getDefault(), 238, 238, 238);
	private Color gradientColor2 = new Color(Display.getDefault(), 216, 216, 216);

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
	private BundleImageLabelProvider labelProvider;
	private BIContentProvider contentProvider;

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
				if (!ignoreFilterEvent) {
					refreshFilter.cancel();
					refreshFilter.schedule(1000);
				}
					
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

		BIVGroupRenderer groupRenderer = new BIVGroupRenderer();
		groupRenderer.setAnimation(true);
		groupRenderer.setAnimationLength(100);
		groupRenderer.setItemSize(48, 48);
		groupRenderer.setTitleBackgroundGradient(gradientColor2, gradinntColor1);
		groupRenderer.setTitleForeground(viewer.getGallery().getForeground());
		viewer.getGallery().setGroupRenderer(groupRenderer);

		contentProvider = new BIContentProvider();
		viewer.setContentProvider(contentProvider);
		labelProvider = new BundleImageLabelProvider();
		viewer.setLabelProvider(labelProvider);
		viewer.setInput(Object.class);

		viewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof BundleEntry) {
					return doFilter(((BundleEntry) element).getBundle());
				} else
					return true;
			}
		});

		new DragImageSupport(viewer);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				handleSelectionChanged();
			}
		});

		labelProvider.addListener(new ILabelProviderListener() {
			@Override
			public void labelProviderChanged(LabelProviderChangedEvent event) {
				handleSelectionChanged();
			}
		});

		refreshFilter();
		configMenu();
	}

	@Override
	public void dispose() {
		gradinntColor1.dispose();
		gradientColor2.dispose();
		PDEToolsCore.getDefault().getPreferenceStore().putValue(BIVConfigConstants.BUNDLE_FILTER, filterLiteral);
		super.dispose();
	}

	private boolean doFilter(Bundle element) {
		if (filterPattern == null) {
			return true;
		}
		String test = element.getSymbolicName() + element.getHeaders().get(Constants.BUNDLE_NAME).toLowerCase();
		return test.matches(filterPattern);
	}

	public String getFilterLiteral() {
		return filterLiteral;
	}

	private void handleSelectionChanged() {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		IStatusLineManager statusLineManager = getViewSite().getActionBars().getStatusLineManager();
		statusLineManager.setMessage(null);

		if (selection.size() > 1) {
			statusLineManager
					.setMessage(SharedImages.getImage(SharedImages.BUNDLE_IMAGE), selection.size() + " images");
		} else if (selection.size() == 1) {
			URLImageEntry item = (URLImageEntry) selection.getFirstElement();
			statusLineManager.setMessage(SharedImages.getImage(SharedImages.BUNDLE_IMAGE), labelProvider.getText(item));
		}
	}

	private void refreshFilter() {
		String literal = filter.getTextField().getText().trim();
		setFilterLiteral(literal, false);
	}

	public void setFilterLiteral(String wildCard) {
		setFilterLiteral(wildCard, true);
	}

	private void setFilterLiteral(String wildCard, boolean updateUI) {
		wildCard = wildCard.toLowerCase();

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
		viewer.getControl().setFocus();
	}

}

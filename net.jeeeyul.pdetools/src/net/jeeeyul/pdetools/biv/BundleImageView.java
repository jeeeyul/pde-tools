package net.jeeeyul.pdetools.biv;

import net.jeeeyul.pdetools.shared.SimpleGalleryGroupRenderer;
import net.jeeeyul.pdetools.shared.SimpleGalleryItemRenderer;
import net.jeeeyul.pdetools.shared.StringUtil;
import net.jeeeyul.pdetools.shared.UpdateJob;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.nebula.widgets.gallery.DefaultGalleryGroupRenderer;
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

	private UpdateJob refreshFilter = new UpdateJob(new Procedure0() {
		@Override
		public void apply() {
			refreshFilter();
		}
	});

	private Filter filter;

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NORMAL);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		layout.verticalSpacing = 2;

		container.setLayout(layout);

		filter = new Filter(container);
		filter.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		filter.getTextField().addListener(SWT.Modify, new Listener() {
			@Override
			public void handleEvent(Event event) {
				refreshFilter.schedule(1000);
			}
		});

		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		viewer = new GalleryTreeViewer(container, SWT.MULTI | SWT.V_SCROLL | SWT.VIRTUAL);
		viewer.setUseHashlookup(true);
		viewer.getGallery().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.getGallery().setItemRenderer(new SimpleGalleryItemRenderer());
		DefaultGalleryGroupRenderer groupRenderer = (DefaultGalleryGroupRenderer) viewer.getGallery()
				.getGroupRenderer();
		groupRenderer.setItemSize(64, 64);

		viewer.getGallery().setGroupRenderer(new SimpleGalleryGroupRenderer());

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
	}

	protected boolean doFilter(Bundle element) {
		if (filterPattern == null) {
			return true;
		}
		return element.getSymbolicName().matches(filterPattern);
	}

	protected void refreshFilter() {
		String literal = filter.getTextField().getText().trim();
		if (literal.isEmpty()) {
			setFilterPattern(null);
		}else if(!literal.contains("*")){
			setFilterPattern(StringUtil.wildExpToRegExpSafeString("*" + literal + "*"));
		}else{
			setFilterPattern(StringUtil.wildExpToRegExpSafeString(literal));
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

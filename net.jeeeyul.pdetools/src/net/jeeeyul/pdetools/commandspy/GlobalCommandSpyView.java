package net.jeeeyul.pdetools.commandspy;

import java.util.Date;

import net.jeeeyul.pdetools.model.pdetools.CommandEvent;
import net.jeeeyul.pdetools.model.pdetools.CommandHistory;
import net.jeeeyul.pdetools.shared.ResourceRegistry;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class GlobalCommandSpyView extends ViewPart {
	private ResourceRegistry<ImageDescriptor, Image> imageRegistry = new ResourceRegistry<ImageDescriptor, Image>(
			new Function1<ImageDescriptor, Image>() {
				@Override
				public Image apply(ImageDescriptor p) {
					return p.createImage();
				}
			});
	private TableViewer viewer;
	private Procedure1<CommandEvent> executionListener = new Procedure1<CommandEvent>() {
		@Override
		public void apply(CommandEvent p) {
			doRefresh();
		}
	};

	@Override
	public void createPartControl(Composite parent) {
		final GlobalCommandSpy spy = GlobalCommandSpy.getInstance();

		viewer = new TableViewer(parent, SWT.NONE | SWT.FULL_SELECTION | SWT.VIRTUAL);
		viewer.setUseHashlookup(true);
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);

		TableViewerColumn nameColumn = new TableViewerColumn(viewer, SWT.NORMAL);
		nameColumn.getColumn().setWidth(150);
		nameColumn.getColumn().setText("Name");
		nameColumn.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				CommandEvent ce = (CommandEvent) cell.getElement();
				cell.setText(ce.getName());

				if (ce.getImageDescriptor() != null) {
					cell.setImage(imageRegistry.get(ce.getImageDescriptor()));
				} else {
					cell.setImage(SharedImages.getImage(SharedImages.BLANK));
				}
			}
		});

		TableViewerColumn idColumn = new TableViewerColumn(viewer, SWT.NORMAL);
		idColumn.getColumn().setWidth(150);
		idColumn.getColumn().setText("ID");
		idColumn.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				CommandEvent ce = (CommandEvent) cell.getElement();
				cell.setText(ce.getCommandId());
			}
		});

		TableViewerColumn whenColumn = new TableViewerColumn(viewer, SWT.NORMAL);
		whenColumn.getColumn().setWidth(150);
		whenColumn.getColumn().setText("When");
		whenColumn.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				CommandEvent ce = (CommandEvent) cell.getElement();
				Date date = new Date(ce.getTime());
				cell.setText(date.toString());
			}
		});

		viewer.setContentProvider(new ILazyContentProvider() {
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			@Override
			public void dispose() {

			}

			@Override
			public void updateElement(int index) {
				((TableViewer) viewer).replace(getHistory().getEvents().get(index), index);
			}

		});

		viewer.setInput(spy.getCommandHistory());
		spy.addListener(executionListener);

		getSite().setSelectionProvider(viewer);
	}

	protected CommandHistory getHistory() {
		return GlobalCommandSpy.getInstance().getCommandHistory();
	}

	private void doRefresh() {
		viewer.setItemCount(getHistory().getEvents().size());
		viewer.refresh();
	}

	@Override
	public void dispose() {
		GlobalCommandSpy.getInstance().removeListener(executionListener);
		imageRegistry.dispose();
		super.dispose();
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

}

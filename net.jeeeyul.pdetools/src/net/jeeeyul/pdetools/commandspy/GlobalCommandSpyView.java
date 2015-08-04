package net.jeeeyul.pdetools.commandspy;

import java.util.Date;

import net.jeeeyul.pdetools.model.pdetools.CommandEvent;
import net.jeeeyul.pdetools.model.pdetools.CommandExecutionType;
import net.jeeeyul.pdetools.model.pdetools.CommandHistory;
import net.jeeeyul.pdetools.shared.DeferredViewerUpdate;
import net.jeeeyul.pdetools.shared.ResourceRegistry;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class GlobalCommandSpyView extends ViewPart {
	private ResourceRegistry<ImageDescriptor, Image> imageRegistry = new ResourceRegistry<ImageDescriptor, Image>(
			new Function1<ImageDescriptor, Image>() {
				@Override
				public Image apply(ImageDescriptor p) {
					return p.createImage();
				}
			});
	private TreeViewer viewer;

	private DeferredViewerUpdate<TreeViewer> viewerRefresh;

	private EContentAdapter modelListener = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			viewerRefresh.schedule();
			super.notifyChanged(notification);
		}
	};
	private Action removeAllAction;

	@Override
	public void createPartControl(Composite parent) {
		final GlobalCommandSpy spy = GlobalCommandSpy.getInstance();

		viewer = new TreeViewer(parent, SWT.NONE | SWT.FULL_SELECTION | SWT.VIRTUAL);
		viewer.setUseHashlookup(true);
		viewer.setAutoExpandLevel(3);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);

		TreeViewerColumn nameColumn = new TreeViewerColumn(viewer, SWT.NORMAL);
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
					cell.setImage(SharedImages.getImage(SharedImages.COMMAND));
				}
			}
		});

		TreeViewerColumn stateColumn = new TreeViewerColumn(viewer, SWT.NORMAL);
		stateColumn.getColumn().setWidth(24);
		stateColumn.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				CommandEvent ce = (CommandEvent) cell.getElement();
				CommandExecutionType type = ce.getType();
				if (type == CommandExecutionType.SUCCEED) {
					cell.setImage(SharedImages.getImage(SharedImages.SUCCEED));
				} else if (type == CommandExecutionType.EXECUTING) {
					cell.setImage(SharedImages.getImage(SharedImages.EXECUTING));
				} else {
					cell.setImage(SharedImages.getImage(SharedImages.ERROR));
				}
			}
		});

		TreeViewerColumn idColumn = new TreeViewerColumn(viewer, SWT.NORMAL);
		idColumn.getColumn().setWidth(250);
		idColumn.getColumn().setText("ID");
		idColumn.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				CommandEvent ce = (CommandEvent) cell.getElement();
				cell.setText(ce.getCommandId());
			}
		});

		TreeViewerColumn whenColumn = new TreeViewerColumn(viewer, SWT.NORMAL);
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

		getSite().setSelectionProvider(viewer);

		viewerRefresh = new DeferredViewerUpdate<TreeViewer>(viewer) {
			@Override
			protected void update(TreeViewer viewer) {
				doRefresh();
			}
		};

		viewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			@Override
			public void dispose() {
			}

			@Override
			public boolean hasChildren(Object element) {
				CommandEvent ce = (CommandEvent) element;
				return ce.getChildren().size() > 0;
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return getHistory().getEvents().toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				CommandEvent ce = (CommandEvent) parentElement;
				return ce.getChildren().toArray();
			}
		});

		viewer.setInput(spy.getCommandHistory());
		spy.getCommandHistory().eAdapters().add(modelListener);
	}

	protected CommandHistory getHistory() {
		return GlobalCommandSpy.getInstance().getCommandHistory();
	}

	private void doRefresh() {
		viewer.refresh();
		removeAllAction.setEnabled(getHistory().getEvents().size() > 0);
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);

		removeAllAction = new Action("Remove All", SharedImages.getImageDescriptor(SharedImages.DELETE_ALL)) {
			@Override
			public void run() {
				getHistory().getEvents().clear();
			}
		};

		getViewSite().getActionBars().getToolBarManager().add(removeAllAction);
	}

	@Override
	public void dispose() {
		GlobalCommandSpy.getInstance().getCommandHistory().eAdapters().remove(modelListener);
		imageRegistry.dispose();
		super.dispose();
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

}

package net.jeeeyul.pdetools.clipboard.internal;

import java.util.ArrayList;
import java.util.List;

import net.jeeeyul.pdetools.clipboard.ClipboardViewer;
import net.jeeeyul.pdetools.clipboard.IClipboardService;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.part.ViewPart;

public class ClipboardView extends ViewPart {
	public static final String ID = "net.jeeeyul.pdetools.clipboard.ClipboardView";
	private ClipboardViewer viewer;
	private List<ClipboardHistoryAction> actions = new ArrayList<ClipboardHistoryAction>();
	private EContentAdapter listener = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			if (notification.isTouch()) {
				return;
			}
			updateActions();
		};
	};

	public ClipboardViewer getViewer() {
		return viewer;
	}

	protected void updateActions() {
		for (ClipboardHistoryAction eachAction : actions) {
			eachAction.update();
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new ClipboardViewer(parent, SWT.NORMAL);
		TableViewer tableViewer = viewer.getTableViewer();
		getViewSite().setSelectionProvider(tableViewer);

		configureActions(tableViewer);

		getClipboardService().getHistory().eAdapters().add(listener);

		updateActions();
	}

	private void configureActions(TableViewer tableViewer) {
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(tableViewer.getTable());
		tableViewer.getTable().setMenu(menu);
		getViewSite().registerContextMenu(menuManager, tableViewer);

		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		RemoveAllAction removeAllAction = new RemoveAllAction(ClipboardServiceImpl.getInstance().getHistory());
		actions.add(removeAllAction);
		toolBarManager.add(removeAllAction);
	}

	@Override
	public void dispose() {
		getClipboardService().getHistory().eAdapters().remove(listener);
		super.dispose();
	}

	private IClipboardService getClipboardService() {
		return (IClipboardService) getSite().getService(IClipboardService.class);
	}

	@Override
	public void setFocus() {
		viewer.getTableViewer().getTable().setFocus();
	}

}

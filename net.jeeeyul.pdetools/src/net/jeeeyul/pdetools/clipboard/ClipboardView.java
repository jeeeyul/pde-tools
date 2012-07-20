package net.jeeeyul.pdetools.clipboard;

import java.util.ArrayList;
import java.util.List;

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
	
	public ClipboardViewer getViewer() {
		return viewer;
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new ClipboardViewer(parent, SWT.NORMAL);
		TableViewer tableViewer = viewer.getTableViewer();
		getViewSite().setSelectionProvider(tableViewer);

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
	public void setFocus() {
		viewer.getTableViewer().getTable().setFocus();
	}

}

package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.clipboard.internal.ClipboardServiceImpl;
import net.jeeeyul.pdetools.clipboard.internal.SharedColor;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;

public class ClipboardViewer {
	private SharedColor sharedColor;
	private TableViewer viewer;
	private TableViewerColumn column;

	private EContentAdapter historyListener = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			if (!notification.isTouch())
				handleNotification(notification);
			super.notifyChanged(notification);
		};
	};
	private int style;

	public ClipboardViewer(Composite parent, int style) {
		this.style = style;
		create(parent);
		parent.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});
	}

	private void create(Composite parent) {
		sharedColor = new SharedColor(parent.getDisplay());
		viewer = new TableViewer(parent, SWT.VIRTUAL | SWT.FULL_SELECTION | style);
		viewer.setUseHashlookup(true);

		column = new TableViewerColumn(viewer, SWT.NORMAL);
		column.setLabelProvider(new ClipEntryLabelProvider(sharedColor));

		/*
		 * prevent drawing ugly focus
		 */
		viewer.getTable().addListener(SWT.EraseItem, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if ((event.detail & SWT.FOCUSED) != 0) {
					event.detail = event.detail ^ SWT.FOCUSED;
				}
			}
		});

		final Listener resizer = new Listener() {
			@Override
			public void handleEvent(Event event) {
				int size = viewer.getTable().getClientArea().width;
				column.getColumn().setWidth(size);
				viewer.getTable().redraw();
			}
		};
		viewer.getTable().addListener(SWT.Resize, resizer);
		viewer.getTable().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				if(viewer.getTable().isDisposed()){
					return;
				}
				resizer.handleEvent(null);
			}
		});

		viewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public void dispose() {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return ClipboardServiceImpl.getInstance().getHistory().getEntries().toArray();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		});

		viewer.setInput(ClipboardServiceImpl.getInstance().getHistory());
		ClipboardServiceImpl.getInstance().getHistory().eAdapters().add(historyListener);

		Font font = PlatformUI.getWorkbench().getThemeManager().getCurrentTheme().getFontRegistry()
				.get("org.eclipse.jface.textfont");
		viewer.getTable().setFont(font);

		DragSource dragSource = new DragSource(viewer.getTable(), DND.DROP_COPY);
		dragSource.setTransfer(new Transfer[] { TextTransfer.getInstance() });
		dragSource.addDragListener(new DragSourceAdapter() {
			@Override
			public void dragSetData(DragSourceEvent event) {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = ((ClipboardEntry) selection.getFirstElement()).getTextContent();
				}
			}

			@Override
			public void dragStart(DragSourceEvent event) {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				if (!selection.isEmpty()) {
					event.detail = DND.DROP_COPY;
					event.doit = true;
				}
			}
		});
	}

	public void dispose() {
		sharedColor.flush();
		ClipboardServiceImpl.getInstance().getHistory().eAdapters().remove(historyListener);
	}

	public TableViewer getTableViewer() {
		return viewer;
	}

	protected void handleNotification(Notification notification) {
		viewer.refresh();
	}

	public void setFocus() {
	}
}

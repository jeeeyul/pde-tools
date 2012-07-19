package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.clipboard.internal.DisposeShellJob;
import net.jeeeyul.pdetools.clipboard.internal.FocusingJob;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

public class ClipEntrySelectionDialog {
	Listener hostHook = new Listener() {
		@Override
		public void handleEvent(Event event) {
			if (shell == null || shell.isDisposed()) {
				return;
			}
			event.doit = !performKeyDown(event);
		}
	};

	Listener focusListener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			if (shell == null || shell.isDisposed()) {
				return;
			}
			handleFocusEvent(event);
		}
	};

	Listener tableHook = new Listener() {
		@Override
		public void handleEvent(Event event) {
			handleTableKeyDown(event);
		}
	};

	private Shell parentShell;
	private Shell shell;
	private ClipboardViewer clipboardViewer;
	private Table table;
	private DisposeShellJob closing;
	private FocusingJob activation;

	public ClipEntrySelectionDialog(Shell parentShell) {
		this.parentShell = parentShell;
	}

	protected void handleTableKeyDown(Event event) {
		int itemCount = table.getItemCount();
		int visibleRow = table.getClientArea().height / table.getItemHeight();
		int selection = table.getSelectionIndex();
		if (selection == -1) {
			selection = 0;
		}
		switch (event.keyCode) {
		case SWT.ARROW_DOWN:
			selection += 1;
			if (selection >= itemCount) {
				selection = 0;
			}
			event.doit = false;
			break;

		case SWT.ARROW_UP:
			selection -= 1;
			if (selection < 0) {
				selection = itemCount - 1;
			}
			event.doit = false;
			break;

		case SWT.PAGE_UP:
			selection = Math.max(0, selection - visibleRow);
			event.doit = false;
			break;

		case SWT.PAGE_DOWN:
			selection = Math.min(itemCount - 1, selection + visibleRow);
			event.doit = false;
			break;

		default:
			return;
		}

		table.select(selection);
		table.showSelection();
	}

	private void allocateShell() {
		shell.setBounds(50, 50, 400, 300);
	}

	public void close() {
		closing.schedule();
	}

	private void create() {
		if (shell != null && !shell.isDisposed()) {
			return;
		}

		shell = new Shell(parentShell, SWT.ON_TOP | SWT.RESIZE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		shell.setLayout(layout);

		clipboardViewer = new ClipboardViewer(shell, SWT.NORMAL);
		table = clipboardViewer.getTableViewer().getTable();
		clipboardViewer.getTableViewer().getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		closing = new DisposeShellJob(shell);

		if (table.getItemCount() > 0) {
			table.select(0);
		}

		table.addListener(SWT.KeyDown, tableHook);

		activation = new FocusingJob(table);
	}

	protected void handleFocusEvent(Event event) {
		Control control = (Control) event.widget;
		while (control != null) {
			if (control == shell) {
				return;
			}
			control = control.getParent();
		}
		shell.dispose();
	}

	public ClipboardEntry open() {
		if (shell == null || shell.isDisposed()) {
			create();
		}

		Display display = parentShell.getDisplay();

		Control host = display.getFocusControl();

		host.addListener(SWT.Traverse, hostHook);
		host.addListener(SWT.KeyDown, hostHook);
		host.addListener(SWT.Modify, hostHook);
		host.addListener(ST.VerifyKey, hostHook);
		display.addFilter(SWT.FocusIn, focusListener);

		allocateShell();
		shell.setVisible(true);

		runLoop();

		host.removeListener(SWT.Traverse, hostHook);
		host.removeListener(SWT.KeyDown, hostHook);
		host.removeListener(SWT.Modify, hostHook);
		host.removeListener(ST.VerifyKey, hostHook);
		display.removeFilter(SWT.FocusIn, focusListener);

		return null;
	}

	private boolean performKeyDown(Event event) {
		int selection = table.getSelectionIndex();
		if (selection == -1) {
			selection = 0;
		}

		if (event.type == SWT.Traverse && event.detail == SWT.TRAVERSE_TAB_NEXT) {
			activate();
			return true;
		}

		if (event.character == SWT.CR) {
			close();
			return true;
		}

		if (event.character == SWT.TAB) {
			activate();
			return true;
		}

		switch (event.keyCode) {
		case SWT.ARROW_DOWN:
		case SWT.ARROW_UP:
		case SWT.PAGE_UP:
		case SWT.PAGE_DOWN:
			if (event.type == SWT.KeyDown) {
				tableHook.handleEvent(event);
			}
			break;

		default:
			close();
			return false;
		}

		return true;
	}

	public void activate() {
		activation.schedule(20);
	}

	private void runLoop() {
		Display display = parentShell.getDisplay();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		if (!display.isDisposed()) {
			display.update();
		}
	}

}

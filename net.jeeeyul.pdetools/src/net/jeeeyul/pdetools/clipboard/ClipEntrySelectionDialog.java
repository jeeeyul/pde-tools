package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.Activator;
import net.jeeeyul.pdetools.clipboard.internal.DisposeShellJob;
import net.jeeeyul.pdetools.clipboard.internal.FocusingJob;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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

	Listener globalFocusHook = new Listener() {
		@Override
		public void handleEvent(Event event) {
			if (shell == null || shell.isDisposed()) {
				return;
			}
			handleFocusEvent(event);
		}
	};

	Listener dialogHook = new Listener() {
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
	private ClipboardEntry result;
	private CaretHint caretHint;

	public ClipEntrySelectionDialog(Shell parentShell) {
		this.parentShell = parentShell;
	}

	private void activate() {
		activation.schedule(20);
	}

	private void allocateShell() {
		int width = getDialogSettings().getInt("width");
		int height = getDialogSettings().getInt("height");
		shell.setSize(width, height);
		if (caretHint != null) {
			shell.setLocation(caretHint.getX(), caretHint.getY() + caretHint.getHeight());
		}
	}

	private void close() {
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

		table.addListener(SWT.KeyDown, dialogHook);

		activation = new FocusingJob(table);

		clipboardViewer.getTableViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				result = (ClipboardEntry) selection.getFirstElement();
			}
		});

		clipboardViewer.getTableViewer().addOpenListener(new IOpenListener() {
			@Override
			public void open(OpenEvent event) {
				close();
			}
		});

		shell.addListener(SWT.Traverse, dialogHook);
		if (table.getItemCount() > 0) {
			table.select(0);
			table.notifyListeners(SWT.Selection, new Event());
		}
	}

	private IDialogSettings getDialogSettings() {
		IDialogSettings section = Activator.getDefault().getDialogSettings().getSection(getClass().getCanonicalName());
		if (section == null) {
			section = Activator.getDefault().getDialogSettings().addNewSection(getClass().getCanonicalName());
			section.put("width", 400);
			section.put("height", 400);
		}
		return section;
	}

	public ClipboardEntry getResult() {
		return result;
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

	protected void handleTableKeyDown(Event event) {
		if (event.character == SWT.CR) {
			close();
			event.doit = false;
			return;
		}

		if (event.character == SWT.ESC) {
			result = null;
			close();
			return;
		}

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
		table.notifyListeners(SWT.Selection, new Event());
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
		display.addFilter(SWT.FocusIn, globalFocusHook);

		allocateShell();
		shell.setVisible(true);

		runLoop();

		host.removeListener(SWT.Traverse, hostHook);
		host.removeListener(SWT.KeyDown, hostHook);
		host.removeListener(SWT.Modify, hostHook);
		host.removeListener(ST.VerifyKey, hostHook);
		display.removeFilter(SWT.FocusIn, globalFocusHook);

		return getResult();
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

		if (event.character == SWT.ESC) {
			result = null;
			close();
			return true;
		}

		switch (event.keyCode) {
		case SWT.ARROW_DOWN:
		case SWT.ARROW_UP:
		case SWT.PAGE_UP:
		case SWT.PAGE_DOWN:
			if (event.type == SWT.KeyDown) {
				dialogHook.handleEvent(event);
			}
			break;

		default:
			close();
			return false;
		}

		return true;
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

	public void setCaretHint(CaretHint caretHint) {
		this.caretHint = caretHint;
	}

}

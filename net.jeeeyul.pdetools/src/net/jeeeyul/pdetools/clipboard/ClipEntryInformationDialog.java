package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.clipboard.internal.OpenJavaElementFunction;
import net.jeeeyul.pdetools.clipboard.internal.OpenResourceFunction;
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;
import net.jeeeyul.pdetools.shared.KRectangle;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.progress.UIJob;

public class ClipEntryInformationDialog implements ISelectionChangedListener {
	private Shell parentShell;
	private ISelectionProvider selectionProvider;
	private Shell shell;
	private Browser browser;
	private ClipEntryInformationGenerator infoGenerator = new ClipEntryInformationGenerator();

	private UIJob openJob;
	private ClipboardEntry entry;

	public ClipEntryInformationDialog(Shell parentShell, ISelectionProvider selectionProvider) {
		super();
		this.parentShell = parentShell;
		this.selectionProvider = selectionProvider;
		parentShell.addListener(SWT.Resize, new Listener() {
			@Override
			public void handleEvent(Event event) {
				allocateShellBounds();
			}
		});
		selectionProvider.addSelectionChangedListener(this);

		openJob = new UIJob("Open Information") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				doOpen();
				return Status.OK_STATUS;
			}
		};
		openJob.setSystem(true);
		open();

	}

	private void create() {
		if (shell != null && !shell.isDisposed()) {
			return;
		}
		shell = new Shell(parentShell, SWT.ON_TOP | SWT.RESIZE);
		shell.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setLayout(new FillLayout());
		browser = new Browser(shell, SWT.NORMAL);
		new OpenJavaElementFunction(browser);
		new OpenResourceFunction(browser);
	}

	private void allocateShellBounds() {
		if (shell == null || shell.isDisposed()) {
			return;
		}

		KRectangle monitor = new KRectangle(parentShell.getMonitor().getClientArea());
		KRectangle parentBounds = new KRectangle(parentShell.getBounds());
		KRectangle newBounds = parentBounds.translate(parentBounds.width, 0);
		if (!monitor.contains(newBounds.getRight())) {
			newBounds.translate(parentBounds.width * -2, 0);
		}
		shell.setBounds(newBounds.toRectangle());
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		open();
	}

	private void open() {
		if (shell == null || shell.isDisposed()) {
			create();
			allocateShellBounds();
		}
		openJob.schedule(300);
	}

	private void doOpen() {
		if (parentShell == null || parentShell.isDisposed()) {
			return;
		}

		ClipboardEntry newEntry = (ClipboardEntry) ((IStructuredSelection) selectionProvider.getSelection())
				.getFirstElement();
		if (newEntry == entry) {
			return;
		}

		if (shell == null || shell.isDisposed()) {
			create();
		}
		allocateShellBounds();

		entry = newEntry;
		browser.setText(infoGenerator.generate(entry).toString());
		shell.setVisible(true);
	}

	public Shell getShell() {
		if (shell == null || shell.isDisposed()) {
			create();
		}
		return shell;
	}

}

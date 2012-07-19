package net.jeeeyul.pdetools.clipboard;

import net.jeeeyul.pdetools.Activator;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

public class PasteDialog extends Dialog {
	private ClipboardViewer clipboardViewer;

	private ClipboardEntry result;

	private CaretHint referencePoint;

	protected PasteDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.RESIZE | SWT.ON_TOP);
	}

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		String sectionName = getClass().getCanonicalName();
		IDialogSettings section = Activator.getDefault().getDialogSettings().getSection(sectionName);
		if (section == null) {
			section = Activator.getDefault().getDialogSettings().addNewSection(sectionName);
		}
		return section;
	}

	@Override
	public void create() {
		super.create();
		getShell().addListener(SWT.Deactivate, new Listener() {
			@Override
			public void handleEvent(Event event) {
				setReturnCode(IDialogConstants.CANCEL_ID);
				setResult(null);
				close();
			}
		});

		getShell().addListener(SWT.Traverse, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (event.detail == SWT.TRAVERSE_RETURN) {
					if (result != null) {
						close();
					}
				}
			}
		});
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		GridData data = (GridData) buttonBar.getLayoutData();
		data.exclude = true;
		return buttonBar;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite) super.createDialogArea(parent);
		GridLayout layout = (GridLayout) comp.getLayout();
		layout.marginWidth = layout.marginHeight = 0;
		layout.verticalSpacing = 0;

		clipboardViewer = new ClipboardViewer(comp, SWT.NORMAL);
		Table table = clipboardViewer.getTableViewer().getTable();

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 400;
		gridData.heightHint = 300;
		table.setLayoutData(gridData);

		clipboardViewer.getTableViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				handleSelection();
			}
		});

		clipboardViewer.getTableViewer().addOpenListener(new IOpenListener() {
			@Override
			public void open(OpenEvent event) {
				handleSelection();
				if (getButton(OK).isEnabled()) {
					close();
				}
			}
		});

		Label separator = new Label(comp, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite header = new Composite(comp, SWT.NORMAL);
		header.setLayout(new GridLayout());

		Button pushButton = new Button(header, SWT.CHECK);
		pushButton.setText("Move selected contents to first");

		return comp;

	}

	public ClipboardEntry getResult() {
		return result;
	}

	private void selectFirstItem() {
		TableViewer tableViewer = clipboardViewer.getTableViewer();
		tableViewer.getTable().setFocus();
		if (ClipboardService.getInstance().getHistory().getEntries().size() > 0) {
			tableViewer.setSelection(new StructuredSelection(ClipboardService.getInstance().getHistory().getEntries()
					.get(0)));
		}
	}

	@Override
	public int open() {
		getParentShell().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				selectFirstItem();
			}
		});
		return super.open();
	}

	@Override
	protected Point getInitialLocation(Point initialSize) {
		if (referencePoint != null) {
			return new Point(referencePoint.getX(), referencePoint.getY() + referencePoint.getHeight());
		} else
			return super.getInitialLocation(initialSize);
	}

	protected void handleSelection() {
		IStructuredSelection selection = (IStructuredSelection) clipboardViewer.getTableViewer().getSelection();
		setResult((ClipboardEntry) selection.getFirstElement());
	}

	private void setResult(ClipboardEntry result) {
		this.result = result;
		getButton(OK).setEnabled(result != null);
	}

	public void setReferencePoint(CaretHint referencePoint) {
		this.referencePoint = referencePoint;
	}

}

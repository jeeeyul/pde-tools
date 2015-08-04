package net.jeeeyul.pdetools.shared;

import net.jeeeyul.pdetools.PDEToolsCore;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IconAndMessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ConfirmDialog extends IconAndMessageDialog {

	private IPreferenceStore store;
	private String doNotAskPreferenceKey;
	private String title = "Confirm Required";

	private Button doNotAskButton;

	public ConfirmDialog(IPreferenceStore store, String doNotAskPreferenceKey, Shell parentShell) {
		super(parentShell);
		this.store = store;
		this.doNotAskPreferenceKey = doNotAskPreferenceKey;
	}

	public ConfirmDialog(String doNotAskPreferenceKey) {
		this(PDEToolsCore.getDefault().getPreferenceStore(), doNotAskPreferenceKey, Display.getDefault()
				.getActiveShell());
	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		if (title != null && shell != null && !shell.isDisposed()) {
			shell.setText(title);
		}
	}

	@Override
	protected void buttonPressed(int buttonId) {
		setReturnCode(buttonId);
		if (buttonId == IDialogConstants.YES_ID) {
			store.setValue(doNotAskPreferenceKey, doNotAskButton.getSelection());
		}
		close();
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.YES_ID, IDialogConstants.YES_LABEL, true);
		createButton(parent, IDialogConstants.NO_ID, IDialogConstants.NO_LABEL, false);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		composite.setLayout(new GridLayout(2, false));
		createMessageArea(composite);

		doNotAskButton = new Button(composite, SWT.CHECK);
		doNotAskButton.setText("Do not ask again.");
		doNotAskButton.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 2, 1));
		return composite;
	}

	@Override
	protected Image getImage() {
		return getShell().getDisplay().getSystemImage(SWT.ICON_QUESTION);
	}

	public String getMessage() {
		return message;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int open() {
		if (store.getBoolean(doNotAskPreferenceKey)) {
			return IDialogConstants.YES_ID;
		} else {
			return super.open();
		}
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

package net.jeeeyul.pdetools.clipboard.internal;

import net.jeeeyul.pdetools.model.pdetools.ClipHistory;
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;

public class SetActiveEntryConmand extends SetCommand {
	private ClipboardEntry oldEntry;
	private ClipHistory history;
	private ClipboardEntry entry;

	public SetActiveEntryConmand(ClipboardEntry entry) {
		super(AdapterFactoryEditingDomain.getEditingDomainFor(entry), entry.getParent(), PdetoolsPackage.eINSTANCE
				.getClipHistory_ActiveEntry(), entry);
		this.entry = entry;
		history = entry.getParent();
		setLabel("Change active content");
	}

	private void applyActiveCliboard(final ClipboardEntry entry) {
		if (entry == null) {
			return;
		}

		if (Display.getCurrent() == null) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					applyActiveCliboard(entry);
				}
			});
		}

		Clipboard clipboard = new Clipboard(Display.getDefault());
		entry.transferTo(clipboard);
		clipboard.dispose();
	}

	@Override
	public void doExecute() {
		oldEntry = history.getActiveEntry();
		super.doExecute();
		applyActiveCliboard(entry);
	}

	@Override
	public void doRedo() {
		super.doRedo();
		applyActiveCliboard(entry);
	}

	@Override
	public void doUndo() {
		super.doUndo();
		applyActiveCliboard(oldEntry);
	}
}

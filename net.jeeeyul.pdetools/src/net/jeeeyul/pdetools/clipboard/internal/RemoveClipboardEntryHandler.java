package net.jeeeyul.pdetools.clipboard.internal;

import java.util.ArrayList;
import java.util.List;

import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class RemoveClipboardEntryHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (!(currentSelection instanceof IStructuredSelection)) {
			return null;
		}

		List<ClipboardEntry> entriesToRemove = new ArrayList<ClipboardEntry>();
		for (Object each : ((IStructuredSelection) currentSelection).toArray()) {
			if (!(each instanceof ClipboardEntry)) {
				continue;
			}
			ClipboardEntry entry = (ClipboardEntry) each;
			entriesToRemove.add(entry);
		}

		if (entriesToRemove.size() == 0) {
			return null;
		}
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(entriesToRemove.get(0));
		RemoveCommand command = new RemoveCommand(domain, ClipboardServiceImpl.getInstance().getHistory(),
				PdetoolsPackage.eINSTANCE.getClipHistory_Entries(), entriesToRemove);
		command.setLabel("Remove Selected Clipobard Items");
		domain.getCommandStack().execute(command);

		return null;
	}

}

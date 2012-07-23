package net.jeeeyul.pdetools.shared;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class AdapterStub implements Adapter {

	private Notifier newTarget;

	@Override
	public void notifyChanged(Notification notification) {

	}

	@Override
	public Notifier getTarget() {
		return newTarget;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		this.newTarget = newTarget;

	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}

}

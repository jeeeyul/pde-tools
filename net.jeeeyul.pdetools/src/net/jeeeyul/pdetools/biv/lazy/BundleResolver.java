package net.jeeeyul.pdetools.biv.lazy;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osgi.framework.Bundle;

public class BundleResolver {
	private class ResolvingJob extends Job {
		public ResolvingJob() {
			super("Resolving Bundle Images");
			setSystem(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			doResolve();
			return Status.OK_STATUS;
		}
	}

	private ILock lock = Job.getJobManager().newLock();

	private Procedure1<BundleEntry> resolvingHandler;

	private ResolvingJob resolvingJob = new ResolvingJob();

	private List<BundleEntry> queue = new ArrayList<BundleEntry>();

	public void add(BundleEntry bundleEntry) {
		lock.acquire();
		queue.add(bundleEntry);
		lock.release();
		resolvingJob.schedule();
	}

	private void doResolve() {
		lock.acquire();
		BundleEntry[] array = queue.toArray(new BundleEntry[queue.size()]);
		queue.clear();
		lock.release();

		for (BundleEntry each : array) {
			resoveBundleEntry(each);
		}
	}

	public Procedure1<BundleEntry> getResolvingHandler() {
		return resolvingHandler;
	}

	private void resoveBundleEntry(BundleEntry bundleEntry) {
		ArrayList<URLImageEntry> result = new ArrayList<URLImageEntry>();

		Bundle bundle = bundleEntry.getBundle();
		Enumeration<URL> iter = bundle.findEntries("/", "*.gif", true);
		while (iter != null && iter.hasMoreElements()) {
			result.add(new URLImageEntry(bundleEntry, iter.nextElement()));
		}

		iter = bundle.findEntries("/", "*.png", true);
		while (iter != null && iter.hasMoreElements()) {
			result.add(new URLImageEntry(bundleEntry, iter.nextElement()));
		}

		iter = bundle.findEntries("/", "*.bmp", true);
		while (iter != null && iter.hasMoreElements()) {
			result.add(new URLImageEntry(bundleEntry, iter.nextElement()));
		}

		iter = bundle.findEntries("/", "*.jpg", true);
		while (iter != null && iter.hasMoreElements()) {
			result.add(new URLImageEntry(bundleEntry, iter.nextElement()));
		}

		Collections.sort(result, new Comparator<URLImageEntry>() {
			@Override
			public int compare(URLImageEntry o1, URLImageEntry o2) {
				return o1.getUrl().toExternalForm().compareTo(o2.getUrl().toExternalForm());
			}
		});

		bundleEntry.setEntries(result);
		bundleEntry.setState(BundleEntry.RESOLVED);

		if (resolvingHandler != null) {
			resolvingHandler.apply(bundleEntry);
		}
	}

	public void setResolvingHandler(Procedure1<BundleEntry> resolvingHandler) {
		this.resolvingHandler = resolvingHandler;
	}
}

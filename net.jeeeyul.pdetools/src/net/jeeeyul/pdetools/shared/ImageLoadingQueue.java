package net.jeeeyul.pdetools.shared;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jeeeyul
 * 
 */
public class ImageLoadingQueue<KeyType> extends Job {
	private List<KeyType> queue = new LinkedList<KeyType>();
	private ILock lock = Job.getJobManager().newLock();
	private Procedure1<List<ImageLoadingEntry<KeyType>>> loadHandler;
	private Function1<KeyType, ImageData> imageLoader;

	public ImageLoadingQueue() {
		super("Icon Previewing");
		setSystem(true);
	}

	public void add(KeyType file) {
		lock.acquire();
		try {
			if (!queue.contains(file))
				queue.add(file);
		} finally {
			lock.release();
		}
		schedule(10);
	}

	public Function1<KeyType, ImageData> getImageLoader() {
		return imageLoader;
	}

	public Procedure1<List<ImageLoadingEntry<KeyType>>> getLoadHandler() {
		return loadHandler;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		List<KeyType> keys = null;
		lock.acquire();
		try {
			keys = new ArrayList<KeyType>(queue);
			queue.clear();
		} finally {
			lock.release();
		}

		ArrayList<ImageLoadingEntry<KeyType>> result = new ArrayList<ImageLoadingEntry<KeyType>>();

		monitor.beginTask("Load image", keys.size());
		for (KeyType each : keys) {
			try {
				ImageData imageData = imageLoader.apply(each);
				result.add(new ImageLoadingEntry<KeyType>(each, imageData));
			} catch (Exception e) {
				e.printStackTrace();
				result.add(new ImageLoadingEntry<KeyType>(each, null));
			}
		}

		if (loadHandler != null) {
			loadHandler.apply(result);
		}
		return Status.OK_STATUS;
	}

	public void setImageLoader(Function1<KeyType, ImageData> imageLoader) {
		this.imageLoader = imageLoader;
	}

	public void setLoadHandler(Procedure1<List<ImageLoadingEntry<KeyType>>> loadHandler) {
		this.loadHandler = loadHandler;
	}
}

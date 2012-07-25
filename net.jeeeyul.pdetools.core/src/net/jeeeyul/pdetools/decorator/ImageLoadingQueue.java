package net.jeeeyul.pdetools.decorator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
/**
 * @author Jeeeyul
 *
 */
public class ImageLoadingQueue extends Job {
	private List<IFile> queue = new LinkedList<IFile>();
	private ILock lock = Job.getJobManager().newLock();
	private Procedure1<List<ImageDataEntry>> loadHandler;

	public ImageLoadingQueue() {
		super("Icon Previewing");
		setSystem(true);
	}

	public void add(IFile file) {
		lock.acquire();
		try {
			if (!queue.contains(file))
				queue.add(file);
		} finally {
			lock.release();
		}
		schedule(10);
	}

	public Procedure1<List<ImageDataEntry>> getLoadHandler() {
		return loadHandler;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		List<IFile> files = null;
		lock.acquire();
		try {
			files = new ArrayList<IFile>(queue);
			queue.clear();
		} finally {
			lock.release();
		}

		ArrayList<ImageDataEntry> result = new ArrayList<ImageDataEntry>();

		monitor.beginTask("Load image", files.size());
		for (IFile each : files) {
			try {
				Job.getJobManager().beginRule(each, new NullProgressMonitor());
				InputStream contents = each.getContents();
				ImageData imageData = new ImageData(contents);
				contents.close();

				if (imageData.width * imageData.height > 4096) {
					result.add(new ImageDataEntry(each, null));
				} else {
					result.add(new ImageDataEntry(each, imageData));
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.add(new ImageDataEntry(each, null));
			}finally{
				Job.getJobManager().endRule(each);
			}
		}

		if (loadHandler != null) {
			loadHandler.apply(result);
		}
		return Status.OK_STATUS;
	}

	public void setLoadHandler(Procedure1<List<ImageDataEntry>> loadHandler) {
		this.loadHandler = loadHandler;
	}
}

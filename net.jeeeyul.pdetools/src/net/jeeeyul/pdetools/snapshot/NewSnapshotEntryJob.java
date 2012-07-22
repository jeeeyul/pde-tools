package net.jeeeyul.pdetools.snapshot;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotFactory;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

public class NewSnapshotEntryJob extends Job implements ISchedulingRule {

	private ImageData imageData;

	public NewSnapshotEntryJob(ImageData imageData) {
		super("Create a new snapshot");
		this.imageData = imageData;
		setSystem(true);
		setRule(this);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			String location = SnapshotCore.getRepository().getRepositoryLocation();
			File folder = new File(location);
			File file = new File(folder, System.currentTimeMillis() + ".png");

			ImageLoader imageLoader = new ImageLoader();
			imageLoader.data = new ImageData[] { imageData };
			FileOutputStream fos = new FileOutputStream(file);
			imageLoader.save(fos, SWT.IMAGE_PNG);
			fos.close();

			SnapshotEntry entry = SnapshotFactory.eINSTANCE.createSnapshotEntry();
			entry.setTakenTime(new Date());
			entry.setFileName(file.getName());

		} catch (Exception e) {

		}

		return Status.OK_STATUS;
	}

	private SnapshotGroup computeTargetGroup() {
		SnapshotGroup result = null;

		SnapshotRepository repository = SnapshotCore.getRepository();
		if (repository.getGroups().size() > 0) {
			SnapshotGroup head = repository.getGroups().get(0);

		}

		return result;
	}

	@Override
	public boolean contains(ISchedulingRule rule) {
		return rule == this;
	}

	@Override
	public boolean isConflicting(ISchedulingRule rule) {
		if (rule == this) {
			return false;
		} else if (rule instanceof NewSnapshotEntryJob) {
			return true;
		}
		return false;
	}

}

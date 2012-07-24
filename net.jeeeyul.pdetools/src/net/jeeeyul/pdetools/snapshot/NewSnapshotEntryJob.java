package net.jeeeyul.pdetools.snapshot;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import net.jeeeyul.pdetools.snapshot.model.snapshot.ShellInfo;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotFactory;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

public class NewSnapshotEntryJob extends Job implements ISchedulingRule {

	private ImageData imageData;
	private String controlType;
	private ShellInfo shellInfo;

	public NewSnapshotEntryJob(ImageData imageData) {
		super("Create a new snapshot");
		this.imageData = imageData;
		setSystem(true);
		setRule(this);
	}

	@Override
	public boolean belongsTo(Object family) {
		return family == SnapshotCore.getRepository();
	}

	private SnapshotGroup computeTargetGroup() {
		SnapshotGroup result = null;

		SnapshotRepository repository = SnapshotCore.getRepository();
		long lengthOfDay = 24 * 60 * 60 * 1000;

		long now = System.currentTimeMillis();
		int startTimeOffset = 9 * 60 * 60 * 1000;

		if (repository.getGroups().size() > 0) {
			SnapshotGroup head = repository.getGroups().get(0);

			long offset = now - (now % lengthOfDay) - startTimeOffset;
			if (head.getDate().getTime() == offset) {
				return head;
			}
		}

		result = SnapshotFactory.eINSTANCE.createSnapshotGroup();
		result.setDate(new Date(now - (now % lengthOfDay) - startTimeOffset));
		SnapshotCore.getRepository().getGroups().add(0, result);

		return result;
	}

	@Override
	public boolean contains(ISchedulingRule rule) {
		return rule == this;
	}

	public String getControlType() {
		return controlType;
	}

	public ShellInfo getShellInfo() {
		return shellInfo;
	}

	@Override
	public boolean isConflicting(ISchedulingRule rule) {
		if (rule instanceof NewSnapshotEntryJob) {
			return true;
		}
		return false;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			String location = SnapshotCore.getRepository().getRepositoryLocation();
			IPath path = new Path(location);
			path = path.removeLastSegments(1).append("F" + System.currentTimeMillis() + ".png");
			path = path.setDevice(null);
			File file = path.toFile();

			ImageLoader imageLoader = new ImageLoader();
			imageLoader.data = new ImageData[] { imageData };
			FileOutputStream fos = new FileOutputStream(file);
			imageLoader.save(fos, SWT.IMAGE_PNG);
			fos.close();

			SnapshotEntry entry = SnapshotFactory.eINSTANCE.createSnapshotEntry();
			entry.setTakenTime(new Date());
			entry.setOriginalFile(file.getName());

			computeTargetGroup().getEntries().add(0, entry);

			Job[] family = Job.getJobManager().find(SnapshotCore.getRepository());
			System.out.println(family.length);

			if (family.length == 1) {
				SnapshotCore.doSave();
				System.out.println("ºº¿Ã∫Í");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Status.OK_STATUS;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public void setShellInfo(ShellInfo shellInfo) {
		this.shellInfo = shellInfo;
	}

}

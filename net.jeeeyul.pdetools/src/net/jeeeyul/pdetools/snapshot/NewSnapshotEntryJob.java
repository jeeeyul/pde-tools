package net.jeeeyul.pdetools.snapshot;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;
import net.jeeeyul.pdetools.model.pdetools.ShellInfo;
import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry;
import net.jeeeyul.pdetools.model.pdetools.SnapshotGroup;
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository;
import net.jeeeyul.pdetools.snapshot.editor.ShellFrame;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;

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

	private SnapshotGroup computeTargetGroup(CompoundCommand command) {
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

		result = PdetoolsFactory.eINSTANCE.createSnapshotGroup();
		result.setDate(new Date(now - (now % lengthOfDay) - startTimeOffset));

		EditingDomain domain = SnapshotCore.getEditingDomain();
		Command addGroupCommand = AddCommand.create(domain, SnapshotCore.getRepository(),
				PdetoolsPackage.eINSTANCE.getSnapshotRepository_Groups(), result, 0);

		command.append(addGroupCommand);

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
			String location = SnapshotCore.getRepository().eResource().getURI().toFileString();
			IPath path = new Path(location);
			String newFileName = generateNewFileName();

			path = path.removeLastSegments(1).append(newFileName);
			path = path.setDevice(null);
			File file = path.toFile();
			System.out.println(file);

			if (shellInfo != null) {
				Rectangle area = new Rectangle(21, 42, 395, 389);
				ImageData data = new ImageData(ShellFrame.class.getResourceAsStream("win7-aero.png"));
				ShellFrame frame = new ShellFrame(data, area);
				imageData = frame.decorate(imageData);
			}

			ImageLoader imageLoader = new ImageLoader();
			imageLoader.data = new ImageData[] { imageData };

			FileOutputStream fos = new FileOutputStream(file);
			imageLoader.save(fos, SWT.IMAGE_PNG);
			fos.close();

			SnapshotEntry entry = PdetoolsFactory.eINSTANCE.createSnapshotEntry();
			entry.setTakenTime(new Date());
			entry.setOriginalFile(file.getName());
			entry.setControlType(controlType);
			System.out.println(file.getName());

			CompoundCommand command = new CompoundCommand("New Snapshot");
			SnapshotGroup targetGroup = computeTargetGroup(command);

			EditingDomain domain = SnapshotCore.getEditingDomain();
			command.append(AddCommand.create(domain, targetGroup, PdetoolsPackage.eINSTANCE.getSnapshotGroup_Entries(),
					entry));
			domain.getCommandStack().execute(command);

			Job[] family = Job.getJobManager().find(SnapshotCore.getRepository());

			if (family.length == 1) {
				SnapshotCore.save();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new Status(IStatus.ERROR, PDEToolsCore.PLUGIN_ID, e.getLocalizedMessage(), e);
		}

		return Status.OK_STATUS;
	}

	private String generateNewFileName() {
		String prefix = null;
		int lastPeriod = controlType.lastIndexOf(".");
		prefix = controlType.substring(lastPeriod + 1);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		prefix += "_" + format.format(new Date());

		return prefix + ".png";
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public void setShellInfo(ShellInfo shellInfo) {
		this.shellInfo = shellInfo;
	}

}

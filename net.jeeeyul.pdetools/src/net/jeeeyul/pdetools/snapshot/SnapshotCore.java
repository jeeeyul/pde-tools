package net.jeeeyul.pdetools.snapshot;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory;
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class SnapshotCore {
	private static SnapshotRepository repository;

	private static SnapshotRepository doLoad() throws IOException {
		URI url = getPersistanceURI();
		BinaryResourceImpl resource = new BinaryResourceImpl(url);
		resource.load(new HashMap<Object, Object>());
		return (SnapshotRepository) resource.getContents().get(0);
	}

	private static URI getPersistanceURI() {
		IPath path = PDEToolsCore.getDefault().getStateLocation().append("snapshot");
		File folder = path.setDevice(null).toFile();
		if (!folder.exists()) {
			folder.mkdirs();
		}

		URI url = URI.createFileURI(path.append("snapshot.data").toPortableString());
		return url;
	}

	public static SnapshotRepository getRepository() {
		if (repository == null) {
			if (new File(getPersistanceURI().toFileString()).exists()) {
				try {
					repository = doLoad();
				} catch (Exception e) {
					repository = PdetoolsFactory.eINSTANCE.createSnapshotRepository();
				}
			} else {
				repository = PdetoolsFactory.eINSTANCE.createSnapshotRepository();
			}
			repository.setRepositoryLocation(getPersistanceURI().toFileString());
		}
		return repository;
	}

	public static void doSave() {
		BinaryResourceImpl resource = new BinaryResourceImpl(getPersistanceURI());
		resource.getContents().add(EcoreUtil.copy(getRepository()));
		try {
			resource.save(new HashMap<Object, Object>());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

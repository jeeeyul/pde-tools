package net.jeeeyul.pdetools.snapshot;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotFactory;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

public class SnapshotCore {
	private static SnapshotRepository repository;

	private static SnapshotRepository doLoad() throws IOException {
		URI url = getPersistanceURI();
		XMLResource resource = new XMLResourceImpl(url);
		resource.load(new HashMap<Object, Object>());
		return (SnapshotRepository) resource.getContents().get(0);
	}

	private static URI getPersistanceURI() {
		IPath path = PDEToolsCore.getDefault().getStateLocation().append("snapshot");
		File folder = path.setDevice(null).toFile();
		if (!folder.exists()) {
			folder.mkdirs();
		}

		URI url = URI.createFileURI(path.append("snapshot.xml").toPortableString());
		return url;
	}

	public static SnapshotRepository getRepository() {
		if (repository == null) {
			if (new File(getPersistanceURI().toFileString()).exists()) {
				try {
					repository = doLoad();
				} catch (Exception e) {
					repository = SnapshotFactory.eINSTANCE.createSnapshotRepository();
				}
			} else {
				repository = SnapshotFactory.eINSTANCE.createSnapshotRepository();
			}
			repository.setRepositoryLocation(getPersistanceURI().toString());
		}
		return repository;
	}

	public static void doSave() {
		XMLResource resource = new XMLResourceImpl(getPersistanceURI());
		resource.getContents().add(EcoreUtil.copy(getRepository()));
		try {
			resource.save(new HashMap<Object, Object>());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

package net.jeeeyul.pdetools.snapshot;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import net.jeeeyul.pdetools.Debug;
import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.clipboard.internal.BinaryResourceFactory;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory;
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository;
import net.jeeeyul.pdetools.model.pdetools.provider.PdetoolsItemProviderAdapterFactory;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

public class SnapshotCore {
	private static SnapshotRepository repository;

	private static AdapterFactoryEditingDomain editingDomain;

	public static void clean() {
		new CleanRepository().run();
	}

	public static synchronized AdapterFactoryEditingDomain getEditingDomain() {
		if (editingDomain == null) {
			editingDomain = new AdapterFactoryEditingDomain(new PdetoolsItemProviderAdapterFactory(),
					new BasicCommandStack());
			editingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put("data", new BinaryResourceFactory());
		}
		return editingDomain;
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
			Resource resource = getResource();
			try {
				resource.load(new HashMap<Object, Object>());
				repository = (SnapshotRepository) resource.getContents().get(0);
				Debug.println("Snapshot repository was loaded.");
			} catch (Exception e) {
				repository = PdetoolsFactory.eINSTANCE.createSnapshotRepository();
				resource.getContents().clear();
				resource.getContents().add(repository);
				Debug.println("Snapshot repository was created.");
			}
		}
		return repository;
	}

	private static Resource getResource() {
		Resource resource = null;
		try {
			resource = getResourceSet().getResource(getPersistanceURI(), true);
		} catch (Exception e) {
			resource = getResourceSet().createResource(getPersistanceURI());
			Debug.println("New resource for snapshot repository was created.");
		}
		return resource;
	}

	private static ResourceSet getResourceSet() {
		return getEditingDomain().getResourceSet();
	}

	public static void save() {
		try {
			getResource().save(new HashMap<Object, Object>());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

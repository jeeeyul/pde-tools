package net.jeeeyul.pdetools.snapshot;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

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

	private static URI getPersistanceURI() {
		IPath path = PDEToolsCore.getDefault().getStateLocation().append("snapshot");
		File folder = path.setDevice(null).toFile();
		if (!folder.exists()) {
			folder.mkdirs();
		}

		URI url = URI.createFileURI(path.append("snapshot.data").toPortableString());
		return url;
	}

	private static AdapterFactoryEditingDomain editingDomain;

	private static AdapterFactoryEditingDomain getEditingDomain() {
		if (editingDomain == null) {
			editingDomain = new AdapterFactoryEditingDomain(new PdetoolsItemProviderAdapterFactory(),
					new BasicCommandStack());
			editingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put("data", new BinaryResourceFactory());
		}
		return editingDomain;
	}

	private static ResourceSet getResourceSet() {
		return getEditingDomain().getResourceSet();
	}

	private static Resource getResource() {
		Resource resource = null;
		try {
			resource = getResourceSet().getResource(getPersistanceURI(), true);
		} catch (Exception e) {
			resource = getResourceSet().createResource(getPersistanceURI());
			System.out.println("신규 리소스 작성");
		}
		return resource;
	}

	public static SnapshotRepository getRepository() {
		if (repository == null) {
			Resource resource = getResource();
			try {
				resource.load(new HashMap<Object, Object>());
				repository = (SnapshotRepository) resource.getContents().get(0);
				System.out.println("스냅샷 리포지터리 로드 됨");
			} catch (Exception e) {
				e.printStackTrace();
				repository = PdetoolsFactory.eINSTANCE.createSnapshotRepository();
				resource.getContents().clear();
				resource.getContents().add(repository);
				System.out.println("스냅샷 리포지터리 새로 생성");

			}
		}
		return repository;
	}

	public static void doSave() {
		try {
			getResource().save(new HashMap<Object, Object>());
			System.out.println("스냅샷 리포지터리 저장됨");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

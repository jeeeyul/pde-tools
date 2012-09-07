package net.jeeeyul.pdetools.biv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.jeeeyul.pdetools.PDEToolsCore;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.nebula.jface.galleryviewer.GalleryTreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;

public class DragImageSupport implements DragSourceListener {
	private GalleryTreeViewer viewer;

	private ArrayList<File> files = new ArrayList<File>();

	public DragImageSupport(GalleryTreeViewer viewer) {
		super();
		this.viewer = viewer;
		DragSource dragSource = new DragSource(viewer.getControl(), DND.DROP_COPY);
		dragSource.setTransfer(new Transfer[] { FileTransfer.getInstance() });
		dragSource.addDragListener(this);
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		for (File each : files) {
			each.deleteOnExit();
		}
		files.clear();
		tempFolder = null;
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		List<URL> selection = getSelection();
		List<String> result = new ArrayList<String>();
		for (URL each : selection) {
			File file = prepareFile(each);
			if (file != null) {
				files.add(file);
				result.add(file.getAbsolutePath());
			}
		}
		event.data = result.toArray(new String[result.size()]);
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		event.doit = !getSelection().isEmpty();
		if (event.doit) {
			event.detail = DND.DROP_COPY;
		}
	}

	@SuppressWarnings("unchecked")
	private List<URL> getSelection() {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		return new ArrayList<URL>(selection.toList());
	}

	private File prepareFile(URL url) {
		try {
			IPath path = new Path(url.toExternalForm());
			String fileExtension = path.getFileExtension();
			String fileName = path.removeFileExtension().lastSegment();

			File file = new File(getTempFolder(), fileName + "." + fileExtension);

			int index = 2;
			while (file.exists()) {
				file = new File(getTempFolder(), fileName + " " + index + "." + fileExtension);
				index++;
			}
			file.deleteOnExit();

			FileOutputStream fos = new FileOutputStream(file);
			InputStream is = url.openStream();

			byte[] buf = new byte[1024];
			int len = -1;

			while ((len = is.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			is.close();
			fos.close();

			return file;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private File tempFolder;

	public File getTempFolder() {
		if (tempFolder == null) {
			File stateFolder = new File(PDEToolsCore.getDefault().getStateLocation().toOSString());
			tempFolder = new File(stateFolder, "image-crawl-temp");
			if (tempFolder.exists()) {
				for (File file : tempFolder.listFiles()) {
					file.delete();
				}
				tempFolder.delete();
			}
			tempFolder.mkdir();
			System.out.println(tempFolder + " was created.");
		}
		return tempFolder;
	}
}

package net.jeeeyul.pdetools.snapshot;

import com.google.common.collect.Iterators;
import java.io.File;
import java.util.Iterator;
import net.jeeeyul.pdetools.shared.SharedImages;
import net.jeeeyul.pdetools.snapshot.SnapshotAction;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class RemoveAllAction extends SnapshotAction {
  public RemoveAllAction(final SnapshotRepository repository) {
    super(repository);
    this.setText("Remove All Items");
    ImageDescriptor _imageDescriptor = SharedImages.getImageDescriptor(SharedImages.DELETE_ALL);
    this.setImageDescriptor(_imageDescriptor);
  }
  
  public void run() {
    SnapshotRepository _repository = this.getRepository();
    String _repositoryLocation = _repository.getRepositoryLocation();
    Path _path = new Path(_repositoryLocation);
    IPath _removeLastSegments = _path.removeLastSegments(1);
    IPath basePath = _removeLastSegments.setDevice(null);
    SnapshotRepository _repository_1 = this.getRepository();
    TreeIterator<EObject> _eAllContents = _repository_1.eAllContents();
    Iterator<SnapshotEntry> _filter = Iterators.<SnapshotEntry>filter(_eAllContents, SnapshotEntry.class);
    Iterable<SnapshotEntry> entries = IteratorExtensions.<SnapshotEntry>toIterable(_filter);
    for (final SnapshotEntry each : entries) {
      {
        String _fileName = each.getFileName();
        IPath _append = basePath.append(_fileName);
        File eachFile = _append.toFile();
        boolean _exists = eachFile.exists();
        if (_exists) {
          try {
            eachFile.delete();
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              eachFile.deleteOnExit();
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    }
    SnapshotRepository _repository_2 = this.getRepository();
    EList<SnapshotGroup> _groups = _repository_2.getGroups();
    _groups.clear();
  }
  
  public void update() {
    SnapshotRepository _repository = this.getRepository();
    EList<SnapshotGroup> _groups = _repository.getGroups();
    boolean _isEmpty = _groups.isEmpty();
    boolean _not = (!_isEmpty);
    this.setEnabled(_not);
  }
}

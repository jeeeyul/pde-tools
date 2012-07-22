package net.jeeeyul.pdetools.snapshot;

import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class SnapshotContentProvider implements ITreeContentProvider {
  public Object[] getChildren(final Object parentElement) {
    return null;
  }
  
  public Object[] getElements(final Object inputElement) {
    EList<SnapshotGroup> _groups = ((SnapshotRepository) inputElement).getGroups();
    return ((Object[])Conversions.unwrapArray(_groups, Object.class));
  }
  
  public Object getParent(final Object element) {
    return ((EObject) element).eContainer();
  }
  
  public boolean hasChildren(final Object element) {
    return (element instanceof SnapshotGroup);
  }
  
  public void dispose() {
  }
  
  public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
  }
}

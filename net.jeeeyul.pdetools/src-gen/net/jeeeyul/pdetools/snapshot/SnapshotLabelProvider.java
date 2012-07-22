package net.jeeeyul.pdetools.snapshot;

import java.util.Arrays;
import java.util.Date;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import org.eclipse.jface.viewers.LabelProvider;

@SuppressWarnings("all")
public class SnapshotLabelProvider extends LabelProvider {
  protected String _getText(final Object element) {
    return "Unknown";
  }
  
  protected String _getText(final SnapshotGroup group) {
    Date _date = group.getDate();
    String _string = _date.toString();
    return _string;
  }
  
  protected String _getText(final SnapshotEntry entry) {
    String _fileName = entry.getFileName();
    return _fileName;
  }
  
  public String getText(final Object entry) {
    if (entry instanceof SnapshotEntry) {
      return _getText((SnapshotEntry)entry);
    } else if (entry instanceof SnapshotGroup) {
      return _getText((SnapshotGroup)entry);
    } else if (entry != null) {
      return _getText(entry);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entry).toString());
    }
  }
}

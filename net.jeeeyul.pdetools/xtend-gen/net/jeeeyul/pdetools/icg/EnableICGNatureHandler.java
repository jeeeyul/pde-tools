package net.jeeeyul.pdetools.icg;

import com.google.common.base.Objects;
import java.util.ArrayList;
import net.jeeeyul.pdetools.icg.ICGConstants;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class EnableICGNatureHandler extends AbstractHandler {
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    try {
      ISelection _currentSelection = HandlerUtil.getCurrentSelection(event);
      boolean _not = (!(_currentSelection instanceof IStructuredSelection));
      if (_not) {
        return null;
      }
      ISelection _currentSelection_1 = HandlerUtil.getCurrentSelection(event);
      IStructuredSelection selection = ((IStructuredSelection) _currentSelection_1);
      Object[] _array = selection.toArray();
      for (final Object each : _array) {
        {
          IAdapterManager _adapterManager = Platform.getAdapterManager();
          Object _adapter = _adapterManager.getAdapter(each, IProject.class);
          IProject project = ((IProject) _adapter);
          boolean _notEquals = (!Objects.equal(project, null));
          if (_notEquals) {
            IProjectDescription description = project.getDescription();
            String[] _natureIds = description.getNatureIds();
            ArrayList<String> natures = CollectionLiterals.<String>newArrayList(_natureIds);
            natures.add(ICGConstants.NATURE_ID);
            final ArrayList<String> _converted_natures = (ArrayList<String>)natures;
            description.setNatureIds(((String[])Conversions.unwrapArray(_converted_natures, String.class)));
            NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
            project.setDescription(description, _nullProgressMonitor);
          }
        }
      }
      return null;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

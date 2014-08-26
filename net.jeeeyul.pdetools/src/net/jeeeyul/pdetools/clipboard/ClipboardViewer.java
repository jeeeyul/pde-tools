package net.jeeeyul.pdetools.clipboard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.jeeeyul.pdetools.PDEToolsCore;
import net.jeeeyul.pdetools.clipboard.internal.ClipboardPreferenceConstants;
import net.jeeeyul.pdetools.clipboard.internal.ClipboardServiceImpl;
import net.jeeeyul.pdetools.clipboard.internal.ComparatorFactory;
import net.jeeeyul.pdetools.clipboard.internal.SharedColor;
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;
import net.jeeeyul.pdetools.shared.ChaindComparator;
import net.jeeeyul.pdetools.shared.UpdateJob;
import net.jeeeyul.swtend.SWTExtensions;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

public class ClipboardViewer {
	private ComparatorFactory comparatorFactory;
	private SharedColor sharedColor;
	private TableViewer viewer;
	private TableViewerColumn column;

	private IPreferenceStore textEditorStore;

	private IPropertyChangeListener preferenceListener = new IPropertyChangeListener() {
		@Override
		public void propertyChange(PropertyChangeEvent event) {
			handlePreferenceChange(event);
		}
	};

	private IPropertyChangeListener editorPreferenceListener = new IPropertyChangeListener() {
		@Override
		public void propertyChange(PropertyChangeEvent event) {
			SWTExtensions.INSTANCE.safeDispose(backgroundColor, foregroundColor);
			backgroundColor = null;
			foregroundColor = null;
			updateColors();
		}
	};

	private EContentAdapter historyListener = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			if (!notification.isTouch())
				handleNotification(notification);
			super.notifyChanged(notification);
		};
	};

	private int style;
	private ClipEntryLabelProvider labelProvider;
	private UpdateJob updateJob = new UpdateJob(new Procedure0() {
		@Override
		public void apply() {
			if (viewer == null || viewer.getControl().isDisposed()) {
				return;
			}
			viewer.refresh();
		}
	});

	private Color backgroundColor;
	private Color foregroundColor;

	public ClipboardViewer(Composite parent, int style) {
		this.style = style;
		comparatorFactory = new ComparatorFactory();

		create(parent);
		parent.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});

		getPreferenceStore().addPropertyChangeListener(preferenceListener);
		getTextEditorStore().addPropertyChangeListener(editorPreferenceListener);
	}

	private Color computeBackgroundColor() {
		if (backgroundColor != null) {
			return backgroundColor;
		}
		IPreferenceStore store = getTextEditorStore();
		boolean useDefault = store.getBoolean(AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT);
		if (useDefault) {
			return Display.getDefault().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		}

		RGB rgb = getRGBFromEditorPreference(store, AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND);
		backgroundColor = new Color(Display.getDefault(), rgb);
		return backgroundColor;
	}

	private Color computeForegroundColor() {
		if (foregroundColor != null) {
			return foregroundColor;
		}
		IPreferenceStore store = getTextEditorStore();
		boolean useDefault = store.getBoolean(AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT);
		if (useDefault) {
			return Display.getDefault().getSystemColor(SWT.COLOR_LIST_FOREGROUND);
		}

		RGB rgb = getRGBFromEditorPreference(store, AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND);
		foregroundColor = new Color(Display.getDefault(), rgb);
		return foregroundColor;
	}

	private void create(Composite parent) {
		sharedColor = new SharedColor(parent.getDisplay());
		viewer = new TableViewer(parent, SWT.VIRTUAL | SWT.FULL_SELECTION | style);
		viewer.setUseHashlookup(true);

		updateColors();

		column = new TableViewerColumn(viewer, SWT.NORMAL);
		labelProvider = new ClipEntryLabelProvider(sharedColor);
		updateLabelProvider();

		column.setLabelProvider(labelProvider);

		/*
		 * prevent drawing ugly focus
		 */
		viewer.getTable().addListener(SWT.EraseItem, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if ((event.detail & SWT.FOCUSED) != 0) {
					event.detail = event.detail ^ SWT.FOCUSED;
				}
			}
		});

		final Listener resizer = new Listener() {
			@Override
			public void handleEvent(Event event) {
				int size = viewer.getTable().getClientArea().width;
				column.getColumn().setWidth(size);
				viewer.getTable().redraw();
			}
		};
		viewer.getTable().addListener(SWT.Resize, resizer);
		viewer.getTable().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				if (viewer.getTable().isDisposed()) {
					return;
				}
				resizer.handleEvent(null);
			}
		});

		viewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public void dispose() {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return ClipboardServiceImpl.getInstance().getHistory().getEntries().toArray();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		});

		updateViewerSorter();

		viewer.setInput(ClipboardServiceImpl.getInstance().getHistory());
		ClipboardServiceImpl.getInstance().getHistory().eAdapters().add(historyListener);

		Font font = PlatformUI.getWorkbench().getThemeManager().getCurrentTheme().getFontRegistry()
				.get("org.eclipse.jface.textfont");
		viewer.getTable().setFont(font);

		DragSource dragSource = new DragSource(viewer.getTable(), DND.DROP_COPY);
		dragSource.setTransfer(new Transfer[] { TextTransfer.getInstance(), FileTransfer.getInstance() });
		dragSource.addDragListener(new DragSourceAdapter() {
			@Override
			public void dragSetData(DragSourceEvent event) {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = ((ClipboardEntry) selection.getFirstElement()).getTextContent();
				}

				if (FileTransfer.getInstance().isSupportedType(event.dataType)) {
					String data = ((ClipboardEntry) selection.getFirstElement()).getTextContent();
					try {
						File file = File.createTempFile("clip-board-", ".txt");
						file.deleteOnExit();
						FileWriter writer = new FileWriter(file);
						writer.write(data);
						writer.close();
						event.data = new String[] { file.getAbsolutePath() };
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			@Override
			public void dragStart(DragSourceEvent event) {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				if (!selection.isEmpty()) {
					event.detail = DND.DROP_COPY;
					event.doit = true;
				}
			}
		});
	}

	public void dispose() {
		sharedColor.flush();
		SWTExtensions.INSTANCE.safeDispose(backgroundColor, foregroundColor);
		ClipboardServiceImpl.getInstance().getHistory().eAdapters().remove(historyListener);
		getPreferenceStore().removePropertyChangeListener(preferenceListener);
		getTextEditorStore().removePropertyChangeListener(editorPreferenceListener);
	}

	private IPreferenceStore getPreferenceStore() {
		return PDEToolsCore.getDefault().getPreferenceStore();
	}

	private RGB getRGBFromEditorPreference(IPreferenceStore store, String key) {
		String bgExp = store.getString(key);
		String[] segments = bgExp.split("[\\s,]+");
		int r = Integer.parseInt(segments[0], 10);
		int g = Integer.parseInt(segments[1], 10);
		int b = Integer.parseInt(segments[2], 10);
		return new RGB(r, g, b);
	}

	public TableViewer getTableViewer() {
		return viewer;
	}

	private IPreferenceStore getTextEditorStore() {
		if (textEditorStore == null) {
			textEditorStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.ui.editors");
		}
		return textEditorStore;
	}

	protected void handleNotification(Notification notification) {
		updateJob.schedule();
	}

	protected void handlePreferenceChange(PropertyChangeEvent event) {
		if (!event.getProperty().startsWith("clipboard-")) {
			return;
		}
		updateViewerSorter();
		updateLabelProvider();
		updateJob.schedule();
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private void updateColors() {
		viewer.getControl().setBackground(computeBackgroundColor());
		viewer.getControl().setForeground(computeForegroundColor());
	}

	private void updateLabelProvider() {
		labelProvider.setColorizeTextOnSelection(getPreferenceStore().getBoolean(
				ClipboardPreferenceConstants.CLIPBOARD_COLORLIZE_IN_SELECTION));
		labelProvider.setNumberOfLineForRow(getPreferenceStore().getInt(
				ClipboardPreferenceConstants.CLIPBOARD_NUMBER_OF_LINES_PER_EACH_ITEM));
	}

	private void updateViewerSorter() {
		final ChaindComparator<ClipboardEntry> comparator = new ChaindComparator<ClipboardEntry>();
		String configString = getPreferenceStore().getString(ClipboardPreferenceConstants.CLIPBOARD_SORT_ORDER);
		for (String each : configString.split(",")) {
			comparator.add(comparatorFactory.getByLiteral(each));
		}
		viewer.setSorter(new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				ClipboardEntry c1 = (ClipboardEntry) e1;
				ClipboardEntry c2 = (ClipboardEntry) e2;
				return comparator.compare(c1, c2);
			}
		});
	}
}

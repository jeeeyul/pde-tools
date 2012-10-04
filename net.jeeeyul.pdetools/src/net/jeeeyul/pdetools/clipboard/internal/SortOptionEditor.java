package net.jeeeyul.pdetools.clipboard.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.jeeeyul.pdetools.model.pdetools.ClipItemSortOption;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class SortOptionEditor {

	public static void main(String[] args) {
		Display display = Display.getDefault();

		Shell shell = new Shell(display);

		shell.setLayout(new FillLayout());
		SortOptionEditor editor = new SortOptionEditor(shell);
		editor.setInput("last-use");

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private TableViewer viewer;
	private List<ClipItemSortOption> model;
	private Button upButton;
	private Button downButton;
	private Composite composite;

	public SortOptionEditor(Composite parent) {
		composite = new Composite(parent, SWT.NORMAL);
		composite.setLayout(new GridLayout(2, false));
		viewer = new TableViewer(composite, SWT.BORDER);
		viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return getDisplayText((ClipItemSortOption) element);
			}
		});
		viewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public void dispose() {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<?>) inputElement).toArray();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		});

		upButton = new Button(composite, SWT.PUSH);
		upButton.setText("UP");
		upButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		upButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				moveUpSelection();
			}
		});

		downButton = new Button(composite, SWT.PUSH);
		downButton.setText("DOWN");
		downButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		downButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				moveDownSelection();
			}
		});

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtonEnabilities();
			}
		});
		viewer.setInput(getModel());

		updateButtonEnabilities();
	}

	private List<ClipItemSortOption> computeModel(String input) {
		model = new ArrayList<ClipItemSortOption>();
		model.addAll(ClipItemSortOption.VALUES);

		if (input != null) {
			final List<String> inputOrder = Arrays.asList(input.split(","));
			Collections.sort(model, new Comparator<ClipItemSortOption>() {
				@Override
				public int compare(ClipItemSortOption op1, ClipItemSortOption op2) {
					int i1 = inputOrder.indexOf(op1.getLiteral());
					if (i1 == -1) {
						i1 = 1000;
					}
					int i2 = inputOrder.indexOf(op2.getLiteral());
					if (i2 == -1) {
						i2 = 1000;
					}
					return i1 - i2;
				}
			});
		}
		return model;
	}

	public Control getControl() {
		return composite;
	}

	public String getInput() {
		List<ClipItemSortOption> model = getModel();
		int size = model.size();

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < size; i++) {
			if (i != 0) {
				buffer.append(",");
			}
			buffer.append(model.get(i).getLiteral());
		}

		return buffer.toString();
	}

	private List<ClipItemSortOption> getModel() {
		if (model == null) {
			model = computeModel(null);
		}
		return model;
	}

	private ClipItemSortOption getSelection() {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		return (ClipItemSortOption) selection.getFirstElement();
	}

	protected void moveDownSelection() {
		ClipItemSortOption selection = getSelection();
		int currentIndex = getModel().indexOf(selection);
		if (currentIndex < getModel().size() - 1) {
			swap(getModel(), currentIndex, currentIndex + 1);
		}
		viewer.refresh();
		updateButtonEnabilities();
	}

	protected void moveUpSelection() {
		ClipItemSortOption selection = getSelection();
		int currentIndex = getModel().indexOf(selection);
		if (currentIndex > 0) {
			swap(getModel(), currentIndex, currentIndex - 1);
		}
		viewer.refresh();
		updateButtonEnabilities();
	}

	public void setInput(String input) {
		model = computeModel(input);
		viewer.setInput(model);
	}

	private <T> void swap(List<T> list, int index1, int index2) {
		T element1 = list.get(index1);
		T element2 = list.get(index2);
		list.set(index1, element2);
		list.set(index2, element1);
	}

	protected void updateButtonEnabilities() {
		ClipItemSortOption selection = getSelection();
		if (selection == null) {
			upButton.setEnabled(false);
			downButton.setEnabled(false);
			return;
		}

		int currentIndex = getModel().indexOf(selection);
		upButton.setEnabled(currentIndex > 0);
		downButton.setEnabled(currentIndex < getModel().size() - 1);
	}

	private String getDisplayText(ClipItemSortOption element) {
		switch (element) {
			case CAPTURED_ORDER:
				return "Recently Captured";

			case LAST_USE:
				return "Recently Used";

			case USING_COUNT:
				return "Most Used";

			case ACTIVE:
				return "Active (System clipboard contents)";

			default:
				return "(INVALID)";
		}
	}
}

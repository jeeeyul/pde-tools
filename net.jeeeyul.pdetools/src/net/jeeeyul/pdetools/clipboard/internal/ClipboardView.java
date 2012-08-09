package net.jeeeyul.pdetools.clipboard.internal;

import java.util.ArrayList;
import java.util.List;

import net.jeeeyul.pdetools.clipboard.ClipboardViewer;
import net.jeeeyul.pdetools.clipboard.IClipboardService;
import net.jeeeyul.pdetools.shared.SharedImages;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.mylyn.commons.ui.GradientCanvas;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.part.ViewPart;

public class ClipboardView extends ViewPart {
	public static final String ID = "net.jeeeyul.pdetools.clipboard.ClipboardView";
	private ClipboardViewer viewer;
	private List<ClipboardHistoryAction> actions = new ArrayList<ClipboardHistoryAction>();
	private EContentAdapter listener = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			if (notification.isTouch()) {
				return;
			}
			updateActions();
		};
	};
	private Composite info;

	public ClipboardViewer getViewer() {
		return viewer;
	}

	protected void updateActions() {
		for (ClipboardHistoryAction eachAction : actions) {
			eachAction.update();
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NORMAL);
		GridLayout layout = new GridLayout();

		layout.marginWidth = layout.marginHeight = 0;
		layout.verticalSpacing = 2;
		container.setLayout(layout);

		viewer = new ClipboardViewer(container, SWT.MULTI);
		viewer.getTableViewer().getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		TableViewer tableViewer = viewer.getTableViewer();
		getViewSite().setSelectionProvider(tableViewer);

		configureActions(tableViewer);

		getClipboardService().getHistory().eAdapters().add(listener);
		updateActions();

		createInlineInfo(container);
	}

	private void createInlineInfo(Composite container) {
		GridLayout outLayout = new GridLayout();
		outLayout.marginWidth = outLayout.marginHeight = 0;

		info = new Composite(container, SWT.NORMAL);
		info.setLayout(outLayout);
		info.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GradientCanvas canvas = new GradientCanvas(info, SWT.SEPARATOR | SWT.DOUBLE_BUFFERED);

		canvas.setLayout(outLayout);
		canvas.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label separator = new Label(canvas, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Display display = container.getDisplay();
		canvas.setBackgroundGradient(
				new Color[] { display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND),
						display.getSystemColor(SWT.COLOR_WHITE) }, new int[] { 100 }, true);

		Composite internal = new Composite(canvas, SWT.NORMAL);
		internal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.marginHeight = 0;
		internal.setLayout(layout);

		Label icon = new Label(internal, SWT.NORMAL);
		icon.setImage(SharedImages.getImage(SharedImages.CLIPBOARD));

		Label label = new Label(internal, SWT.NORMAL);
		label.setText("Information");

		ImageHyperlink closeButton = new ImageHyperlink(internal, SWT.PUSH);
		closeButton.setImage(SharedImages.getImage(SharedImages.CLOSE_INACTIVE));
		closeButton.setHoverImage(SharedImages.getImage(SharedImages.CLOSE));
		closeButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		closeButton.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				GridData data = (GridData) info.getLayoutData();
				data.exclude = true;
				info.getParent().layout(true, true);
			}
		});

		FormText text = new FormText(info, SWT.WRAP);
		text.setBackground(container.getBackground());
		text.setText("<form><p>You can drag items into <b>Editors</b> or <b>Navigators</b>.</p></form>", true, false);
		GridData textData = new GridData(GridData.FILL_HORIZONTAL);
		textData.horizontalIndent = 26;
		text.setLayoutData(textData);
		text.setWhitespaceNormalized(true);

	}

	private void configureActions(TableViewer tableViewer) {
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(tableViewer.getTable());
		tableViewer.getTable().setMenu(menu);
		getViewSite().registerContextMenu(menuManager, tableViewer);

		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		RemoveAllAction removeAllAction = new RemoveAllAction(ClipboardServiceImpl.getInstance().getHistory());
		actions.add(removeAllAction);
		toolBarManager.add(removeAllAction);
	}

	@Override
	public void dispose() {
		getClipboardService().getHistory().eAdapters().remove(listener);
		super.dispose();
	}

	private IClipboardService getClipboardService() {
		return (IClipboardService) getSite().getService(IClipboardService.class);
	}

	@Override
	public void setFocus() {
		viewer.getTableViewer().getTable().setFocus();
	}

}

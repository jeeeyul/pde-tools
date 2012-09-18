package net.jeeeyul.pdetools.crazyoutline;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.part.PageSite;

public class CrazyOutlineView extends PageBookView {
	public static final String ID = "net.jeeeyul.pdetools.crazyoutline.CrazyOutlineView";

	@Override
	protected IPage createDefaultPage(PageBook book) {
		MessagePage page = new MessagePage();
		page.createControl(book);
		page.setMessage("Only works with text based editors");
		return page;
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		StyledText client = (StyledText) part.getAdapter(Control.class);
		COPage page = new COPage(client);
		PageSite site = new PageSite(getViewSite());
		page.init(site);
		page.createControl(getPageBook());

		return new PageRec(part, page);
	}

	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		pageRecord.page.dispose();
	}

	@Override
	protected IWorkbenchPart getBootstrapPart() {
		return getSite().getPage().getActiveEditor();
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		return part instanceof IEditorPart && part.getAdapter(Control.class) instanceof StyledText;
	}

}

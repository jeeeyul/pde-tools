package net.jeeeyul.pdetools.crazyoutline;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.part.PageSite;
import org.eclipse.ui.texteditor.AbstractTextEditor;

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
		Page page = null;

		if (part instanceof MultiPageEditorPart) {
			page = new MultiPageCrazyPage((MultiPageEditorPart) part);
		} else if (part instanceof AbstractTextEditor) {
			page = new CrazyPage((AbstractTextEditor) part);
		} else {
			return null;
		}

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
		if (!(part instanceof IEditorPart)) {
			return false;
		}
		IEditorPart editor = (IEditorPart) part;
		return editor instanceof AbstractTextEditor || editor instanceof MultiPageEditorPart;
	}

}

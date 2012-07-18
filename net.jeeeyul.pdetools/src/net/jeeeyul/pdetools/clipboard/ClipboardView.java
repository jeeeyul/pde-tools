package net.jeeeyul.pdetools.clipboard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ClipboardView extends ViewPart {
	public static final String ID = "net.jeeeyul.pdetools.clipboard.ClipboardView";

	private StyledText styledText;
	private SharedColor sharedColor;

	@Override
	public void createPartControl(Composite parent) {
		sharedColor = new SharedColor(parent.getDisplay());
		styledText = new StyledText(parent, SWT.READ_ONLY);
	}

	@Override
	public void setFocus() {
		styledText.setFocus();
	}

	@Override
	public void dispose() {
		sharedColor.flush();
		super.dispose();
	}

	public void showRTF(String rtfContents) {
		StyleAndTextFactory factory = new StyleAndTextFactory(sharedColor);

		StyleAndText result = factory.createFromRTFString(rtfContents);
		styledText.setText(result.getText());
		styledText.setStyleRanges(result.getStyleRanges());
	}

}

package net.jeeeyul.pdetools.icg.builder.parts;

import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.model.pdetools.Palette;

public interface IConstantGenerator {
	public String generateJavaSource(Palette rootPalette);
	public void setConfig(ICGConfiguration config);
}

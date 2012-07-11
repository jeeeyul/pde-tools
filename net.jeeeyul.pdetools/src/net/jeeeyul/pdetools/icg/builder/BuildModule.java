package net.jeeeyul.pdetools.icg.builder;

import net.jeeeyul.pdetools.icg.builder.model.BuildContext;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class BuildModule extends AbstractModule {
	private IncrementalProjectBuilder builder;
	private int buildKind;

	public BuildModule(IncrementalProjectBuilder builder, int buildKind) {
		this.builder = builder;
		this.buildKind = buildKind;
	}

	@Override
	protected void configure() {
	}

	@Provides
	public IProject provideProject() {
		return builder.getProject();
	}

	@Provides
	@Singleton
	public ICGConfiguration provideConfiguration() {
		return new ICGConfiguration(builder.getProject());
	}

	@Provides
	public IncrementalProjectBuilder provideBuilder() {
		return builder;
	}

	@Provides
	@Singleton
	public BuildContext provideBuildContenxt() {
		BuildContext buildContext = new BuildContext();
		buildContext.setBuilder(builder);
		buildContext.setBuildKind(buildKind);
		return buildContext;
	}

}

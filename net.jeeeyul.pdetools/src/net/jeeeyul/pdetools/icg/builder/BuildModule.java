package net.jeeeyul.pdetools.icg.builder;

import net.jeeeyul.pdetools.icg.builder.model.BuildContext;
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration;
import net.jeeeyul.pdetools.icg.builder.parts.GraphitiImageCosntantGenerator;
import net.jeeeyul.pdetools.icg.builder.parts.IConstantGenerator;
import net.jeeeyul.pdetools.icg.builder.parts.StandardImageCosntantGenerator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

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
	public IConstantGenerator provideGenerator() {
		ICGConfiguration config = provideConfiguration();
		String generateType = config.getGenerateType();
		IConstantGenerator result = null;
		if (generateType.equals(ICGConfiguration.GENERATE_TYPE_STANDARD)) {
			result = new StandardImageCosntantGenerator();
		} else {
			result = new GraphitiImageCosntantGenerator();
		}
		result.setConfig(config);
		return result;
	}

	@Provides
	@Singleton
	public BuildContext provideBuildContenxt() {
		BuildContext buildContext = new BuildContext();
		buildContext.setBuilder(builder);
		buildContext.setBuildKind(buildKind);
		return buildContext;
	}

	@Provides
	@Singleton
	public IJavaProject provideJavaProject() {
		return JavaCore.create(builder.getProject());
	}

}

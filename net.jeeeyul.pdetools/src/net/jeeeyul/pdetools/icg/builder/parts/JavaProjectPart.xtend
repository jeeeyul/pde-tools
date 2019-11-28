package net.jeeeyul.pdetools.icg.builder.parts

import com.google.inject.Inject
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.shared.ResourceExtensions
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.pde.core.IEditableModel
import org.eclipse.pde.core.plugin.PluginRegistry

class JavaProjectPart {
	@Inject
	extension ResourceExtensions
	
	@Inject
	ICGConfiguration config
	
	@Inject
	IJavaProject javaProject
	
	@Inject
	IProject project
	
	/**
	 * ��� �ڹ� �ҽ��� ������ �ҽ������� �����, �ڹ� �ҽ� ������ ���� �н��� ����Ѵ�.
	 * �̹� �����ϰ�, �̹� ��ϵǾ� ������ �ƹ��ϵ� ���� �ʴ´�.
	 */
	def ensureJavaSourceFolder(){
		// �ҽ� ������ ���縦 �����Ѵ�.
		config.generateSrcFolder.ensureExist()
		
		// �ҽ� ������ �̹� �ڹ� ������Ʈ�� �ҽ� ������ ��ϵǾ� �ִ��� Ȯ���Ѵ�.
		var isAlreadJavaSoruceFolder = javaProject.rawClasspath.exists[it.path == config.generateSrcFolder.fullPath]
		
		// �ڹ� �ҽ� ������ �ƴѰ��, �ڹ� �ҽ� ������ ����Ѵ�.
		if(!isAlreadJavaSoruceFolder){
			var rawClasspathes = newArrayList(javaProject.rawClasspath)
			rawClasspathes += JavaCore::newSourceEntry(config.generateSrcFolder.fullPath)
			javaProject.setRawClasspath(rawClasspathes, new NullProgressMonitor)
		}
		
		var model = PluginRegistry::findModel(project)
		var buildModel = PluginRegistry::createBuildModel(model)
		var entry = buildModel.build.buildEntries.findFirst[it.name == "source.."]
		
		var srcPath = config.generateSrcFolder.projectRelativePath.toPortableString + "/"
		if(!entry.contains(srcPath)){
			entry.addToken(srcPath)
			(buildModel as IEditableModel).save()
		}
		buildModel.dispose()
	}
		
}
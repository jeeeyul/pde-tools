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
	 * 결과 자바 소스가 생성될 소스폴더를 만들고, 자바 소스 폴더로 빌드 패스에 등록한다.
	 * 이미 존재하고, 이미 등록되어 있으면 아무일도 하지 않는다.
	 */
	def ensureJavaSourceFolder(){
		// 소스 폴더의 존재를 보증한다.
		config.generateSrcFolder.ensureExist()
		
		// 소스 폴더가 이미 자바 프로젝트에 소스 폴더로 등록되어 있는지 확인한다.
		var isAlreadJavaSoruceFolder = javaProject.rawClasspath.exists[it.path == config.generateSrcFolder.fullPath]
		
		// 자바 소스 폴더가 아닌경우, 자바 소스 폴더로 등록한다.
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
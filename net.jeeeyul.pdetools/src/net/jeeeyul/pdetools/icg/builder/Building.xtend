package net.jeeeyul.pdetools.icg.builder

import java.io.ByteArrayInputStream
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator
import net.jeeeyul.pdetools.shared.ResourceExtensions
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl
import java.util.HashMap
import org.eclipse.emf.ecore.util.EcoreUtil
import com.google.inject.Inject
import net.jeeeyul.pdetools.icg.builder.parts.ErrorPart
import net.jeeeyul.pdetools.icg.builder.parts.ValidationPart
import net.jeeeyul.pdetools.icg.builder.parts.ResourceDeltaPart
import net.jeeeyul.pdetools.icg.builder.parts.ImageCosntantGenerator
import net.jeeeyul.pdetools.icg.builder.parts.JavaProjectPart

class Building {
	extension ResourceExtensions = new ResourceExtensions()
	
	@Inject
	extension ValidationPart
	
	@Inject
	extension IncrementalProjectBuilder builder
	
	@Inject
	extension ErrorPart
	
	@Inject
	extension ResourceDeltaPart
	
	@Inject
	extension ImageCosntantGenerator
	
	@Inject
	ICGConfiguration config
	
	@Inject
	extension JavaProjectPart
	
	def IProject[ ] build(IProgressMonitor monitor) {
		// 빌드 설정및 구성을 검사한다.
		validate()
		
		// 이전 리소스 마커들을 제거하고, 검사 결과에 따른 마커들을 생성한다.
		cleanMarkers()
		generateMarkers()

		// 빌드 할 필요가 없거나, 빌드가 불가능하면 종료한다.
		if(!canBuild() || !hasResourceDelta()) {
			return emptyList
		}
		
		// 출력될 자바 소스가 담길 자바 소스 폴더를 확보한다.
		ensureJavaSourceFolder()
		
		var pmg = new PaletteModelGenerator(config)
		var paletteModel = pmg.generatePalette(config.monitoringFolder)
		if(config.ouputFile.exists) {
			config.ouputFile.delete(true, new NullProgressMonitor())
		}
		
		var serializer = new XMLResourceImpl()
		serializer.contents += EcoreUtil::copy(paletteModel)
		serializer.save(System::out, new HashMap)
		
		var stream = new ByteArrayInputStream(paletteModel.generateJavaSource().toString.bytes)
		
		config.ouputFile.parent.ensureExist()
		config.ouputFile.create(stream, true, new NullProgressMonitor())
		stream.close()
		config.ouputFile.derived = config.markDerived
		
		return newArrayList(project)
	}
	
	def boolean isNullOrBlank(String src){
		if(src == null){
			return true
		}else{
			return src.trim.empty
		}
	}
}
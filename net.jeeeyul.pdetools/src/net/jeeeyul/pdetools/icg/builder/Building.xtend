package net.jeeeyul.pdetools.icg.builder

import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.util.HashMap
import net.jeeeyul.pdetools.icg.builder.model.ICGConfiguration
import net.jeeeyul.pdetools.icg.builder.model.PaletteModelGenerator
import net.jeeeyul.pdetools.icg.builder.parts.ErrorPart
import net.jeeeyul.pdetools.icg.builder.parts.IConstantGenerator
import net.jeeeyul.pdetools.icg.builder.parts.JavaProjectPart
import net.jeeeyul.pdetools.icg.builder.parts.ResourceDeltaPart
import net.jeeeyul.pdetools.shared.ResourceExtensions
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl

class Building {
	extension ResourceExtensions = new ResourceExtensions() 
	
	@Inject
	extension IncrementalProjectBuilder builder
	
	@Inject
	extension ErrorPart
	
	@Inject
	extension ResourceDeltaPart
	
	@Inject
	extension IConstantGenerator
	
	@Inject
	ICGConfiguration config
	
	@Inject
	extension JavaProjectPart
	
	def IProject[ ] build(IProgressMonitor monitor) {
		monitor.beginTask("ICG Build", IProgressMonitor::UNKNOWN);
		
		// 빌드 설정및 구성을 검사한다.
		validate()
		
		// 이전 리소스 마커들을 제거하고, 검사 결과에 따른 마커들을 생성한다.
		cleanMarkers()
		generateMarkers()

		// 빌드 할 필요가 없거나, 빌드가 불가능하면 종료한다.
		if(!canBuild() || !hasResourceDelta()) {
			monitor.done()
			return emptyList 
		}
		
		// 출력될 자바 소스가 담길 자바 소스 폴더를 확보한다.
		ensureJavaSourceFolder()
		
		var pmg = new PaletteModelGenerator(config)
		var paletteModel = pmg.generatePalette(config.monitoringFolder)
		
		
		var data = paletteModel.generateJavaSource().toString.bytes;
		var stream = new ByteArrayInputStream(data)
		config.ouputFile.parent.ensureExist()
		if(config.ouputFile.exists){
			config.ouputFile.setContents(stream, true, true, new NullProgressMonitor);
		}
		else{
			config.ouputFile.create(stream, true, new NullProgressMonitor())
		}
		stream.close()
		config.ouputFile.setDerived(config.markDerived, new NullProgressMonitor)
		
		var uri = URI::createPlatformResourceURI(project.fullPath.append('''.settings/«net::jeeeyul::pdetools::PDEToolsCore::getDefault.bundle.symbolicName».palette.xml''').toPortableString, false)
		var resource = new XMLResourceImpl(uri)
		resource.contents.add(paletteModel)
		resource.save(new HashMap())
			
		monitor.done()
		return newArrayList(project)
	}
	
	def boolean isNullOrBlank(String src){
		if(src === null){
			return true
		}else{
			return src.trim.empty
		}
	}
}
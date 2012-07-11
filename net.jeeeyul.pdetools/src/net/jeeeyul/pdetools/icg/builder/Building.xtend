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

class Building {
	extension ResourceExtensions = new ResourceExtensions()
	
	@Inject
	extension BuildValidator
	
	@Inject
	extension IncrementalProjectBuilder builder
	
	@Inject
	extension BuildErrorAcceptor
	
	@Inject
	extension ResourceDeltaDetector
	
	@Inject
	ICGConfiguration config
		
	def IProject[ ] build(IProgressMonitor monitor) {
		validate()
		cleanMarkers()
		generateMarkers()

		if(!canBuild || !hasResourceDelta) {
			return emptyList
		}
		config.ouputFile.parent.ensureExist()
		var pmg = new PaletteModelGenerator(config)
		var paletteModel = pmg.generatePalette(config.monitoringFolder)
		var generator = new ImageCosntantGenerator()
		generator.config = config
		generator.rootPalette = paletteModel
		if(config.ouputFile.exists) {
			config.ouputFile.delete(true, new NullProgressMonitor())
		}
		
		var serializer = new XMLResourceImpl()
		serializer.contents += EcoreUtil::copy(paletteModel)
		serializer.save(System::out, new HashMap)
		
		var stream = new ByteArrayInputStream(generator.generate.toString.bytes)
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
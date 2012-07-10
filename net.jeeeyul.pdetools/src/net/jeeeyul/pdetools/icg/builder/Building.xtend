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

class Building {
	int kind
	extension ResourceExtensions = new ResourceExtensions()
	extension IncrementalProjectBuilder builder
	ICGConfiguration _config

	new(IncrementalProjectBuilder builder, int kind) {
		this.builder = builder
		this.kind = kind
	}

	def IProject[ ] build(IProgressMonitor monitor) {
		if(!hasToBuild) {
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

	def ICGConfiguration getConfig() {
		if(_config == null) {
			_config = new ICGConfiguration(project)
		}
		return _config
	}

	def hasToBuild() {
		var monitoringFolder = config.monitoringFolder
		
		if(kind != IncrementalProjectBuilder::CLEAN_BUILD && kind != IncrementalProjectBuilder::FULL_BUILD) {
			var projectDelta = project.delta
			if(projectDelta == null) {
				return false;
			}
			
			if(monitoringFolder == null) {
				return false
			}
			if(!monitoringFolder.exists) {
				return false;
			}
			var monitoredDelta = projectDelta.findMember(config.monitoringFolder.projectRelativePath)
			if(monitoredDelta == null) {
				return false;
			}
		}
		
		if(!monitoringFolder.exists){
			return false
		}
		
		return true;
	}
}
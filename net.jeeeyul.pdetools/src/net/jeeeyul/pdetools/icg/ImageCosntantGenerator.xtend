package net.jeeeyul.pdetools.icg

class ImageCosntantGenerator {
	ICGConfiguration config
	def generate()'''
	package «config.generatePackageName»;
	
	public class «config.generateClassName»{
		
	}
	'''
}
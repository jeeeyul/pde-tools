package net.jeeeyul.pdetools.decorator

import org.eclipse.swt.graphics.ImageData
import org.eclipse.swt.graphics.PaletteData
import org.eclipse.swt.SWT

class ImageDataExtensions {
	def static ImageData embedInCanvas(ImageData data, int width, int height){
		var palette = new PaletteData(0xff0000, 0xff00, 0xff)
		var result = new ImageData(width, height, 32, palette)
		
		var offsetX = (width - data.width) / 2
		var offsetY = (width - data.height) / 2
		
		for(x:0..result.width - 1){
			for(y:0..result.height - 1){
				result.setAlpha(x, y, 0)
			}
		}
		
		for(x : 0..data.width - 1){
			for(y : 0..data.height - 1){
				var rgb = data.palette.getRGB(data.getPixel(x, y))
				if(x + offsetX < result.width && x + offsetX >= 0 && 0 <= offsetY + y && offsetY + y < result.height){
					result.setPixel(x + offsetX, y + offsetY, result.palette.getPixel(rgb))
					
					var alpha = 255
					switch(data.transparencyType){
						case SWT::TRANSPARENCY_ALPHA:{
							alpha = data.getAlpha(x, y)
						}
						
						case SWT::TRANSPARENCY_PIXEL:{
							if(data.getPixel(x, y) == data.transparentPixel){
								alpha = 0
							}else{
								alpha = 255
							}
						}
						
						default:{
							alpha = 255
						}
					}
					result.setAlpha(x+offsetX, y + offsetY, alpha)		
				}
			}
		}
		
		return result
	}
}
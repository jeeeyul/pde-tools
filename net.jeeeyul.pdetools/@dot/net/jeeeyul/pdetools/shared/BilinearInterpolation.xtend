package net.jeeeyul.pdetools.shared

import org.eclipse.swt.graphics.ImageData
import org.eclipse.swt.graphics.PaletteData
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.SWT

class BilinearInterpolation {
	private ImageData source
	private ImageData out
	
	private double xRatio
	private double yRatio
	
	new(ImageData source, int targetWidth, int targetHeight){
		this.source = source
		xRatio = targetWidth / source.width as double
		yRatio = targetHeight / source.height as double
		
		var palette = new PaletteData(0xff0000, 0xff00, 0xff)
		out = new ImageData(targetWidth, targetHeight, 32, palette)
	}
	
	def ImageData run(){
		for(x : 0..out.width - 1){
			for(y : 0..out.height - 1){
				out.setPixel(x, y, out.palette.getPixel(f(x, y)))
				out.setAlpha(x, y, af(x, y))
			}
		}
		return out
	}
	
	def private f(int x, int y){
		var u = (x / xRatio) as int
		var v = (y / yRatio) as int

		var ud = (x / xRatio) - u
		var vd = (y / yRatio) - v
		
		var c00 = src(u, v)
		var c10 = src(u + 1, v)
		var c01 = src(u, v + 1)
		var c11 = src(u + 1, v + 1)
		
		var top = c00.blendWith(c10, ud)
		var bottom = c01.blendWith(c11, ud)
		var result = top.blendWith(bottom, vd)		
		return result
	}
	
	def private af(int x, int y){
		var u = (x / xRatio) as int
		var v = (y / yRatio) as int

		var ud = (x / xRatio) - u
		var vd = (y / yRatio) - v
		
		var c00 = srcAlpha(u, v)
		var c10 = srcAlpha(u + 1, v)
		var c01 = srcAlpha(u, v + 1)
		var c11 = srcAlpha(u + 1, v + 1)
		
		var top = c00.blendWith(c10, ud)
		var bottom = c01.blendWith(c11, ud)
		var result = top.blendWith(bottom, vd)		
		
		return result
	}
	
	def RGB blendWith(RGB source, RGB over, double strength){
		var result = new RGB(0, 0, 0) => [
			red = (((source.red * (1.0 - strength)) + (over.red * strength)) as int).limit(0, 255) 
			green = (((source.green * (1.0 - strength)) + (over.green * strength)) as int).limit(0, 255) 
			blue = (((source.blue * (1.0 - strength)) + (over.blue * strength)) as int).limit(0, 255) 
		]
		return result
	}
	
	def int blendWith(int v1, int v2, double strength){
		return ((v1 * (1-strength) + v2 * strength) as int).limit(0, 255)
	}
	
	def private int srcAlpha(int x, int y){
		var ax = x.limit(0, source.width - 1)
		var ay = y.limit(0, source.height - 1)
		var result = 0
		
		switch(source.transparencyType){
			case SWT::TRANSPARENCY_ALPHA:{
				result = source.getAlpha(ax, ay)
			}
			
			case SWT::TRANSPARENCY_PIXEL:{
				if(source.transparentPixel == source.getPixel(ax, ay)){
					result = 0
				} else{
					result = 255
				}
			}
			
			default:{
				result = 255
			}
		}
		
		return result
	}
	
	def private RGB src(int x, int y){
		var pixel = source.getPixel(x.limit(0, source.width - 1), y.limit(0, source.height - 1))
		return source.palette.getRGB(pixel)
	}
	
	def private limit(int value, int min, int max) {
		Math::min(Math::max(min, value), max)
	}
}
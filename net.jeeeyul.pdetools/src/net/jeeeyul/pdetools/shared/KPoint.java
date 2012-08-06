package net.jeeeyul.pdetools.shared;

import org.eclipse.swt.graphics.Point;

public class KPoint {
	public int x;
	public int y;

	public KPoint(){
		
	}
	
	public KPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point toPoint() {
		return new Point(x, y);
	}
}

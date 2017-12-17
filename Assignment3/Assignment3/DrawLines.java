import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class DrawLines extends GraphicsProgram {
	
	public void init() {
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		line = new GLine(x, y, x, y);
		add(line);
	} 
	
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		line.setEndPoint(x, y);
	}
	
	private GLine line;
	private double x, y;
}

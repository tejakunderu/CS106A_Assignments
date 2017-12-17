import acm.graphics.*; 
import acm.program.*; 
import acm.util.*;  
import java.awt.event.*;

public class DragObjects extends GraphicsProgram { 
	
	public void init() { 
		GRect rect = new GRect(100, 100, 150, 100); 
		rect.setFilled(true); 
		add(rect); 
		
		GOval oval = new GOval(50, 50, 150, 100); 
		oval.setFilled(true); 
		add(oval); 
		
		addMouseListeners(); 
		addKeyListeners(); 
	}
	
	public void mousePressed(MouseEvent e) { 
		last = new GPoint(e.getPoint()); 
		gobj = getElementAt(last);
		if (gobj != null) gobj.sendToFront();
	} 
	
	public void mouseDragged(MouseEvent e) { 
		if (gobj != null) { 
			gobj.move(e.getX() - last.getX(), e.getY() - last.getY()); 
			last = new GPoint(e.getPoint()); 
		} 
	} 

	public void keyTyped(KeyEvent e) { 
		if (gobj != null) gobj.setColor(rgen.nextColor());  
	}

	private GObject gobj;
	private GPoint last;  
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
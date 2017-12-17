import acm.graphics.*;
import java.awt.event.*;

public class MyCanvas extends GCanvas implements ComponentListener {
	
	private static final double BOX_WIDTH = 60;
	private static final double BOX_HEIGHT = 60;
	
	public MyCanvas() {
		addComponentListener(this);
		rect = new GRect(BOX_WIDTH, BOX_HEIGHT);
		rect.setFilled(true);
	}
	
	public void update() {
		removeAll();
		add(rect, getWidth() / 2 - BOX_WIDTH / 2, getHeight() / 2 - BOX_HEIGHT / 2);
	}
	
	public void componentResized(ComponentEvent e) { update();}
	public void componentHidden(ComponentEvent e) {}
	public void componentMoved(ComponentEvent e) {}
	public void componentShown(ComponentEvent e) {}
	
	private GRect rect;
	
}

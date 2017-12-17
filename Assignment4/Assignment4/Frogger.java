import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class Frogger extends GraphicsProgram {
	
	private static final int SQSIZE = 75;
	private static final int NCOLS = 7;
	private static final int NROWS = 3;
	
	public static final int APPLICATION_WIDTH = NCOLS * SQSIZE;
	public static final int APPLICATION_HEIGHT = NROWS * SQSIZE;
	
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;
	
	public void run() {
		initializeObject();
		add(kimi);
		addMouseListeners();
	}
	
	private void initializeObject() {
		kimi = new GImage("Yawn.jpg");
		kimi.setSize(SQSIZE, SQSIZE);
		kimi.setLocation(WIDTH / 2 - kimi.getWidth() / 2, HEIGHT - SQSIZE / 2 - kimi.getHeight() / 2);
	}
	
	public void mouseClicked(MouseEvent e) {
		moveKimi(e.getX(), e.getY());
	}
	
	private void moveKimi(double x_m, double y_m) {
		double x_k = kimi.getX() + kimi.getWidth() / 2;
		double y_k = kimi.getY() + kimi.getHeight() / 2;
		
		double dx = x_m - x_k;
		if(dx < 0) dx = -dx;
		
		double dy = y_m - y_k;
		if(dy < 0) dy = -dy;
		
		if(dx > SQSIZE / 2 || dy > SQSIZE / 2) {
			if(dx > dy && x_m > x_k && (x_k + SQSIZE < WIDTH)) kimi.move(SQSIZE, 0);
			if(dx > dy && x_m < x_k && (x_k - SQSIZE > 0)) kimi.move(-SQSIZE, 0);
			if(dx < dy && y_m > y_k && (y_k + SQSIZE < HEIGHT)) kimi.move(0, SQSIZE);
			if(dx < dy && y_m < y_k && (y_k + SQSIZE > 0)) kimi.move(0, -SQSIZE);
		}
	}
	
	private GImage kimi;
}

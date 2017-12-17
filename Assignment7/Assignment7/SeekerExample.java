import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class SeekerExample extends GraphicsProgram {
	
	private static final int TARGET_SIZE = 30;
	private static final int SEEKER_SIZE = 50;
	private static final int PAUSE_TIME = 4;
	private static final int STEP = 1;
	
	public void run() {
		initTarget();
		initSeeker();
		addMouseListeners();
		
		while(true) {
			seek();
		}
	}
	
	private void initTarget() {
		targetSquare = new GRect(TARGET_SIZE, TARGET_SIZE);
		targetSquare.setColor(Color.RED);
		targetSquare.setFilled(true);
		targetX = getWidth() / 2;
		targetY = getHeight() / 2;
		add(targetSquare, targetX - TARGET_SIZE / 2, targetY - TARGET_SIZE / 2);
	}
	
	private void initSeeker() {
		seeker = new GRect(SEEKER_SIZE, SEEKER_SIZE);
		add(seeker, 0, 0);
	}
	
	public void mouseClicked(MouseEvent e) {
		targetX = e.getX();
		targetY = e.getY();
		remove(targetSquare);
		add(targetSquare, targetX - TARGET_SIZE / 2, targetY - TARGET_SIZE / 2);
	}
	
	private void seek() {
		pause(PAUSE_TIME);
		double dx = 0;
		double mycurrentX = seeker.getX() + SEEKER_SIZE / 2;
		if(targetX > mycurrentX) {
			dx = STEP;
		} else if(targetX < mycurrentX) {
			dx = -STEP;
		}
		double dy = 0;
		double mycurrentY = seeker.getY() + SEEKER_SIZE / 2;
		if(targetY > mycurrentY) {
			dy = STEP;
		} else if(targetY < mycurrentY) {
			dy = -STEP;
		}
		seeker.move(dx, dy);
	}
	
	private GRect targetSquare;
	private int targetX;
	private int targetY;
	private GRect seeker;

}

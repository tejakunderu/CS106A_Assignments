import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.awt.*;

public class UfoGame extends GraphicsProgram {
	
	private static final int UFO_WIDTH = 40;
	private static final int UFO_HEIGHT = UFO_WIDTH / 2;
	private static final int UFO_SPEED = 1;
	
	private static final int BULLET_DIAM = 5;
	private static final int BULLET_SPEED = 2;
	
	private static final int DELAY = 2;
	
	public void run() {
		setup();
		while(!gameOver()) {
			moveUfo();
			moveBullet();
			checkForCollision();
			pause(DELAY);
		}
	}
	
	private void setup() {
		ufo = new GRect(UFO_WIDTH, UFO_HEIGHT);
		ufo.setFilled(true);
		add(ufo, 0, 0);
		ufoToLeft = false;
		addMouseListeners();
	}
	
	public void mouseClicked(MouseEvent e) {
		if(bullet == null) {
			bullet = new GOval(BULLET_DIAM, BULLET_DIAM);
			bullet.setFilled(true);
			bullet.setFillColor(Color.RED);
			add(bullet, getWidth() / 2 - BULLET_DIAM / 2, getHeight() - BULLET_DIAM);
		}
	}
	
	private boolean gameOver() {
		return (ufo == null) || (ufo.getY() > getHeight() - UFO_HEIGHT);
	}
	
	private void moveUfo() {
		if(!ufoToLeft) {
			ufo.move(UFO_SPEED, 0);
			if(ufo.getX() >= getWidth() - UFO_WIDTH) {
				ufo.move(0, UFO_HEIGHT);
				ufoToLeft = true;
			}
		} else {
			ufo.move(-UFO_SPEED, 0);
			if(ufo.getX() <= 0) {
				ufo.move(0, UFO_HEIGHT);
				ufoToLeft = false;
			}
		}
	}
	
	private void moveBullet() {
		if(bullet != null) bullet.move(0, -BULLET_SPEED);
	}
	
	private void checkForCollision() {
		collideWithUfo();
		moveOffScreen();
	}
	
	private void collideWithUfo() {
		if(bullet != null) {
			GObject object = getElementAt(bullet.getX() + BULLET_DIAM / 2, bullet.getY());
			if(object == ufo) {
				remove(ufo);
				remove(bullet);
				ufo = null;
				bullet = null;
			}
		}
	}
	
	private void moveOffScreen() {
		if(bullet != null) {
			if(bullet.getY() <= -BULLET_DIAM) {
				remove(bullet);
				bullet = null;
			}
		}
	}
	
	private GRect ufo;
	private GOval bullet;
	private boolean ufoToLeft;

}

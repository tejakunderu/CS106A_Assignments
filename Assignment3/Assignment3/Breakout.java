import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	private static final int PADDLE_Y_OFFSET = 30;

	private static final int NBRICKS_PER_ROW = 10;

	private static final int NBRICK_ROWS = 10;

	private static final int BRICK_SEP = 4;

	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	private static final int BRICK_HEIGHT = 8;

	private static final int BALL_RADIUS = 10;

	private static final int BRICK_Y_OFFSET = 70;

	private static int nturns = 3;
	
	private static final int DELAY = 10;
	
	private static final int PADDLE_Y = HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
	
	private static final double BRICK_X = WIDTH / 2 - 5 * BRICK_WIDTH - 4.5 * BRICK_SEP;
	
	private static int brick_count = 100;
	
	public static void main(String[] args) {
		new Breakout().start(args);
	}
	
	public void run() {
		setup();
		while(nturns != 0 && brick_count != 0) {
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
		displayFinalMessage();
	}
	
	private void setup() {
		createBricks();
		addMouseListeners();
		createPaddle();
		createBall();
		setupScore();
		setupTurns();
	}
	
	private void createBricks() {
		for(int i = 0; i < NBRICK_ROWS; i++) {
			for(int j = 0; j < NBRICKS_PER_ROW; j++) {
				brick = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				colorBricks(i);
				add(brick, BRICK_X + j * (BRICK_WIDTH + BRICK_SEP) , BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP));
			}
		}
	}
	
	private void colorBricks(int i) {
		switch (i) {
		case 0: brick.setColor(Color.RED);
				break;
		case 1: brick.setColor(Color.RED);
				break;
		case 2: brick.setColor(Color.ORANGE);
				break;
		case 3: brick.setColor(Color.ORANGE);
				break;
		case 4: brick.setColor(Color.YELLOW);
				break;
		case 5: brick.setColor(Color.YELLOW);
				break;
		case 6: brick.setColor(Color.GREEN);
				break;
		case 7: brick.setColor(Color.GREEN);
				break;
		case 8: brick.setColor(Color.CYAN);
				break;
		case 9: brick.setColor(Color.CYAN);
				break;
		}
	}
	
	private void createPaddle() {
		paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle, WIDTH / 2 - PADDLE_WIDTH / 2, PADDLE_Y);
		last = new GPoint(paddle.getLocation());
	}
	
	public void mouseMoved(MouseEvent e) {
		paddle.move(e.getX() - last.getX(), 0);
		last = new GPoint(e.getPoint());
		if ((e.getX() + PADDLE_WIDTH / 2 >= WIDTH)) {
			paddle.setLocation(WIDTH - PADDLE_WIDTH, PADDLE_Y);
		} else if (e.getX() - PADDLE_WIDTH / 2 <= 0) {
			paddle.setLocation(0, PADDLE_Y);
		}
	}
	
	private void createBall() {
		ball = new GOval(2 * BALL_RADIUS, 2 * BALL_RADIUS);
		ball.setFilled(true);
		add(ball, WIDTH / 2 - BALL_RADIUS, HEIGHT / 2 - BALL_RADIUS);
		vx = rgen.nextDouble(+1.0, +3.0);
		if(rgen.nextBoolean()) vx = -vx;
		vy = +3.0;
	}
	
	private void setupScore() {
		score = new GLabel("Score: 0");
		score.setFont("Times New Roman-24");
		score.setColor(Color.RED);
		add(score, 0, score.getHeight());
	}
	
	private void setupTurns() {
		turns = new GLabel("Turns Left: " + nturns);
		turns.setFont("Times New Roman-24");
		turns.setColor(Color.RED);
		add(turns, WIDTH - turns.getWidth(), turns.getHeight());
	}
	
	private void moveBall() {
		ball.move(vx, vy);
		if(ball.getX() <= 0 || ball.getX() >= WIDTH - 2 * BALL_RADIUS) {
			vx = -vx;
		} else if(ball.getY() <= 0) {
			vy = -vy;
		} else if(ball.getY() >= HEIGHT - 2 * BALL_RADIUS) {
			respawn();
		}
	}
	
	private void respawn() {
		nturns--;
		updateTurns();
		remove(ball);
		if(nturns != 0) {
			createBall();
			pause(2000);
		}
	}
	
	private void checkForCollision() {
		setCollidingObject();
		if(collider != null) {
			if(collider == paddle) {
				vy = -vy;
			} else if(collider != score && collider!= turns){
				remove(collider);
				brick_count--;
				updateScore();
				vy = -vy;
			}
		}
	}
	
	private void setCollidingObject() {
		if(getElementAt(ball.getX(), ball.getY()) != null) {
			collider = getElementAt(ball.getX(), ball.getY());
		} else if(getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY()) != null) {
			collider = getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY());
		} else if(getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS) != null) {
			collider = getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS);
		} else if(getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS) != null) {
			collider = getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS);
		} else {
			collider = null;
		}
	}
	
	private void updateScore() {
		score.setLabel("Score: " + (100 - brick_count));
	}
	
	private void updateTurns() {
		turns.setLabel("Turns Left: " + nturns);
	}
	
	private void displayFinalMessage() {
		GLabel label = new GLabel("");
		label.setFont("Times New Roman-50");
		label.setColor(Color.RED);
		if(nturns == 0) label.setLabel("GAME OVER :(");
		if(brick_count == 0) label.setLabel("YOU WIN!!");
		add(label, WIDTH / 2 - label.getWidth() / 2, HEIGHT / 2);
	}

	
	private GRect brick;
	private GRect paddle;
	private GPoint last;
	private GOval ball;
	private GObject collider;
	private double vx, vy;
	private GLabel score;
	private GLabel turns;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}

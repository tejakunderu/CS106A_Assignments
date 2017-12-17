import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {
	private static final int HEAD_WIDTH = 250;
	private static final int HEAD_HEIGHT = 400;
	private static final int EYE_RADIUS = 25;
	private static final int MOUTH_WIDTH = 150;
	private static final int MOUTH_HEIGHT = 50;
	
	public void run() {
		GRect Head = new GRect(getWidth()/2.0-HEAD_WIDTH/2.0, getHeight()/2.0-HEAD_HEIGHT/2.0, HEAD_WIDTH, HEAD_HEIGHT);
		Head.setFillColor(Color.GRAY);
		Head.setFilled(true);
		add(Head);
		
		GOval Eye1 = new GOval(getWidth()/2.0-HEAD_WIDTH/4.0-EYE_RADIUS, getHeight()/2.0-HEAD_HEIGHT/4.0-EYE_RADIUS, EYE_RADIUS*2, EYE_RADIUS*2);
		GOval Eye2 = new GOval(getWidth()/2.0+HEAD_WIDTH/4.0-EYE_RADIUS, getHeight()/2.0-HEAD_HEIGHT/4.0-EYE_RADIUS, EYE_RADIUS*2, EYE_RADIUS*2);
		Eye1.setColor(Color.YELLOW);
		Eye1.setFilled(true);
		Eye2.setColor(Color.YELLOW);
		Eye2.setFilled(true);
		add(Eye1); add(Eye2);
		
		GRect Mouth = new GRect(getWidth()/2.0-MOUTH_WIDTH/2.0, getHeight()/2.0+HEAD_HEIGHT/4.0-MOUTH_HEIGHT/2.0, MOUTH_WIDTH, MOUTH_HEIGHT);
		Mouth.setColor(Color.WHITE);
		Mouth.setFilled(true);
		add(Mouth);
	}
}

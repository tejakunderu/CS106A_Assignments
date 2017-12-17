import acm.program.*;
import acm.graphics.*;
import acm.util.*;

public class RandomCircle extends GraphicsProgram {
	
	private static final int NCIRCLES = 10;
	private static final double MIN_RADIUS = 5;
	private static final double MAX_RADIUS = 50;
	
	public void run() {
		for (int i = 0; i < NCIRCLES; i++) {
			double radius = rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
			double x = rgen.nextDouble(0, getWidth() - 2 * radius);
			double y = rgen.nextDouble(0, getHeight() - 2 * radius);
			
			GOval circle = new GOval (2 * radius, 2 * radius);
			circle.setFilled(true);
			circle.setColor(rgen.nextColor());
			
			add(circle, x, y);
		}
	}

	private RandomGenerator rgen = RandomGenerator.getInstance();
}

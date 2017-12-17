import acm.graphics.*;
import acm.util.*;
import acm.program.*;

public class ColorChangingSquare extends GraphicsProgram {
	
	private static final int SQ_SIZE = 100;
	private static final int PAUSE_TIME = 100;
	
	public void run() {
		GRect sq = new GRect(getWidth()/2-SQ_SIZE/2, getHeight()/2-SQ_SIZE/2, SQ_SIZE, SQ_SIZE);
		sq.setFilled(true);
		add(sq);
		while(true){
			sq.setColor(rgen.nextColor());
			pause(PAUSE_TIME);
		}
	}

	private RandomGenerator rgen = RandomGenerator.getInstance();
	
}

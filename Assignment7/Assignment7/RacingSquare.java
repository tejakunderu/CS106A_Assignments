import java.awt.Color;

import acm.graphics.*;
import acm.util.*;

public class RacingSquare extends GRect implements Runnable {
	
	public RacingSquare(int index, boolean[] finished) {
		super(SIZE, SIZE);
		setFilled(true);
		myIndex = index;
		finishers = finished;
	}
	
	public void run() {
		finishers[myIndex] = false;
		for(int i = 0; i < 1500; i++) {
			pause(rgen.nextDouble(1, 5));
			move(STEP, 0);
		}
		int count = 0;
		for(int i = 0; i < finishers.length; i++)
			if(finishers[i]) 
				count++;
		finishers[myIndex] = true;
		if(count == 0)
			setColor(Color.RED);
	}
	
	private static final int SIZE = 80;
	private static final double STEP = 1;
	
	private int myIndex;
	private boolean[] finishers;
	private RandomGenerator rgen = RandomGenerator.getInstance();

}

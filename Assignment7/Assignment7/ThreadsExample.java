import acm.program.*;
import acm.graphics.*;
import javax.swing.*;
import java.awt.event.*;

public class ThreadsExample extends GraphicsProgram {
	
	public void init() {
		racers = new RacingSquare[NUM_RACERS];
		finished = new boolean[NUM_RACERS];
		threads = new Thread[NUM_RACERS];
		
		add(new JButton("Start!"), SOUTH);
		addActionListeners();
		add(new GLine(1620, 0, 1620, 1000));
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Start!")) {
			for(int i = 0; i < NUM_RACERS; i++) {
				if(racers[i] != null)
					remove(racers[i]);
				racers[i] = new RacingSquare(i, finished);
				add(racers[i], 40, 20 + 90 * i);
				threads[i] = new Thread(racers[i]);
				threads[i].start();
			}
		}
		
	}

	private static final int NUM_RACERS = 10;
	
	private RacingSquare[] racers;
	private boolean[] finished;
	private Thread[] threads;
}

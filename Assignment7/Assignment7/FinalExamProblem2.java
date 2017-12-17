import acm.graphics.*;
import acm.program.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FinalExamProblem2 extends GraphicsProgram {
	
	private static final int STEP = 20;
	
	public void init() {
		createInteractors();
		createCross();
		currentX = getWidth() / 2;
		currentY = getHeight()/ 2;
		add(cross, currentX, currentY);
		addActionListeners();
	}
	
	private void createInteractors() {
		add(new JButton("North"), SOUTH);
		add(new JButton("South"), SOUTH);
		add(new JButton("East"), SOUTH);
		add(new JButton("West"), SOUTH);
	}
	
	private void createCross() {
		GLine line1 = new GLine(-5, -5, 5, 5);
		GLine line2 = new GLine(5, -5, -5, 5);
		cross = new GCompound();
		cross.add(line1);
		cross.add(line2);
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("North")) {
			moveCross(0, -STEP);
		} else if(cmd.equals("South")) {
			moveCross(0, STEP);
		} else if(cmd.equals("East")) {
			moveCross(STEP, 0);
		} else if(cmd.equals("West")) {
			moveCross(-STEP, 0);
		}
	}
	
	private void moveCross(int x, int y) {
		cross.move(x, y);
		GLine line = new GLine(currentX, currentY, currentX + x, currentY + y);
		line.setColor(Color.RED);
		add(line);
		currentX += x;
		currentY += y;
	}
	
	private GCompound cross;
	private int currentX;
	private int currentY;
	
}

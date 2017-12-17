import acm.program.*;
import acm.graphics.*;
import java.util.*;
import java.awt.event.*;


public class LabelList extends GraphicsProgram {
	
	private static final double START_X = 50;
	private static final double START_Y = 100;
	
	public void run() {
		addMouseListeners();
	}
	
	public void mouseClicked(MouseEvent e) {
		GLabel label = new GLabel("# " + labelList.size());
		label.setFont("Courier-18");
		
		double dy = label.getHeight();
		
		for(int i = 0; i < labelList.size(); i++) {
			labelList.get(i).move(0, dy);
		}
		
		add(label, START_X, START_Y);
		labelList.add(label);
	}

	private ArrayList<GLabel> labelList = new ArrayList<GLabel>();
}

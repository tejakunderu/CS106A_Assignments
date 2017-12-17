import acm.program.*;
import acm.graphics.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TextAndGraphics extends ConsoleProgram {
	
	private static final int SPACE = 5;
	private static final int RECT_WIDTH = 50;
	private static final int RECT_HEIGHT = 20;
	
	public void init() {
		setLayout(new GridLayout(1, 3));
		
		leftCanvas = new GCanvas();
		add(leftCanvas);
		
		rightCanvas = new GCanvas();
		add(rightCanvas);
		
		text = new JTextField(10);
		add(new JLabel("Some text "), SOUTH);
		add(text, SOUTH);
		text.addActionListener(this);
		
		add(new JButton("Draw Left"), SOUTH);
		add(new JButton("Draw Right"), SOUTH);
		
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == text)
			println("You typed: " + text.getText());
		String cmd = e.getActionCommand();
		if(cmd.equals("Draw Left")) {
			leftCanvas.add(createNewRect(), 20, leftY);
			leftY += SPACE + RECT_HEIGHT;
		} else if(cmd.equals("Draw Right")) {
			rightCanvas.add(createNewRect(), 20, rightY);
			rightY += SPACE + RECT_HEIGHT;
		}
	}
	
	private GRect createNewRect() {
		GRect rect = new GRect(RECT_WIDTH, RECT_HEIGHT);
		rect.setFilled(true);
		//rect.setFillColor(Color.RED);
		return rect;
	}

	private GCanvas leftCanvas;
	private GCanvas rightCanvas;
	private JTextField text; 
	
	private double leftY = SPACE;
	private double rightY = SPACE;
	
}

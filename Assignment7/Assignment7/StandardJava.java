import java.awt.Font;

import javax.swing.*;

public class StandardJava {
	
	public static void main(String[] args) {
		graphicalHello();
		consoleHello();
		interactiveHello();
	}
	
	private static void graphicalHello() {
		JFrame frame = new JFrame("Graphical Hello");
		JLabel label = new JLabel("Hello World!",
							JLabel.CENTER);
		Font labelFont = label.getFont();
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 56));
		frame.add(label);
		frame.setSize(2000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private static void consoleHello() {
		System.out.println("Hello World!");
	}
	
	private static void interactiveHello() {
		JFrame frame = new JFrame("Interactive Hello");
		frame.add(new MovingLabel("CS106A sucks!", 800, 500));
		frame.setSize(2000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

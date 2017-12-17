import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldExample extends ConsoleProgram {
	
	public void run() {
		add(new JLabel("Enter text: "), SOUTH);
		tf = new JTextField(10);
		tf.setActionCommand("name");
		add(tf, SOUTH);
		tf.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(tf == e.getSource())
			println("Hello, " + tf.getText());
		if(e.getActionCommand().equals("name"))
			println("Hi, " + tf.getText());
	}
	
	
	private JTextField tf;

}

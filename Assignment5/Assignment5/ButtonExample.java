import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonExample extends ConsoleProgram {
	
	public void init() {
		add(new JButton("Hi"), SOUTH);
		add(new JButton("Bye"), NORTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Hi"))
			println("Hello");
		else if(e.getActionCommand().equals("Bye"))
			println("F off");
	}

}

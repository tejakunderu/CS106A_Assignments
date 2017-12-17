import acm.program.*;
import javax.swing.*;
import java.awt.event.*;
import acm.gui.*;

public class TemperatureConversion extends Program {
	
	public void init() {
		setLayout(new TableLayout(3, 3));
	
		fah = new IntField(10);
		fah.setActionCommand("F -> C");
		fah.addActionListener(this);
	
		cel = new IntField(10);
		cel.setActionCommand("C -> F");
		cel.addActionListener(this);
		
		add(new JLabel("Degrees Fahrenheit "));
		add(fah);
		add(new JButton("F -> C"));
		
		add(new JLabel("Degrees Celcius "));
		add(cel);
		add(new JButton("C -> F"));
		
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("F -> C"))
			convertToCelcius();
		else if(e.getActionCommand().equals("C -> F"))
			convertToFahrenheit();
	}
	
	private void convertToCelcius() {
		int f = fah.getValue();
		int c = (5 * (f - 32) / 9);
		cel.setValue(c);
	}
	
	private void convertToFahrenheit() {
		int c = cel.getValue();
		int f = (9 * c / 5 + 32);
		fah.setValue(f);
	}
	
	IntField fah;
	IntField cel;

}

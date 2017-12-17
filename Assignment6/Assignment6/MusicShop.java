import acm.program.*;
import javax.swing.*;
import java.awt.event.*;

public class MusicShop extends Program {
	
	public void init() {
		createInteractors();
		data = new MusicDataBase("music-data.txt");
		display = new MusicDataDisplay();
		add(display);
		addActionListeners();
	}
	
	private void createInteractors() {
		textField = new JTextField(30);
		add(new JLabel("Album Name "), SOUTH);
		add(textField, SOUTH);
		textField.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == textField) {
			String str = textField.getText();
			Album currentAlbum = data.getAlbumFromName(str.toLowerCase());
			display.printAlbumData(currentAlbum);
		}
	}
	
	private JTextField textField;
	private MusicDataBase data;
	private MusicDataDisplay display;
}

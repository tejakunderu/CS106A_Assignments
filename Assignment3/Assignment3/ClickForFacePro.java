import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ClickForFacePro extends GraphicsProgram {
	
	private static final int SMALL_FACE_DIAM = 33;
	private static final int MEDIUM_FACE_DIAM = 66;
	private static final int LARGE_FACE_DIAM = 100;
	
	public void init() {
		initGUI();
		
		addActionListeners();
		addMouseListeners();
	}
	
	private void initGUI() {
		add(new JButton("Clear"), SOUTH);
		
		initOrientation();
		add(orientation, SOUTH);
		
		initSize();
		add(small, SOUTH); add(medium, SOUTH); add(large, SOUTH);
		
		initColor();
		add(new JLabel("    Color: "), SOUTH);
		add(color, SOUTH);
	}
	
	private void initOrientation() {
		orientation = new JCheckBox("Front");
		orientation.setSelected(true);
	}
	
	private void initSize() {
		ButtonGroup size = new ButtonGroup();
		small = new JRadioButton("Small");
		medium = new JRadioButton("Medium");
		large = new JRadioButton("Large");
		size.add(small); size.add(medium); size.add(large);
		large.setSelected(true);
	}
	
	private void initColor() {
		color = new JComboBox();
		color.addItem("Black"); color.addItem("Blue"); color.addItem("Red"); color.addItem("Green");
		color.setEditable(false);
		color.setSelectedItem("Black");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Clear"))
			removeAll();
	}
	
	public void mouseClicked(MouseEvent e) {
		setSize();
		setOrientation();
		setColor();
		
		add(face, e.getX() - face_diam / 2, e.getY() - face_diam / 2);
	}
	
	private void setSize() {
		if(small.isSelected()) 
			face_diam = SMALL_FACE_DIAM;
		else if(medium.isSelected())
			face_diam = MEDIUM_FACE_DIAM;
		else if(large.isSelected())
			face_diam = LARGE_FACE_DIAM;
	}
	
	private void setOrientation() {
		if(orientation.isSelected())
			face = new GFace(face_diam, face_diam);
		else face = new GOval(face_diam, face_diam);
	}
	
	private void setColor() {
		String name = (String)color.getSelectedItem();
		if(name.equals("Black"))
			face.setColor(Color.BLACK);
		else if(name.equals("Blue"))
			face.setColor(Color.BLUE);
		else if(name.equals("Green"))
			face.setColor(Color.GREEN);
		else if(name.equals("Red"))
			face.setColor(Color.RED);
	}
	
	private GObject face;
	private double face_diam;
	
	private JCheckBox orientation;
	
	private JRadioButton small;
	private JRadioButton medium;
	private JRadioButton large;
	
	private JComboBox color;

}

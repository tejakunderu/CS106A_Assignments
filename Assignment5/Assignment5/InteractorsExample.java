import acm.program.*;
import acm.graphics.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class InteractorsExample extends GraphicsProgram {
	
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	
	public void init() {
		objectList = new HashMap<String, GObject>();
		createGUI();
		addActionListeners();
		addMouseListeners();
	}
	
	private void createGUI() {
		textInput = new JTextField(20);
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		clearButton = new JButton("Clear");
		
		textInput.addActionListener(this);
		
		add(new JLabel(), SOUTH);
		add(textInput, SOUTH);
		add(addButton, SOUTH);
		add(removeButton, SOUTH);
		add(clearButton, SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == textInput || source == addButton) {
			addBox(textInput.getText());
		} else if(source == removeButton) {
			removeBox(textInput.getText());
		} else if(source == clearButton) {
			clearObjects();
		}
	}
	
	private void addBox(String name) {
		GCompound box = new GCompound();
		GLabel label = new GLabel(name);
		GRect outline = new GRect(BOX_WIDTH, BOX_HEIGHT);
		box.add(label, - label.getWidth() / 2, label.getAscent() / 2);
		box.add(outline, - BOX_WIDTH / 2, - BOX_HEIGHT / 2);
		add(box, getWidth() / 2, getHeight() / 2);
		objectList.put(name, box);
	}
	
	public void mousePressed(MouseEvent e) {
		last = new GPoint(e.getPoint());
		currentObject = getElementAt(last);
	}
	
	public void mouseDragged(MouseEvent e) {
		if(currentObject != null) {
			currentObject.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}
	
	private void removeBox(String name) {
		GObject object = objectList.get(name);
		if(object != null)
			remove(object);
	}
	
	private void clearObjects() {
		for(String name: objectList.keySet())
			removeBox(name);
		objectList.clear();
	}
	
	public void mouseClicked(MouseEvent e) {
		if(currentObject != null)
			currentObject.sendToFront();
	}
	
	private JTextField textInput;
	private JButton addButton;
	private JButton removeButton;
	private JButton clearButton;
	private GObject currentObject;
	private GPoint last;
	private HashMap<String, GObject> objectList;
}

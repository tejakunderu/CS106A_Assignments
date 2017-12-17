/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {
	
	public static void main(String[] args) {
		new NameSurfer().start(args);
	}

	public void init() {
	    createInteractors();
	    database = new NameSurferDataBase(NAMES_DATA_FILE);
	    graph = new NameSurferGraph();
	    add(graph);
	    addActionListeners();
	}
	
	private void createInteractors() {
		nameEntry = new JTextField(20);
		graphButton = new JButton("Graph");
		clearButton = new JButton("Clear");
		
		add(new JLabel("Name"), SOUTH);
		add(nameEntry, SOUTH);
		add(graphButton, SOUTH);
		add(clearButton, SOUTH);
		nameEntry.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == nameEntry || source == graphButton) {
			String name = nameEntry.getText();
			NameSurferEntry entry = database.findEntry(name);
			if(entry != null) {
				graph.addEntry(entry);
				graph.update();
			}
		} else if(source == clearButton) {
			graph.clear();
			graph.update();
		}
	}
	
	private JTextField nameEntry;
	private JButton graphButton;
	private JButton clearButton;
	private NameSurferDataBase database;
	private NameSurferGraph graph;
}

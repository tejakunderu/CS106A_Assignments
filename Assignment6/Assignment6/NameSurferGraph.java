/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	public NameSurferGraph() {
		addComponentListener(this);
		entries = new ArrayList<NameSurferEntry>();
	}
	
	private void createBackground() {
		createVerticalLines();
		createHorizontalLines();
		createLabels();
	}
	
	private void createVerticalLines() {
		double x = getWidth() / NDECADES;
		for(int i = 0 ; i < NDECADES; i++)
			add(new GLine(i * x, 0, i * x, getHeight()));
	}
	
	private void createHorizontalLines() {
		add(new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE));
		add(new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(), getHeight() - GRAPH_MARGIN_SIZE));
	}
	
	private void createLabels() {
		double x = getWidth() / NDECADES;
		for(int i = 0 ; i < NDECADES; i++) {
			String decade = START_DECADE + i * 10 + "";
			GLabel label = new GLabel(decade);
			add(label, i * x + 5, getHeight() - label.getAscent() / 2);
		}
	}
	
	public void clear() {
		entries.clear();
	}
	
	public void addEntry(NameSurferEntry entry) {
		entries.add(entry);
	}
	
	public void update() {
		removeAll();
		createBackground();
		addAllEntriesToGraph();
	}
	
	private void addAllEntriesToGraph() {
		int count = 0;
		for(NameSurferEntry entry: entries) {
			addSingleEntryToGraph(entry, count);
			count ++;
		}
	}
	
	private void addSingleEntryToGraph(NameSurferEntry entry, int count) {
		double x = getWidth() / NDECADES;
		double y = (double)(getHeight() - 2 * GRAPH_MARGIN_SIZE) / MAX_RANK;
		
		String name = entry.getName();
		String currentLabel = "";
		String pastLabel = "";
		
		for(int i = START_DECADE + 10; i < START_DECADE + 10 * NDECADES; i += 10) {
			int currentY = entry.getRank(i);
			int pastY = entry.getRank(i - 10);
			
			if(currentY == 0) {
				currentY = MAX_RANK;
				currentLabel = "*";
			} else currentLabel = "" + currentY;
			
			if(pastY == 0) {
				pastY = MAX_RANK;
				pastLabel = "*";
			} else pastLabel = "" + pastY;

			int lineNum = (i - START_DECADE) / 10;
			GLine line = new GLine(x * (lineNum - 1), y * pastY + GRAPH_MARGIN_SIZE, x * lineNum, y * currentY + GRAPH_MARGIN_SIZE);
			GLabel label1 = new GLabel(name + " " + currentLabel, x * lineNum, y * currentY + GRAPH_MARGIN_SIZE);
			GLabel label2 = new GLabel(name + " " + pastLabel, x * (lineNum - 1), y * pastY + GRAPH_MARGIN_SIZE);
			line.setColor(getColor(count));
			label1.setColor(getColor(count));
			label2.setColor(getColor(count));
			
			add(line); add(label1); add(label2);
		}
	}
	
	private Color getColor(int count) {
		count = count % 4;
		switch(count) {
		case 0: return Color.BLACK;
		case 1: return Color.RED;
		case 2: return Color.BLUE;
		case 3: return Color.MAGENTA;
		default: return Color.BLACK;
		}
	}
	
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	private ArrayList<NameSurferEntry> entries;
}

/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	private static final int box_width = 120;
	private static final int box_height = 40;
	
	public void run() {
		add(new GRect((getWidth()-box_width)/2, getHeight()/5, box_width, box_height));
		add(new GRect(getWidth()/5-box_width/2, getHeight()/2, box_width, box_height));
		add(new GRect((getWidth()-box_width)/2, getHeight()/2, box_width, box_height));
		add(new GRect(getWidth()*(4.0/5)-box_width/2, getHeight()/2, box_width, box_height));
		
		add(new GLine(getWidth()/2, getHeight()/5+box_height, getWidth()/5, getHeight()/2));
		add(new GLine(getWidth()/2, getHeight()/5+box_height, getWidth()/2, getHeight()/2));
		add(new GLine(getWidth()/2, getHeight()/5+box_height, getWidth()*(4.0/5), getHeight()/2));
		
		GLabel La1 = new GLabel("Program");
		La1.setLocation(getWidth()/2-La1.getWidth()/2, getHeight()/5+box_height/2+La1.getAscent()/2);
		GLabel La2 = new GLabel("GraphicsProgram");
		La2.setLocation(getWidth()/5-La2.getWidth()/2, getHeight()/2+box_height/2+La2.getAscent()/2);
		GLabel La3 = new GLabel("ConsoleProgram");
		La3.setLocation(getWidth()/2-La3.getWidth()/2, getHeight()/2+box_height/2+La3.getAscent()/2);
		GLabel La4 = new GLabel("DialogProgram");
		La4.setLocation(getWidth()*(4/5.0)-La4.getWidth()/2, getHeight()/2+box_height/2+La4.getAscent()/2);
		
		add(La1); add(La2); add(La3); add(La4);
		
	}
}


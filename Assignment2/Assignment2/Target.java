/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {
	private static final int inch = 72;
	
	public void run() {
		double r[] = {inch, 0.65*inch, 0.3*inch};
		for(int i=0; i<3; i++){
			double x = (getWidth()/2)-r[i];
			double y = (getHeight()/2)-r[i];
			GOval target = new GOval(x,y,2*r[i],2*r[i]);
			if(i%2==0){
				target.setFillColor(Color.RED);
			} else {
				target.setFillColor(Color.WHITE);
			}
			target.setFilled(true);
			add(target);
		}
	}
}

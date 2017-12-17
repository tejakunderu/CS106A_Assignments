import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class GProgram extends GraphicsProgram {
	public void run() {
		GLabel label = new GLabel("hello", 100, 75);
		add(label);
		waitFor(1000);
		label.setColor(Color.RED);
		waitFor(1000);
		label.move(-100, 35);
		label.setFont("SansSerif-BOLDITALIC-36");
		waitFor(1000);
		GRect rectangle = new GRect(200,100);
		rectangle.setLocation(0,110);
		add(rectangle);
		rectangle.setColor(Color.MAGENTA);
		rectangle.setFillColor(Color.BLUE);
		rectangle.setFilled(true);
		
	}
	
	public void waitFor(int x){
		try {
			Thread.sleep(x);
		} catch(InterruptedException ex) {}
	}
}
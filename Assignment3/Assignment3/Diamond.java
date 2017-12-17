import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Diamond extends GraphicsProgram {
	
	public void run() {
		GPolygon diamond = createDiamond(200, 200);
		diamond.setFilled(true);
		diamond.setFillColor(Color.MAGENTA);
		add(diamond, getWidth() / 2, getHeight() / 2);
	}
	
	private GPolygon createDiamond(double width, double height) {
		GPolygon diamond = new GPolygon();
		diamond.addVertex(-width / 2, 0);
		diamond.addVertex(0, -height / 2);
		diamond.addVertex(width / 2, 0);
		diamond.addVertex(0, height / 2);
		return diamond;
	}
}

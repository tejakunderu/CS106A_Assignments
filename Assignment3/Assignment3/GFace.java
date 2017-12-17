import acm.graphics.*;

public class GFace extends GCompound {
	
	private static final double EYE_WIDTH = 0.15;
	private static final double EYE_HEIGHT = 0.15;
	private static final double NOSE_WIDTH = 0.15;
	private static final double NOSE_HEIGHT = 0.15;
	private static final double MOUTH_WIDTH = 0.50;
	private static final double MOUTH_HEIGHT = 0.03;
	
	public GFace(double width, double height) {
		head = new GOval(width, height);
		leftEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		rightEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		nose = createNose(NOSE_WIDTH * width, NOSE_HEIGHT * height);
		mouth = new GRect(MOUTH_WIDTH * width, MOUTH_HEIGHT * height);
		
		add(head, 0, 0);
		add(leftEye, (width / 4 - EYE_WIDTH * width / 2), (height / 4 - EYE_HEIGHT * height / 2));
		add(rightEye, (width * 3 / 4 - EYE_WIDTH * width / 2), (height / 4 - EYE_HEIGHT * height / 2));
		add(nose, width / 2, height / 2);
		add(mouth, (width / 2 - MOUTH_WIDTH * width / 2), (height * 3 / 4 - MOUTH_HEIGHT * height / 2));
	}
	
	private GPolygon createNose(double width, double height) {
		GPolygon nose = new GPolygon();
		nose.addVertex(0, - height / 2);
		nose.addVertex(width / 2, height / 2);
		nose.addVertex(- width / 2, height / 2);
		return nose;
	}
	
	private GOval head;
	private GOval leftEye, rightEye;
	private GPolygon nose;
	private GRect mouth;
}

import acm.program.*;

public class DrawFace extends GraphicsProgram {
	
	private static final int FACE_WIDTH = 150;
	private static final int FACE_HEIGHT = 200;
	
	public void run() {
		GFace face = new GFace(FACE_WIDTH, FACE_HEIGHT);
		add(face, getWidth() / 2 - FACE_WIDTH / 2, getHeight() / 2 - FACE_HEIGHT / 2);
	}
}

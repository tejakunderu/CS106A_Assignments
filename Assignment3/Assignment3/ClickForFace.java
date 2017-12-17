import acm.program.*;
import java.awt.event.*;

public class ClickForFace extends GraphicsProgram {
	
	private static final int FACE_DIAM = 100;
	
	public void init() {
		addMouseListeners();
	}
	
	public void mouseClicked(MouseEvent e) {
		GFace face = new GFace(FACE_DIAM, FACE_DIAM);
		add(face, e.getX() - FACE_DIAM / 2, e.getY() - FACE_DIAM / 2);
	}

}

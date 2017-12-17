import acm.graphics.*;
import acm.program.*;

public class GreyImage extends GraphicsProgram {
	
	public void run() {
		GImage kimi = new GImage("Yawn.jpg");
		GImage greyKimi = createGreyImage(kimi);
		
		kimi.scale(0.8, 1);
		add(kimi, getWidth() / 2 - kimi.getWidth(), 0);
		
		greyKimi.scale(0.8, 1);
		add(greyKimi, getWidth() / 2, 0);
	}
	
	private GImage createGreyImage(GImage image) {
		int[][] array = image.getPixelArray();
		
		int height = array.length;
		int width = array[0].length;
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				int pixel = array[i][j];
				
				int r = GImage.getRed(pixel);
				int g = GImage.getGreen(pixel);
				int b = GImage.getBlue(pixel);
				
				int gpixel = computeLumosity(r, g, b);
				
				array[i][j] = GImage.createRGBPixel(gpixel, gpixel, gpixel);
			}
		}
		
		return new GImage(array);
	}
	
	private int computeLumosity(int r, int g, int b) {
		return GMath.round(0.3 * r + 0.59 * g + 0.11 * b);
	}

}

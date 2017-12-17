import acm.program.*;
import acm.graphics.*;

public class FlipHorizontal extends GraphicsProgram {
	
	public void run() {
		GImage kimi = new GImage("Yawn.jpg");
		GImage flippedKimi = flipHorizontal(kimi);
		
		kimi.scale(0.8, 1);
		add(kimi, getWidth() / 2 - kimi.getWidth(), 0);
		
		flippedKimi.scale(0.8, 1);
		add(flippedKimi, getWidth() / 2, 0);
	}
	
	private GImage flipHorizontal(GImage image) {
		int[][] array = image.getPixelArray();
		
		int height  = array.length;
		int width = array[0].length;
		
		int[][] flippedArray = new int[height][width];
		
		for(int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				flippedArray[i][width - 1 - j] = array[i][j];
		
		return new GImage(flippedArray);
	} 

}

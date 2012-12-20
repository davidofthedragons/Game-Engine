package engine;

import java.awt.*;

import javax.swing.*;

public final class GLibrary {
	
	private static long nextID=1000000l;

	public static Image loadImage(String fileName) {
		return new ImageIcon(fileName).getImage();
	}
	
	public static long retrieveID() {
		long id = nextID;
		nextID++;
		return id;
	}
	
	
	//Put somewhere else or get rid of entirely.
	@SuppressWarnings("unused")
	private class AFrame {
		
		Image image;
		int delay;
		
		public AFrame(Image img, int dly) {
			image = img; delay=dly;
		}
		public Image getImage() {
			return image;
		}
		public int getDelay() {
			return delay;
		}
	}
}

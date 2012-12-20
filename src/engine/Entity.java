package engine;

import java.awt.*;
import java.util.ArrayList;

public class Entity {

	ArrayList<Image> frames = new ArrayList<Image>();
	int frameCount = 0;
	
	private double x, y;
	private double delX=1, delY=1;
	//private double delX=0, delY=0;
	Direction xDir = Direction.NOT_MOVING;
	Direction yDir = Direction.NOT_MOVING;
	private double speed;
	private double angle;
	private boolean visible = true;
	private long ID;
	private String type;
	//private boolean player = false;
	
	public Entity(int x, int y, double speed, String type) {
		this.x=x; this.y=y; this.speed=speed;
		this.type=type.trim();
		delX=speed; delY=speed;
		ID = GLibrary.retrieveID();
	}
	
	public long getID() {return ID;}
	
	public String getType() {
		return type;
	}
	
	public void addFrame(Image image) {
		frames.add(image);
	}
	
	public void update() {
		if(frameCount==frames.size()-1) frameCount=0;
		else frameCount++;
		x+=delX; y+=delY;
	}
	
	public void rotate(double rotAngle) {
		if(angle+rotAngle<360) {
			angle += rotAngle;
		}
		else{
			angle = angle+rotAngle-360;
		}
		delY = Math.tan(angle)*speed;
	}
	
	
	public void draw(Graphics g) {
		if (visible) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.rotate(angle, x + frames.get(frameCount).getWidth(null) / 2, y
					+ frames.get(frameCount).getHeight(null) / 2);
			g2d.drawImage(frames.get(frameCount), (int) x, (int) y, null);
			g2d.rotate(-angle, x + frames.get(frameCount).getWidth(null) / 2, y
					+ frames.get(frameCount).getHeight(null) / 2);
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, frames.get(frameCount).getWidth(null), 
				frames.get(frameCount).getHeight(null));
		
	}
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean v) {
		visible=v;
	}
	public void toggleVisible() {
		if(visible) visible=false;
		else visible=true;
	}
	
	public Point getCenter() {
		return new Point(frames.get(frameCount).getWidth(null), 
				frames.get(frameCount).getHeight(null));
	}
	
	public void onKey(int keyCode) {}
	
	public String toString() {
		return "Entity ID " + ID + " Type '" + type + "'";
	}
	
}

/*Game Engine
 * David Gardner 
 * Updated 091212
 * 
 * Extend this class to begin. 
 * Extend entity to define game types. All entities will be stored internally 
 * though an ArrayList of specific entities can be retrieved by type.
 * 
 * All Entities are automatically given a unique long ID number 
 * on instantiation that can be used to retrieve them individually.
 * Entities also are given a user-specified type. The method getEntities(String type); will 
 * return an ArrayList of all Entities that were initialized with that type. 
 * 
 * GLibrary contains a library of useful game functions. 
 * 
 * 
 * To-Do list
 * -Fix Images ( use ImageObserver :P ) or BufferedImage!
 * -Add movement (attach an entity to mouse/keyboard/mouse and keyboard inputs).
 * -Allow player entity to receive key (or mouse) events not intended for movement.
 * -Add mouse only movement?
 * -Add option to turn rotation off?
 * -Provide for swing components... Extend JPanel instead???
 * -Add delays to animation frames. 
 * -Test!!!
*/
package engine;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Control extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public int SCREENX, SCREENY;
	
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private Image background;
	private Color bgColor = Color.WHITE;
	
	private int frameRate = 10;
	
	private Timer timer = new Timer(frameRate, this);
	protected boolean running = false;
	
	private long player = 0;
	
	public Control(int sizeX, int sizeY, String title) {
		super(title);
		SCREENX=sizeX; SCREENY=sizeY;
		setSize(SCREENX, SCREENY);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setFrameRate(int rate) {
		frameRate = rate;
		timer.setDelay(frameRate);
	}
	
	public void start() {
		timer.start();
		running = true;
	}
	public void pause() {
		timer.stop();
		running = false;
	}
	public void togglePause() {
		if(running) {
			timer.stop();
			running = false;
		}
		else {
			timer.start();
			running = true;
		}
	}
	
	public void setBackground(Image bgImage) {
		background = bgImage;
	}
	public void setBackground(Color color) {
		bgColor = color;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (background==null) {
			g.setColor(bgColor);
			g.fillRect(0, 0, SCREENX, SCREENY);
			g.setColor(Color.BLACK);
		}
		else {
			g.drawImage(background, 0, 0, null);
		}
		for(int i=0; i<entities.size(); i++) {
			entities.get(i).draw(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for(int i=0; i<entities.size(); i++) {
			entities.get(i).update();
		}
		repaint();
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	public Entity getEntity(int index) {
		return entities.get(index);
	}
	public Entity getEntity(long ID) {
		for (int i=0; i<entities.size(); i++) {
			if(entities.get(i).getID()==ID) {
				return entities.get(i);
			}
		}
		return null;
	}
	public ArrayList<Entity> getEntities(String type) {
		ArrayList<Entity> typeEntities = new ArrayList<Entity>();
		for(int i=0; i<entities.size(); i++) {
			if(entities.get(i).getType().equals(type)) {
				typeEntities.add(entities.get(i));
			}
		}
		return typeEntities;
	}
	public void removeEntity(long ID) {
		for (int i=0; i<entities.size(); i++) {
			if(entities.get(i).getID()==ID) {
				entities.remove(i);
				return;
			}
		}
	}
	
	public boolean collides(Entity e1, Entity e2) {
		if(e1.getBounds().intersects(e2.getBounds())) return true;
		else return false;
		
	}
	
	public void addKeyNavagator(long playerID, boolean arrowKeys) {
		
	}
	
	public void addKeyMouseNavagator(long playerID, boolean arrowKeys) {
		
	}
	
	private class KL extends KeyAdapter{
		public KL() {
			
		}
		
	}
	
	private class KML implements KeyListener, MouseMotionListener, MouseListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	

	
}

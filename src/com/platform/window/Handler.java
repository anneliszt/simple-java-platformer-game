package com.platform.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.platform.framework.GameObject;
import com.platform.framework.ObjectID;
import com.platform.objects.Block;
import com.platform.objects.Flag;
import com.platform.objects.Player;

import com.platform.objects.Spikes;

/**
 * Handles the creation of levels
 */
public class Handler {
	
	public ArrayList<GameObject> object = new ArrayList<GameObject>();						// Array list for game object
	
	private GameObject tempObject;															
	private Camera cam;
	
	private BufferedImage level1 = null, level2 = null, level3 = null;
	
	/**
	 * Constructor
	 * @param cam camera object
	 */
	public Handler(Camera cam) {
		this.cam = cam;
		
		BufferedImageLoader loader = new BufferedImageLoader();		
		level1 = loader.loadImage("/bgLevel1.png"); // Loads images
		level2 = loader.loadImage("/bgLevel2.png");
		level3 = loader.loadImage("/bgLevel3.png"); 
		
		loadImageLevel(level1);	
	}
	
	/**
	 * Traverses through the list, updates it and determines the number of ticks
	 */
	public void tick() {
		for(int i=0; i<object.size(); i++) {
			tempObject = object.get(i);
			tempObject.tick(object);
		}
	}
	
	/**
	 * Traverses through the list, updates and renders it
	 * @param g tool that draws onto the component
	 */
	public void render(Graphics g) {
		for(int i=0; i<object.size(); i++) {
			tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	/**
	 * Loads the images for each level
	 * @param image image layout for the levels
	 */
	public void loadImageLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx=0; xx<h; xx++) {
			for(int yy=0; yy<w; yy++) { 											
				
				// Returns an integer pixel in the default RGB color model in order to get RBG values
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8 & 0xff);
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 255 & blue == 255) { 						// Tiles
					addObject(new Block(xx*32, yy*32, 0, ObjectID.Block));
				}
				
				if(red == 255 && green == 0 & blue == 0) { 							// Tiles
					addObject(new Block(xx*32, yy*32, 1, ObjectID.Block));
				}
				
				if(red == 247 && green == 0 & blue == 185) { 						// Can Texture
					addObject(new Block(xx*32, yy*32, 2, ObjectID.Block));
				}
				
				if(red == 255 && green == 255 & blue == 0) { 						// Can Texture
					addObject(new Block(xx*32, yy*32, 3, ObjectID.Block));
				}
				
				if(red == 157 && green == 0 & blue == 255) { 						// Flag Goal
					addObject(new Flag(xx*32, yy*32, 0,  ObjectID.Flag));
				}
				
				if(red == 0 && green == 255 & blue == 0) { 							// Flag Exit
					addObject(new Flag(xx*32, yy*32, 1,  ObjectID.Flag));
				}
				
				if (red == 0 && green == 234 & blue == 255) { 						// Spike
					addObject(new Spikes(xx * 32, yy * 32, 0, ObjectID.Spikes));
				}
				
				if(red == 0 && green == 0 & blue == 255) { 							// Player
					addObject(new Player(xx*32, yy*32, this, cam, ObjectID.Player));
				}
			}
		}
	}
	
	/**
	 * Switches level
	 */
	public void switchLevel() {
		clearLevel();																// Clear level
		cam.setX(0);																// Reset camera
		
		switch(Game.LEVEL) {
			case 1: loadImageLevel(level2); break;
			case 2: loadImageLevel(level3);	break;
			case 3: Game.State = Game.STATE.OUTRO; break;	
		}
		Game.LEVEL++;																// Increment game level
	}
	
	public void reset() {
		clearLevel();
		cam.setX(0);
		
		switch(Game.LEVEL) {
			case 1: loadImageLevel(level1); break;
			case 2: loadImageLevel(level2); break;
			case 3: loadImageLevel(level3); break;
		}
	}
	
	/**
	 * Creates a blank slate
	 */
	private void clearLevel() {
		object.clear();
	}
	
	/**
	 * Adds object
	 * @param object object
	 */
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	/**
	 * Removes object
	 * @param object object
	 */
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}

package com.platform.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Performs all necessary animations for the player sprite
 */
public class Animation {
	
	private int speed;
	private int frames;
	
	private int index = 0;
	private int count = 0;
	
	private BufferedImage[] images;
	private BufferedImage currentImg;
	
	/**
	 * Constructor
	 * @param speed speed of the animation
	 * @param args
	 */
	public Animation(int speed, BufferedImage... args) { 				// Can get infinite amount of parameters
		this.speed = speed;
		images = new BufferedImage[args.length];
		
		for(int i=0; i<args.length; i++) {
			images[i] = args[i]; 
		}
		frames = args.length;
	}
	
	/**
	 * Performs running animation
	 */
	public void runAnimation() {
		index++;
		if(index>speed) {
			index = 0;
			nextFrame();												// Calls on next frame
		}
	}
	
	/**
	 * Gets image on next frame
	 */
	private void nextFrame() {
		count++;
        if(count==frames){
            count = 0;
        }
        currentImg = images[count];
	}
	
	/**
	 * Draws the animation
	 * @param g tool that draws onto the component
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public void drawAnimation(Graphics g, int x, int y) {
		g.drawImage(currentImg, x, y, null);
	}
	
	/**
	 * Draws the animation
	 * @param g tool that draws onto the component
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param scaleX scale of width
	 * @param scaleY scale of height
	 */
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
		g.drawImage(currentImg, x, y, scaleX, scaleY, null);
	}

}

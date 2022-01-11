package com.platform.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Shows the ending of the game or its outro
 */
public class Outro {
    
	public BufferedImage bgImg = null;
	
	/**
	 * Renders the appearance for the outro
	 * @param g tool that draws onto the component
	 */
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		// Loads images
		BufferedImageLoader loader = new BufferedImageLoader();
		bgImg = loader.loadImage("/bgOutro.png");
		
		// Draw images
		g2d.drawImage(bgImg, 0, 0, Game.WIDTH, Game.HEIGHT, null);
	}
}
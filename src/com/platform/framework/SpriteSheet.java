package com.platform.framework;

import java.awt.image.BufferedImage;

/**
 * Divides the image into sub images
 */
public class SpriteSheet {
	
	private BufferedImage image;
	
	/**
	 * Constructor
	 * @param image image
	 */
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}
	
	/** 
	 * Grabs the necessary sub image according to x & y coordinate and width & height.
	 * @param col column number of the sub image
	 * @param row row number of the sub image
	 * @param width width of the sub image
	 * @param height height of the sub image
	 * @return sub image
	 */
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage((col*width)-width, (row*height)-height, width, height);
		return img;
	}

}

package com.platform.window;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Returns the image being loaded
 */
public class BufferedImageLoader {
	
	private BufferedImage image;
	
	/**
	 * Loads the image
	 * @param path the file path on where to get the image
	 * @return loaded image
	 */
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
		}
		return image;
	}
}

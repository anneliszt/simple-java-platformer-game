package com.platform.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Outro {
    
    /**
     * IMPLEMENT DISPOSE AFTER CLOSE
     */
	public BufferedImage bg = null, bgImg = null;
	public Rectangle startButton = new Rectangle(Game.WIDTH/2-170 + 120, 350, 100, 50);
	public Rectangle exitButton = new Rectangle(Game.WIDTH/2-170 + 120, 420, 100, 50);
	
	Font customFont;
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		bgImg = loader.loadImage("/bgOutro.png");

		g.setColor(Color.black);
		g2d.drawImage(bgImg, 0, 0, Game.WIDTH, Game.HEIGHT, null);
	}
}
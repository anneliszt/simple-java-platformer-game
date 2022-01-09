package com.platform.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Intro implements MouseListener{
	
	public BufferedImage bgImg = null, button = null;
	public Rectangle contButton = new Rectangle(450, -50, Game.WIDTH, Game.HEIGHT);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		BufferedImageLoader loader = new BufferedImageLoader();

		bgImg = loader.loadImage("/bgIntro.png");
		button = loader.loadImage("/introForeground.png");
		
		g2d.drawImage(bgImg, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g2d.drawImage(button, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		/**
		 public Rectangle contButton = new Rectangle(450, -50, Game.WIDTH, Game.HEIGHT);
	
		 */
		
		if(mx > 450) {
			if(my >= -50) {
				// Pressed play button
				Game.State = Game.STATE.GAME;
			}
		}
	}
	

	public void mouseReleased(MouseEvent e) {
	}


	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}

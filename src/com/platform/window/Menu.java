package com.platform.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Shows the main menu of the game with the options to start and exit
 */
public class Menu implements MouseListener{
	
	public BufferedImage bg = null, bgImg = null;
	public Rectangle startButton = new Rectangle(Game.WIDTH/2-170 + 120, 350, 100, 50);
	public Rectangle exitButton = new Rectangle(Game.WIDTH/2-170 + 120, 420, 100, 50);
	
	Font customFont;
	
	/**
	 * Renders the appearance for the main menu
	 * @param g tool that draws onto the component
	 */
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		bg = loader.loadImage("/menuTitle.png");
		bgImg = loader.loadImage("/menuBG.png");
		
		try {
	        customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Minecraft.ttf")).deriveFont(30f);
	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(customFont);
	    }
	    catch (IOException | FontFormatException e) {
	        e.printStackTrace();
	    }

		g.setFont(customFont);
		g.setColor(Color.black);
		g2d.drawImage(bgImg, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g2d.drawImage(bg, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		
		g.drawString("Start", startButton.x+20, startButton.y+30);
		g.drawString("Exit", exitButton.x+20, exitButton.y+30);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= Game.WIDTH/2-170 + 120 && mx <= Game.WIDTH/2+220) {
			if(my >=350 && my <= 400) {
				// Pressed play button
				Game.State = Game.STATE.INTRO;
			}
		}
		
		if(mx >= Game.WIDTH/2-170 + 120 && mx <= Game.WIDTH/2+220) {
			if(my >=420 && my <= 470) {
				// Pressed exit button
				System.exit(0);
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
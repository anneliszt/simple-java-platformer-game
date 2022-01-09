package com.platform.window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		/**
		 public Rectangle startButton = new Rectangle(Game.WIDTH/2-170 + 120, 350, 100, 50);
		 public Rectangle exitButton = new Rectangle(Game.WIDTH/2-170 + 120, 420, 100, 50);
	
		 */
		
		if(mx >= Game.WIDTH/2-170 + 120 && mx <= Game.WIDTH/2+220) {
			if(my >=350 && my <= 400) {
				// Pressed play button
				Game.State = Game.STATE.INTRO;
			}
		}
		
		if(mx >= Game.WIDTH/2-170 + 120 && mx <= Game.WIDTH/2+220) {
			if(my >=420 && my <= 470) {
				// Pressed exit button
				System.exit(1);
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

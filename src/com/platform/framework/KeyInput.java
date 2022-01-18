package com.platform.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import com.platform.window.Game;
import com.platform.window.Game.STATE;
import com.platform.window.Handler;

/**
 * Receives keyboard events
 */
public class KeyInput extends KeyAdapter{
	
	Handler handler;
	Game game = new Game();
	
	/**
	 * Constructor
	 * @param handler handler
	 */
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(Game.State == STATE.GAME) {
			
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ObjectID.Player) {
				if(key == KeyEvent.VK_D) {											// Walks to the right
					tempObject.setVelX(5);
				}
				if(key == KeyEvent.VK_A) {											// Walks to the left
					tempObject.setVelX(-5);
				}
				if(key == KeyEvent.VK_SPACE && !tempObject.isJumping()) {			// Jumps
					
					tempObject.setJumping(true);
					tempObject.setVelY(-12);
					
					// Jump sound effect
					try {
						game.musicPlayer("jump");
					} catch (UnsupportedAudioFileException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		}
		if(key == KeyEvent.VK_ESCAPE) {												// Escape
			System.exit(0);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ObjectID.Player) {
				if(key == KeyEvent.VK_D) {
					tempObject.setVelX(0);
				}
				if(key == KeyEvent.VK_A) {
					tempObject.setVelX(0);
				}
			}
		}
	}

}

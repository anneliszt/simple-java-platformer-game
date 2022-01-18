package com.platform.window;

import java.awt.Dimension;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
* <h1>Simple Java Platformer Game</h1>
* This game is called "Who let the Hamsters out?" and is inspired by most 2D platform games.
* <p>In this game, you will help Ham the hamster escape the pet store and reunite him with his friend, Cheese!
* 
*
* @author  Ann Beatrice Destajo
* @since   2022-01-6
*/

/**
 * This class allows us to set up the window for the game
 */
public class Window {
	
	/**
	 * This is the constructor for the window. 
	 * <br>This is where the Game class is connected in order for it to be added to the main frame of the window.
	 * @param w - Width of the window
	 * @param h - Height of the window
	 * @param title - Title of the program
	 * @param game - Game class
	 * @throws LineUnavailableException 
	 * 
	 */
	public Window(int w, int h, String title, Game game){
		
		// Background music
		try {
			game.musicPlayer("introMusic");
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		
		// Sets the size for the game
		game.setPreferredSize(new Dimension(w, h));
		game.setMaximumSize(new Dimension(w, h));
		game.setMinimumSize(new Dimension(w, h));
		
		JFrame frame = new JFrame(title); 							// Container that provides a window on the screen
		frame.add(game); 											// Adds game to frame
		frame.pack();												// Sized to fit the preferred size and layouts of its subcomponents
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// Terminates program when closing
		frame.setResizable(false);									// Will not allow resizing
		frame.setLocationRelativeTo(null);
		game.start();												// Starts game
		frame.setVisible(true);										// Set frame visible to true
	}
}

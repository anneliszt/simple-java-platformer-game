package com.platform.window;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
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
	public Window(int w, int h, String title, Game game) throws LineUnavailableException {
		try {
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("res/bgmusic.wav"));

			AudioFormat format = inputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(inputStream);
            clip.start();
	        
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// Sets the size for the game
		game.setPreferredSize(new Dimension(w, h));
		game.setMaximumSize(new Dimension(w, h));
		game.setMinimumSize(new Dimension(w, h));
		
		JFrame frame = new JFrame(title); // Container that provides a window on the screen
		frame.add(game); // 
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		game.start();
		frame.setVisible(true);
	}
}

package com.platform.window;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
* <h1>Welcome</h1>
* This simple Hamster RPG Platformer program implements a simple game that
* has the basic elements of platformer games.
* <p>
* Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
* 
*
* @author  Ann Beatrice Destajo
* @since   2022-01-6
*/

public class Window {
	
	JFrame frame;
	public Window(int w, int h, String title, Game game) {
		
		game.setPreferredSize(new Dimension(w, h));
		game.setMaximumSize(new Dimension(w, h));
		game.setMinimumSize(new Dimension(w, h));
		
		frame = new JFrame(title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	
		game.start();
		frame.setVisible(true);
	}
}

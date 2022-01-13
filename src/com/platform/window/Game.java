package com.platform.window;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.sound.sampled.LineUnavailableException;

import com.platform.framework.KeyInput;
import com.platform.framework.ObjectID;
import com.platform.framework.Texture;

/**
 * Main class
 */
public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -1943005620488936606L;

	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH, HEIGHT;
	
	public BufferedImage bg = null;
	
	// Object
	Handler handler;
	Camera cam;
	
	// Camera bgCam;
	static Texture tex;
	
	public static int LEVEL = 1;
	
	/**
	 * Represents a group of constants
	 * <br>In this case, it represents the states of the game
	 */
	public static enum STATE{
		MENU,
		INTRO,
		GAME,
		OUTRO
	};
	
	public static STATE State = STATE.MENU;
	
	private Menu menu;
	private Intro intro;
	private Outro outro;
	
	/**
	 * Constructor
	 */
	private void init() {
		WIDTH = getWidth();															// Gets dimensions of the game
		HEIGHT = getHeight();
		
		tex = new Texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();						// Loads the images
		bg = loader.loadImage("/petBG.png");
		
		cam = new Camera(0, 0);														// Camera object
		handler = new Handler(cam);													// Handler object
	
		menu = new Menu();															// Menu object
		intro = new Intro();														// Intro object
		outro = new Outro();														// Outro object
		
		this.addKeyListener(new KeyInput(handler));									// Receives keyboard event
		this.addMouseListener(new Menu());											// Receives mouse events
		this.addMouseListener(new Intro());											// Receives mouse events
	}
	
	/**
	 * Starts the thread
	 */
	public synchronized void start() {
		if(running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();																// Thread is starting
	}
	
	/**
	 * Game loop
	 * <br>The game loop is what runs the game. It's running 
	 * the amount of ticks per second @ 60 
	 */
	public void run() {
		
		init();
		this.requestFocus();														// Component get the input focus
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			
			try {
				render();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
			}
		}
	}
	
	/**
	 * Determines how many times the game loop iterates
	 */
	private void tick() {
		
		if(State == STATE.GAME) {														
			handler.tick();															
		}
		
		if(State == STATE.INTRO) {
			handler.tick();
		}
		
		for(int i=0; i<handler.object.size(); i++ ) {
			if(handler.object.get(i).getID() == ObjectID.Player) {
				cam.tick(handler.object.get(i));
			}
		}	
	}
	
	/**
	 * Renders all the needed graphics/images for the program
	 * @throws InterruptedException 
	 */
	private void render() throws InterruptedException { 							// Graphics
		BufferStrategy bs = this.getBufferStrategy(); 								// Canvas method
		if(bs == null) {
			this.createBufferStrategy(3); 											// The amount of buffers 
			return;
		}
		
		/* Buffer strategy represents the mechanism with which to 
		organize complex memory on a particular Canvas
		It pre-loads images at the same time */
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		// This is where we draw everything from our game
		if(State == STATE.INTRO) {													// Renders intro class
			intro.render(g);
		}
		
		else if(State == STATE.OUTRO) {												// Renders outro class
			outro.render(g);
		}
		
		else if(State == STATE.GAME) {												// Renders handler class
			g.fillRect(0, 0, getWidth(), getHeight());
			
			g2d.translate(cam.getX(), cam.getY()); 									// Beginning of camera	
				for(int xx=0; xx < bg.getWidth() * 2; xx += bg.getWidth()) {
					g.drawImage(bg, xx-100, 0, this);								// Draw background
				handler.render(g);
				}
				
			g2d.translate(-cam.getX(), -cam.getY());			 					// End of camera
			
		}else if(State == STATE.MENU) {												// Renders menu class
			menu.render(g);
			
		}
		
		g.dispose();
		bs.show();
	}
    
	/**
	 * Get instance of the texture class
	 * @return texture
	 */
	public static Texture getInstance() {
		return tex;
	}
	
	/**
	 * Main function where we create a new window
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			new Window(800, 600, "Hamster Platform Game", new Game());
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}

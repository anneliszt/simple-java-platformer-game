package com.platform.framework;

import java.awt.image.BufferedImage;

import com.platform.window.BufferedImageLoader;

/**
 * Responsible for all textures for the game objects
 */
public class Texture {
	
	SpriteSheet bs, ps, fl, ex, spk;
	
	// Load buffered images
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	private BufferedImage flag_sheet = null;
	private BufferedImage exit_sheet = null;
	private BufferedImage spike_sheet = null;

	public BufferedImage[] block = new BufferedImage[5];
	public BufferedImage[] player = new BufferedImage[14];
	public BufferedImage[] player_jump = new BufferedImage[6];
	public BufferedImage[] flag = new BufferedImage[1];
	public BufferedImage[] exit = new BufferedImage[1];
	public BufferedImage[] spike = new BufferedImage[1];
	
	/** 
	 * Constructor
	 */
	public Texture() {
		
		// Load buffered images
		BufferedImageLoader loader = new BufferedImageLoader();						
		
		try {
			block_sheet = loader.loadImage("/texture.png");
			player_sheet = loader.loadImage("/ham-player.png");
			flag_sheet = loader.loadImage("/cheeseIdle.png");
			exit_sheet = loader.loadImage("/exitFlag.png");
			spike_sheet = loader.loadImage("/spike.png");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// Creates new spritesheet objects
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		fl = new SpriteSheet(flag_sheet);
		ex = new SpriteSheet(exit_sheet);
		spk = new SpriteSheet(spike_sheet);
		getTextures();
	}
	
	/**
	 * Gets the individual textures from the sprite sheets
	 */
	private void getTextures() {
		block[0] = bs.grabImage(1, 1, 32, 32); // tile texture
		block[1] = bs.grabImage(2, 1, 32, 32); // tile texture
		block[2] = bs.grabImage(1, 2, 32, 32); // can texture
		block[3] = bs.grabImage(2, 2, 32, 32); // can texture
		flag[0] = fl.grabImage(1, 1, 32, 32); // flag/end goal texture
		exit[0] = ex.grabImage(1, 1, 32, 32); // exit texture
		spike[0] = spk.grabImage(1, 1, 32, 32); 
		
		  //looking right
		for (int i = 0; i < 7; i++) {
			player[i] = ps.grabImage(i+1, 1, 32, 64); // player walking right frames
	      }
	      //looking left
		for (int i = 7, ii = 20; i < 14; i++, --ii) {
			player[i] = ps.grabImage(ii, 1, 32, 64); // player walking left frames
	      }
	      //jumping
		for (int i = 0, ii = 8; i < 6; i++, ii++) {
			player_jump[i] = ps.grabImage(ii, 2, 32, 64); // jumping player frames
	    }
	}

}

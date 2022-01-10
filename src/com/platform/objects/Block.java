package com.platform.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.platform.framework.GameObject;
import com.platform.framework.ObjectID;
import com.platform.framework.Texture;
import com.platform.window.Game;

/**
 * Block object class that gets all the methods from GameObject class
 */
public class Block extends GameObject{
	
	Texture tex = Game.getInstance();
	private int type;

	/**
	 * Constructor for the block
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param type type of texture
	 * @param id object id
	 */
	public Block(float x, float y, int type, ObjectID id) {
		super(x, y, id);
		this.type = type;
	}

	/**
	 * Ticks
	 */
	public void tick(ArrayList<GameObject> object) {
	}

	/**
	 * Renders and draws all of the necessary images into its respective type and will placed according to the given x and y coordinate
	 * <p>Type 0 = Tile texture
	 * <br>Type 1 = Tile texture
	 * <br> Type 2 = Can texture
	 * <br> Type 3 = Can texture
	 */
	public void render(Graphics g) {
		if(type==0) { 
			g.drawImage(tex.block[0], (int)x, (int)y, null);
		}
		if(type==1) { 
			g.drawImage(tex.block[1], (int)x, (int)y, null);
		}
		if(type==2) { 
			g.drawImage(tex.block[2], (int)x, (int)y, null);
		}
		if(type==3) { 
			g.drawImage(tex.block[3], (int)x, (int)y, null);
		}

	}

	/**
	 * Gets bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}

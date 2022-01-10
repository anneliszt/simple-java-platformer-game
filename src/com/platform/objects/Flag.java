package com.platform.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.platform.framework.GameObject;
import com.platform.framework.ObjectID;
import com.platform.framework.Texture;
import com.platform.window.Game;

/**
 * Flag class object that gets all the methods from the GameObject class
 * <br>The flag is also known as the "goal" of the game that will appear at the end of the platforms
 */
public class Flag extends GameObject{
	
	Texture tex = Game.getInstance();
	private int type;
	
	/**
	 * Constructor
	 * @param x coordinate
	 * @param y coordinate
	 * @param type type of texture
	 * @param id game object id
	 */
	public Flag(float x, float y, int type, ObjectID id) {
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
	 * <p>Type 0 = Cheese the Hamster Idle Image
	 * <br>Type 1 = Exit sign
	 */
	public void render(Graphics g) {
	
		if(type==0) { 
			g.drawImage(tex.flag[0], (int)x, (int)y, null);
		}
		if(type==1) { 
			g.drawImage(tex.exit[0], (int)x, (int)y, null);
		}
		
	}

	/**
	 * Gets collision bounds for the flag
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}

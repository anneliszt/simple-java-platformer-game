package com.platform.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.platform.framework.GameObject;
import com.platform.framework.ObjectID;
import com.platform.framework.Texture;
import com.platform.window.Game;

public class Spikes extends GameObject {

	Texture tex = Game.getInstance();
	private int type;

	/**
	 * Constructor
	 * 
	 * @param x    coordinate
	 * @param y    coordinate
	 * @param type type of texture
	 * @param id   game object id
	 */
	public Spikes(float x, float y, int type, ObjectID id) {
		super(x, y, id);
		this.type = type;
	}

	/**
	 * Ticks
	 */
	public void tick(ArrayList<GameObject> object) {
	}

	/**
	 * Renders and draws all of the necessary images into its respective type and
	 * will placed according to the given x and y coordinate
	 * 
	 * <p>Type 0 = Spikes
	 */
	public void render(Graphics g) {
		if (type == 0) {
			g.drawImage(tex.spike[0], (int) x, (int) y, null);
		}
	}

	/**
	 * Gets collision bounds for the spike
	 */
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

}

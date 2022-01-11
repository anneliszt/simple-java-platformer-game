package com.platform.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Responsible for all game objects
 */
public abstract class GameObject {
	
	protected ObjectID id;
	protected float x, y;
	protected float velX = 0, velY = 0;
	protected boolean falling = true;
	protected boolean jumping = false;
	protected int facing = 1;
	
	/**
	 * Constructor
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param id object id
	 */
	public GameObject(float x, float y, ObjectID id) { // Constructor
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	/**
	 * Perform ticks
	 * @param object game object
	 */
	public abstract void tick(ArrayList<GameObject> object);
	
	/**
	 * Renders
	 * @param g tool that draws onto the component
	 */
	public abstract void render(Graphics g);
	
	/**
	 * Gets collision bounding for the player
	 * @return
	 */
	public abstract Rectangle getBounds();
	
	/**
	 * Gets the value of X
	 * @return x
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * Gets the value of Y
	 * @return y
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Sets the value for X
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	
	/**
	 * Sets the value for Y
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Gets the value of velocity X
	 * @return velX
	 */
	public float getVelX() {
		return velX;
	}
	
	/**
	 * Gets the value of velocity Y
	 * @return velY
	 */
	public float getVelY() {
		return velY;
	}
	
	/**
	 * Sets the value for velocity X
	 * @param velX
	 */
	public void setVelX(float velX) {
		this.velX = velX;
	}
	
	/**
	 * Sets the value for velocity Y
	 * @param velY
	 */
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	/**
	 * TRUE if it's falling, FALSE if otherwise
	 * @return true
	 */
	public boolean isFalling() {
		return falling;
	}

	/**
	 * Sets the value whether it's true or false depending on the action
	 * @param falling
	 */
	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	/**
	 * TRUE if it's not jumping, FALSE if otherwise
	 * @return false
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * Sets the value whether it's true or false depending on the action
	 * @param jumping
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	/**
	 * Gets the facing direction of player sprite
	 * @return facing direction
	 */
	public int getFacing() {
		return facing;
	}

	/**
	 * Gets the object ID specified
	 * @return ID
	 */
	public ObjectID getID() {
		return id;
	}
}

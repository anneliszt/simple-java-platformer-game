package com.platform.window;

import com.platform.framework.GameObject;

/**
 * Follows the player object
 */
public class Camera {
	
	private float x, y;
	
	/**
	 * Constructor
	 * @param x specifies the starting x-coordinate
	 * @param y specifies the starting y-coordinate
	 */
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Snap the player onto the camera
	 * @param player player
	 */
	public void tick(GameObject player) { // Use tweaning algorithm
		x = -player.getX()+Game.WIDTH/2;
	}
	
	// Getters and setter methods
	
	/**
	 * Sets the value for the distance along the X-axis
	 * @param x distance along the x-coordinate
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * Sets the value for the distance along the Y-axis
	 * @param y distance along the y-coordinate
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Gets the value for the distance along the X-axis
	 * @return distance of x
	 */
	public float getX() {
		return x;
	}
	
	/**
	* Gets the value for the distance along the Y-axis
	 * @return distance of y
	 */
	public float getY() {
		return y;
	}
}

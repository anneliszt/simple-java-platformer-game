package com.platform.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.platform.framework.GameObject;
import com.platform.framework.ObjectID;
import com.platform.framework.Texture;
import com.platform.window.Animation;
import com.platform.window.Camera;
import com.platform.window.Game;
import com.platform.window.Handler;

/**
 * Player class object that gets all the methods from the GameObject class
 */
public class Player extends GameObject{
	
	private float width = 40, height = 96;
	private float gravity = 0.45f;
	
	private final float MAX_SPEED = 10;
	
	private Handler handler;
	Texture tex = Game.getInstance();
	
	private Animation playerWalk, playerWalkLeft;
	
	/**
	 * Constructor
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param handler handler
	 * @param cam camera
	 * @param id object id
	 */
	public Player(float x, float y, Handler handler, Camera cam, ObjectID id) {
		super(x, y, id);
		this.handler = handler;
		playerWalk = new Animation(10, tex.player[1], tex.player[2], tex.player[3], tex.player[4], tex.player[5], tex.player[6]);
		playerWalkLeft = new Animation(10, tex.player[8], tex.player[9], tex.player[10], tex.player[11], tex.player[12], tex.player[13]);
	}

	/**
	 * Controls the gravity of the player as well as its animation
	 */
	public void tick(ArrayList<GameObject> object) {
		x += velX;
		y += velY;
		
		if(velX > 0) facing = 1;
		else if(velX < 0) facing = -1;
		
		if(falling || jumping) {
			velY += gravity;
			if(velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		}
		Collision(object);
		
		playerWalk.runAnimation();
		playerWalkLeft.runAnimation();
	}
	
	/**
	 * Collision
	 * @param object game object
	 */
	private void Collision(ArrayList<GameObject> object) { 
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ObjectID.Block) { // If we are colliding with the block
				
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					y = (float) (tempObject.getY() + (tempObject.getBounds().getHeight()));
					velY = 0;
				}
				
				if(getBounds().intersects(tempObject.getBounds())) { // Bottom
					y = tempObject.getY()-height;	
					velY = 0;
					falling = false;
					jumping = false;
				}else {
					falling = true;
				}
				
				// Right
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX()-width;	
				}
				
				// Left
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					x = (float) (tempObject.getX() + tempObject.getBounds().getWidth());	
				}
			} else if (tempObject.getID() == ObjectID.Flag) {
				// Switch level if it reaches the flag
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.switchLevel();
				}
			} 
		}
	}

	/**
	 * Renders the appearance of the player when jumping, facing to the right, or facing to the left.
	 */
	public void render(Graphics g) {
		g.setColor(Color.blue);
		// g.fillRect((int)x, (int)y, (int)width, (int)height);
		if(jumping) {
			if(facing == 1) {
				g.drawImage(tex.player_jump[2], (int)x, (int)y, 48, 96, null);
			}else if(facing == -1) {
				g.drawImage(tex.player_jump[3], (int)x, (int)y, 48, 96, null);
			}
		}else {
			if(velX != 0) {
				if(facing == 1) {
					playerWalk.drawAnimation(g, (int)x, (int)y, 48, 96);
				}else {
					playerWalkLeft.drawAnimation(g, (int)x, (int)y, 48, 96);
				}
			}
			
			else {
				if(facing == 1) {
					g.drawImage(tex.player[0], (int)x, (int)y, 48, 96, null);
				}else if(facing == -1){
					g.drawImage(tex.player[7], (int)x, (int)y, 48, 96, null);
				}
			}
		}
	}

	/**
	 * Gets collision bounds at the bottom
	 * @return collision bounds at the bottom
	 */
	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	
	/**
	 * Gets collision bounds at the top
	 * @return collision bounds at the top
	 */
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int)y, (int)width/2, (int)height/2);
	}
	
	/**
	 * Gets collision bounds at the right
	 * @return collision bounds at the right
	 */
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x+(width-5)), (int)y+5, (int)5, (int)height-10);
	}
	
	/**
	 * Gets collision bounds at the left
	 * @return collision bounds at the left
	 */
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}
}

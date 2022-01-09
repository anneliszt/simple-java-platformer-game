package com.platform.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.platform.framework.GameObject;
import com.platform.framework.ObjectID;
import com.platform.framework.Texture;
import com.platform.window.BufferedImageLoader;
import com.platform.window.Game;

public class Flag extends GameObject{
	
	Texture tex = Game.getInstance();
	private int type;
	
	public Flag(float x, float y, int type, ObjectID id) {
		super(x, y, id);
		this.type = type;

	}

	public void tick(ArrayList<GameObject> object) {
		
	}

	public void render(Graphics g) {
	
		if(type==0) { 
			g.drawImage(tex.flag[0], (int)x, (int)y, null);
		}
		if(type==1) { 
			g.drawImage(tex.exit[0], (int)x, (int)y, null);
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}

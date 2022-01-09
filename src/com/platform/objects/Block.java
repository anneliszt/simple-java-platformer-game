package com.platform.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.platform.framework.GameObject;
import com.platform.framework.ObjectID;
import com.platform.framework.Texture;
import com.platform.window.Game;

public class Block extends GameObject{
	
	Texture tex = Game.getInstance();
	private int type;

	public Block(float x, float y, int type, ObjectID id) {
		super(x, y, id);
		this.type = type;
	}

	public void tick(ArrayList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		if(type==0) { // dirt block
			g.drawImage(tex.block[0], (int)x, (int)y, null);
		}
		if(type==1) { // grass block
			g.drawImage(tex.block[1], (int)x, (int)y, null);
		}
		if(type==2) { // grass block
			g.drawImage(tex.block[2], (int)x, (int)y, null);
		}
		if(type==3) { // grass block
			g.drawImage(tex.block[3], (int)x, (int)y, null);
		}

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}

package by.bsuir.kovalev.jail.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.framework.Texture;
import by.bsuir.kovalev.jail.window.Game;

public class Block extends GameObject{
	
	Texture texture = Game.getInstance();
	private int type;

	public Block(float x, float y, int type, ObjectId objectId) {
		super(x, y, objectId);
		this.type = type;
	}

	public void tick(LinkedList<GameObject> object) {
	}

	public void render(Graphics g) {
		if(type == 0)
			g.drawImage(texture.block[0], (int)x, (int)y, null);
		if(type == 0)
			g.drawImage(texture.block[1], (int)x, (int)y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
 
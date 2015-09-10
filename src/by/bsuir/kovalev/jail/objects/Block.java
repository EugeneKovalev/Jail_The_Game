package by.bsuir.kovalev.jail.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.framework.Texture;
import by.bsuir.kovalev.jail.window.Game;

public class Block extends GameObject{
	
	Texture texture = Game.getTextureInstance();
	private int type;
	public static final int BRICK_BLOCK = 0;

	public Block(float x, float y, ObjectId objectId, int type ) {
		super(x, y, objectId);
		this.type = type;
	}

	public void tick(LinkedList<GameObject> object) {
	}

	public void render(Graphics graphics) {
		if(type == 0)
			graphics.drawImage(texture.block[0], (int)x, (int)y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
 
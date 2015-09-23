package by.bsuir.kovalev.jail.objects;

import java.awt.Graphics;
import java.util.LinkedList;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.HumanoidGameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.framework.Texture;
import by.bsuir.kovalev.jail.window.Game;
import by.bsuir.kovalev.jail.window.Handler;

public class Player extends HumanoidGameObject{
	
	private float gravity = 0.5f;
	private Handler handler;
	Texture texture = Game.getTextureInstance();

	public Player(int x, int y, int width, int height, ObjectId objectId, Handler handler) {
		super(x, y, width, height, objectId);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		x += xVelocity;
		y += yVelocity;
		if (isFalling || isJumping){
			yVelocity += gravity;
		}
		processCollisionCondition(handler);
	}
	
	public void render(Graphics g) {
		g.drawImage(texture.player[0], x, y, width, height, null);
	}

}

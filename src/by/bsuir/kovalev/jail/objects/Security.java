package by.bsuir.kovalev.jail.objects;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.HumanoidGameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.framework.Texture;
import by.bsuir.kovalev.jail.window.Game;
import by.bsuir.kovalev.jail.window.Handler;

public class Security extends HumanoidGameObject{

	private float gravity = 0.5f;
	private Handler handler;
	Texture texture = Game.getTextureInstance();

	public Security(int x, int y, int width, int height, ObjectId objectId, Handler handler) {
		super(x, y, width, height, objectId);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		Random rnd = new Random();
		int a=rnd.nextInt(3);
		x += a;
		y += y_velocity;
		if (isFalling || isJumping){
			y_velocity += gravity;
		}
		processCollisionCondition(handler);
	}
		
	public void render(Graphics graphics) {
		graphics.drawImage(texture.security[0], x, y, width, height, null);
	}
	
}

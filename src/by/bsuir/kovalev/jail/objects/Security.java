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

	private boolean isLeftDirection;
	private int primaryLocation;
	private int movingLimit;
	private float gravity = 0.5f;
	private Handler handler;
	Texture texture = Game.getTextureInstance();

	public Security(int x, int y, int width, int height, ObjectId objectId, Handler handler) {
		super(x, y, width, height, objectId);
		primaryLocation = x;
		movingLimit = new Random().nextInt(600);
		if(new Random().nextInt(2) == 1)isLeftDirection = true;
		else isLeftDirection = false;
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		checkForChangingDirectionNecessity();
		processWalking();
		processFalling();
		processCollisionCondition(handler);
	}
	
	private void processWalking(){
		if(isLeftDirection)
			x -= 3;
		else x+=3;
	}
	
	private void processFalling(){
		y += yVelocity;
		if (isFalling || isJumping){
			yVelocity += gravity;
		}
	}
	
	private void checkForChangingDirectionNecessity(){
		if(Math.abs(primaryLocation - this.getX()) > movingLimit){
			primaryLocation = this.getX();
			if(isLeftDirection) isLeftDirection = false;
			else isLeftDirection = true;
		}
	}
		
	public void render(Graphics graphics) {
		graphics.drawImage(texture.security[0], x, y, width, height, null);
	}
	
}

package by.bsuir.kovalev.jail.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {

	protected float width, height;
	protected ObjectId gameObjectId;
	protected float velocity_X = 0, velocity_Y = 0;
	protected boolean falling = true;
	
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	protected boolean jumping = false;
	
	public GameObject(float width, float height, ObjectId gameObjectId){
		this.width = width;
		this.height = height;
		this.gameObjectId = gameObjectId;
	}
	
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public float getX() {
		return width;
	}

	public float getY() {
		return height;
	}

	public void setX(float x) {
		this.width = x;
	}

	public void setY(float y) {
		this.height = y;
	}

	public float getVelocity_X() {
		return velocity_X;
	}

	public float getVelocity_Y() {
		return velocity_Y;
	}

	public void setVelocity_X(float velocity_X) {
		this.velocity_X = velocity_X;
	}

	public void setVelocity_Y(float velocity_Y) {
		this.velocity_Y = velocity_Y;
	}

	public ObjectId getId() {
		return gameObjectId;
	}
}

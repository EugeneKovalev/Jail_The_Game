package by.bsuir.kovalev.jail.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {

	protected ObjectId objectId;
	protected float x;
	protected float y;
	protected float x_velocity; 
	protected float y_velocity;
	protected boolean isFalling;
	protected boolean isJumping;
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public GameObject(float x, float y, ObjectId objectId){
		this.objectId = objectId;
		this.x = x;
		this.y = y;
		this.x_velocity = 0;
		this.y_velocity = 0;
		this.isFalling = true;
		this.isJumping = false;
	}
	
	public ObjectId getObjectId() {
		return objectId;
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float get_x_velocity() {
		return x_velocity;
	}
	
	public void set_x_velocity(float x_velocity) {
		this.x_velocity = x_velocity;
	}
	
	public float get_y_velocity() {
		return y_velocity;
	}

	public void set_y_velocity(float y_velocity) {
		this.y_velocity = y_velocity;
	}
	
	public boolean isFalling() {
		return isFalling;
	}

	public void setIsFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}

	public boolean isJumping() {
		return isJumping;
	}

	public void setIsJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

}

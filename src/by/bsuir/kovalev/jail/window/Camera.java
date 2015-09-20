package by.bsuir.kovalev.jail.window;

import by.bsuir.kovalev.jail.framework.GameObject;

public class Camera {

	private float x;
	private float y;
	
	public Camera(){
		this.x = 0;
		this.y = 0;
	}
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public void tick(GameObject player){
		x = -player.getX()+ 400;
	}
	
}

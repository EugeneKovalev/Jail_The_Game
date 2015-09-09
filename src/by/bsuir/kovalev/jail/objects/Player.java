package by.bsuir.kovalev.jail.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.framework.Texture;
import by.bsuir.kovalev.jail.window.Game;
import by.bsuir.kovalev.jail.window.Handler;

public class Player extends GameObject{
	
	private float width = 48;
	private float height = 96;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 100;
	private Handler handler;
	Texture texture = Game.getInstance();

	public Player(float x, float y, Handler handler, ObjectId objectId) {
		super(x, y, objectId);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		x += x_velocity;
		y += y_velocity;
		if (isFalling || isJumping){
			y_velocity += gravity;
			if(y_velocity > MAX_SPEED)
				y_velocity = MAX_SPEED;
		}
		collision(object);
	}
	
	private void collision(LinkedList<GameObject> object){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getObjectId() == ObjectId.Block){
				
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y = tempObject.getY() + 32;
					y_velocity = 0;
				}
				
				if(getBounds().intersects(tempObject.getBounds())){
					y = tempObject.getY() - height;
					y_velocity = 0;
					isFalling = false;
					isJumping = false;
				}
				else
					isFalling = true;
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;
				}
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;
				}
				
				
				
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawImage(texture.player[0], (int)x, (int)y, 48, 96, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}

}

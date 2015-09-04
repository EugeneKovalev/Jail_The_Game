package by.bsuir.kovalev.jail.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.window.Handler;

public class Player extends GameObject{
	
	private float width1 = 48;
	private float height1 = 96;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	private Handler handler;

	public Player(float width, float height, Handler handler, ObjectId gameObjectId) {
		super(width, height, gameObjectId);
		this.handler = handler;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		width += velocity_X;
		height += velocity_Y;
		if (falling || jumping){
			velocity_Y += gravity;
			if(velocity_Y > MAX_SPEED)
				velocity_Y = MAX_SPEED;
		}
		Collision(object);
	}
	
	private void Collision(LinkedList<GameObject> object){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Block){
				if(getBounds().intersects(tempObject.getBounds())){
					height = tempObject.getY() - height1;
					velocity_Y = 0;
					falling = false;
					jumping = false;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)width, (int)height, (int)width1, (int)height1);
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)width+(width1/2)-((width1/2)/2)), (int) ((int)height+(height1/2)), (int)width1/2, (int)height1/2);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)width+(width1/2)-((width1/2)/2)), (int)height, (int)width1/2, (int)height1/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)width+width1-5), (int)height+5, (int)5, (int)height1-10);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)width, (int)height+5, (int)5, (int)height1-10);
	}

}

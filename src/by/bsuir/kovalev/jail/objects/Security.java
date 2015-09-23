package by.bsuir.kovalev.jail.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.HumanoidGameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.framework.Texture;
import by.bsuir.kovalev.jail.window.Game;
import by.bsuir.kovalev.jail.window.Handler;

public class Security extends HumanoidGameObject{

	private int width = 48;
	private int height = 96;
	private float gravity = 0.5f;
	private Handler handler;
	Texture texture = Game.getTextureInstance();

	public Security(int x, int y, ObjectId objectId, Handler handler) {
		super(x, y, objectId);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		Random rnd = new Random();
		int a=rnd.nextInt(3);
		System.out.println(a);
		x += a;
		y += y_velocity;
		if (isFalling || isJumping){
			y_velocity += gravity;
		}
		processCollisionCondition();
	}
	
	private void processCollisionCondition(){
		for(int i = 0; i < handler.objectList.size(); i++){
			GameObject tempObject = handler.objectList.get(i);
			if(tempObject.getObjectId() == ObjectId.Block){
				checkForTopIntersectionWithPlayer((Block)tempObject);
				checkForBottomIntersectionWithPlayer((Block)tempObject);
				checkForLeftIntersectionWithPlayer((Block)tempObject);
				checkForRightIntersectionWithPlayer((Block)tempObject);	
			}
		}
	}
	
	private boolean checkForTopIntersectionWithPlayer(Block block){
		if(getBoundsTop().intersects(block.getBounds())){
			if(checkForLeftIntersectionWithPlayer(block)|| checkForRightIntersectionWithPlayer(block)) return false;
			y = block.getY() + Block.TEXTURE_SIZE;
			y_velocity = 0;
			return true;
		}
		else return false;
	}
	
	private boolean checkForBottomIntersectionWithPlayer(Block block){
		if(getBoundsBottom().intersects(block.getBounds())){
			y = block.getY() - height;
			y_velocity = 0;
			isJumping = false;
			return true;
		}
		else return false;
	}
	
	private boolean checkForLeftIntersectionWithPlayer(Block block){
		if(getBoundsLeft().intersects(block.getBounds())){
			x = block.getX() + Block.TEXTURE_SIZE;
			return true;
		}
		else return false;
	}
	
	private boolean checkForRightIntersectionWithPlayer(Block block){
		if(getBoundsRight().intersects(block.getBounds())){
			x = block.getX() - width;
			return true;
		}
		else return false;
	}

	public void render(Graphics graphics) {
		graphics.setColor(Color.red);
		graphics.fillRect(x, y, width, height);
		graphics.drawImage(texture.security[0], x, y, width, height, null);
	}

	public Rectangle getBounds() {
		return null;
	}

	public Rectangle getBoundsTop() {
		return new Rectangle(x+2*width/5, y, width/5, height/2);
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle(x+2*width/5, y+height/2, width/5, height/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle(x+3*width/4, y+height/4, width/4, height/2);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle(x, y+height/4, width/4, height/2);
	}
	
}

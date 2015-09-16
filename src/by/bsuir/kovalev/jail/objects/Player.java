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
	
	private int width = 48;
	private int height = 96;
	private float gravity = 0.5f;
	private Handler handler;
	Texture texture = Game.getTextureInstance();

	public Player(int x, int y, ObjectId objectId, Handler handler) {
		super(x, y, objectId);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		x += x_velocity;
		y += y_velocity;
		if (isFalling || isJumping){
			y_velocity += gravity;
		}
		processCollisionCondition(object);
	}
	
	private void processCollisionCondition(LinkedList<GameObject> object){
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

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, width, height);
		//g.drawImage(texture.player[0], (int)x, (int)y, 48, 96, null);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsBottom());
	}
	
	public Rectangle getBounds() {
		return null;
	}

	public Rectangle getBoundsTop() {
		return new Rectangle(x+width/4, y, width/2, height/2);
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle(x+width/4, y+height/2, width/2, height/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle(x+3*width/4, y+height/4, width/4, height/2);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle(x, y+height/4, width/4, height/2);
	}
	
	private void checkForTopIntersectionWithPlayer(Block block){
		if(getBoundsTop().intersects(block.getBounds())){
			System.out.println("Top");
			//JOptionPane.showMessageDialog(null, "Top");
			y = block.getY() + Block.TEXTURE_SIZE;
			y_velocity = 0;
		}
	}
	
	private void checkForBottomIntersectionWithPlayer(Block block){
		if(getBoundsBottom().intersects(block.getBounds())){
			System.out.println("Bottom");
			y = block.getY() - height;
			y_velocity = 0;
			isJumping = false;
		}
	}
	
	private void checkForLeftIntersectionWithPlayer(Block block){
		if(getBoundsLeft().intersects(block.getBounds())){
			System.out.println("Left");
			//JOptionPane.showMessageDialog(null, "Left");
			x = block.getX() + Block.TEXTURE_SIZE + 3;
		}
	}
	
	private void checkForRightIntersectionWithPlayer(Block block){
		if(getBoundsRight().intersects(block.getBounds())){
			System.out.println("Right");
			x = block.getX() - width - 3;
		}
	}
}

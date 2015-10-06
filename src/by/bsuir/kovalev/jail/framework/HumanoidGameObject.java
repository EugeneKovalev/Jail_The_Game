package by.bsuir.kovalev.jail.framework;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

import by.bsuir.kovalev.jail.objects.Block;
import by.bsuir.kovalev.jail.objects.ExitDoor;
import by.bsuir.kovalev.jail.window.Handler;

public abstract class HumanoidGameObject extends GameObject{

	protected boolean isJumping;
	
	public HumanoidGameObject(int x, int y, int width, int height, ObjectId objectId) {
		super(x, y, width, height, objectId);
		this.isJumping = false;
		this.isFalling = true;
	}
	
	public boolean isJumping() {
		return isJumping;
	}

	public void setIsJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}
	
	public Rectangle getBoundsTop(int width, int height) {
		return new Rectangle(x+2*width/5, y, width/5, height/2);
	}
	
	public Rectangle getBoundsBottom(int width, int height) {
		return new Rectangle(x+2*width/5, y+height/2, width/5, height/2);
	}
	
	public Rectangle getBoundsRight(int width, int height) {
		return new Rectangle(x+3*width/4, y+height/4, width/4, height/2);
	}
	
	public Rectangle getBoundsLeft(int width, int height) {
		return new Rectangle(x, y+height/4, width/4, height/2);
	}
	
	protected void processCollisionCondition(Handler handler){
		for(int i = 0; i < handler.objectList.size(); i++){
			GameObject tempObject = handler.objectList.get(i);
			if(tempObject.getObjectId() == ObjectId.Block){
				checkForTopIntersectionWithPlayer((Block)tempObject);
				checkForBottomIntersectionWithPlayer((Block)tempObject);
				checkForLeftIntersectionWithPlayer((Block)tempObject);
				checkForRightIntersectionWithPlayer((Block)tempObject);	
			}
			else if (tempObject.getObjectId() == ObjectId.ExitDoor){
				checkForExitCondition((ExitDoor)tempObject);
			}
		}
	}
	
	private void checkForExitCondition(ExitDoor exitDoor){
		if(this.getBoundsTop(width, height).intersects(exitDoor.getBounds())){
			JOptionPane.showMessageDialog(null, "THE END");
			System.exit(1);
		}
	}
	
	private boolean checkForTopIntersectionWithPlayer(Block block){
		if(getBoundsTop(width, height).intersects(block.getBounds())){
			if(checkForLeftIntersectionWithPlayer(block)|| checkForRightIntersectionWithPlayer(block)) return false;
			y = block.getY() + Block.TEXTURE_SIZE;
			yVelocity = 0;
			return true;
		}
		else return false;
	}
	
	private boolean checkForBottomIntersectionWithPlayer(Block block){
		if(getBoundsBottom(width, height).intersects(block.getBounds())){
			y = block.getY() - height;
			yVelocity = 0;
			isJumping = false;
			return true;
		}
		else return false;
	}
	
	private boolean checkForLeftIntersectionWithPlayer(Block block){
		if(getBoundsLeft(width, height).intersects(block.getBounds())){
			x = block.getX() + Block.TEXTURE_SIZE;
			return true;
		}
		else return false;
	}
	
	private boolean checkForRightIntersectionWithPlayer(Block block){
		if(getBoundsRight(width, height).intersects(block.getBounds())){
			x = block.getX() - width;
			return true;
		}
		else return false;
	}

}

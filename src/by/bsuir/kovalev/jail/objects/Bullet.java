package by.bsuir.kovalev.jail.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.framework.Texture;
import by.bsuir.kovalev.jail.window.Game;
import by.bsuir.kovalev.jail.window.Handler;

public class Bullet extends GameObject{

	Texture texture = Game.getTextureInstance();
	private Handler handler;
	
	public Bullet(int x, int y, int width, int height, ObjectId objectId, Handler handler) {
		super(x, y, width, height, objectId);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		x += xVelocity;
		processWoundingCondition(handler);
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 3, 1);
	}

	private void processWoundingCondition(Handler handler){
		for(int i = 0; i < handler.objectList.size(); i++){
			GameObject tempObject = handler.objectList.get(i);
			if(tempObject.getBounds().intersects(this.getBounds())){
					if(tempObject.getObjectId() == ObjectId.Security){
						handler.objectList.remove(tempObject);
						handler.objectList.remove(this);
					}
					else if (tempObject.getObjectId() == ObjectId.Block){
						handler.objectList.remove(this);
					}
				}
		}
	}
}

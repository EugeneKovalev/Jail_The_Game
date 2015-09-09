package by.bsuir.kovalev.jail.window;

import java.awt.Graphics;
import java.util.LinkedList;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.objects.Block;

public class Handler {

		public LinkedList<GameObject> object = new LinkedList<GameObject>();
		private GameObject tempObject;
		
		public void tick(){
			for(int i = 0; i < object.size(); i++){
				tempObject = object.get(i);
				tempObject.tick(object);
			}
		}
		
		public void render(Graphics g){
			for(int i = 0; i < object.size(); i++){
				tempObject = object.get(i);
				tempObject.render(g);
			}
		}
		
		public void addObject(GameObject object){
			this.object.add(object);
		}
		
		public void removeObject(GameObject object){
			this.object.remove(object);
		}
		
		public void createLevelBasis(float frameWidth, float frameHeight){
			int y = (int) (frameHeight - 32);
			for(int x = 0; x < frameWidth; x+=32)
				addObject(new Block(x, y, 0, ObjectId.Block));
			int x = 0;
			for(y = y-32; y > 0; y-=32)
				addObject(new Block(x, y, 0, ObjectId.Block));
			y = (int) (frameHeight - 128);
			for(x = 400; x < 500; x+=32)
				addObject(new Block(x, y, 0, ObjectId.Block));
		}
}

package by.bsuir.kovalev.jail.window;

import java.awt.Graphics;
import java.util.LinkedList;

import by.bsuir.kovalev.jail.framework.GameObject;

public class Handler {

		public LinkedList<GameObject> objectList = new LinkedList<GameObject>();
		private GameObject tempObject;
		
		public void tick(){
			for(int i = 0; i < objectList.size(); i++){
				tempObject = objectList.get(i);
				tempObject.tick(objectList);
			}
		}
		
		public void render(Graphics graphics){
			for(int i = 0; i < objectList.size(); i++){
				tempObject = objectList.get(i);
				tempObject.render(graphics);
			}
		}
		
		public void addObject(GameObject object){
			this.objectList.add(object);
		}
		
		public void removeObject(GameObject object){
			this.objectList.remove(object);
		}
}

package by.bsuir.kovalev.jail.window;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

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
		
		public void createLevel(){
			for(int i = 0; i < Game.WIDTH+32; i+=32)
				addObject(new Block(i, Game.HEIGHT-32, ObjectId.Block));
		}
}

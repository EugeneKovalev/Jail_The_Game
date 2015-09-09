package by.bsuir.kovalev.jail.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import by.bsuir.kovalev.jail.window.Handler;

public class KeyInput extends KeyAdapter{
	
	protected Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getObjectId() == ObjectId.Player){
				if(key == KeyEvent.VK_D) tempObject.set_x_velocity(15);
				if(key == KeyEvent.VK_A) tempObject.set_x_velocity(-15);
				if(key == KeyEvent.VK_SPACE && !tempObject.isJumping()){
					tempObject.setIsJumping(true);
					tempObject.set_y_velocity(-10);
				} 
				if(key == KeyEvent.VK_W) tempObject.set_y_velocity(-15);
				if(key == KeyEvent.VK_S) tempObject.set_y_velocity(15);
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getObjectId() == ObjectId.Player){
				if(key == KeyEvent.VK_D) tempObject.set_x_velocity(0);
				if(key == KeyEvent.VK_A) tempObject.set_x_velocity(0);
				//if(key == KeyEvent.VK_W) tempObject.set_y_velocity(0);
				//if(key == KeyEvent.VK_S) tempObject.set_y_velocity(0);
			}
		}
	}
	
}

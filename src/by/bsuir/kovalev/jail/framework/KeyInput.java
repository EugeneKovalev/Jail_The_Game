package by.bsuir.kovalev.jail.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import by.bsuir.kovalev.jail.objects.Player;
import by.bsuir.kovalev.jail.window.Handler;

public class KeyInput extends KeyAdapter{
	
	protected Handler handler;
	public KeyInput(Handler handler){
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.objectList.size(); i++){
			GameObject tempObject = handler.objectList.get(i);
			if(tempObject.getObjectId() == ObjectId.Player){
				if(key == KeyEvent.VK_D) {
					tempObject.set_x_velocity(15);
					System.out.println("goes");
					if(Player.hui == 0)Player.hui = 4;
					else if(Player.hui == 4)Player.hui = 5;
					else if(Player.hui == 5)Player.hui = 6;
					else if(Player.hui == 6)Player.hui = 7;
					else if(Player.hui == 7)Player.hui = 8;
					else if(Player.hui == 8)Player.hui = 9;
					else if(Player.hui == 9)Player.hui = 10;
					else if(Player.hui == 10)Player.hui = 11;
					else if(Player.hui == 11)Player.hui = 4;
					}
				if(key == KeyEvent.VK_A) tempObject.set_x_velocity(-15);
				if(key == KeyEvent.VK_SPACE && !((HumanoidGameObject)tempObject).isJumping()){
					((HumanoidGameObject)tempObject).setIsJumping(true);
					((HumanoidGameObject)tempObject).set_y_velocity(-10);
				}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i< handler.objectList.size(); i++){
			GameObject tempObject = handler.objectList.get(i);
			if(tempObject.getObjectId() == ObjectId.Player){
				if(key == KeyEvent.VK_D) tempObject.set_x_velocity(0);
				if(key == KeyEvent.VK_A) tempObject.set_x_velocity(0);
			}
		}
	}
	
}

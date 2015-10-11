package by.bsuir.kovalev.jail.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import by.bsuir.kovalev.jail.objects.Player;
import by.bsuir.kovalev.jail.window.Handler;

public class KeyInput extends KeyAdapter{
	protected Handler handler;
	private boolean isPressedA = false;
	private boolean isPressedD = false;
	public KeyInput(Handler handler){
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.objectList.size(); i++){
			GameObject tempObject = handler.objectList.get(i);
			if(tempObject.getObjectId() == ObjectId.Player){
				if(key == KeyEvent.VK_D && isPressedD == false) {
					isPressedD = true;
					tempObject.set_x_velocity(15);
					runPressedDButtonAction();
					}
				if(key == KeyEvent.VK_A && isPressedA == false) {
					isPressedA = true;
					tempObject.set_x_velocity(-15);
					runPressedAButtonAction();
				}
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
				if(key == KeyEvent.VK_D) {
					isPressedD = false;
					tempObject.set_x_velocity(0);
				}
				if(key == KeyEvent.VK_A) {
					isPressedA = false;
					tempObject.set_x_velocity(0);
				}
			}
		}
	}
	
	public void checkButtonsState(){
		if(isPressedD) runPressedDButtonAction();
		if(isPressedA) runPressedAButtonAction();
	}
	
	void runPressedDButtonAction(){
		if(Player.imagePart < 4 || Player.imagePart > 10)Player.imagePart = 4;
		else Player.imagePart++;
	}
	
	void runPressedAButtonAction(){
		if(Player.imagePart < 12 || Player.imagePart > 18)Player.imagePart = 12;
		else Player.imagePart++;
	}
	
	
}

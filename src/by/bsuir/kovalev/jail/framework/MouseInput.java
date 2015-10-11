package by.bsuir.kovalev.jail.framework;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import by.bsuir.kovalev.jail.objects.Bullet;
import by.bsuir.kovalev.jail.objects.Player;
import by.bsuir.kovalev.jail.window.Handler;

public class MouseInput extends MouseAdapter{

	protected Handler handler;
	
	public MouseInput(Handler handler){
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mouseKey = e.getButton();
			for(int i = 0; i < handler.objectList.size(); i++){
				GameObject tempObject = handler.objectList.get(i);
				if(tempObject.getObjectId() == ObjectId.Player){
					if(mouseKey == MouseEvent.BUTTON1)runBullet(tempObject); 
				}
			}
	}
	
	private void runBullet(GameObject tempObject){
		int x = tempObject.getX();
		int y = tempObject.getY();
		Bullet bullet = new Bullet(x+30, y+10, 3, 1, ObjectId.Bullet, handler);
		if(Player.imagePart < 4 || Player.imagePart > 11)
			bullet.set_x_velocity(-20);
		else if (Player.imagePart < 12 || Player.imagePart > 18) bullet.set_x_velocity(20);
		handler.addObject(bullet);
	}
	
}

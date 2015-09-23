package by.bsuir.kovalev.jail.framework;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import by.bsuir.kovalev.jail.objects.Bullet;
import by.bsuir.kovalev.jail.window.Handler;

public class MouseInput extends MouseAdapter implements MouseMotionListener{

	protected Handler handler;
	
	public MouseInput(Handler handler){
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mouseKey = e.getButton();
		for(int i = 0; i < handler.objectList.size(); i++){
			GameObject tempObject = handler.objectList.get(i);
			if(tempObject.getObjectId() == ObjectId.Player){
				if(mouseKey == MouseEvent.BUTTON1){
					int x = tempObject.getX();
					int y = tempObject.getY();
					handler.addObject(new Bullet(x, y, 3, 1, ObjectId.Bullet, handler));
				} 
			}
		}
	}
	
}

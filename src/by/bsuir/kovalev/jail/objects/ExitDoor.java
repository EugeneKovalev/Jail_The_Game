package by.bsuir.kovalev.jail.objects;

import java.awt.Graphics;
import java.util.LinkedList;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;

public class ExitDoor extends GameObject{

	public ExitDoor(int x, int y, int width, int height, ObjectId objectId) {
		super(x, y, width, height, objectId);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
	}

	@Override
	public void render(Graphics g) {
	}

}

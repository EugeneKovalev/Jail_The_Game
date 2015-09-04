package by.bsuir.kovalev.jail.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import by.bsuir.kovalev.jail.framework.GameObject;
import by.bsuir.kovalev.jail.framework.ObjectId;

public class Block extends GameObject{

	public Block(float width, float height, ObjectId id) {
		super(width, height, id);
	}

	public void tick(LinkedList<GameObject> object) {
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect((int)width, (int)height, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)width, (int)height, 32, 32);
	}

}
 
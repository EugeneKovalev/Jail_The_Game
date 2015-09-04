package by.bsuir.kovalev.jail.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import by.bsuir.kovalev.jail.framework.KeyInput;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.objects.Block;
import by.bsuir.kovalev.jail.objects.Player;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -3957124689436603261L;
	private boolean isRunning = false;
	private Thread thread;
	Handler handler;
	Random rand = new Random();
	public static int WIDTH, HEIGHT;
	
	public static void main(String args[]){
		new Window(800, 600, "Jail The Game", new Game());
	}
	
	public synchronized void start(){
		if(isRunning)
			return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		initializeTestObjects();
		this.requestFocus();
		holly_bullshit();
	}
	
	private void holly_bullshit(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(isRunning){
			System.out.println("MY SHIT: " + delta);
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				System.out.println("===============");
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void tick(){
		handler.tick();;
	}
	
	private void render(){
		BufferStrategy bufferStrategy = this.getBufferStrategy();
		if(bufferStrategy == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bufferStrategy.getDrawGraphics();
		//////////////////////////////////////
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		handler.render(g);

		///////////////////
		g.dispose();
		bufferStrategy.show();
	}
	
	private void initializeTestObjects(){
		WIDTH = getWidth();
		HEIGHT = getHeight();
		handler = new Handler();
		handler.addObject(new Player(100, 100, handler, ObjectId.Player));
		handler.createLevel();
		this.addKeyListener(new KeyInput(handler));
	}
}

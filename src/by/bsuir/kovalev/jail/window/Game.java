package by.bsuir.kovalev.jail.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;



import java.awt.image.BufferedImage;

import by.bsuir.kovalev.jail.framework.KeyInput;
import by.bsuir.kovalev.jail.framework.ObjectId;
import by.bsuir.kovalev.jail.framework.Texture;
import by.bsuir.kovalev.jail.objects.Block;
import by.bsuir.kovalev.jail.objects.Player;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -3957124689436603261L;
	private boolean isRunning = false;
	private Thread thread;
	protected Handler handler;
	protected Camera camera;
	static Texture texture;
	private BufferedImage levelImage = null;
	
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
		initializeGameObjects();
		displayGameObjects();
	}
	
	private void initializeGameObjects(){
		handler = new Handler();
		texture = new Texture();
		loadLevel();
		setCameraPosition();
		
		
		
		this.addKeyListener(new KeyInput(handler));
		
	}
	
	private void loadLevel(){
		BufferedImageLoader loader = new BufferedImageLoader();
		levelImage = loader.loadImage("/level.png");
		loadLevelFromImage(levelImage);
	}
	
	private void setCameraPosition(){
		camera = new Camera();
		this.requestFocus();
	}
	
	private void displayGameObjects(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(isRunning){
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / ns;
			lastTime = currentTime;
			while(delta >= 1){
				tick();
				
				delta--;
			}	render();
		}
	}
	
	private void tick(){
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getObjectId() == ObjectId.Player){
				camera.tick(handler.object.get(i));
			}
		}
		
	}
	
	private void render(){
		BufferStrategy bufferStrategy = this.getBufferStrategy();
		if(bufferStrategy == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bufferStrategy.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		//////////////////////////////////////
		
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.translate(camera.getX(), camera.getY());
		handler.render(g);
		g2d.translate(-camera.getX(), -camera.getY());
		///////////////////
		g.dispose();
		bufferStrategy.show();
	}
	
	private void loadLevelFromImage(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx<h; xx++){
			for(int yy = 0; yy<w; yy++){
				int pixel = image.getRGB(xx, yy); 
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				if(red == 255 && green == 255 && blue == 255){
					handler.addObject(new Block(xx*32, yy*32, 0, ObjectId.Block));
				}
				if(red == 0 && green == 0 && blue == 255){
					handler.addObject(new Player(xx*32, yy*32, handler, ObjectId.Player));
				}
			}
		}
		//System.out.p
	}
	
	public static Texture getInstance(){
		return texture;
	}
	
}

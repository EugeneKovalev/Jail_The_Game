package by.bsuir.kovalev.jail.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import by.bsuir.kovalev.jail.framework.Sound;

public class Window extends MouseAdapter{
	
	private BufferedImage mainMenuImage = null;
	
	public Window(int width, int height, String title, Game game){
		game.setPreferredSize(new Dimension(width, height));
		setFrame(game, title);
		startSoundtrack();
		loadMainMenuImage();
		game.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent e) {
				int mouseKey = e.getButton();
				if(mouseKey == MouseEvent.BUTTON1){
					boolean newGameClick = checkForNewGameClick(e);
					boolean exitClick = checkForExitClick(e);
					if(newGameClick){
						game.removeMouseListener(this);
						game.start();
					}
					if(exitClick)System.exit(0);					
				}
			}
		});
		drawMainMenu(game);
	}
	
	private boolean checkForNewGameClick(MouseEvent e){
		if((e.getX()>186 && e.getX()<290) && (e.getY()>389 && e.getY()<415))
			return true;
		else return false;
	}
	
	private boolean checkForExitClick(MouseEvent e){
		if((e.getX()>543 && e.getX()<615) && (e.getY()>392 && e.getY()<414))
			return true;
		else return false;
	}
	
	private void startSoundtrack(){
		Sound soundtrack = new Sound("/soundtrack.wav");
		soundtrack.start();
	}
	
	private void loadMainMenuImage(){
		BufferedImageLoader loader = new BufferedImageLoader();
		mainMenuImage = loader.loadImage("/intro.png");
	}
	
	private void drawMainMenu(Game game){
		while(true){
			BufferStrategy bufferStrategy = game.getBufferStrategy();
			if(bufferStrategy == null){
				game.createBufferStrategy(3);
				bufferStrategy = game.getBufferStrategy();
			}
			Graphics2D graphics2D = (Graphics2D) bufferStrategy.getDrawGraphics();
			graphics2D.setColor(Color.BLACK);
			graphics2D.fillRect(0, 0, game.getWidth(), game.getHeight());
			graphics2D.drawImage(mainMenuImage, 170, 10, game);	
			graphics2D.dispose();
			bufferStrategy.show();
			if(game.isRunning()) break;
		}
	}
	
	private void setFrame(Game game, String title){
		JFrame frame = new JFrame(title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}

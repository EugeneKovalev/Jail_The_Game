package by.bsuir.kovalev.jail.window;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window {
	
	public Window(int width, int height, String title, Game game){
		game.setPreferredSize(new Dimension(width, height));
		setFrame(game, title);
		
		game.start();
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

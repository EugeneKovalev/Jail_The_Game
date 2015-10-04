package by.bsuir.kovalev.jail.framework;

import java.awt.image.BufferedImage;

import by.bsuir.kovalev.jail.window.BufferedImageLoader;

public class Texture {
	SpriteSheet bs, ps, ss;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	private BufferedImage security_sheet = null;
	public BufferedImage[] block = new BufferedImage[1];
	public BufferedImage[] player = new BufferedImage[12];
	public BufferedImage[] security = new BufferedImage[1];
	
	public Texture(){
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			block_sheet = loader.loadImage("/block_sheet.png");
			player_sheet = loader.loadImage("/player_sheet.png");
			security_sheet = loader.loadImage("/security_sheet.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		ss = new SpriteSheet(security_sheet);
		getTextures();
	}
	
	private void getTextures(){
		block[0] = bs.grabImage(1, 1, 32, 32);
		player[0] = ps.grabImage(1, 1, 66, 96);
		player[1] = ps.grabImage(1, 2, 66, 96);
		player[2] = ps.grabImage(1, 3, 66, 96);
		player[3] = ps.grabImage(1, 4, 66, 96);
		player[4] = ps.grabImage(1, 5, 66, 96);
		player[5] = ps.grabImage(1, 6, 78, 96);
		player[6] = ps.grabImage(1, 7, 97, 96);
		player[7] = ps.grabImage(1, 8, 92, 96);
		player[8] = ps.grabImage(1, 9, 77, 96);
		player[9] = ps.grabImage(1, 10, 54, 96);
		player[10] = ps.grabImage(1, 11, 52, 96);
		player[11] = ps.grabImage(1, 12, 58, 96);
		security[0] = ss.grabImage(1, 1, 64, 190);
	}
}

package ai.game.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width = 32, height = 32;
	//represent images from the spritesheet
	public static BufferedImage player, enemy, reward, dirt, rock, hole;
	//called once, loads in everything for the game
	public static void init(){
		//load spreadsheet
		SpriteSheet sheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/Scavengers_SpriteSheet.png"));
		//laod assets
		player = sheet.crop(0, 0, width, height);
		enemy = sheet.crop(0, height * 2, width, height);
		dirt = sheet.crop(0, height * 4, width, height);
		rock = sheet.crop(width, height * 3, width, height);
		hole = sheet.crop(0, height * 3, width, height);
		reward = sheet.crop(width * 2, height * 2, width, height);
		
		
	}
}

package ai.game.tilegame.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	//takes a String param of the file location and tries to find it
	//for example; (/textures/image.png
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			//if fail exit
			System.exit(1);
		}
		return null;
	}
}

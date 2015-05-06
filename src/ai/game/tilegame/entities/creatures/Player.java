package ai.game.tilegame.entities.creatures;

import java.awt.Graphics;

import ai.game.tilegame.gfx.Assets;

public class Player extends Creature {

	public Player(float x, float y) {
		super(x, y);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		//cast floats into ints
		g.drawImage(Assets.player, (int)x, (int)y, null);
		
	}

}

package ai.game.tilegame.states;

import java.awt.Graphics;

import ai.game.tilegame.entities.creatures.Player;
import ai.game.tilegame.gfx.Assets;



public class GameState extends State {

	
	private Player player;
	
	public GameState(){
		player = new Player(100, 100);
		
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}

package ai.game.tilegame.entities.creatures;

import ai.game.tilegame.entities.Entity;

public abstract class Creature extends Entity {
	
	protected int health;

	public Creature(float x, float y) {
		super(x, y);
		health = 10;
	}
	
}

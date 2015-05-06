package ai.game.tilegame;

//starts up game
public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("GAME" , 400 , 400);
		game.start();
	}
}

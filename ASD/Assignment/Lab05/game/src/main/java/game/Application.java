package game;

public class Application {

	public static void main(String[] args) {
//		Game game = new Game();
		FFUser game = new FFUser(1);
		game.setUserLevel(new Level1(game));
		game.play();
		game.play();
		game.play();
		game.play();
		game.play();

	}

}

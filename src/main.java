
public class main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Game of Life ");
		
		Game game = new Game();
		
		for(int i = 0; i < 20; i++) {
			game.nextState();
		}
		
		

	}

}

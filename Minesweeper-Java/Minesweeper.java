import java.util.Scanner;
/**
  * this class holds the main method
  * 
  */
public class Minesweeper {
    private static final Scanner in = new Scanner(System.in);
	private static MineField field;
	private static Ranking rank = new Ranking();
	private static int result;

	public static void main(String[] args) {
		Minesweeper game = new Minesweeper();
		game.start();
	}

	Minesweeper() {
		init(true);
	}
	
	public void start() {
		mainMessage();
		while (gameCountinue());
		System.out.println("\nThank you for playing :) Have a nice day!");
	}
	
	private static void init(boolean first) {
		if (!first)
			rank.recordName(result);
		field = new MineField();
		result = 0;
	}

	private static boolean gameCountinue() {
		field.show();
		System.out.print("\nPlease enter your move(row col): ");
		String input = in.nextLine();

		if (evalInput(input))
			return false;

		if (field.legalMoveString(input) && ++result == 35) {
			System.out.println("Congratulations you WON the game!");
			init(false);
		} else if (field.getBoom()) {
			System.out.println(
					"\nBooooooooooooooooooooooooooooom!You stepped on a mine!You survived " + result + " turns");
			init(false);
			
		}
		return true;
	}

	private static boolean evalInput(String input) {
		if (input.equalsIgnoreCase("exit")) {
			rank.recordName(result);
			return true;
		} else if (input.equalsIgnoreCase("restart")) {
			init(false);
		} else if (input.equalsIgnoreCase("top"))
			rank.show();
		return false;
	}

/**
  * This is the menu for the game
  * 
  */
	
	private static void mainMessage(){
		System.out.println(
		    "Welcome to Minesweeper!\n" +
			"To play just input some coordinates and try not to step ont mine :)\n" +
			"Usefull commands:\n" +
			"restart- Starts a new game.\n" +
			"exit- Quits the game.\n" +
			"top- Reveals the top scoreboard.\n" +
			"Have Fun !");
	}
}

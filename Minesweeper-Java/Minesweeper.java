import java.util.Scanner;

public class Minesweeper {
    private static final Scanner in = new Scanner(System.in);
	private static MineField field;
	private static Ranking rank = new Ranking();
	private static int result;
	private static int rowMax;
	private static int colMax;
	private static int seed;

	public static void main(String[] args) {
		Minesweeper game = new Minesweeper(5, 10, 0);
		game.start();
	}

	/**
	 * Returns a Minesweeper object to play the game.
	 * This object will only create the game itself, not actually start it.
	 * 
	 * @param rowMax	Number of rows used for minefield generated
	 * @param colMax	Number of colons used for minefield generated
	 * @param seed		Specify	own seed value for the PRNG, a value of 0 means
	 * 					no specified seed value will be used
	 * @see				MineField#MineField(int)
	 * @see 			Minesweeper#start()
	 */
	Minesweeper(int rowMax, int colMax, int seed) {
		Minesweeper.seed = seed;
		Minesweeper.rowMax = rowMax;
		Minesweeper.colMax = colMax;
		init(true);
	}
	
	/**
	 * Starts the game.
	 */
	public void start() {
		mainMessage();
		while (gameContinue());
		System.out.println("\nThank you for playing :) Have a nice day!");
	}
	
	private static void init(boolean first) {
		if (!first)
			rank.recordName(result);
		field = new MineField(rowMax, colMax, seed);
		result = 0;
	}

	private static boolean gameContinue() {
		field.show();
		System.out.print("\nPlease enter your move(row col): ");

		if (evalInput(in.nextLine().toLowerCase()))
			return false;

		return true;
	}

	private static boolean evalInput(String input) {
		switch(input) {
		case "exit":
			rank.recordName(result);
			return true;
		case "restart":
			init(false);
			break;
		case "top":
			rank.show();
			break;
		default:
			mineProbe(input);
		}
		return false;
	}

	private static void mineProbe(String input) {
		if (field.legalMoveString(input) && ++result == 35) {
			System.out.println("Congratulations you WON the game!");
			init(false);
		} else if (field.getBoom()) {
			System.out.println(
					"\nBooooooooooooooooooooooooooooom!You stepped on a mine!You survived " + result + " turns");
			init(false);
		}
	}

	private static void mainMessage(){
		System.out.println(
		    "Welcome to Minesweeper!\n" +
			"To play just input some coordinates and try not to step on a mine :)\n" +
			"Useful commands:\n" + "restart- Starts a new game.\n" +
			"exit- Quits the game.\n" + "top- Reveals the top scoreboard.\n" +
			"Have Fun !");
	}
}

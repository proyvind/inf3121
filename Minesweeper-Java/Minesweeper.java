import java.util.Scanner;
/**
  * this class holds the main method
  * 
  */
public class Minesweeper {
    private static Scanner in;
	private static MineField field;
	private static Ranking rank;	
	public static void main(String[] args) {
		rank=new Ranking();
		mainMessage();
		while(gameCountinue());
		System.out.println("\nThank you for playing :) Have a nice day!");
	}	
	private static boolean gameCountinue() {
		field = new MineField();
		int result = 0;
		while (true) {

			field.show();
			System.out.print("\nPlease enter your move(row col): ");
			in = new Scanner(System.in);
			String input = in.nextLine();

			if (evalInput(input, result))
				return false;

			if (field.legalMoveString(input)) {
				if (++result == 35) {
					System.out.println("Congratulations you WON the game!");
					rank.recordName(result);
					return true;
				}
				continue;
			}else if (field.getBoom()) {
				System.out.println("\nBooooooooooooooooooooooooooooom!You stepped on a mine!You survived " + result + " turns");
				rank.recordName(result);
				return true;
			}

		}

	}
	
	private static boolean evalInput(String input, int result) {
		if (input.equalsIgnoreCase("exit")) {
			rank.recordName(result);
			return true;
		}
		else if (input.equalsIgnoreCase("restart"))
			rank.recordName(result);
		else if (input.equalsIgnoreCase("top"))
			rank.show();
		return false;
	}

/**
  * This is the menu for the game
  * 
  */
	
	private static void mainMessage(){
		System.out.println("Welcome to Minesweeper!" 
			+ "\nTo play just input some coordinates and try not to step ont mine :)"
			+ "\nUsefull commands:"
			+ "\nrestart- Starts a new game."
			+ "\nexit- Quits the game."
			+ "\ntop- Reveals the top scoreboard."
			+ "\nHave Fun !");
	}
}

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking{

	private final int MAX_PEOPLE_LIMIT = 5;
	private List<HighScore> highScores;
	private int last;
	private final Scanner in=new Scanner(System.in);
	
	Ranking(){
		highScores = new ArrayList<>(MAX_PEOPLE_LIMIT);
		
		last=0;
	}


	public void recordName(int result) {
		System.out.print("\n Please enter your name -");
		
		record(result, in.nextLine());
		sort();
		show();
	}
	private void record(int result, String newName) {
		if((last==MAX_PEOPLE_LIMIT)&&highScores.get(MAX_PEOPLE_LIMIT-1).score>result){
			System.out.println("\nSorry you cannot enter top "+(MAX_PEOPLE_LIMIT)+" players");
			return;
		}
		else if(last==MAX_PEOPLE_LIMIT)
			highScores.set(MAX_PEOPLE_LIMIT - 1, new HighScore(newName, result));
		else{
			highScores.add(new HighScore(newName, result));
			last++;
		}
	}


	public void show() {
		if(last==0){
			System.out.println("Still no results");
			return;
		}
		System.out.println(String.format("%1$2s. %2$-10s\t%3$s", "N", "Name", "Result"));
		for (int i = 0; i < highScores.size(); i++) {
			HighScore result = highScores.get(i);
			System.out.println(String.format("%1$2d. %2$-10s\t%3$s", i + 1, result.name, result.score));
		}
	}
	
	private void sort(){
		Collections.sort(highScores, (r1, r2) -> r2.score - r1.score);
	}
	
	static class HighScore {
		public final String name;
		public final int score;

		public HighScore(String name, int score) {
			this.name = name;
			this.score = score;
		}

		@Override
		public String toString() {
			return String.format("%1$-10s\t%2$s", name, score);
		}
	}

}

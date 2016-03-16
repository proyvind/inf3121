import java.util.Scanner;

public class Ranking{

	private final int MAX_PEOPLE_LIMIT=5;
	private String[] name;
	private int[] record;
	private int last;
	private final Scanner in=new Scanner(System.in);
	
	Ranking(){
		name=new String[MAX_PEOPLE_LIMIT];
		record=new int[MAX_PEOPLE_LIMIT];
		
		last=0;
	}


	public void recordName(int result) {
		System.out.print("\n Please enter your name -");
		
		record(result, in.nextLine());
		sort();
		show();
	}
	private void record(int result, String newName) {
		if((last==MAX_PEOPLE_LIMIT)&&record[MAX_PEOPLE_LIMIT-1]>result){
			System.out.println("\nSorry you cannot enter top "+(MAX_PEOPLE_LIMIT)+" players");
			return;
		}
		else if(last==MAX_PEOPLE_LIMIT){
			name[MAX_PEOPLE_LIMIT-1]=newName;
			record[MAX_PEOPLE_LIMIT-1]=result;
		}
		else{
			name[last]=newName;
			record[last]=result;
			last++;
		}
	}


	public void show() {
		if(last==0){
			System.out.println("Still no results");
			return;
		}
		System.out.println("N Name\t\tresult");
		for(int i=0;i<last;i++)
			System.out.println((i+1)+" "+name[i]+"\t"+record[i]);
	}

	private void swap(int i){
		record[i]^=record[i+1];
		record[i+1]^=record[i];
		record[i]^=record[i+1];
		String swapN=name[i];
		name[i]=name[i+1];
		name[i+1]=swapN;
	}
	
	private void sort(){
		if(last<2) return;
		boolean unsorted=true;
		while(unsorted)
			unsorted=sortCont();
	}
	
	private boolean sortCont() {
		boolean unsorted = true;
		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < (last - 1); i++)
				if (record[i + 1] > record[i]) {
					swap(i);
					unsorted=true;
				}
		}
		return unsorted;
	}
}

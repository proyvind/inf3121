import java.util.Random;

class MineField{

	private boolean[][] mines,visible;
	private boolean boom;
	private final int rowMax = 5;
	private final int colMax = 10;
	
	MineField(){
		
		mines=new boolean[rowMax][colMax];
		visible=new boolean[rowMax][colMax];
		boom=false;
		

		int counter2=15;
		int randomRow,randomCol;
		Random RGenerator=new Random();
		
		while(counter2>0){
			
			randomRow=Math.abs(RGenerator.nextInt()%rowMax);
			randomCol=Math.abs(RGenerator.nextInt()%colMax);
			
			if(trymove(randomRow,randomCol))
				counter2--;
		}
	}
	private boolean trymove(int randomRow, int randomCol) {
		if(mines[randomRow][randomCol])
			return false;
		else{
			mines[randomRow][randomCol]=true;
			return true;
		}
	}
	private void boom() {
		for(int row=0;row<rowMax;row++)
			for(int col=0;col<colMax;col++)
				if(mines[row][col])
					visible[row][col]=true;
		boom=true;
		show();
	}


	private void drawRow(int row) {
		StringBuilder line = new StringBuilder(colMax * 2);
		for (int col = 0; col < colMax; col++) {
			if (visible[row][col])
				line.append((mines[row][col] ? "* " : Integer.toString(minesNearby(row, col)) + ' '));
			else
				line.append((boom ? "- " : "? "));
		}
		System.out.println(row + " | " + line.toString() + "|");

	}
	private int minesNearby(int row, int col){
		int count = 0;

		for (int irow = ((row-1 > 0) ? row-1 : 0); irow <= ((row + 1 >= rowMax) ? rowMax-1 : row+1); irow++)
			for (int icol = ((col-1 > 0) ? col-1 : 0); icol <= ((col+1 >= rowMax) ? rowMax-1 : col+1); icol++)
				if (mines[irow][icol])
					count++;
		
		return count;
	}
	
	public boolean getBoom(){
		
		return boom;
	}


	public boolean legalMoveString(String input) {
		String[] separated=input.split(" ");
		int row;
		int col;
		try{
			
			
			row=Integer.parseInt(separated[0]);
			col=Integer.parseInt(separated[1]);
			if(row<0||col<0||row>=rowMax||col>=colMax)
				throw new java.io.IOException();
		}
		catch(Exception e){
			System.out.println("\nInvalid Input!");
			return false;
		}
		
		if(legalMoveValue(row,col))
			return true;
		else
			return false;
 	}

	private boolean legalMoveValue(int row, int col) {
		
		if(visible[row][col]){
			System.out.println("You stepped in allready revealed area!");
			return false;
		}
		else
			visible[row][col]=true;
		
		if(mines[row][col]){
			boom();
			return false;
		}
		
		return true;
	}
	public void show() {
		System.out.println("\n    0 1 2 3 4 5 6 7 8 9 ");
		System.out.println("   ---------------------");
		for(int row=0;row<rowMax;row++)
			drawRow(row);
		System.out.println("   ---------------------");
	}
	
}

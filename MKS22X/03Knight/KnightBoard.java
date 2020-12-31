public class KnightBoard {

    private int[][] board;
    private int[][] moves = new int[][] {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};  


    public KnightBoard (int startingRows,int startingCols) {
	if (startingRows < 0 || startingCols < 0) {
	    throw new IllegalArgumentException();
	}
	
	board = new int[startingRows][startingCols];
	for (int r = 0; r < startingRows; r++) {
	    for (int c = 0; c < startingCols; c++) {
		board[r][c] = 0;
	    }
	}
    }

    public String toString() {
	String brd = "";
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] == 0) {
		    brd += "__ ";
		}
		if (board.length * board[r].length > 10) {
		    if (board[r][c] < 10 && board[r][c] > 0) {
			brd += " " + board[r][c] + " ";
		    }
		    else if (board[r][c] != 0) {
			brd += board[r][c] + " ";
		    }
		}
		else if (board[r][c] != 0) {
		    brd += " " + board[r][c] + " ";
		}
	    }
	    brd += "\n";
	}
	return brd;
    }

    public boolean solve (int startingRow, int startingCol) {
	if (startingRow < 0 || startingCol < 0 || startingRow > board.length - 1 || startingCol > board.length - 1) {
	    throw new IllegalArgumentException();
	}
	
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board.length; c++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(startingRow, startingCol, 1);
    }

    private boolean solveH (int row, int col, int level) {
	if (level > board.length * board[0].length) {
	    return true;
	}
       
	for (int i[]: moves) {
	    try {
		if (board[row][col] == 0) {
		    board[row][col] = level;
		    if (solveH(row + i[0],col + i[1], level + 1)) {
			//System.out.println(toString());
			return true;			
		    }
		    else {
			board[row][col] = 0;
		    }
		}		
	    }catch (Exception e) {
	    }
	}
	
	return false;
    }


    public int countSolutions (int startingRow, int startingCol) {
	if (startingRow >= board.length || startingRow < 0 || startingCol >= board[0].length || startingCol < 0) {
	    throw new IllegalArgumentException();
	}
	
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return totalSol(startingRow, startingCol, 1);
    }

    public int totalSol(int row, int col, int level){
	int totalSol = 0;	
	
	if (level == board.length * board[0].length){
	    return 1; 
	}	 
	
	for (int i[]: moves) {
	    try {
		if (board[row+i[0]][col+i[1]] == 0) {
		    board[row][col] = level;
		    totalSol += totalSol(row+i[0],col+i[1], level + 1);
		    board[row][col] = 0;		    
		}
					
	    }catch(Exception e) {
	    }
	   
	}
	
	return totalSol;
    }

    public static void main(String[]args){
	KnightBoard a = new KnightBoard(5,5);
	System.out.println(a.toString());

	System.out.println("solveable? " + a.solve(0,0) + ". ");
	System.out.println(a);
    }
}

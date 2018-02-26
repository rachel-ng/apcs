public class KnightBoard {
    private int[][] board;
    private int[] movesR = new int[] {-2, -2, 2, 2, -1, -1, 1, 1};
    private int[] movesC = new int[] {-1, 1, -1, 1, -2, 2, -2, 2}; 
    
	
    public KnightBoard(int startingRows,int startingCols) {
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

    public boolean addKnight(int r, int c, int l) {
	if (r < board.length && r > -1 && c < board[r].length && c > -1 && l < board.length * board[0].length) {
	    if (board[r][c] == 0) {
		board[r][c] = l;
		return true;
	    }
	    else {
		return false;
	    }
	}
	return false;
    }

    public boolean removeKnight(int r, int c) {
	if (r < board.length && r > -1 && c < board[r].length && c > -1) {
	    if (board[r][c] > 0) {
		board[r][c] = 0;
		return true;
	    }
	    else {
		return false;
	    }
	}
	return false;
    }
    
    public String toString() {
	String brd = "";
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] == 0) {
		    brd += "__ ";
		}
		if (board.length * board[r].length >= 10) {
		    if (board[r][c] < 10 && board[r][c] > 0) {
			brd += " " + board[r][c] + " ";
		    }
		    else if (board[r][c] != 0) {
			brd += board[r][c] + " ";
		    }
		}
		else if (board[r][c] != 0) {
		    brd += board[r][c] + " ";
		}
	    }
	    brd += "\n";
	}
	return brd;
    }
    
    
    public boolean solve(int startingRow, int startingCol) {
	if (startingRow < 0 || startingCol < 0 || startingRow > board.length - 1 || startingCol > board.length - 1) {
	    throw new IllegalArgumentException();
	}
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(startingRow,startingCol,1);
    }

    private boolean solveH(int row, int col, int level) {
	if (level == board.length * board[0].length) {
	    return true;
	}
	for (int i = 0; i < movesR.length; i++) {
	    if (addKnight(row + movesR[i], col + movesC[i], level ++)) {
		if (solveH(row + movesR[i], col + movesC[i], level ++)) {
		    return true;
		}
		else {
		    board[row][col] = 0;
		}
	    }
	    removeKnight(row + movesR[i],col +movesC[i]);
	}
	return false;
    }

    private boolean full() {
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] == 0) {
		    return false;
		}
	    }
	}
	return true;
    }

    public int countSolutions(int startingRow, int startingCol) {
	if (startingRow < 0 || startingCol < 0) {
	    throw new IllegalArgumentException();
	}
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return countSol(startingRow,startingCol,1);
    }

    private int countSol(int row, int col, int level) {
	int sol = 0;
	if (level == board.length * board[0].length) {
	    // System.out.println(toString());
	    return 1;
	}
	for (int i = 0; i < movesR.length; i++) {
	    if (addKnight(row + movesR[i], col + movesC[i], level ++)) {
		sol += countSol(row + movesR[i], col + movesC[i], level ++);
	    }
	    removeKnight(row + movesR[i],col +movesC[i]);
	}
	return sol;
    }    

    public void totalSol() {
	int totalSol = 0;
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		totalSol += countSolutions(i,j);
	    }
	}
	System.out.println(totalSol);
    }

    
    public static void main (String[] args) { // My Driver
	KnightBoard b = new KnightBoard(5,5);

	System.out.println(b.toString());

	/*
	System.out.println(b.addKnight(0,0,1));
	System.out.println(b.toString());
	System.out.println(b.addKnight(1,2,2));
	System.out.println(b.toString());
	System.out.println(b.addKnight(0,1,3));
	System.out.println(b.toString());
	System.out.println(b.addKnight(3,3,4));
	System.out.println(b.toString());
	System.out.println(b.addKnight(3,2,5));
	System.out.println(b.toString());
	System.out.println(b.removeKnight(3,2));
	System.out.println("is this full? " + b.full());
	System.out.println(b.toString());
	*/
	
	System.out.println(b.countSolutions(0,0));
	/*
	System.out.println(b.countSolutions(0,1));
	System.out.println(b.countSolutions(0,2));
	System.out.println(b.countSolutions(0,3));
	System.out.println(b.countSolutions(0,4));
	System.out.println(b.countSolutions(1,0));
	System.out.println(b.countSolutions(1,1));
	System.out.println(b.countSolutions(1,2));
	System.out.println(b.countSolutions(1,3));
	System.out.println(b.countSolutions(1,4));
	System.out.println(b.countSolutions(2,0));
	System.out.println(b.countSolutions(2,1));
	System.out.println(b.countSolutions(2,2));
	System.out.println(b.countSolutions(2,3));
	System.out.println(b.countSolutions(2,4));
	System.out.println(b.countSolutions(3,0));
	System.out.println(b.countSolutions(3,1));
	System.out.println(b.countSolutions(3,2));
	System.out.println(b.countSolutions(3,3));
	System.out.println(b.countSolutions(3,4));
	System.out.println(b.countSolutions(4,0));
	System.out.println(b.countSolutions(4,1));
	System.out.println(b.countSolutions(4,2));
	System.out.println(b.countSolutions(4,3));
	System.out.println(b.countSolutions(4,4));
	*/
	b.totalSol();


	//System.out.println(b.countSolutions());
    }

    
}

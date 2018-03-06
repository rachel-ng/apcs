public class KnightBoard {
    private int[][] board;
    private int[][] moves = new int[][] {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};    
	
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
	if (level > board.length * board[0].length) {
	    return true;
	}
	for (int m = 0; m < moves.length; m++) {
	    if (addKnight(row + moves[m][0], col + moves[m][1], level++)) {
		if (solveH(row + moves[m][0], col + moves[m][1], level++)) {
		    return true;
		}
	    }
	    //System.out.println(toString());
	    removeKnight(row + moves[m][0],col + moves[m][1]);
	}
       	return false;
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
	    return 1;
	}
	for (int m = 0; m < moves.length; m++) {
	    if (addKnight(row + moves[m][0], col + moves[m][1], level++)) {
		sol += countSol(row + moves[m][0], col + moves[m][1], level++);
	    }
	    removeKnight(row + moves[m][0],col + moves[m][1]);
	}
	return sol;
    }    

    public void totalSol() {
	int totalSol = 0;
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		System.out.println(countSolutions(i,j));
		totalSol += countSolutions(i,j);
	    }
	}
	System.out.println(totalSol);
    }
    
    public static void main (String[] args) { // My Driver
	KnightBoard a = new KnightBoard(5,5);
	KnightBoard b = new KnightBoard(5,5);

	System.out.println(a.toString());
	System.out.println(b.toString());

	System.out.println("solveable? " + a.solve(0,0) + ". ");
	System.out.println(a);
	
	b.totalSol();

	//System.out.println(b.countSolutions());
    }

    
}

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
    
    
    public boolean solve() {
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(0,0,0);
    }

    private boolean solveH(int row ,int col, int level) {
	if (full()) {
	    return true;
	}
	for (int i = 0; i < 8; i++) {
	    System.out.println(toString());
	    if (solveH(row + movesR[i], col + movesC[i], level++)) {
		return true;
	    }
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
    
    /*
    public int countSolutions() {
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
    }
    */
    
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
	
	System.out.println(b.solve());
	System.out.println(b.toString());

	//System.out.println(b.countSolutions());
    }

    
}

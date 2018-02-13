public class KnightBoard {
    private int[][] board;
    
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
	if (r < board.length && c < board[r].length) {
	    if (board[r][c] == 0) {
		board[r][c]--;
		return true;
	    }
	    else {
		return false;
	    }
	}
	return false;
    }

    public boolean removeKnight(int r, int c) {
	if (r < board.length && c < board[r].length) {
	    if (board[r][c] == -1) {
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
    
    /*
    public boolean solve() {
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(0);
    }

    private boolean solveH(int row ,int col, int level) {
	
    }
    */

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
	KnightBoard b = new KnightBoard(7,7);

	System.out.println(b.toString());
	
	System.out.println(b.addKnight(0,0,1));
	System.out.println(b.toString());
	System.out.println(b.addKnight(1,2,2));
	System.out.println(b.toString());
	System.out.println(b.addKnight(0,0,3));
	System.out.println(b.toString());
	System.out.println(b.addKnight(3,3,4));
	System.out.println(b.toString());
	System.out.println(b.addKnight(3,2,5));
	System.out.println(b.toString());
	System.out.println(b.removeKnight(3,2));
	System.out.println("is this bitch full? " + b.full());
	System.out.println(b.toString());
	
	//System.out.println(b.solve());
	//System.out.println(b.countSolutions());
    }

    
}

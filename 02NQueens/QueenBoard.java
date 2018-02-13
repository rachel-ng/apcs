public class QueenBoard {
    private int[][] board;

    public QueenBoard(int size) {
	board = new int[size][size];
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		board[r][c] = 0;
	    }
	}
    }

    private boolean addQueen(int r, int c) {
	if (r < board.length && c < board[r].length) {
	    if (board[r][c] == 0) {
		board[r][c]--;
		nope(r,c);
		System.out.println("addQueen(" + r + "," + c + ")");
		return true;
	    }
	    else {
		return false;
	    }
	}
	return false;
    }


    private void nope(int r, int c) {
	for (int rr = r + 1, cc = c + 1; rr < board.length && cc < board.length; rr++, cc++) {
	    board[rr][cc]++;
	}
	for (int rr = r + 1; rr < board.length; rr++) {
	    board[rr][c]++;
	}
	for (int cc = c + 1; cc < board.length; cc++) {
	    board[r][cc]++;
	}
	for (int rr = r - 1, cc = c + 1; rr > -1 && cc < board.length; rr--, cc++) {
	    board[rr][cc]++;
	}
	if (r > 0 || c > 0) {
	    for (int rr = r - 1, cc = c - 1; rr > -1 && cc > -1; rr--, cc--) {
		board[rr][cc]++;
	    }
	    for (int rr = r - 1;  rr > -1; rr--) {
		board[rr][c]++;
	    }
	    for (int cc = c - 1; cc > -1; cc--) {
		board[r][cc]++;
	    }
	    for (int rr = r + 1, cc = c - 1; rr > board.length && cc > -1; rr++, cc--) {
		board[rr][cc]++;
	    }
	}
    }
    
    private boolean removeQueen(int r, int c) {
	if (r < board.length && c < board[r].length) {
	    if (board[r][c] == -1) {
		board[r][c]++;
		abort(r,c);
		System.out.println("removeQueen(" + r + "," + c + ")");
		return true;
	    }
	    else {
		return false;
	    }
	}
	return false;
    }

    private void abort(int r, int c) {
	for (int rr = r + 1, cc = c + 1; rr < board.length && cc < board.length; rr++, cc++) {
	    board[rr][cc]--;
	}
	for (int rr = r + 1; rr < board.length; rr++) {
	    board[rr][c]--;
	}
	for (int cc = c + 1; cc < board.length; cc++) {
	    board[r][cc]--;
	}
	for (int rr = r - 1, cc = c + 1; rr > -1 && cc < board.length; rr--, cc++) {
	    board[rr][cc]--;
	}
	if (r > 0 || c > 0) {
	    for (int rr = r - 1, cc = c - 1; rr > -1 && cc > -1; rr--, cc--) {
		board[rr][cc]--;
	    }
	    for (int rr = r - 1;  rr > -1; rr--) {
		board[rr][c]--;
	    }
	    for (int cc = c - 1; cc > -1; cc--) {
		board[r][cc]--;
	    }
	    for (int rr = r + 1, cc = c - 1; rr > board.length && cc > -1; rr++, cc--) {
		board[rr][cc]--;
	    }
	}
    }
    
    public String toString() {
	String brd= "";
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] == -1) {
		    brd += "Q ";
		    //brd += board[r][c] + "\t";
		}
		else {
		    //brd += "_ ";
		    brd += board[r][c] + " "; //+ "\t";
		}
	    }
	    brd += "\n";
	}
	return brd;
    }
    
    public boolean solve() {
	if (board[0][0] != 0) {
	    throw new IllegalStateException();
	}
	if (solver(0)) {
	    System.out.println(countSolutions());
	}
	else {
	    for (int r = 0; r < board.length; r++) {
		for (int c = 0; c < board[r].length; c++) {
		    if (board[r][c] == 0) {
			return false;
		    }
		    board[r][c] = 0;
		}
	    }
	}
	return false;
    }

    public boolean solver(int col) {
	if (col == board.length) {
	    return true;
	}
	for (int rr = 0; rr < board[rr].length; rr++) {
	    System.out.println(rr + " " + col);
	    if (board[rr][col] == -1) {
		col++;
	    }
	    if (addQueen(rr,col)) {
		System.out.println(toString());
		if (solver(col + 1)) {
		    return true;
		}
	    }
	    removeQueen(rr,col);
	}
	return false;
    }
    
    public int countSolutions() {
	int count = 0;
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] == -1) {
		    count++;
		}
		board[r][c] = 0;
	    }
	}
	// board[0][0] = 1; // used to test IllegalStateException
	if (board[0][0] != 0) {
	    throw new IllegalStateException();
	}
	return count;
    }
    
    public static void main (String[] args) {
	QueenBoard b = new QueenBoard(5);
	System.out.println(b.toString());
	/*
	System.out.println("addQueen(0,0): " + b.addQueen(0,0));
	System.out.println(b.toString());
	System.out.println("addQueen(1,1): " + b.addQueen(1,1));
	System.out.println(b.toString());
	System.out.println("addQueen(1,3): " + b.addQueen(1,3));
	System.out.println(b.toString());
	//System.out.println("removeQueen(1,3): " + b.removeQueen(1,3));
	*/
	System.out.println("\n- - - - -\n");
	System.out.println(b.toString());
	System.out.println(b.solve());
	System.out.println(b.toString());
    }
}

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
	return false;
    }
    
    /*
    public int countSolutions() {
	if (board[0][0] != 0) {
	    throw new IllegalStateException();
	}
    }
    */
    
    public static void main (String[] args) {
	QueenBoard b = new QueenBoard(20);
	System.out.println(b.toString());
	System.out.println(b.addQueen(0,0));
	System.out.println(b.toString());
	System.out.println(b.addQueen(3,2));
	System.out.println(b.toString());
	System.out.println(b.addQueen(1,3));
	System.out.println(b.toString());
	System.out.println(b.removeQueen(1,1));
	System.out.println(b.toString());
	System.out.println(b.solve());
    }
}

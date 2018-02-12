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
		for (int rr = r + 1, cc = c + 1; rr < board.length && cc < board[rr].length; rr++, cc++) {
		    board[rr][c]++;
		    board[r][cc]++;
		    board[rr][cc]++;
		}
		return true;
	    }
	    else {
		return false;
	    }
	}
	return false;
    }
    
    private boolean removeQueen(int r, int c) {
	if (r < board.length && c < board[r].length) {
	    if (board[r][c] == -1) {
		board[r][c]++;
		for (int rr = r + 1, cc = c + 1; rr < board.length && cc < board[rr].length; rr++, cc++) {
		    board[rr][c]--;
		    board[r][cc]--;
		    board[rr][cc]--;
		}
		return true;
	    }
	    else {
		return false;
	    }
	}
	return false;
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
    /*
    public boolean solve() {
	
    }

    public int countSolutions() {
	
    }
    */
    public static void main (String[] args) {
	QueenBoard b = new QueenBoard(5);
	System.out.println(b.toString());
	//System.out.println(b.addQueen(1,1));
	//System.out.println(b.toString());
	System.out.println(b.addQueen(3,2));
	System.out.println(b.toString());
	System.out.println(b.addQueen(1,3));
	System.out.println(b.toString());
	//System.out.println(b.removeQueen(1,1));
	//System.out.println(b.toString());
    }
}

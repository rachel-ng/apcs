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
		board[r][c] = -1;
		return true;
	    }
	    else {
		return false;
	    }
	}
	return false;
    }
    /*
    private boolean removeQueen(int r, int c) {
	
    }
    */
    public String toString() {
	String brd= "";
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] == -1) {
		    //brd += "Q ";
		    brd += board[r][c] + " ";
		}
		else {
		    //brd += "_ ";
		    brd += board[r][c] + " ";
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
	QueenBoard b = new QueenBoard(3);
	System.out.println(b.toString());
	System.out.println(b.addQueen(1,1));
	System.out.println(b.toString());
    }
}

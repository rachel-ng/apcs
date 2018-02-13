public class QueenBoard {
    private int[][] board;
    
    public QueenBoard(int size) {
	board = new int[size][size];
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board.length; c++) {
		board[r][c] = 0;
	    }
	}
    }

    private boolean addQueen(int r, int c) {
	if (r < board.length && c < board.length) {
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
	if (r < board.length && c < board.length) {
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
	    for (int c = 0; c < board.length; c++) {
		if (board[r][c] == -1) {
		    brd += "Q ";
		}
		else {
		    brd += "_ ";
		    //brd += board[r][c] + " "; //+ "\t";
		}
	    }
	    brd += "\n";
	}
	return brd;
    }
    
    public boolean solve() {
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board.length; c++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return solver(0);
    }

    private boolean solver(int col) {
	if (col == board.length) {
	    return true;
	}
	for (int r = 0; r < board.length; r++) {
	    if (addQueen(r,col)) {
		if (solver(col + 1)) {
		    return true;
		}
	    }
	    removeQueen(r,col);
	}
	return false;
    }

    public int countSolutions() {
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board.length; c++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return countSol(0); 
    }

    private int countSol(int col) {
	int sol = 0;
	if (col == board.length) {
	    return 1;
	}
	for (int r = 0; r < board.length; r++) {
	    if (addQueen(r,col)) {
		sol += countSol(col + 1);
	    }
	    removeQueen(r,col);
	}
	return sol;
    }
    
    public static void main (String[] args) { // My Driver
	QueenBoard a = new QueenBoard(10);
	QueenBoard b = new QueenBoard(10);

	// System.out.println("B R D   A\n ");
	// System.out.println(a.toString());
	// System.out.println(a.addQueen(1,2));
	// System.out.println(a.toString());
	// System.out.println(a.removeQueen(1,2));
	// System.out.println(a.toString());
	
	System.out.println(b.toString());
	//System.out.println(b.solve());
	System.out.println(b.toString());
	System.out.println(b.countSolutions());
    }


    /*
    public static void main(String[] args){ // Crystal's Driver for Queen Board
	QueenBoard b = new QueenBoard(4);

	System.out.println(b.solve()); //prints true
	System.out.println(b); //prints a valid solution

	try{
	    b.solve();
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"
	
	try{
	b.countSolutions();
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"
	
	for (int i = 0; i < 12; i++){
	    QueenBoard a = new QueenBoard(i);
	    System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
	    /*          Expected Values
			i --> # of Solutions   i --> # of Solutions
			0 --> 1                      6 --> 4
			1 --> 1                      7 --> 40
			2 --> 0                      8 --> 92
			3 --> 0                      9 --> 352
			4 --> 2                    10 --> 724
			5 --> 10                  11 --> 2680
	    */
    /*
	    System.out.println(a); //prints out an empty i by i grid of underscores
	}
    }
    */
}

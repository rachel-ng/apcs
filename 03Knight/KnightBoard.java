public class KnightBoard {
    private int[][] board;
    
    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
	for (int r = 0; r < startingRows; r++) {
	    for (int c = 0; c < startingCols; c++) {
		board[r][c] = 0;
	    }
	}
    }

    public boolean addKnight(int r, int c, int l) {
	if (board[r][c] == 0) {
	    board[r][c] = l;
	}
	return true;
    }
    
    
    public String toString() {
	String brd = "";
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		if (board[r][c] == 0) {
		    brd += "__ ";
		}
		if (board.length * board[r].length >= 10) {
		    if (board[r][c] < 10) {
			brd += "_" + board[r][c] + " ";
		    }
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
		
    private boolean solveH(int row ,int col, int level) {

    }
    */
    
    public static void main (String[] args) { // My Driver
	KnightBoard b = new KnightBoard(2,3);

	System.out.println(b.toString());
	System.out.println(b.addKnight(0,0,1));
	System.out.println(b.toString());
	System.out.println(b.addKnight(1,2,2));
	System.out.println(b.toString());
	System.out.println(b.addKnight(0,0,3));
	System.out.println(b.toString());
	//System.out.println(b.solve());
	//System.out.println(b.countSolutions());
    }

    
}

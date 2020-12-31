import java.util.*;
import java.io.*;
import java.io.File;

public class Maze{

    private char[][] maze;
    private boolean animate;//false by default

    private int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int[] ss = new int[2];

    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	
	File text = new File(filename);
	Scanner inf = new Scanner(text);

	String str = "";
	int row = 0;
	int col = 0;

	while(inf.hasNextLine()){
	    row++;
	    String line = inf.nextLine();
	    str += line + "\n";
	    col = line.length();
	}

	maze = new char[row][col];

	int nch = 0;
	int sc = 0;
	int ec = 0;

	for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[0].length; c++) {
		if (str.charAt(nch) == 'S') {
		    ss[0] = r;
		    ss[1] = c;
		    sc++;
		}
		if (str.charAt(nch) == 'E') {
		    ec++;
		}
		if (str.charAt(nch) == '\n') {
		    nch++;
		}
		maze[r][c] = str.charAt(nch);
		nch++;
	    }
	}
	
	if (sc != 1 && ec != 1) {
	    throw new IllegalArgumentException("exactly 1 s and 1 e ONLY");
	}
    }

    public boolean add (int row, int col) {
	if (maze[row][col] == ' ') {
	    maze[row][col] = '@';
	    return true;
	}
	if (maze[row][col] == '@') {
	    return false;
	}
	if (maze[row][col] == '#' || maze[row][col] == '.') {
	    return false;
	}
	return false;
    }
    
    public boolean surrounded (int row, int col) {
	int coun = 0;
	int at = 0;
	for (int i = 0; i < 4; i++) {
	    if (maze[row + move[i][0]][col + move[i][1]] == '#' || maze[row + move[i][0]][col + move[i][1]] == '.') {
		coun++;
	    }
	    if (maze[row + move[i][0]][col + move[i][1]] == '@') {
		at++;
	    }
	}
	return coun > 2 || at > 1;
    }
    
    public String toString() {
	String str = "";
	for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[0].length; c++) {
		str += maze[r][c];
	    }
	    str += "\n";
	}
	return str; 
    }
    
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){
        animate = b;
    }


    public void clearTerminal(){ //erase terminal, go to top left of screen.
	System.out.println("\033[2J\033[1;1H");
    }
    
    public int solve(){

	int row = ss[0];
	int col = ss[1];

	/*
	for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[0].length; c++) {
		if (maze[r][c] == 'S') {
		    maze[r][c] = ' ';
		    row = r;
		    col = c; 
		}
	    }
	}
	*/


	maze[row][col] = '@';
	return solve(row, col);
    }
    
    private int solve(int row, int col){
	// ty for animate 
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(50);
        }
	
	for (int i = 0; i < 4; i++) {
	    if (maze[row + move[i][0]][col + move[i][1]] == 'E') {
		return numsAt();
	    }
	    if (add(row + move[i][0],col + move[i][1])) {
		maze[row + move[i][0]][col + move[i][1]] = '@';
		return solve(row + move[i][0],col + move[i][1]);
	    }
	    if (surrounded(row,col) && maze[row + move[i][0]][col + move[i][1]] == '@') {
		maze[row][col] = '.';
		//maze[row + move[i][0]][col + move[i][1]] = '.';
		return solve(row + move[i][0],col + move[i][1]);
	    }
	}

        return -1;
    }

    public int numsAt() {
	int coun = 0;
	for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[0].length; c++) {
		if (maze[r][c] == '@') {
		    coun++;
		}
	    }
	}
	return coun;
    }

}

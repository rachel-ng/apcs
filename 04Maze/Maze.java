import java.io.File;
import java.util.*;
import java.io.*;

public class Maze{

    private char[][] maze;
    private boolean animate;//false by default

    private int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	
	File text = new File(filename);
	Scanner inf = new Scanner(text);

	String str = "";
	int r = 0;
	int c = 0;

	while(inf.hasNextLine()){
	    r++;
	    String line = inf.nextLine();
	    str += line + "\n";
	    c = line.length();
	}

	maze = new char[ln][ch];

	int nch = 0;
	int sc = 0;
	int ec = 0;

	for (int 
	
	if (sc != 1 && ec != 1) {
	    throw new IllegalArgumentException("exactly 1 s and 1 e ONLY");
	}
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



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    /*
    public int solve(){
	for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[0].length; c++) {
		if (maze[r][c] == "S") {
		    maze[r][c] = "@";
		}
	    }
	}
            //find the location of the S. 


            //erase the S


            //and start solving at the location of the s.

            //return solve(???,???);
	return 0;
    }
    */
    
    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE

        return -1; //so it compiles
    }


}

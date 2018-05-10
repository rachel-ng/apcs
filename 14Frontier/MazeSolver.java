import java.util.*;

public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public MazeSolver(String mazeText){
	maze = new Maze (mazeText);
    }

    //Default to BFS
    public boolean solve(){
	return solve(0);
    }

    //mode: required to allow for alternate solve modes.
    //0: BFS breadth first search
    //1: DFS depth first search
    public boolean solve(int mode){

	
	
	if (mode == 0) {
	    
	}

	if (mode == 1) {
	    
	}
	
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false
	return false;
    }

    public void BFSolve () {
	
    }

    public void DFSolve () {

    }
    
    public String toString(){
	return maze.toString();
    }
}

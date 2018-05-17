import java.util.*;

public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean astar;
    
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
	astar = false;
	
	
	if (mode == 0) {
	    frontier = new FrontierQueue();
	}

	if (mode == 1) {
	    frontier = new FrontierStack();
	}

	if (mode == 2) {
	    frontier = new FrontierPriorityQueue();
	}

	else {
	    frontier = new FrontierPriorityQueue();
	    maze.setastart(true);
	}

	frontier.add(maze.getStart());
	Location end = maze.getEnd();
	
	while (frontier.hasNext()) {
	    Location n = frontier.next();

	    if (!n.equals(maze.getStart())) {
		maze.set(next.getX(), next.getY(), '.');
	    }

	    Location[] neighbors = maze.getNeightbors(next);

	    for (Location l : neighbors) {
		if (l != null) {
		    if (l.equals(end) {
			    while (!n.equals(maze.getStart())) {
				maze.set(n.getX(), n.getY(), '@');
				n = n.getPrev();
			    }

			    return true;
			}

			frontier.add(l);
			maze.set(l.getX(), l.getY(), '?');
			}
		}
	}

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

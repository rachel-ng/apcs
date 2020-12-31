import java.util.*;

public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean aStar;
        
    public MazeSolver(String mazeText){
	maze = new Maze (mazeText);
    }

    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int mode){
	aStar = false;
	
	if (mode == 0) {
	    frontier = new FrontierQueue();
	}
	else if (mode == 1) {
	    frontier = new FrontierStack();
	}
	else if (mode == 2) {
	    frontier = new FrontierPriorityQueue();
	}
	else {
	    frontier = new FrontierPriorityQueue();
	    maze.setAStar(true);
	}

	frontier.add(maze.getStart());
	Location end = maze.getEnd();
	
	while (frontier.hasNext()) {
	    Location n = frontier.next();

	    if (!n.equals(maze.getStart())) {
		maze.set(n.getX(), n.getY(), '.');
	    }

	    Location[] neighbors = maze.getNeighbors(n);

	    for (Location l : neighbors) {
		if (l != null) {
		    if (l.equals(end)) {
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
    
    public String toString(){
	return maze.toString();
    }

    public static void main(String[]args) {
	MazeSolver x = new MazeSolver("test.txt");
	MazeSolver y = new MazeSolver("test.txt");
	MazeSolver z = new MazeSolver("test.txt");
	System.out.println(x.solve(0));
	System.out.println(x);
	System.out.println(y.solve(1));
	System.out.println(y);
	System.out.println(z.solve(2));
	System.out.println(z);
    }
}

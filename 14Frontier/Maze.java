public class Maze{
    private Location start,end;
    private char[][] board;

    public Maze(String mazeText){
	for (int i = 0; i < mazeText.length(); i++) {

	}
    }

    // '#' - wall 
    // ' ' - open space
    // '?' - frontier space
    // '.' - visited space
    // 'E' - end space (do not replace this)
    // if (maze[r][c] == 'E') {
    //     end = Location (r, c);
    // }
    // '@' - part of solution
    // 'S' - starting space (do not replace this)
    // if (maze[r][c] == 'S') {
    //     start = Location (r, c);
    // }
    public String toString(){
	
    }
   
    // Work on this method as a group! 
    public String toStringColor(){
	
    }

    //return a list of Locations that are:
    // adjacent to n and  not visited
    // all the Locations in this list should have their previous set to n.
    public Location[] getNeighbors(Location n){
	return null;
    }

    public Location getStart(){
	return null;
    }

    public Location getEnd(){
	return null;
    }

}
